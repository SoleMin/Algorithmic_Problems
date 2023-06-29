#include <iostream>
#include <string>
#include <map>
#include <queue>
#include <vector>
#include <cstring>
#include <algorithm>
using namespace std;

int n, r;
bool adj[101][101];
map<string, int> getNum;
map<int, string> getName;
vector<string> ret;

int bfs(int start) {
	bool visited[101] = {0, };
	visited[start] = true;
	
	queue<int> q;
	for(int i = 0; i < n; i++) {
		if(adj[start][i]) {
			q.push(i);
			visited[i] = true;
			break;
		}
	}
	
	int cnt = 0;
	while(!q.empty()) {
		int cur = q.front(); q.pop();
		cnt++;
		
		for(int i = 0; i < n; i++) {
			if(!visited[i] && adj[cur][i]) {
				q.push(i);
				visited[i] = true;
			}
		}
	}
	return cnt;
}

void solve() {
	
	for(int i = 0; i < n; i++) {
		int cnt = bfs(i);
		if(cnt < n - 1) {
			ret.push_back(getName[i]);
		}
	}
}

int main() {
	int tc = 0;
	while(true) {
		cin >> n;
		if(!n) break;
		tc++;
		// init
		getNum.clear();
		getName.clear();
		ret.clear();
		memset(adj, 0, sizeof(adj));
		
		int idx = 0;
		for(int i = 0; i < n; i++) {
			string s;
			cin >> s;
			getNum[s] = idx;
			getName[idx] = s;
			idx++;
		}
		cin >> r;
		for(int i = 0; i < r; i++) {
			string a, b;
			cin >> a >> b;
			adj[getNum[b]][getNum[a]] = adj[getNum[a]][getNum[b]] = true;
		}
		
		solve();
		sort(ret.begin(), ret.end());
		
		cout << "City map #" << tc << ": " << ret.size() << " camera(s) found\n";
		for(int i = 0; i < ret.size(); i++)
			cout << ret[i] << endl;
		cout << '\n';
	}
	
	
	return 0;
}