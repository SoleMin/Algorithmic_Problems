#include <stdio.h>
#include <map>
#include <set>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

vector<int> g[105];
map<string, int> R;
set<string> S;
int visited[105], depth[105];
char buf[105], name[105][105];

int dfs(int node, int dep, int chk, int root) {
	int i, back = 0xffff, tmp, son = 0;
	bool cntpoint = false;
	depth[node] = dep;
	visited[node] = 1;

	for (i = 0; i < g[node].size(); i++) {
		if (visited[g[node][i]] == 0) {
			tmp = dfs(g[node][i], dep + 1, node, root);
			if (tmp >= dep)  cntpoint = true;
			son++;
			back = min(back, tmp);
		}
		else {
			if (g[node][i] != chk)
				back = min(back, depth[g[node][i]]);
		}
	}

	if ((node == root && son > 1)
		|| (node != root && cntpoint)) {
		S.insert(name[node]);
	}

	return back;
}
int main() {
	int n, m, i, j, x, y, cases = 0;

	while (scanf("%d", &n) == 1 && n) {
		R.clear();
		S.clear();

		for (i = 0; i < n; i++) {
			scanf("%s", name[i]);
			R[name[i]] = i;
			g[i].clear();
			visited[i] = depth[i] = 0;
		}

		scanf("%d", &m);
		while (m--) {
			scanf("%s", buf);
			x = R[buf];
			scanf("%s", buf);
			y = R[buf];
			g[x].push_back(y);
			g[y].push_back(x);
		}

		for (i = 0; i < n; i++) {
			if (visited[i] == 0) {
				dfs(i, 1, -1, i);
			}
		}

		if (cases)   puts("");
		printf("City map #%d: %d camera(s) found\n", ++cases, S.size());

		for (set<string>::iterator it = S.begin();
			it != S.end(); it++)
			cout << *it << endl;
	}

	return 0;
}