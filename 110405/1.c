#include <stdio.h>
#include <stdlib.h>

int n , ti[1000] , si[1000] , result[1000];

void solve(void)
{
	int i,j,temp;
	for (i = 0; i < n; i++)result[i] = i;
		// 버블 정렬을 이용하여 정렬한다
	for (i = 1; i < n; i++) 
	{
		for (j = 0; j < n - i; j++) 
		{
			if (ti[result[j]]*si[result[j+1]] > ti[result[j+1]]*si[result[j]])
			{
				temp = result[j];
				result[j] = result[j+1];
				result[j+1] = temp;
			}
		}
	}
}

int main(void)
{
	int cases;
	scanf("%d" , &cases);
	
	for(int a=0; a<cases; a++) //케이스의 수만큼 반복
	{
		scanf("%d" ,&n);
		for(int b=0; b<n; b++)scanf("%d %d", &ti[b], &si[b]); //작업일수와 벌금을 입력받음
		
		solve();
		
		for (int j = 0; j < n; j++)printf("%d ", result[j] + 1); //정렬된 작업순서를 출력
		printf("\n\n"); //케이스간에 공백으로 구분하므로 개행문자를 2개사용
	}
}