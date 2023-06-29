#include <stdio.h>
#include <string.h>
#include <ctype.h>
int main() {
	char grid[50][50];
	int i, j, t;
	int m, n, k;
	char low_grid[50][50];
	int test_case;
	char word[51];
	char low_word[51];
	char tmp_word[8][51];
	int len;
	scanf("%d\n", &test_case);
	while(test_case--){
		for(i = 0;i < 50;i++){
			for(j = 0;j < 50;j++){
				grid[i][j] = 0;
				low_grid[i][j] = 0;
			}
		}
		scanf("%d %d", &m, &n);
		for(i = 0;i < m;i++){
			scanf("%s", grid[i]);
		}
		for(i = 0;i < m;i++){
			for(j = 0;j < n;j++){
				low_grid[i][j] = tolower(grid[i][j]);
			}
		}
		scanf("%d", &k);
		while(k--){	
			for(i = 0;i < 8;i++)
				for(j = 0;j < 51;j++)
					tmp_word[i][j] = 0;
			scanf("%s", word);
			len = strlen(word);
			for(i = 0;i < 51;i++) low_word[i] = 0;
			for(i = 0;i < len;i++) low_word[i] = tolower(word[i]);
			for(i = 0;i < m;i++){
				for(j = 0;j < n;j++){
					if(low_word[0] == low_grid[i][j]){
						if((i - len) >= -1){
							for(t = 0;t < len;t++){
								tmp_word[0][t] = low_grid[i - t][j];
							}
						}
						if((i - len) >= -1 && (j + len) <= n){
							for(t = 0;t < len;t++){
								tmp_word[1][t] = low_grid[i - t][j + t];
							}
						}
						if((j + len) <= n){
							for(t = 0;t < len;t++){
								tmp_word[2][t] = low_grid[i][j + t];
							}
						}
						if((i + len) <= m && (j + len) <= n){
							for(t = 0;t < len;t++){
								tmp_word[3][t] = low_grid[i + t][j + t];
							}
						}
						if((i + len) <= m){
							for(t = 0;t < len;t++){
								tmp_word[4][t] = low_grid[i + t][j];
							}
						}
						if((i + len) <= m && (j - len) >= -1){
							for(t = 0;t < len;t++){
								tmp_word[5][t] = low_grid[i + t][j - t];
							}
						}
						if((j - len) >= -1){
							for(t = 0;t < len;t++){
								tmp_word[6][t] = low_grid[i][j - t];
							}
						}
						if((i - len) >= -1 && (j - len) >= -1){
							for(t = 0;t < len;t++){
								tmp_word[7][t] = low_grid[i - t][j - t];
							}
						}
						for(t = 0;t < 8;t++){
							if(strncmp(tmp_word[t], low_word, len) == 0){
								printf("%d %d\n", i + 1, j + 1); 
								i = m;
								j = n;
								break;
							}
						}
					}
				}
			}
		}
		printf("\n");
	}
	return 0;
}