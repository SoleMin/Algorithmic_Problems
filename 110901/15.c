#include <stdio.h>

int edge_has[200][200];
int color[200];
int possible = 1;

void dfs(int node , int c , int n)
{
	int i;
	color[node] = c;
	for(i=0; i<n && possible; i++)
	{
		if(edge_has[node][i] == 0) continue; //간선이 존재하지 않으므로 그곳에는 갈수없음
		
		if(color[i] == 0) dfs(i, c%2+1 , n); //색이 안칠해져있다면 c%2+1 (1또는2)로 색칠하라
		else if(color[i] == c) //만약 색이 칠해져있고 , 현재 노드를 중심으로 인접해있지만 , 색이 같을경우 이런경우 NOT BICOLORABLE.
		{
			possible = 0;
			return;
		}
	}
}

void init()
{
	possible = 1;
	for(int a=0; a<200; a++)
	{
		for(int b=0; b<200; b++)
		{
			edge_has[a][b] = 0;
		}
		color[a] = 0;
	}
}
int main() 
{
	int node ,edge ,start ,end;
	while(1)
	{
		init();
		scanf("%d" , &node); //노드의개수
		if(node == 0) return 0;
		scanf("%d" , &edge); //간선의 개수
		for(int a=0; a<edge; a++) //어떠한 간선이 있는지 입력
		{
			scanf("%d %d" , &start , &end);
			edge_has[start][end] = edge_has[end][start] = 1;
		}
		dfs(0,1,node);
		
		if(possible == 0 ) printf("NOT BICOLORABLE.\n");
		else printf("BICOLORABLE.\n");
	}
}
