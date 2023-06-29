#include <stdio.h>
#include <stdlib.h>

int main(void)
{
	int printF , printS , first , second , bigcount;
  long x; //할때마다 처리속도가 달라짐
	
	while(scanf("%d %d", &first , &second)==2)
	{
		printF = first;
		printS = second; //출력양식을 위해 값저장
		if(first > second)
		{
			int temp = first;
			first = second;
			second = temp;  //앞의 값이 뒤의값보다 클경우 자리교체
		}
		int* counter = (int*)malloc(sizeof(int)*(second+1)); //입력받은 만큼의 배열크기할당
		bigcount = 0;
		for(int i=0; i<=second+1; i++)
		{
			counter[i] = 0; //배열초기화
		}
		for(int i = first; i<=second; i++)
		{
			int count = 1;
			x = i;
			while(x!=1)
			{
				if(x<second && counter[x]!=0) 
				{
					counter[i] = counter[x] + count -1; //이미 한번 계산값이라면
					break;
				}
				if(x%2==0) x = x/2;
				else x=x*3+1;
				count++;
			}
			if(counter[i]==0)counter[i] = count;
			if(counter[i] > bigcount) bigcount = counter[i]; //사이클이 제일 긴길이를 저장
		}
		printf("%d %d %d\n" , printF , printS , bigcount);
	}
}