#include <stdio.h>
#include <string.h>

int main() {
	int m, n, c=1;
	
	while(scanf("%d %d", &m, &n) == 2){
		if(m==0 && n==0) break;
		getchar();
		char input[102][102];
		int map[102][102] = {0};
		for(int i=1; i<m+1; i++){
			for(int j=1; j<n+1; j++){
				scanf("%c", &input[i][j]);
				if(input[i][j] == '*')
					map[i][j] = -100;
				else
					map[i][j] = 0;
			}
			getchar();
		}
		for(int i=0; i<m+2; i++){
			for(int j=0; j<n+2; j++){
				if(map[i][j] < 0){
					for(int k=i-1; k<=i+1; k++){
						for(int p=j-1; p<=j+1; p++){
							map[k][p] += 1;
						} 
					} 
				}
			}
		}
		printf("Field #%d:\n", c);
		c++;
		for(int i=1; i<m+1; i++){
			for(int j=1; j<n+1; j++)
				if(map[i][j] < 0)
					printf("*");
				else
					printf("%d", map[i][j]);
			printf("\n");
		}
		printf("\n");
	}
	
	return 0;
}
