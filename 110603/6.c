#include <stdio.h>
#include <stdlib.h>
#include <string.h>
static char save[1000][500]={0,};

int plus(int count , int cal ,int lenr)
{
	int len = 0 , carry =0;
	int len_s = lenr;
	int len_c = lenr;
	//printf("::::::::: %d %d\n" , len_s , len_c);
	for(; len <len_s && len < len_c; len++)
	{	
		//printf("**************%d %d\n" , save[count][len] , save[cal][len]);
		save[count][len] = (save[count][len] + save[cal][len] + carry);
		//printf("**************%d %d\n" , save[count][len] , save[cal][len]);
		//printf("[%d]\n" , save[count][len]);
		if(save[count][len] >= 10) carry = 1;
		else carry = 0;
		save[count][len] %=10;
	}
	if(len < len_s)
	{
		for(; len<len_s; len++)
		{
			if(save[count][len] !=0)
			{
				save[count][len] = save[count][len] + carry;
			}
			else save[count][len] = save[count][len] + carry;
			if(save[count][len] >= 10) carry = 1;
			else carry = 0;
			save[count][len] %=10;
		}
	}
	else if(len < len_c)
	{
		//printf("뒤쪽이 더길경우 진입\n");
		for(; len<len_c; len++)
		{
			if(save[count][len] !=0)
			{
				save[count][len] += save[cal][len] + carry;
			}
			else save[count][len] = save[cal][len] + carry;
			if(save[count][len] >= 10) carry = 1;
			else carry = 0;
			save[count][len] %=10;
		}
	}
	if(carry) save[count][len++] = 1;
	//printf("%d ^ %d ^ %d ^ %d ^ %d\n" ,save[count][0] ,save[count][1] , save[count][2] ,save[count][3] ,save[count][4]);
	return len;
}

int main()
{
	save[0][0] = 1;
	save[1][0] = 2;
	save[2][0] = 5;
	int temp ,count=3 , result=1;
	while(scanf("%d" , &temp) == 1)
	{
		int check =0;
		for(; count<=temp; count++)
		{
		 // printf("%d부분입니다.\n" , count);
			int re = plus(count ,count-1 ,result); //save[count]에 대한값을 계산함
			if(re > result) result = re;
			re = plus(count ,count-1 , result);
			if(re > result) result = re;
			re = plus(count ,count-2 , result);
			if(re > result) result = re;
			re = plus(count ,count-3 , result);
			if(re > result) result = re;
			//printf(":::::::::: 결과는 ??? : %d\n" ,result);
		}
		for(int i=result-1; i>=0; i--) //역으로 넣었기때문에 역으로 꺼내야함
		{
			if(check==0 && save[temp][i] == 0)
			{
				continue;
			}
			else
			{
				check = 1;
				printf("%d" , save[temp][i]);
			}
		}
		printf("\n");
	}
}
