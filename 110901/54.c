#include <stdio.h>

#define MAXNUM 200

static int n, graph [MAXNUM][MAXNUM];
static int color[MAXNUM];
static int colorable;

int input()
{
	int i, j, l ,a, b;
	
	scanf("%d", &n);
	if(n==0) return 0;
	
	for(i=0; i<n; i++)
		for(j=0; j<n; j++)
			graph[i][j] = 0;
	
	scanf("%d", &l);
	
	for(i = 0 ; i < l; i++)
	{
		scanf("%d %d", &a ,&b);
		
		graph[a][b] = graph[b][a] = 1;
	}
	
	return 1;
}


void dfs(int nd, int c)
{
	int i;
	
	color[nd] = c;
	for(i=0; i<n && colorable; i++)
	{
		if(graph[nd][i] == 0) continue;
		
		if(color[i] == 0)
			dfs(i, c%2 +1);
		else
		{
			if(color[i] == c)
			{
				colorable = 0;
				return;
			}
		}
	}
}

void main(void)
{
	int i;
	
	while(input())
	{
		for(i = 0; i<n;  i++)
			color[i] = 0;
		
		colorable = 1;
		
		dfs(0, 1);
		
		if(colorable == 0)
			printf("NOT BICOLORABLE.\n");
		else
			printf("BICOLORABLE.\n");
	}
}