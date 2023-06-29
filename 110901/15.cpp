#include <iostream>
#include <vector>
#include <cstring>
using namespace std;

int n, k;
bool bicolor;
bool adj[201][201];
int visited[201];

// 1 : black, -1 : red
void dfs(int curV, int curColor) {
	for(int i = 0; i < n; i++) {
		if(!adj[curV][i] || curV == i) continue;
		if(visited[i]) {
			if(visited[i] == curColor) {
				bicolor = false;
				return;
			}
			continue;
		}
		visited[i] = -curColor;
		dfs(i, -curColor);
	}
} 

int main() {
	while(true) {
		memset(visited, 0, sizeof(visited));
		memset(adj, 0, sizeof(adj));
		cin >> n;
		if(!n) break;
		cin >> k;
		int a, b;
		for(int i = 0; i < k; i++) {
			cin >> a >> b;
			adj[a][b] = true;
			adj[b][a] = true;
		}
		
		bicolor = true;
		visited[0] = 1;
		dfs(0, 1);
		if(bicolor)
			cout << "BICOLORABLE.\n";
		else
			cout << "NOT BICOLORABLE.\n";
	}	
	
	return 0;
}