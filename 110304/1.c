#include <stdio.h>
#include <string.h>
const char trueword[36]="thequickbrownfoxjumpsoverthelazydog"; //원본 및 비교문구

void main()
{
	int cases , alphabet[26]={0};
	char string[80]={'\0'} ,  buffer[80]={'\0'};

	scanf("%d" , &cases);
	getchar(); getchar();

	for(int cycle=0; cycle<cases; cycle++)
	{
		int count=0 , find=0;
		char line[100][80]={'\0'} , sort[27]={'\0'} , real[36]={'\0'};
		while(gets(string)) //문장들을 처음부터 끝까지 받아들긴 위한 코드
		{
			if(strcmp(string , buffer) == 0) break;
			strcpy(line[count] , string); //문장을 읽어들임
			if(find==0) //아직 복호화 큐칙을 못찾았을경우
			{
				for(int init=0; init<26; init++) alphabet[init]=0;// 한문장을 받아들일때마다 사용하므로 초기화를 진행
				for(int a=0; a<strlen(line[count]); a++)
				{
					if(line[count][a] == ' ')continue; //공백을 제외하고 입력을 받기위함.
					int index = line[count][a]-97; //알파벳을 인덱스로 사용기하기위함.
					alphabet[index]+=1;
				}
				int sum=0;
			
				for(int a=0; a<26; a++)
				{
					sum+=alphabet[a];
					int number=0 , real_count=0;
					if(alphabet[a]==0)break;
					if(sum==35) //a~z까지의 모든알파벳이 존재하고 알파벳숫자가 35개일때 그것이 원본을 암호화한것인지를 확인하기 위한 코드
					{
						for(int change=0; change<strlen(line[count]); change++) //입력받은문을 원문과 비교하여 어떻게 바꾸는지 저장하는코드
						{
							if(line[count][change]==' ') continue;
							int index = line[count][change]-97;
							sort[index] = trueword[number++];	
						}
						for(int change=0; change<strlen(line[count]); change++) //바꾼코드가 원문과 같다면 이것은 올바른 복호화 코드이다
						{
							if(line[count][change]==' ')continue;
							real[real_count++] = sort[line[count][change]-97];
						}
						if(strcmp(trueword , real) == 0)find=1;
					}
				}
			}
			count++;
		}
		if(find == 1)
		{
			for(int a=0; a<count; a++)
			{
				for(int b=0; b<strlen(line[a]); b++)
				{
					if(line[a][b]==' ')printf(" ");
					else printf("%c" , sort[line[a][b]-97]);
				}
				printf("\n");
			}
		}
		else printf("No solution.\n");
		printf("\n");
	}
}