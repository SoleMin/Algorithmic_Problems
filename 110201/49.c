#include <stdio.h>
#define MAX_N 3000
#define abs(x) ((x < 0) ? (-(x)) : (x))

void main() {
	
	int present[MAX_N];
	int n, jolly, prev, curr, diff;
	char line[5000];
	
	//초기 정수(수열의 크기) 입력 , 올바르지 않을 시 종료
	while (scanf("%d", &n) == 1) {
		jolly = 1;
		
		//초기화 작업
		for(int i = 1; i <= n; i++) 
			present[i] = 0;
		
		scanf("%d", &prev);
		for(int i = 1; i < n; i++) {
			scanf("%d", &curr);
			diff = abs(curr - prev);
			//조건에 맞지 않으면 jolly = 0
			if (diff <= 0 || diff >= n || present[diff]) {
				jolly = 0;
				break;
			}
			present[diff] = 1;
			prev = curr;
		}
		gets(line);
		puts(jolly ? "Jolly" : "Not jolly");
	}
	
}
