#include <iostream>
#include <cstdio>
#include <cstring>
#include <vector>
#include <map>
#include <set>
#include <utility>
#include <algorithm>

using namespace std;

const int MAXN = 10005;

// edge
struct Edge {
	int t;
	int n;
	bool c;
}e[MAXN * 10];

int front[MAXN];
int to;
int small[MAXN];
int dfs[MAXN];
int Index;
int index_2;
bool visited[MAXN];

// 구글선생님들이 이거 쓰라했음
map<string, int> city;
map<string, int>::iterator iter;

// 도시
string s1, s2;

// 간선 추가
void add(int u, int v) {
	e[to].t = v;
	e[to].n = front[u];
	e[to].c = false;
	front[u] = to++;
}

// 야매 DFS
void DFS(int vnear, int before) {
	int v; // vertex

	small[vnear] = ++Index;
	dfs[vnear] = ++Index;

	// 다음 정점표시
	int next = 0;

	for (int i = front[vnear]; i != -1; i = e[i].n) {
		
		v = e[i].t; // 정점 삽입

		if (v == before) { // 이전 정점 패스
			continue;
		}

		if (!dfs[v]) { // 확인할 가치가 있는 정점
			next++;
			DFS(v, vnear);

			if (small[vnear] > small[v]) {
				small[vnear] = small[v];
			}
			if (vnear != before && small[v] >= dfs[vnear]) {
				visited[vnear] = true;
			}
		} 
		else if (small[vnear] > dfs[v]) {
			small[vnear] = dfs[v];
		}
	}
	if (vnear == before && next > 1) { // 정점방문 후
		visited[vnear] = true;
	}
}

int main() {

	int n, m, t = 0;
	while (scanf("%d", &n) && n) {

		// 초기화들 memset이 for문보다 빠르다..!
		memset(front, -1, sizeof(front));
		memset(dfs, 0, sizeof(dfs));
		memset(visited, false, sizeof(visited));
		to = 0;
		Index = 0;
        index_2 = 0;
		city.clear();

		for (int i = 1; i <= n; i++) { // 도시 개수 받기
			cin >> s1;
			city[s1] = i;
		}

		scanf("%d", &m);
		for (int i = 0; i < m; i++) { // 연결된 도시 받기
			cin >> s1 >> s2;
			add(city[s1], city[s2]);
			add(city[s2], city[s1]);
		}

		for (int i = 1; i <= n; i++) { // 정점 검사 dfs호출
			if (!dfs[i]) {
				DFS(i, i);
			}
		}
		for (int i = 1; i <= n; i++) { // 방문 했다면 index증가
			if (visited[i]) {
				index_2++;
			}
		}

		if (t) printf("\n");
		printf("City map #%d: %d camera(s) found\n", ++t, index_2);
		// 구글선생님의 ilter
		for (iter = city.begin(); iter != city.end(); iter++)
			if (visited[iter->second])
				cout << iter->first << endl;
	}
	return 0;
}