#include <iostream>
#include <vector>
#include <cstring>
#include <queue>
using namespace std;
int n;
// int src[4], dst[4];
int src, dst;
vector<int> avoid;
// bool adj[10000][10000];
vector<int> adj[10000];
int visited[10000];
// vector<vector<int>> avoid;

void init() {
	for(int i = 0; i < 10000; i++) {
		// 일의 자리
		if(i % 10 == 9) {
			adj[i].push_back(i - 9);
			adj[i].push_back(i - 1);
			// adj[i][i - 9] = true;
			// adj[i][i - 1] = true;
		}
		else if(i % 10 == 0) {
			adj[i].push_back(i + 1);
			adj[i].push_back(i + 9);
			// adj[i][i + 1] = true;
			// adj[i][i + 9] = true;
		}
		else {
			adj[i].push_back(i + 1);
			adj[i].push_back(i - 1);
			// adj[i][i + 1] = true;
			// adj[i][i - 1] = true;
		}
		
		// 십의 자리
		int ten = i / 10 % 10;
		if(ten == 9) {
			adj[i].push_back(i - 90);
			adj[i].push_back(i - 10);
			// adj[i][i - 90] = true;
			// adj[i][i - 10] = true;
		}
		else if(ten == 0) {
			adj[i].push_back(i + 10);
			adj[i].push_back(i + 90);
			// adj[i][i + 10] = true;
			// adj[i][i + 90] = true;
		}
		else {
			adj[i].push_back(i + 10);
			adj[i].push_back(i - 10);
			// adj[i][i + 10] = true;
			// adj[i][i - 10] = true;
		}
		
		//백의자리
		int hundr = i / 100 % 10;
		if(hundr == 9) {
			adj[i].push_back(i - 900);
			adj[i].push_back(i - 100);
			// adj[i][i - 900] = true;
			// adj[i][i - 100] = true;
		}
		else if(hundr == 0) {
			adj[i].push_back(i + 100);
			adj[i].push_back(i + 900);
			// adj[i][i + 100] = true;
			// adj[i][i + 900] = true;
		}
		else {
			adj[i].push_back(i + 100);
			adj[i].push_back(i - 100);
			// adj[i][i + 100] = true;
			// adj[i][i - 100] = true;
		}
		
		//천의 자리
		int thou = i / 1000;
		if(thou == 9) {
			adj[i].push_back(i - 9000);
			adj[i].push_back(i - 1000);
			// adj[i][i - 9000] = true;
			// adj[i][i - 1000] = true;
		}
		else if(thou == 0) {
			adj[i].push_back(i + 1000);
			adj[i].push_back(i + 9000);
			// adj[i][i + 1000] = true;
			// adj[i][i + 9000] = true;
		}
		else {
			adj[i].push_back(i + 1000);
			adj[i].push_back(i - 1000);
			// adj[i][i + 1000] = true;
			// adj[i][i - 1000] = true;
		}
	}
}

int solve() {
	queue<int> q;
	q.push(src);
	visited[src] = 0;
	
	// 금지 배치를 방문된 것으로 전처리
	for(int i = 0; i < avoid.size(); i++) {
		visited[avoid[i]] = 0;
	}
	
	while(!q.empty()) {
		int cur = q.front();
		q.pop();
		
		if(cur == dst) {
			return visited[cur];
		}
		
		for(int i = 0; i < 8; i++) {
			int next = adj[cur][i];
			if(visited[next] != -1) continue;
			q.push(next);
			visited[next] = visited[cur] + 1;
		}
	}
	return -1;
}

int main() {
	int t; cin >> t;
	
	init();
	
	while(t--) {
		memset(visited, -1, sizeof(visited));
		avoid.clear();
		src = dst = 0;
		
		int tmp;
		for(int i = 0; i < 4; i++) {
			cin >> tmp;
			src *= 10;
			src += tmp;
		}
		for(int i = 0; i < 4; i++) {
			cin >> tmp;
			dst *= 10;
			dst += tmp;
		}
		cin >> n;
		for(int i = 0; i < n; i++) {
			int num = 0;
			for(int j = 0; j < 4; j++) {
				cin >> tmp;
				num *= 10;
				num += tmp;
			}
			avoid.push_back(num);
		}
		
		cout << solve() << '\n';
	}
// 	while(t--) {
// 		for(int i = 0; i < 4; i++)
// 			cin >> src[i];
// 		for(int i = 0; i < 4; i++)
// 			cin >> dst[i];
// 		cin >> n;
// 		avoid = vector<vector<int>>(n, vector<int>(4));
// 		for(int i = 0; i < n; i++) {
// 			for(int j = 0; j < 4; j++) {
// 				cin >> avoid[i][j];
// 			}
// 		}
// 	}
	
	return 0;
}