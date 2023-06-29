#include <stdio.h>
#define MAXN 1000

static int n, ti[MAXN], si[MAXN];
static int result[MAXN];

void input(void);
void solve(void);

int main() {
	int t;
	
	scanf("%d", &t);
	for(int i = 0; i < t; i++) {
		input();
		solve();
		if(i > 0)
			printf("\n");
		for(int j = 0; j < n - 1; j++)
			printf("%d ", result[j] + 1);
		printf("%d\n", result[n - 1] + 1);
	}
	return 0;
}

void input() {
	scanf("%d", &n);
	for(int i = 0; i < n; i++)
		scanf("%d %d", &ti[i], &si[i]);
}

void solve() {
	int i, j, temp;
	for(int i = 0; i < n; i++)
		result[i] = i;
	for(int i = 1; i < n; i++) {
		for(int j = 0; j < n - 1; j++) {
			if(ti[result[j]] * si[result[j + 1]] > ti[result[j + 1]] * si[result[j]]) {
				temp = result[j];
				result[j] = result[j + 1];
				result[j + 1] = temp;
			}
		}
	}
}
