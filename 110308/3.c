#include <stdio.h>
#include <string.h>
char* token = NULL;
int line_start=0 , sum=0;

void print()
{
	int count = strlen(token);
	if(line_start == 0)
	{
		printf("%s" , token);
		line_start = 1;
		sum = count;		
	}
	else
	{
		if(sum + count + 1 <=72)
		{
			printf(" %s" , token);
			sum = sum + count + 1;
		}
		else
		{
			printf("\n");
			printf("%s" , token);
			sum = count;
		}
	}
}

int main(void)
{
	char string[300]={'\0'} ,buffer[300]={'\0'} , save[300]={'\0'};
	int length = 0 , token_count=0 ,index=0 , lg=0;
	
	while(gets(string))
	{
		
		token_count = 0;
		index = 0 ;
		if(strcmp(string , buffer) == 0)
		{
			sum=0;
			line_start = 0;
			printf("\n\n");
			continue;
		}
		strcpy(save , string);
		
		while(1)
		{
			if((string[index] == ' ' && token == NULL) || string[index] == ' ')
			{
				if(string[index] == ' ' && token == NULL)
				{
					printf(" ");
					index++;
					sum = sum + 1;
				}
				else if(string[index] == ' ' && token!=NULL)
				{
					lg++;
					index++;
				}
			}
			else if(token_count == 0)
			{
				if(lg >=2)
				{
					sum = sum + lg;
					for(int a=0; a<lg-1; a++)
					{
						
						printf(" ");
					}
				}
				token = strtok(save , " ");
				index = index + strlen(token);
				token_count = 1;
				lg=0;
				print();
			}
			else
			{
				if(lg >=2)
				{
					sum = sum + lg;
					for(int a=0; a<lg-1; a++)
					{
						printf(" ");
					}
				}
				lg=0;
				token = strtok(NULL, " ");
				if(token == NULL)break; //마지막이 NULL일시 계산하지 않고 그 문장계산을 종료
				index = index + strlen(token);
				print();
			}
		}
	}
}