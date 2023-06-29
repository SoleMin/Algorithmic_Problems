#include <stdio.h>
#define NSIZE 100
#define MSIZE 100

int main() {
	
	int n, m, i, j, k, l, f_num = 1;
	
	char input[NSIZE+1][MSIZE+1];
	char result[NSIZE+2][MSIZE+2];
	
	scanf("%d %d", &n, &m);
	while(n != 0 && m != 0){
		for(i=1; i<=n; i++)
			for(j=1; j<= m; j++)
				result[i][j]='0';
		
		for(i=1; i<=n; i++)
			scanf("%s", input[i]);
		
		for(i=1; i<=n; i++) {
			for(j=1; j<=m; j++){
				if (input[i][j-1] == '*'){
					for (k = i-1; k < i+2 ; k++){
						for(l = j-1; l < j+2; l++)
							result[k][l]++;
					}
				}
			}
		}
		
		for(i=1; i<=n; i++){
			for(j=1; j<=m; j++){
				if (input[i][j-1]=='*')
					result[i][j]='*';
			}
		}
		
		if (f_num> 1)
			printf("\n");
		printf("Field #%d:\n",f_num);
		f_num++;
		for( i =1; i <=n; i++){
			for(j = 1; j <= m; j++){
				putchar(result[i][j]);
			}
			printf("\n");
		}
		scanf("%d %d", &n, &m);
	}
	return 0;
}
