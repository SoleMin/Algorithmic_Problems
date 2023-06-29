#include <stdio.h>

int main(void) {
	int cas, i, j, k, arr[100]; 
	int week, n, p; // n = 기간, p = party(정당)
	
	scanf("%d", &cas);
	while( cas-- > 0) { //  테스트 케이스의 갯수, 추가 입력 없을 때 까지.
		scanf("%d", &n);  // 기간
		scanf("%d", &p);  // 정당의 개수
		for(i = 0; i < p; i++)
			scanf("%d", &arr[i]); // i번째 정당의 동맹휴업 지수
			week = 0;
			for(j = 1; j <= n; j++) {
				if((j - 1) % 7 < 5) // 나머지 0 ~ 6 총 7개에서 동맹 휴업 없는 금, 토 제외 의미
					for(k = 0; k < p; k++)
						if(j % arr[k] == 0) {
							week++;
							break;
						}
		}
		printf("%d\n", week);
	} 
	return 0;
}