#include <cstdio>
#include <vector>
#include <cmath>
using namespace std;

vector<int> chop;
int dp[5001];
int two[5001];

int main()
{
	int T, i, j, N, K, least;
	scanf("%d", &T);

	while (T--) {
		scanf("%d %d", &K, &N);
		K += 8;
		chop.clear();
		chop.assign(N+1, 0);
		// K : 손님 수, N : 젓가락의 갯수

		for (i = N; i >= 1; i--)
			scanf("%d", &chop[i]);

		for (i = 2; i <= N; i++)
			two[i] = pow(chop[i] - chop[i - 1], 2);


		for (i = 0; i <= N; i++)
			dp[i] = 0;

		for (i = 1; i <= K; i++) {
			for (j = N; i * 3 <= j; j--)
				dp[j] = dp[j - 2] + two[j];
			for (j = i * 3; j <= N - 1; j++)
				if (dp[j] < dp[j + 1])
					dp[j + 1] = dp[j];
		}

		printf("%d\n", dp[N]);
	}
	return 0;
}