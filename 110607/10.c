#include <stdio.h>

static long dp[200000000];

void main()
{
	int k, input, n, sum, count;
	while(scanf("%d", &input)!=EOF&&input!=0)
	{
		//이후의 연산을 위한 초기화
		dp[1]=1;
		dp[2]=2;
		
		count=3;	//결과의 분기를 결정지어줄 범위
		n=2;		//대입할 연속되는 결과
		sum=3;	//f(n)의 결과. 입력한 목표값까지의 도달여부를 결정지어줄 것
		//1~3까지는 값을 정의하고, 3이후부터 연산
		for(k=3;k<200000000;k++)		//순열 순회
		{
			dp[k]=n;	//결과 초기화 및 대입
			sum+=n;		//합에 이전의 결과를 더해줌
			if(sum>=input)	//만약 합이 입력한 목표값에 도달하면 
			{
				break;		//연산 종료
			}
			if(k==count)	//현재의 k값이 dp[k]가 변하는 분기점을 만나면
			{
				n++;			//결과값이 바뀜
				count+=dp[n];		//분기점의 크기도 이전 분기점의 값만큼 늘려줌
			}
		}
		//3 이하의 값이 입력됐는지 확인
		if(input==1)
		{
			k=1;
		}
		else if(input==2)
		{
			k=2;
		}
		else if(input==3)
		{
			k=2;
		}
		
		//결과 출력
		printf("%d\n", k);
	}
}