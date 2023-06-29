#include <iostream>
#include <algorithm>
#define MAX_N 5607
#define INF 200000000
using namespace std;

typedef struct _Turtle {
	int w; // weight
	int h; // health
} Turtle;

Turtle T[MAX_N];
int dp[MAX_N];

bool cmp(Turtle a, Turtle b) {
	if(a.h == b.h)
		return a.w < b.w;
	return a.h < b.h;
}

int main(void) {
	int tnum = 1;
	
	while(scanf("%d %d", &T[tnum].w, &T[tnum].h) != EOF)
		tnum++;
	
	sort(T + 1, T + tnum, cmp);
	tnum--;
	
	for(int i = 1; i <= tnum; i++)
		dp[i] = INF;
	dp[0] = 0;
	
	int result = 1;
	for(int i = 1; i <= tnum; i++) {
		for(int j = tnum; j >= 1; j--) {
			if(dp[j - 1] + T[i].w <= T[i].h)
				dp[j] = min(dp[j], dp[j - 1] + T[i].w);
			if(dp[j] < INF)
				result = max(j, result);
		}
	}
	
	printf("%d\n", result);
	return 0;
}