#include <stdio.h>
#define MAX_P 100	//정당의 수 P(1<=P<=100)

void main() {
	
	int n, date, p, i, j, hart;
	int h[MAX_P];
	int test_case;
	
	//테스트 케이스의 수
	scanf("%d", &test_case);
	
	while (test_case > 0) {
		hart = 0;	//초기화 작업
		
		scanf("%d", &date); //날 수
		scanf("%d", &p);		//정당 수
		
		for (i = 0; i < p; i++) 
			scanf("%d", &h[i]);	//i번째 정당의 동맹 휴업지수
		
		for (i = 1; i <= date; i++) {
			if ((i-1) % 7 < 5) {	//일요일 부터 0, 토요일까지 6, 금,토 제외
				for (j = 0; j < p; j++) {
					if (i % h[j] == 0) {
						hart++;
						break;
					}
				}
			}
		}
		printf("%d", hart);
		printf("\n");
		test_case--;
	}
	
}
