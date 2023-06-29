#include <stdio.h>
#include <stdlib.h>
#include <string.h>
void print_result(int Grade[][10])
{
	int sorting[101][3]={0} ,count=0;
	for(int i=0; i<101; i++)
	{
		int cal=0 , grade=0 , howmany=0;
		for(int j=0; j<10; j++)
		{
			if(Grade[i][j] >=0 )
			{
				cal++;
				//printf(" Team  :: [%d]  CAL :: [%d]\n" , i , cal);
				grade = grade + Grade[i][j];
			}
			if(Grade[i][j] <=-10000)  
			{
				howmany++;
			}
		}
		if(grade >= 0 && cal>0)
		{
			sorting[count][0] = cal; //최종적으로 푼 문제의수
			sorting[count][1] = grade; // 최종시간점수
			sorting[count][2] = i; //팀번호
			count++;
		}
		if(howmany>0 && cal==0)
		{
			sorting[count][0] = cal;
			sorting[count][1] = 0;
			sorting[count][2] = i;
			count++;
		}
	}
	sort(count , sorting);
	printf("\n");
}
void sort(int count , int sorting[][3])
{
	for(int i=0; i<count-1; i++)
	{
		for(int k=i+1; k<count; k++)
		{
			for(int index =0; index<3; index++)
			{
				if(sorting[i][index] > sorting[k][index] && index== 0) break;
				if(sorting[i][index] < sorting[k][index] && index == 0) //비교하고자하는값이
				{
					for(int swap=0; swap<3; swap++)
					{
						int temp = sorting[i][swap];
						sorting[i][swap] = sorting[k][swap];
						sorting[k][swap] = temp;
					}
					break;
				}
				if(sorting[i][index] < sorting[k][index] && (index == 1 || index == 2)) break;
				if(sorting[i][index] > sorting[k][index] && (index == 1 || index == 2))
				{
					for(int swap=0; swap<3; swap++)
					{
						int temp = sorting[i][swap];
						sorting[i][swap] = sorting[k][swap];
						sorting[k][swap] = temp;
					}
					break;
				}
			}
		}
	}
	for(int i=0; i<count; i++)
	{
		printf("%d %d %d\n" , sorting[i][2] , sorting[i][0] , sorting[i][1]);
	}
}

int main() 
{
	int cases , Grade[101][10]={-9999,} , count=0;
	int team , answer , time;
	char line[20];
	char* token;

	scanf("%d" , &cases); //케이스개수
	getchar(); getchar();
	
	for(int cycle=0; cycle<cases; cycle++) //케이스개수만큼 사이클반복
	{
		for(int q=0; q<101; q++)
		{
			for(int o=0 ; o<10; o++)
			{
				Grade[q][o] = -9999;
			}
		}
		while(gets(line) != NULL)//한개의 테스트케이스에 대해서 입력을받음
		{
			token = strtok(line, " ");
			if(token == NULL)
			{
				break;
			}
			team = atoi(token);
			
			token = strtok(NULL, " ");
			answer = atoi(token);
			
			token = strtok(NULL, " ");
			time = atoi(token);
	
			token = strtok(NULL , " ");
			
			if(token[0] == 'C')
			{		
				if(Grade[team][answer] <=0)	Grade[team][answer] = (Grade[team][answer]%9999)*(-20)+time; //점수가없거나 패널티가 존재할때만 (즉, 재채점 점수를 방지)
				//printf("[팀번호  ::  %d  점수 :: %d]\n" , team , Grade[team][answer]);
			}
			else if(token[0] == 'I')
			{
				if(Grade[team][answer] <=0 ) Grade[team][answer]+=-1;
			}
			else if(token[0] == 'R' || token[0] == 'L' || token[0] == 'E' || token[0] == 'U') 
			{
				if(Grade[team][answer] <=0) Grade[team][answer] += -19998;
			}
		}
		print_result(Grade);
	}
}
