#include <stdio.h>
int main() 
{
	int n[100]; //정당의 휴업지수
	int day, num, count, Dday, testCase;//시뮬레이션 날짜, 정당개수, 날짜 카운트, 쉬는날, 테스트케이스
	
	scanf("%d", &testCase);
	
	for (int j = 0; j < testCase; j++)
	{
		scanf("%d", &day);
		scanf("%d", &num);
		Dday = 0;
		for (int i = 0; i < num; i++)
			scanf("%d", &n[i]);
		
		for (count = 1; count <= day; count++)
			if (count % 7 != 6 && count % 7 != 0)
				for (int i = 0; i < num; i++)
					if (count % n[i] == 0)
					{
						Dday++;
						break;
					}
		printf("%d\n", Dday);
	}
}
