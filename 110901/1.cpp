#include <cstdio>
#define change(x) ((x==2)?3:2)
int** arr;
int* colorarr;
int result = 1;
void dfs(int N, int point)
{
	int i, j, tmp;
	static int color = 2, solved = false;


	if (point == 0) {
		solved = false;
		result = 1;
	}
	else if (solved) return;
	colorarr[point] = color;
	for (i = 0; i < N; i++)
	{
		if (arr[point][i] == 0 || point == i ) continue;
		else if (colorarr[i] == color) {
			solved = true;
			result = -1;
			return;
		}
		if (colorarr[i] != 0) continue;
		
		colorarr[i] = color;

		color = change(color);
		dfs(N, i);
		if (solved)
			return;
		color = change(color);
	}
}

int main()
{
	int i, j, n, e, N, inp1, inp2;
	scanf("%d", &N);
	while(N)
	{
		arr = new int*[N];
		colorarr = new int[N];
		for (i = 0; i < N; i++)
			arr[i] = new int[N];
		for (i = 0; i < N; i++) {
			colorarr[i] = 0;
			for (j = 0; j < N; j++)
				arr[i][j] = 0;
		}

		scanf("%d", &e);

		for (i = 0; i < e; i++)
		{
			scanf("%d %d", &inp1, &inp2);
			arr[inp1][inp2] = 1;
			arr[inp2][inp1] = 1;
		}

		dfs(N, 0);
		if (result == -1)
			printf("NOT BICOLORABLE.\n");
		else			
			printf("BICOLORABLE.\n");
		scanf("%d", &N);
	}
}