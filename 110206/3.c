#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int cycle=0 ,crown=0;
char cmp[100][100][100] ,  buffer[100]={'\0'};   //사이클수 , 사람수 , 이름크기

struct Data //최종 저자와 에르되시수가 저장될 구조체
{
	char name[100];
	int grade;
}Grade[100];

void reset() //이름 및 에르되시수 초기화 (케이스별로 실행됨)
{
	for(int i=0; i<100; i++)
	{
		strcpy(Grade[i].name , buffer);
		Grade[i].grade = -1;
		strcpy(cmp[i] , buffer);
	}
	strcpy(Grade[0].name , "Erdos, P."); 
	Grade[0].grade = 0;
}
void in(char temp[]) //비교를위해 이름을 집어넣음
{
	crown++; //한 사이클에대해서 저자의수를 카운트
	strcpy(cmp[cycle][crown] , temp); //각 논문(사이클)에 해당하는 그룹끼리 이름 저장
}
void judge() //
{
	int i=0;
	while(strcmp(Grade[i].name , buffer) !=0) //더이상 에르되시수를 판별할수없을때까지
	{
		for(int a=1; a<=cycle; a++)
		{
			for(int b=1; b<100; b++)
			{
				if(strcmp(cmp[a][b] , buffer) == 0) break; //저자가 존재하는 곳까지만 읽음
				if(strcmp(cmp[a][b] , Grade[i].name) == 0) //저장되어있는 저자들을 순차적으로 검색하여 같은값이 있는가를 확인
				{
					for(int c=1; c<100; c++)
					{
						if(strcmp(cmp[a][c] , buffer) == 0)break;
						judge2(a,c ,i);
					}
				}
			}
		}
		i++;
	}
}
void judge2(int b , int c , int i) //에르되시수와 관련이 있는 저자들을 저장 및 수를 저장
{
	int index=0;
	for(int a=0; a<100; a++)
	{
		if(strcmp(Grade[a].name , buffer) == 0) 
		{
			index = a;
			break; //있는값 까지만 읽음 여기에 통과되면 값이 존재하지않으므로 넣는다라는뜻
		}
		if(strcmp(Grade[a].name , cmp[b][c]) ==  0) return ; //이미 존재하는 저자라면 체크할필요가 없으므로 함수종료
	}
	strcpy(Grade[index].name , cmp[b][c]); //목록에 없다면 저자를 저장
	if(i==0) Grade[index].grade=1;
	else Grade[index].grade = Grade[i].grade+1;
}


int main(void)
{
	int cases , book , people , comma_count=0 , index=0;
	char line[1000]={'\0'};
	char temp[100]={'\0'};
	scanf("%d" , &cases);
	
	for(int a=0; a<cases; a++) //케이스의수만큼반복
	{
		scanf("%d %d" , &book , &people);
		getchar(); //버퍼에 남아있는 개행문자제거
		reset(); //케이스가 실행될때마다 초기화실행	
		cycle =0; 

		for(int b=0; b<book; b++) //논문의 수만큼 반복
		{	
			crown = 0;
			gets(line);
			cycle++; //한케이스에대해서 논문의 수를 카운트
			for(int c=0; c<strlen(line); c++) //저자 , 논문이름들을 입력받음 
			{
				if(line[c] == ':')
				{
					in(temp);
					for(int d=0; d<100; d++) temp[d] = '\0';
					comma_count = 0;
					index = 0;
					break;
				}
				if(line[c] == ',') comma_count++;
				if(comma_count == 2)
				{
					in(temp);
					for(int d=0; d<100; d++) temp[d] ='\0';
					comma_count = 0;
					index = 0;
				}
				else
				{
					if(line[c] == ' ' && index==0) continue;
					temp[index++] = line[c];
				}
			}
		}
		
		judge(); //이름을 다 넣었으니 에르되시수를 판별
		printf("Scenario %d\n" , a+1);
		
		for(int b=0; b<people; b++) //에르되시수를 알고자 하는 사람들을 입력받아 그 결과를 출력
		{
			gets(line);
			for(int search=0; search<100; search++)
			{
				if(strcmp(Grade[search].name , line) == 0) //저장되어있지 않은 저자일경우
				{
					printf("%s %d\n" , Grade[search].name , Grade[search].grade); //infinuty를 출력
					break;
				}
				if(strcmp(Grade[search].name , buffer) == 0)
				{
					printf("%s infinity\n" ,line); //저장되어있을경우 결과값을 출력
					break;// 더이상 탐색을 할필요가 없으므로 중지
				}

			}
		}
	}
}
