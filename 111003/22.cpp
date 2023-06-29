#include <iostream>
#include <string>
#include <sstream>
#include <cstring>
using namespace std;

const int INF = 87654321;

int n, m;
bool isFire[501];
int adj[501][501];

void init() {
	for(int i = 0; i <= m; i++)
		for(int j = 0; j <= m; j++) {
			if(i == j)
				adj[i][j] = 0;
			else
				adj[i][j] = INF;
		}
	memset(isFire, 0, sizeof(isFire));
}

void floyd() {
	for(int k = 0; k < m; k++) {
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < m; j++) {
				int weight = adj[i][k] + adj[k][j];
				if(weight < adj[i][j]) {
					adj[i][j] = weight;
				}
			}
		}
	}
	
// 	for(int i = 0; i < m; i++) {
// 		for(int j = 0; j < m; j++)
// 			cout << adj[i][j] << ' ';
// 		cout << endl;
// 	}
}

int solve() {
	// int maxDst = -1;
	int minDst = INF;
	int newStation = -1;
	for(int src = 0; src < m; src++) {
		if(isFire[src]) continue;
		
		isFire[src] = true;
		int tmpMax = 0;
		for(int i = 0; i < m; i++) {
			if(isFire[i]) continue;
			int tmpMin = INF;
			for(int j = 0; j < m; j++) {
				if(!isFire[j]) continue;
				tmpMin = min(tmpMin, adj[i][j]);
			}
			tmpMax = max(tmpMax, tmpMin);
		}
		if(minDst > tmpMax) {
			minDst = tmpMax;
			newStation = src;
		}
		isFire[src] = false;
	}
	return newStation + 1;
// 	for(int src = 0; src < m; src++) {
// 		if(isFire[src]) continue;
		
// 		int tmpMax = 0;
// 		for(int dst = 0; dst < m; dst++) {
// 			if(src == dst || isFire[dst]) continue;
// 			tmpMax = max(tmpMax, adj[src][dst]);
// 		}
// 		cout << src << ", " << tmpMax << endl;
// 		if(minDst > tmpMax) {
// 			minDst = tmpMax;
// 			newStation = src;
// 		}
// 	}
// 	return newStation + 1;
}

int main() {
	int t; cin >> t;
	while(t--) {
		cin >> n >> m;
		
		init();
		for(int i = 0; i < n; i++) {
			int tmp; cin >> tmp;
			isFire[tmp - 1] = true;
		}
		
		cin.get();					// delete newLine
		string s;
		int a, b, c;
		while(true) {
			getline(cin, s);
			if(s == "") break;
			stringstream ss(s);
			ss >> a >> b >> c;
			a--; b--;
			adj[a][b] = min(adj[a][b], c);
			adj[b][a] = min(adj[b][a], c);
		}
		
		floyd();
		cout << solve() << "\n\n";
	}
	
	
	return 0;
}