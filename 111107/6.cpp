#include <iostream>
#include <cstring>
#define MAXK 1000
#define MAXN 5000
#define INF 100000

using namespace std;

int k, n, chop[MAXN], dp[MAXK+8][MAXN];

int len(int a, int b){
	return (a-b)*(a-b);
}

void solve(){
	for(int i=0; i<k; i++){
		for(int j=0; j<n; j++){
			if(3*(i+1) > j+1)
				continue;
			if(i == 0)
				dp[i][j] = len(chop[j], chop[j-1]);
			else
				dp[i][j] = dp[i-1][j-2] + len(chop[j], chop[j-1]);
			if(3*(i+1) < j+1)
				dp[i][j] = min(dp[i][j-1], dp[i][j]);
		}
	}
}

int main() {
	int t;
	cin >> t;
	for(; t>0; t--){
		cin >> k >> n;
		k += 8;
		memset(dp, INF, sizeof(dp));
		for(int i=n-1; i>=0; i--){
			cin >> chop[i];
		}
		solve();
		cout << dp[k-1][n-1] << endl;
	}
	

	return 0;
}