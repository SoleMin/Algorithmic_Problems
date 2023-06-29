#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

#define N 5607

typedef struct {
	int weight;
	int strength;
} turtle;

turtle turtles[N];
int n = 0;
int result;

int min(int x, int y) {
  return x < y ? x : y;
}

int compare(const void* x, const void* y) {
	return (*(turtle*)x).strength - (*(turtle*)y).strength;
	//return (*(turtle*)y).strength - (*(turtle*)x).strength;
}

void all_work_and_no_play_makes_jack_a_dull_boy(void) {
  long dp[n + 1][n + 1];
  for (int i = 0; i < n + 1; i++)
    for (int j = 0; j < n + 1; j++) {
      dp[i][j] = INT_MAX;	
			dp[i][0] = 0;
		}
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
			if (j > i)
				break;
      if (dp[i - 1][j - 1] + turtles[i - 1].weight <= turtles[i - 1].strength)
        dp[i][j] = min(dp[i - 1][j - 1] + turtles[i - 1].weight, dp[i - 1][j]);
      else
        dp[i][j] = dp[i - 1][j];
    }
  }

  int max = -1;
  for (int i = 1; i <= n; i++) {
		if (dp[n][i] == INT_MAX)
			continue;
    if (dp[n][i] > max) {
      max = dp[n][i];
      result = i;
    }
  }
/*
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++)
			printf("%d ", dp[i][j]);
		printf("\n");
	}
	*/
}

int main(void) {
  while (scanf("%d %d", &turtles[n].weight, &turtles[n].strength) != EOF)
    n++;
  qsort(turtles, n, sizeof(turtle), compare);
	//for (int i = 0; i < n; i++)
		//printf("%d %d\n", turtles[i].weight, turtles[i].strength);
  all_work_and_no_play_makes_jack_a_dull_boy();
  printf("%d\n", result);
  return 0;
}