#include <stdio.h>

#define M 100
#define N 100
int main() {
	char board[M+2][N+2];
	char buf[N+1];	// 열 개수 + 1
	int m = 1, n = 1, i, j, row, col, field = 0;	// m, n이 0 미만이면 아래 반복문을 실행할 수 없으므로 0보다큰 숫자(중 아무거나) 1로 초기화
	
	while (scanf("%d %d", &m, &n) && (m > 0) && (n > 0)) {	// m, n에 0, 0이 입력되면 그만.
		
		// 보드판 초기화
		for (i = 0; i < m+2; i++) {
			for (j = 0; j < n+2; j++) {
				board[i][j] = '0';
			}
		}
		
		for (i = 1; i < m+1; i++) {
			scanf("%s", buf);	// 버퍼에 한줄씩 입력 받기
			for (j = 1; j < n+1; j++) {
				if (buf[j-1] == '*') {	// 입력값이 지뢰면
					board[i][j] = '*';	// 지뢰 설치
					for (row = i-1; row <= i+1; row++) { // 팔방 숫자
						for (col = j-1; col <= j+1; col++) {
							if (board[row][col] != '*') {	// 지뢰가 아닐 경우
								board[row][col]++;	// 숫자++
							}
						}
					}
				}
			}
		}
		
		printf("Field #%d:\n", ++field);
		for (i = 1; i < m+1; i++) {
			for (j = 1; j < n+1; j++) {
				printf("%c", board[i][j]);
			}
			putchar('\n');
		}
		putchar('\n');
	}
	
	return 0;
}
