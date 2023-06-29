#include <stdio.h>
#define MAX_N 3000
int abs(int x);

void main(void) {
	int n,i,prev,now,diff,jolly;
	int check[MAX_N];
	char line[1000];
while(scanf("%d",&n)==1)
{ jolly=1; // 일단 유쾌한 점퍼라고 판단, 유쾌한 점퍼가 아닐 조건에 들어갈 때 jolly값 0으로 변화
	for(i=1;i<=n;i++)
	{
		check[i]=0;
	}//차이 값이 이전에 나왔는지를 검사하는데 배열의 인덱스를 활용. 배열 초기화
	scanf("%d",&prev);	
	for(i=1;i<n;i++)
	{scanf("%d",&now);
	 diff = abs(now-prev);
	 if (diff<=0 || diff>=n || check[diff]==1)
	 {jolly = 0;
		break;
	 } // 인접한 두 수의 차이가 0에서 n-1 이외의 범위의 값을 가진다면, 또는 이전에 중복한 값이라면 not jolly
	 check[diff]=1;
	 prev=now;
	}//수열에서 인접한 두 수의 차이를 반복하여 검사 
	 gets(line);
	if(jolly ==1)
		printf("Jolly\n");
	else if(jolly ==0)
		printf("Not jolly\n");
}//while
}//main

int abs(int x)
{
	if(x < 0)
		return -x;
	else
		return x;
}