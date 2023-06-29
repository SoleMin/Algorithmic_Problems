#include <stdio.h>
#include <stdlib.h>
int save[1000]={'\0'};
void qsort(void *base , size_t nel , size_t width , int(*compare)(const void* , const void*));

int intcompare(int *i , int *j)
{
	if(*i > *j) return(1);
	if(*i < *j) return(-1);
	return (0);
}

int cal_time(int save[] , int many)
{
	int sum=0 , people=0 , count=0;
	//many는 사람의 수를 뜻함
	if(many==1) return save[0];
	else if(many==2)return save[1];
	else
	{
		for(int number=many-1; number>=0; number = number - 2)
		{
			if(save[1]*2 - save[0] >= save[number] || save[1]*2 - save[0] >= save[number-1]) count = 1;
			if(count == 1)
			{
				for(int a=many-people-1; a>0; a--)
				{
					sum = sum + save[a];
					people = people + 2;
					if(people == many) return sum;
					sum = sum + save[0];
					people = people-1;
				}
			}
			else
			{
				sum = sum + save[1];
				people = people + 2;
				if(people == many)
				{
					return sum;
				}
				sum = sum + save[0];
				people = people - 1;
				
				sum = sum + save[number]; //남아있는 사람중 가장 느린사람을뜻함
				people = people + 2;
				if(people == many)
				{
					return sum;
				}
				sum = sum + save[1];
				people = people - 1;
			}
		}
	}
}

int main() 
{
	int cases=0;
	scanf("%d" , &cases); //케이스가 반복될 횟수를 입력받음
	
	for(int a=0; a<cases; a++) //케이스의 수만큼반복
	{
		for(int init=0; init<1000; init++) save[init]=0; //초기화
		int many=0;
		scanf("%d" , &many);
		
		for(int b=0; b<many; b++) //사람들의 속도를 입력받음
		{
			scanf("%d" , &save[b]);
		}
		qsort(save , many , sizeof(int) , intcompare); //오름차순정렬
		int result = cal_time(save , many);
		printf("%d\n\n" ,result);
	}
}
