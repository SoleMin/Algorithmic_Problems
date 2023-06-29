#include <stdio.h>
#include <ctype.h>
#include <string.h>
#define M_MAX 50
#define N_MAX 50
#define K_MAX 20
int canFind(int i, int j, int l, int m, int n, char grid[][N_MAX], char wordList[][M_MAX]){
	int mf, nf, w;
	mf = j; nf = l; w = 0;
	// 북서쪽 방향 조사
	while(mf >= 0 && mf < m && nf >= 0 && nf < n && w < strlen(wordList[i]) && wordList[i][w] == grid[mf][nf]){
		mf += 1; nf -= 1; w++;
	}
	if(w == strlen(wordList[i]))
		return 1;
	// 북쪽 방향 조사
	mf = j; nf = l; w = 0;
	while(mf >= 0 && mf < m && nf >= 0 && nf < n && w < strlen(wordList[i]) && wordList[i][w] == grid[mf][nf]){
		mf += 1; nf += 0; w++;
	}
	if (w == strlen(wordList[i]))
		return 1;
	// 북동쪽 방향 조사
	mf = j; nf = l; w = 0;
	while(mf >= 0 && mf < m && nf >= 0 && nf < n && w < strlen(wordList[i]) && wordList[i][w] == grid[mf][nf]){
		mf += 1; nf += 1; w++;
	}
	if (w == strlen(wordList[i]))
		return 1;
	// 동쪽 방향 조사
	mf = j; nf = l; w = 0;
	while(mf >= 0 && mf < m && nf >= 0 && nf < n && w < strlen(wordList[i]) && wordList[i][w] == grid[mf][nf]){
		mf += 0; nf += 1; w++;
	}
	if (w == strlen(wordList[i]))
		return 1;
	// 남동쪽 방향 조사
	mf = j; nf = l; w = 0;
	while(mf >= 0 && mf < m && nf >= 0 && nf < n && w < strlen(wordList[i]) && wordList[i][w] == grid[mf][nf]){
		mf += -1; nf +=1; w++;
	}
	if (w == strlen(wordList[i]))
		return 1;
	// 남쪽 방향 조사
	mf = j; nf = l; w = 0;
	while(mf >= 0 && mf < m && nf >= 0 && nf < n && w < strlen(wordList[i]) && wordList[i][w] == grid[mf][nf]){
		mf += -1; nf += 0; w++;
	}
	if (w == strlen(wordList[i]))
		return 1;
	// 남서쪽 방향 조사
	mf = j; nf = l; w = 0;
	while(mf >= 0 && mf < m && nf >= 0 && nf < n && w < strlen(wordList[i]) && wordList[i][w] == grid[mf][nf]){
		mf += -1; nf += -1; w++;
	}
	if (w == strlen(wordList[i]))
		return 1;
	// 서쪽 방향 조사
	mf = j; nf = l; w = 0;
	while(mf >= 0 && mf < m && nf >= 0 && nf < n && w < strlen(wordList[i]) && wordList[i][w] == grid[mf][nf]){
		mf += 0; nf += -1; w++;
	}
	if (w == strlen(wordList[i]))
		return 1;
	return 0;
}
int main() {
	int testcase, m, n, k;
	// char grid[M_MAX][N_MAX];
	// char wordList[K_MAX][M_MAX];
	scanf("%d", &testcase);
	for(int t = 0; t < testcase; t++){
		if ( t > 0)
			putchar('\n');
		scanf("%d %d", &m, &n);
		char grid[M_MAX][N_MAX] = {};
		char wordList[K_MAX][M_MAX] = {};
		// 그리드 입력받고 대문자는 소문자로 고치기
		for(int i = 0; i < m; i++){
			scanf("%s", grid[i]);
			for(int j = 0; j < n; j++){
				if (isupper(grid[i][j])){
					grid[i][j] = tolower(grid[i][j]);
				}
			}
		}
		// 검색할 단어 목록 입력받고 대문자는 소문자로 고치기
		scanf("%d", &k);
		for(int i = 0; i < k; i++){
			scanf("%s", wordList[i]);
			for(int j = 0; j < strlen(wordList[i]); j++){
				if (isupper(wordList[i][j])){
					wordList[i][j] = tolower(wordList[i][j]);
				}
			}
		}
		// 단어 찾기
		for(int i = 0; i < k; i++){
			for(int j = 0; j < m; j++){
				for (int l = 0; l < n; l++){
					if(canFind(i, j, l, m, n, grid, wordList)){
						printf("%d %d\n", j+1, l+1);
						j = m; 
						l = n;
					}
				}
			}
		}
	}
}
