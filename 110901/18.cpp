#include <iostream>
#include <vector>
#include <queue>
using namespace std;
#define MAX 200

vector<int> adj[MAX + 1];
// bool visit[MAX + 1];
bool color[MAX + 1];
bool colorable;

void dfs(int node, bool c) {
	int i;
	color[node] = c;
	for (i = 0; i < adj[node].size() && colorable; i++) {
		if (!color[adj[node][i]])
			dfs(adj[node][i], !c);	// 재귀
		else {
			if (color[adj[node][i]] == c) {
				colorable = false;
				return;
			}
		}
	}
}

int main() {
	int v, e, i, j, v1, v2;

	while (1) {
		scanf("%d", &v);
		if (v == 0) break;

		// node가 0이 아니면 edge 입력 받기
		scanf("%d", &e);
		colorable = true;
		// 인접 행렬 채우기
		for (i = 0; i < e; i++) {
			scanf("%d %d", &v1, &v2);
			adj[v1].push_back(v2);
			adj[v2].push_back(v1);
		}

		dfs(0, 1);

		if (colorable)
			cout << "BICOLORABLE." << '\n';
		else
			cout << "NOT BICOLORABLE." << '\n';

		for (int j = 0; j < v; j++) {
			adj[j].clear();
			color[j] = false;
		}
	}

	return 0;
}