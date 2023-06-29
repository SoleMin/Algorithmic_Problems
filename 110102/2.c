#include <stdio.h>
#include <stdlib.h>
#include <memory.h>

char mine[101][101];	//입력 받는 원본 지뢰찾기 맵.
char Rmine[101][101]; //숫자를 반영한 결과 지뢰찾기 맵.

int main(void) {
	int Field = 1;
	int m, n, i, j;
	
	while( scanf("%d %d", &n, &m) == 2) {
		if( m == 0 && n == 0) return 0;	// 반복문 제어 구문
	
		for( i = 0; i < 100; i++) {
			memset( mine[i], 0, sizeof(char) * 100 );	// 메모리 할당.
		}
		
		for( i = 0; i < n; i++) {	// 입력
			scanf("%s", mine[i]);
		}
		
		for( i = 0; i < n; i++) {
			for( j = 0; j < m; j++) {
				int num = 0;
				if ( mine[i][j] == '*') {
					Rmine[i][j] = '*';
					continue;
				}
				if( i - 1 >= 0 && j - 1 >= 0 && mine[i - 1][j - 1] == '*' ) num++;	// 좌하단
				if( i - 1 >= 0 && j >= 0 && mine[i - 1][j] == '*' ) num++;	        // 하단
				if( i - 1 >= 0 && j + 1 <= m && mine[i - 1][j + 1] == '*') num++;   // 우하단
				if( i >= 0 && j + 1 <= m && mine[i][j + 1] == '*' ) num++;          // 오른쪽
				if( i >= 0 && j - 1 >= 0 && mine[i][j - 1] == '*' ) num++;          // 왼쪽
				if( i + 1 <= n && j - 1 >= 0 && mine[i + 1][j - 1] == '*' ) num++;  // 좌상단
				if( i + 1 <= n && j >= 0 && mine[i + 1][j] == '*') num++;           // 상단
				if( i + 1 <= n && j + 1 <= m && mine[i + 1][j + 1] == '*') num++;   // 우상단
				Rmine[i][j] = num + '0'; // 근처 지뢰 갯수
			}
		}
		printf("Field #%d: \n", Field++ );
		for( i = 0; i < n; i++) {
			for( j = 0; j < m; j++) {
				printf("%c", Rmine[i][j]);
			}printf("\n");
		}printf("\n");
	}
}