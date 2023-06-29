#include <stdio.h>
#define MAX_CHOPSTICKS 5000

int chopsticks[MAX_CHOPSTICKS];
int dp[1001][1001];

void solved(int guest, int num) {
	int i, j, temp;
	j = num;
	for (i = 0; i < j; i++) {
		temp = chopsticks[i];
		chopsticks[i] = chopsticks[j];
		chopsticks[j] = temp;
		j--;
	}

	for (j = 0; j <= num; j++)
		dp[0][j] = 0;
	
	for (i = 1; i <= guest + 8; i++) {
		for (j = 1; j <= num; j++) {
			if (j < 3 * i) {
				dp[i][j] = -1;
				continue;
			}

			dp[i][j] = -1;
			if (dp[i - 1][j - 2] != -1) 
				dp[i][j] = dp[i - 1][j - 2] + (chopsticks[j] - chopsticks[j - 1]) * (chopsticks[j] - chopsticks[j - 1]);
			
			if (dp[i][j - 1] != -1) {
				if (dp[i][j] == -1)
					dp[i][j] = dp[i][j - 1];
				
				else {
					if (dp[i][j - 1] < dp[i][j])
						dp[i][j] = dp[i][j - 1];
				}
			}
		}
	}
	printf("%d", dp[guest + 8][num]);
	printf("\n");
}

int main(void) {
	int test;
	int t, i, j;
	int guest, c_num;

	scanf("%d", &test);
	for (t = 0; t < test; t++) {
		scanf("%d %d", &guest, &c_num);
		
		for (i = 0; i < c_num; i++)
			scanf("%d", &chopsticks[i]);

		solved(guest, c_num);
	}
}