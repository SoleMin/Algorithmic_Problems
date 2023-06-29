#include<iostream>
#include<cstdio>
#include<cstring>
#include<algorithm>
#define INF 0x3f3f3f3f
using namespace std;

int dp[5607];
struct Turtle {
	int w, s;
} t[5607];

bool cmp(Turtle t1, Turtle t2) {
	return t1.s < t2.s;
}

int main() {
	int N = 0;
	while (scanf("%d%d", &t[N].w, &t[N].s) != EOF) N++;
	sort(t, t + N, cmp);

	int M = 0, i, j;
	memset(dp, INF, sizeof(dp));
	dp[0] = 0;
	for (i = 0; i < N; i++)
		for (j = M; j >= 0; j--)
		{
			if (t[i].s >= dp[j] + t[i].w && dp[j] + t[i].w < dp[j + 1])
			{
				dp[j + 1] = dp[j] + t[i].w;
				if (j + 1 > M) M = j + 1;
			}
		}
	printf("%d", M);

	return 0;
}