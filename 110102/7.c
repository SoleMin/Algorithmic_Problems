#include <stdio.h>
#include <stdlib.h>
#define LINE_MAX 100
#define FIELD_MAX 10
int main() {
	int n, m, k = 0; // 행, 열, 필드번호
	int i, j, x, y; // for문 변수
	int num, temp; // 필드번호2 임시 변수
	int field[FIELD_MAX][2];// 필드번호->행,열 크기
	char mine[LINE_MAX][LINE_MAX];// 지뢰밭 입력
	char ***ex_mine;// 지뢰밭 출력
	
	ex_mine = (char***)malloc(sizeof(char**)*FIELD_MAX);
	for(i = 0; i < FIELD_MAX; i++){
		ex_mine[i] = (char**)malloc(sizeof(char*)*LINE_MAX);
		for(j = 0; j < LINE_MAX; j++){
			ex_mine[i][j] = (char*)malloc(sizeof(char)*LINE_MAX);
		}
	}
	
	while(1){
		scanf("%d %d", &field[k][0], &field[k][1]);
		
		n = field[k][0];
		m = field[k][1];
		
		for(i = 0; i < n; i++)
			scanf("%s", mine[i]);
		
		for(i = 0; i < n; i++){
			for(j = 0; j < m; j++){
				if(mine[i][j] == '.') ex_mine[k][i][j] = '0';
				else ex_mine[k][i][j] = '*';
			}
		}
		
		for(i = 0; i < n; i++){
			for(j = 0; j < m; j++){
				if(mine[i][j] == '*'){
					for(x = i - 1; x <= i + 1; x++){
						for(y = j - 1; y <= j + 1; y++){
							if((mine[x][y] == '*') || (x < 0 || x >= n) || (y < 0 || y >= m)) continue;
							
							temp = ex_mine[k][x][y] - '0';
							temp++;
							ex_mine[k][x][y] = temp + '0';
						}
					}
				}
			}
		}
		if((n+m) == 0) break;
		k++;
	}
	
	for(num = 0; num < k; num++){
		n = field[num][0];
		m = field[num][1];
		printf("Field #%d:\n",num+1);
		
		for(i = 0; i < n; i++){
			for(j = 0; j < m; j++){
				printf("%c",ex_mine[num][i][j]);
			}
			printf("\n");
		}
		printf("\n");
	}
	
	for(i = 0; i < FIELD_MAX; i++){
		for(j = 0; j < LINE_MAX; j++){
			free(ex_mine[i][j]);
		}
		free(ex_mine[i]);
	}
	free(ex_mine);
	
	return 0;
}
