#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

int T;
int K;
int N;
int L[5001];
int dp[1001][5001];
int differ[5001];
FILE* god;

int get_min(int x, int y) {
  return x < y ? x : y;
}

void input(void) {
		//fscanf(god, "%d %d", &K, &N);
		scanf("%d %d", &K, &N);
		for (int i = N; i >= 1; i--)
			scanf("%d", L + i);
			//fscanf(god, "%d", L + i);
    for (int i = 2; i <= N; i++)
      differ[i] = (L[i] - L[i - 1]) * (L[i] - L[i - 1]);
    for (int i = 0; i < 1001; i++)
      for (int j = 0; j < 5001; j++)
        dp[i][j] = 0;
}

void solve(void) {
  for (int i = 1; i <= K + 8; i++) {
    dp[i][3 * i] = dp[i - 1][3 * i - 2] + differ[3 * i];
    for (int j = 3 * i + 1; j <= N; j++)
      dp[i][j] = get_min(dp[i - 1][j - 2] + differ[j], dp[i][j - 1]);
  }
  printf("%d\n", dp[K + 8][N]);
}

int main(void) {
  //god = fopen("input.txt", "r");
	//fscanf(god, "%d", &T);
	scanf("%d", &T);
	while (T--) {
		input();
		solve();
	}
}