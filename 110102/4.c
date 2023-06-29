#include <stdio.h>
#define MAX 102
int main() {
	int n, m, cnt = 1;
	int i, j, k;
	while(scanf("%d %d", &n, &m) == 2){
		if(n == 0 && m == 0) break;
		char minesweeper[MAX][MAX] = {',',};
		for(i = 1;i <= n; i++){
			fflush(stdin);
			for(j = 1; j <= m + 1;j++)
				minesweeper[i][j] = getchar();
		}
		printf("\nField #%d:\n", cnt);
		for(i = 1; i <= n; i++){
			for(j = 2; j <= m + 1;j++){
				if(minesweeper[i][j] == '*') printf("%c", minesweeper[i][j]);
				else{
					k=0;
					if(minesweeper[i][j+1] == '*') k++;
					if(minesweeper[i][j-1] == '*') k++;
					if(minesweeper[i+1][j] == '*') k++;
					if(minesweeper[i-1][j] == '*') k++;
					if(minesweeper[i+1][j+1] == '*') k++;
					if(minesweeper[i+1][j-1] == '*') k++;
					if(minesweeper[i-1][j+1] == '*') k++;
					if(minesweeper[i-1][j-1] == '*') k++;
					printf("%d", k);
				}
			}
			printf("\n");
		}
		cnt++;
	}
	return 0;
}
