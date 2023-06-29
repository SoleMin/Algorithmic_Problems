#include <stdio.h>

#define MAXN 200

static int n, graph[MAXN][MAXN]; //n: 정점의 개수, graph: i에서 j로 가는 엣지가 있으면 1 or 0
static int color[MAXN];
static int colorable;

int input(void) {
	int i, j, l, a, b;
	scanf("%d", &n);
	if (n == 0)
		return 0;
	for (i = 0; i < n; i++)
		for (j = 0; j < n; j++)
			graph[i][j] = 0; //그래프 초기화 부분
	scanf("%d", &l);
	for (i = 0; i < l; i++) {
		scanf("%d %d", &a, &b);
		graph[a][b] = graph[b][a] = 1; //비방향 그래프이니 모두 활성화
	}
	return 1;
}

void dfs(int node, int c) {
	int i;
	color[node] = c;
	for (i = 0; i < n && colorable; i++) {
		if (graph[node][i] == 0)
			continue;
		if (color[i] == 0)
			dfs(i, c%2 + 1);
		else {
			if (color[i] == c) {
				colorable = 0;
				return;
			}
		}
	}
}

void main(void) {
	int i;
	while (input()) {
		for (i = 0; i < n; i++)
			color[i] = 0; //이게 아마 방문 했는지를 알리는 변수
		colorable = 1; //일단 true로 놓는거겠지
		dfs(0, 1); //0번 노드부터 1 색부터 시작
		if (colorable == 0)
			printf("NOT BICOLORABLE.\n");
		else
			printf("BICOLORABLE.\n");
	}
}