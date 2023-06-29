#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

// vector<pair<int, int>> arr;
vector<pair<int, pair<int, int>>> arr;
int dp[1001];
int parent[1001];

bool comp(pair<int, pair<int, int>> a, pair<int, pair<int, int>> b) {
	return a.second.first < b.second.first;
}

int main() {
	arr.push_back({0, {0, 99999}});
	int eNum = 1;
	while(true) {
		int a, b;
		cin >> a >> b;
		if(cin.eof()) break;
		arr.push_back({eNum++, {a, b}});
	}
	
	sort(arr.begin() + 1, arr.end(), comp);
	
	// for(int i = 0; i < arr.size(); i++) {
	// 	cout << arr[i].first << ' ';
	// }
	// cout << endl;
	
	
	for(int i = 1; i <= arr.size(); i++) {
		dp[i] = 1;
	}
	
	for(int i = 2; i < arr.size(); i++) {
		for(int j = 1; j < i; j++) {
			if(arr[i].second.first > arr[j].second.first && arr[i].second.second < arr[j].second.second) {
				if(dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
					parent[i] = j;
				}
				else if(dp[i] == dp[j] + 1) {
					if(arr[parent[i]].first > arr[j].first)
						parent[i] = j;
				}
			}
		}
	}
	
	// for(int i = 0; i < arr.size(); i++) {
	// 	cout << arr[i].second.second << ' ';
	// }
	// cout << endl;
	// for(int i = 0; i < arr.size(); i++) {
	// 	cout << arr[i].first << ' ';
	// }
	// cout << endl;
	// for(int i = 0; i < arr.size(); i++) {
	// 	cout << dp[i] << ' ';
	// }
	// cout << endl;
	// for(int i = 0; i < arr.size(); i++) {
	// 	cout << parent[i] << ' ';
	// }
	// cout << endl;
	
	int tmp = dp[1];
	for(int i = 2; i < arr.size(); i++) {
		if(tmp < dp[i]) {
			tmp = dp[i];
		}
	}
	
	vector<vector<int>> ret;
	for(int i = 1; i < arr.size(); i++) {
		if(dp[i] == tmp) {
			int idx = i;
			vector<int> vt;
			while(idx) {
				vt.push_back(arr[idx].first);
				idx = parent[idx];
			}
			
			reverse(vt.begin(), vt.end());
			ret.push_back(vt);
		}
	}
	sort(ret.begin(), ret.end());
	
	cout << tmp << '\n';
	for(int i = 0; i < ret[0].size(); i++) {
		cout << ret[0][i] << '\n';
	}
	
	
	
	return 0;
}