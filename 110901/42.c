#include <stdio.h>
#define MAXN 200

static int n, graph[MAXN][MAXN];
static int color[MAXN];
static int colorable;

void dfs(int node, int c){
	int i;
	color[node] = c;
	for(i=0; i < n && colorable; i++){
		if(graph[node][i]==0) continue;
		if(color[i]==0)
			dfs(i, c%2 + 1);
		else{
			if(color[i]==c){
				colorable=0;
				return;
			}
		}
	}
}

int main() {
	int i, j, k, l, p, q;
	scanf("%d",&n);
	while(n != 0) {
		for(i = 0; i < n; i++)
			for(j = 0; j < n; j++)
				graph[i][j] = 0;
		scanf("%d",&l);
		for(i=0; i<l; i++){
			scanf("%d %d", &p, &q);
			graph[p][q] = graph[q][p] =1;
		}
		for(i=0; i<n; i++)
			color[i]=0;
		colorable = 1;
		dfs(0,1);
		if(colorable==0)
			printf("NOT BICOLORABLE.\n");
		else
			printf("BICOLORABLE.\n");
		
		scanf("%d", &n);
	}
}
