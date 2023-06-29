#include <iostream>
#include <algorithm>
using namespace std;

const int INF = 1987654321;

vector<pair<int, int>> turt;
int dp[5610][5610];

bool comp(pair<int, int> a, pair<int, int> b) {
	return a.second < b.second;
}

void solve() {
	for(int i = 1; i <= turt.size(); i++) {
		for(int j = 1; j <= turt.size(); j++) {
			dp[i][j] = INF;
		}
	}
	dp[1][1] = turt[1].first;
	for(int i = 2; i < turt.size(); i++) {
		if(dp[1][i - 1] + turt[i].first < turt[i].second) {
			dp[1][i] = dp[1][i - 1] + turt[i].first;
		}
	}
	
	for(int i = 2; i < turt.size(); i++) {
		for(int j = 1; j <= i; j++) {
			if(dp[i - 1][j - 1] + turt[i].first <= turt[i].second)
				dp[i][j] = min(dp[i - 1][j - 1] + turt[i].first, dp[i - 1][j]);
			else
				dp[i][j] = dp[i - 1][j];
		}
	}
}

int main() {
	int a, b;
	turt.push_back({0, 0});
	while(true) {
		cin >> a >> b;
		if(cin.eof()) break;
		
		turt.push_back({a, b});
	}
	sort(turt.begin() + 1, turt.end(), comp);
	solve();
	
	
	// for(int i = 1; i < turt.size(); i++) {
	// 	for(int j = 1; j < turt.size(); j++)
	// 		cout << dp[i][j] << ' ';
	// 	cout << endl;
	// }
	
	int maxWeight = 0;
	int maxIdx = 0;
	for(int i = 1; i < turt.size(); i++) {
		int curWeight = dp[turt.size() - 1][i];
		if(curWeight != INF && maxWeight < curWeight) {
			maxWeight = curWeight;
			maxIdx = i;
		}
	}
	cout << maxIdx << '\n';
	
	
	return 0;
}