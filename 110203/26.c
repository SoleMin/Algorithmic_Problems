#include <stdio.h>

int calcurate_hartals(int N, int P, int *h)
{
	/* N번 반복할 전체일수 i와 P번 반복할 정당의 수 j */
	int i, j, result = 0;
	
	for (i = 1; i <= N; i++)
	{
		for (j = 0; j < P; j++)
		{
			/* 금요일과 토요일을 제외하고 휴업일이 있으면 result++ */
			if (((i - 1) % 7) < 5)
			{
				if((i % h[j]) == 0)
				{
					result++;
					break;
				}
			}
		}
	}
	
	return result;
}

int main() {
	
	/* 시뮬레이션 기간 N, 테스트케이스의 수 T, 정당의 개수 P, 정당의 동맹휴업지수 h, 휴일의 수 hartals*/
	int i, j, N, T, P, h[100], hartals;
	
	/* 테스트케이스의 갯수를 T에 입력받고 True면 while반복문 동작 */
	while (scanf("%d\n", &T) == 1)
	{
		for (i = 0; i < T; i++)
		{
			/* 시뮬레이션을 돌릴 기간(날수)을 N에 입력받기 */
			scanf("%d\n", &N);
			/* 정당의 개수를 P에 입력받기 */
			scanf("%d\n", &P);
			/* P(정당의 개수)개의 각 정당의 동맹휴업지수를 h[i]에 입력받기 */
			for (j = 0; j < P; j++)
			{
				scanf("%d\n", &h[j]);
			}
			hartals = calcurate_hartals(N, P, h);
			printf("%d\n", hartals);
		}
	}
	
	return 0;
}