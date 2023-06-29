#include <stdio.h>
#include <string.h>
#define MAX_N 10001
#define MAX_LEN 60

int move[200][MAX_LEN];
int hanoi[MAX_N][MAX_LEN];
int main(void) {
	int n;
	int i, j, k, p, s;
	memset(move, 0, sizeof(move));
	move[0][0] = 1;
	for(i = 0; i < 150; i++) {
		for(j = 0; j < MAX_LEN; j++) {
			move[i][j] += move[i - 1][j] * 2;
			if(move[i][j] >= 10) {
				move[i][j + 1]++;
				move[i][j] %= 10;
			}
		}
	}
	memset(hanoi, 0, sizeof(hanoi));
	hanoi[0][0] = 0;
	p = 1;
	for(i = 0; i <= 150 && p <= MAX_N; i++) {
		for(j = 1; j <= i + 1 && p <= MAX_N; j++) {
			for(k = 0; k < MAX_LEN; k++) {
				hanoi[p][k] += hanoi[p - 1][k] + move[i][k];
				if(hanoi[p][k] >= 10) {
					hanoi[p][k + 1]++;
					hanoi[p][k] %= 10;
				}
			}
			p++;
		}
	}
	while(scanf("%d", &n) == 1) {
		for(i = MAX_LEN - 1; i >= 0; i--) {
			if(hanoi[n][i] != 0) {
				s = i;
				break;
			}
		}
		for(i = s; i >= 0; i--)
				printf("%d", hanoi[n][i]);
		printf("\n");
	}
	return 0;
}