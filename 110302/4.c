#include <stdio.h>
#include <string.h>
int findword(const char grid[51][51], int M, int N, int row, char* word)
{
	int i, j, c, r, cnt, wordlen;
	
	wordlen = strlen(word);
	
	
	for(j=0; j<N; j++)
	{
		cnt = 0;
		r = row, c = j;
		while(cnt < wordlen){			// 왼쪽 위로 찾기
			if(r<0 || c<0 || grid[r][c] != word[cnt])
				break;
			r--, c--;
			cnt++;
		}
		if(cnt == wordlen)
			return j;
		
		cnt = 0;
		r = row, c = j;
		while(cnt < wordlen){			// 위로 찾기
			if(r < 0 || grid[r][c] != word[cnt])
				break;
			r--;
			cnt++;
		}
		if(cnt == wordlen)
			return j;
		cnt = 0;
		r = row, c = j;
		while(cnt < wordlen){			//오른쪽 위로 찾기
			if(r<0 || c == N || grid[r][c] != word[cnt])
				break;
			r--, c++;
			cnt++;
		}
		if(cnt == wordlen)
			return j;
		cnt = 0, r = row, c = j;
		while(cnt < wordlen){			//오른쪽으로 찾기
			if( c==N || grid[r][c] != word[cnt])
				break;
			c++;
			cnt++;
		}
		if(cnt == wordlen)
			return j;
		cnt = 0, r = row, c = j;
		while(cnt < wordlen){
			if(c==N || r==M || grid[r][c]!=word[cnt])
				break;
			r++, c++;
			cnt++;
		}
		if(cnt == wordlen)
			return j;
		cnt = 0, r = row, c = j;
		while(cnt < wordlen){
			if(r == M || grid[r][c]!= word[cnt])
				break;
			r++;
			cnt++;
		}
		if(cnt == wordlen)
			return j;
		cnt = 0, r = row, c = j;
		
		while(cnt < wordlen){
			if(r == M || c < 0 || grid[r][c] != word[cnt])
				break;
			r++, c--;
			cnt++;
		}
		if(cnt == wordlen)
			return j;
		cnt = 0, r = row, c = j;
		
		while(cnt < wordlen){
			if(c < 0 || grid[r][c] != word[cnt])
				break;
			c--;
			cnt++;
		}
		if(cnt == wordlen)
			return j;
	}
	return -1;
}
int main() {
	int M, N, i, j, T, t, K, k, loc;
	char grid[51][51], word[51], tmp[10];
	
	scanf("%d", &T);
	
	for(t=0; t<T; t++){
		scanf("%d %d", &M, &N);
	
		for(i=0; i<M; i++){
			scanf("%s", grid[i]);
			for(j=0; grid[i][j]!='\0'; j++)
				grid[i][j] = toupper(grid[i][j]);
		}
		scanf("%d", &K);
		fgets(word, 51, stdin);
		while(fgets(word, 51, stdin)){
			if(word[0]=='\n')
				break;
			word[strlen(word)-1]='\0';
			for(i=0; word[i]!='\0'; i++)
				word[i] = toupper(word[i]);
			for(i=0; i<M; i++){
				if((loc = findword(grid, M, N, i, word))>=0){
				   printf("%d %d\n", i+1, loc+1);
					break;
				}
			}
		}
		printf("\n");
	}
}
