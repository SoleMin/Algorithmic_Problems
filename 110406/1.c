#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>

struct money{ //구조체선언
	char car[21];
	int time;
	char enter[6];
	int km;
	int s;
};
struct money MONEY[1000]={'\0'};
struct money temp[1]={'\0'};
struct money trash[1]={'\0'};
char car_n[1000][21]={'\0'};
char trash_2[1][21]={'\0'};
float much[1000];
int timer[24] , car_number=0;

void init()
{
	car_number=0;
	for(int a=0; a<1000; a++)
	{
		much[a]=0;
	}
}
void end_sort() //차량을 차량번호순서대로 정렬
{
	char min_temp[1][21];
	int min;
	float min_f;
	for(int i=0; i<car_number-1; i++)
	{
		min = i;
		for(int j=i+1; j<car_number; j++)
		{
			if(strcmp(car_n[min] , car_n[j]) >0) //왼쪽의 문자열이 더클경우 즉, 사전상 뒤로 가야할경우
			{
				min = j;
			}
		}
		strcpy(min_temp[0] , car_n[i]);
		min_f = much[i];
		
		strcpy(car_n[i] , car_n[min]);
		much[i] = much[min];
		
		strcpy(car_n[min] , min_temp[0]);
		much[min] = min_f;
		
	}
}
void sort(int index) //시간순으로정렬
{
	int min;
	for(int a=0; a<index-1; a++)
	{
		min = a;
		for(int b=a+1; b<index; b++)
		{
			if(MONEY[b].time < MONEY[min].time) min=b;
		}
		temp[0] = MONEY[a];
		MONEY[a] = MONEY[min];
		MONEY[min] = temp[0];
	}
}

void judge(int index) //시간순으로 정렬한 기록을 가지고 요금을 계산
{
	int where=-1;
	for(int t=0; t<index; t++)
	{
		int count=0; //여기부터 차량기록을 가지고 차량이 몇대인지 세는부분
		for(int check=0; check<=car_number; check++)
		{
			if(strcmp(car_n[check] , MONEY[t].car) ==0)
			{
				count = 1;
				break;
			}
		}
		if(count == 1) continue;
		else strcpy(car_n[car_number++] , MONEY[t].car); //여기까지 //이분을 통과한다면 이차는 요금정산을 안한것이므로 정산시작
		
		for(int a=0; a<index; a++)
		{
			if(strcmp(MONEY[a].enter , "enter") == 0 && strcmp(MONEY[a].car , car_n[car_number-1])==0) 
			{
				where = a;
			}
			if(strcmp(MONEY[a].enter , "exit")==0  && where!=-1 && strcmp(MONEY[a].car , car_n[car_number-1])==0)
			{
				//where가 "enter"기록  ,   a가  "exit"기록
				float hour = timer[MONEY[where].s];
				hour = hour/100;
				much[car_number-1] = much[car_number-1] + (float)(abs(MONEY[where].km - MONEY[a].km))*hour+1;
				where = -1;
			}
		}
		where=-1;
	}
}

int main()
{
	int m , d , h , s ,sum;
	char string[300]={'\0'}, save[300]={'\0'}, buffer[300]={'\0'};
	char* token;
	
	int cases;	
	scanf("%d" , &cases);
	
	for(int a=0; a<cases; a++)//케이스의 수만큼 반복
	{
		init();
		for(int time=0; time<24; time++)scanf("%d" , &timer[time]); //24시간 - 시간단위 센트를 저장
		getchar(); //문자열 입력을 받기위해 '\n' 제거
		
		int index=0;
		while(gets(string)) //각 차량에 대해서 입력을받기 시작하는 지점
		{
			if(strcmp(string , buffer) == 0) //다음케이스진입
			{
				printf("\n");
				break;
			}
			strcpy(save , string); //문자열분리를 위해 분리를 위한 save를 사용
			token = strtok(save , " ");
			strcpy(MONEY[index].car , token); //차이름
			
			token = strtok(NULL, ":"); //달 
			m = atoi(token);
			
			token = strtok(NULL, ":"); //일 
			d = atoi(token);
			
			token = strtok(NULL, ":"); //시간 -------------이것만이 시간당 돈을 계산할수있음
			h = atoi(token);
			MONEY[index].s = h;//따라서 따로저장함
			
			token = strtok(NULL, " "); //분 
			s = atoi(token);
			
			sum = m*216000 + d*3600 + h*60 + s; //시간자체를 분으로계산하여 순착적으로 정렬하기위함
			MONEY[index].time = sum;
			
			token = strtok(NULL, " "); //퇴장, 입장기록
			strcpy(MONEY[index].enter , token);
			
			token = strtok(NULL, " "); //km
			MONEY[index].km = atoi(token);
			//여기까지 "차번호" - "시간" - "입퇴장기록" - "km - hour"를 입력받음
			
			index = index + 1; //다음 사진기록저장을위해 + 1
		}
		
		sort(index); //시간순으로 정렬
		judge(index); //출입기록에따른 요금정산
		end_sort(); //출력을위한 문자열 정렬
		
		for(int end=0; end<car_number; end++)
		{
			if(much[end] == 0)continue;
			printf("%s $%.2f\n", car_n[end] , much[end]+2);
		}
		printf("\n");
	}
}
