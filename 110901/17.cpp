#include <iostream>
using namespace std;

int n;
int graph[201][201];
int color[201];
int c_able;

int input() {
	int l, x, y;
	
	cin >> n;
	if(n == 0) return 0;
	
	for(int i = 0; i < n; i++) {
		for(int j = 0; j < n; j++) {
			graph[i][j] = 0;
		}
	}
	
	cin >> l;
	for(int i = 0; i < l; i++) {
		cin >> x >> y;
		graph[x][y] = graph[y][x] = 1;
	}
	return 1;
}

void dfs(int nd, int c) {
	
	color[nd] = c;
	for(int i = 0; i < n && c_able; i++) {
		if(graph[nd][i] == 0) continue;
		
		if(color[i] == 0) dfs(i, c%2 + 1);
		else {
			if(color[i] == c) {
				c_able = 0;
				return;
			}
		}
	}
}

int main() {
	
	while(input()) {
		for(int i = 0; i < n; i++) {
			color[i] = 0;
		}
		
		c_able = 1;
		
		dfs(0, 1);
		
		if(c_able == 0) cout << "NOT BICOLORABLE." << endl;
		else cout << "BICOLORABLE." << endl;
		
	}
	return 0;
}