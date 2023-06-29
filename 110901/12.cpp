#include<iostream>

using namespace std;

static int graph[200][200];
static int color[200];
static int colorable;

void dfs(int node, int c, int n)
{
	color[node] = c;
	for (int i = 0; i < n && colorable; i++)
	{
		if (graph[node][i] == 0)
			continue;
		if (color[i] == 0)
			dfs(i, c % 2 + 1, n);
		else
		{
			if (color[i] == c)
			{
				colorable = 0;
				return;
			}
		}
	}
}

int main()
{
	
	int n;
	while (1)
	{
		cin >> n;
		if (n == 0)
			break;
		int l, a, b;

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				graph[i][j] = 0;

		cin >> l;
		for (int i = 0; i < l; i++)
		{
			cin >> a >> b;
			graph[a][b] = graph[b][a] = 1;
		}

		for (int i = 0; i < n; i++)
			color[i] = 0;
		colorable = 1;

		dfs(0, 1, n);

		if (colorable == 0)
			cout << "NOT BICOLORABLE." << endl;
		else
			cout << "BICOLORABLE." << endl;
	}

	return 0;
}