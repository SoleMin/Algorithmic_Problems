#include <stdio.h>
#define MAX_N 3000
#define abs(x) ((x) < 0 ? (-(x)) : (x))

int main(void)
{
	int present[MAX_N];
	int n ,i ,prev , curr ,diff , jolly;
	char line[5000];
	
	while(scanf("%d" , &n)==1)
	{
		jolly = 1;
		for(i=1; i<=n; i++)
		{
			present[i] = 0; //배열을 0으로 초기화
		}
		scanf("%d" , &prev); //맨처음 숫자 입력
		for(i=1; i<n; i++)
		{
			scanf("%d", &curr); //n-1개의 숫자들을 입력
			diff = abs(curr - prev); //앞 뒤 숫자의 절댓값계산
			if(diff <= 0 ||diff>=n || present[diff]) //0보다같거나 작거나 최대범위보다 같거나 크거나 이미 그 값이 존재하는경우
			{
				jolly =0; //
				break;
			}
			present[diff] = 1;
			prev = curr; //앞에 숫자를 옮겨감
		}
		gets(line);
		puts(jolly ? "Jolly" : "Not jolly");
	}
}