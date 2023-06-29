#include <stdio.h>
#include <string.h>
int main() {
	char string[1000]={'\0'} , A[1000]={'\0'} , B[1000]={'\0'} , buffer[1000]={'\0'} ,check[1000]={'\0'};
	int save[1000];
	int case_count = 0 , count , blank=0;
	while(gets(string))
	{
		if(case_count == 0)
		{
			strcpy(A , string);
			case_count++;
		}
		else if(case_count == 1)
		{
			strcpy(B , string);
			case_count++;
		}
		for(int init=0; init<1000; init++)
		{
			check[init] = '\0';
		}
		if(case_count == 2)  //한케이스를 모두 입력받았을때 처리
		{
			case_count = 0;
			count=0;
			for(int a=0; a<strlen(A); a++)
			{
				for(int b=0; b<strlen(B); b++)
				{
					if(A[a] == B[b])
					{
						if(check[b]=='\0')
						{
							
							check[b] = B[b];
							save[count++] = A[a];
							break;
						}
					
					}
				}
			}
			
			
			for(int a=0; a<count-1; a++) //한케이스에 대해서 순차적으로 알파벳정렬
			{
				for(int b=a+1; b<count; b++) //선택정렬
				{
					if(save[a] > save[b])
					{
						int temp = save[a];
						save[a] = save[b];
						save[b] = temp;
					}
				}
			}
			for(int a=0; a<count; a++) //출력
			{
			  printf("%c" , save[a]);
				save[a] = '\0';
			}
			
			printf("\n");
		}
	}
}
