#include <stdio.h>
int main(void) {
	int m, n, i, j;
	int count=1;
	
	char mat[100][100];
	char result[100][100];
	
	while (1) {
		scanf("%d %d", &m, &n);
		if(m==0 && n==0)
			break;
		
		for(i=0; i<m; i++) {
			for(j=0; j<n+1; j++) {
				mat[i][j] = getchar();
				if(mat[i][j] == '*')
					result[i][j] = '*';
				else
					result[i][j] = 48;
			}
		}
		
		for(i=0; i<m; i++) {
			for(j=0; j<n+1; j++) {
				if(result[i][j-1] == '*') {
					if(result[i][j] == '*')
						result[i][j] +=0;
					else
						result[i][j] +=1;
				}
				
				if(result[i][j+1] == '*') {
					if(result[i][j]=='*')
						result[i][j]+=0;
					else
						result[i][j]+=1;
				}
				if(result[i-1][j]=='*'){
					if(result[i][j]=='*')
						result[i][j]+=0;
					else
						result[i][j]+=1;
				}
				if(result[i+1][j]=='*'){
					if(result[i][j]=='*')
						result[i][j]+=0;
					else
						result[i][j]+=1;
				}
				if(result[i-1][j-1]=='*'){
					if(result[i][j]=='*')
						result[i][j]+=0;
					else
						result[i][j] += 1;
				}
				if(result[i-1][j+1]=='*'){
					if(result[i][j]=='*')
						result[i][j] +=0;
					else
						result[i][j] +=1;
				}
				if(result[i+1][j-1]=='*'){
					if(result[i][j]=='*')
						result[i][j]+=0;
					else
						result[i][j]+=1;
				}
				if(result[i+1][j+1]=='*'){
					if(result[i][j]=='*')
						result[i][j]+=0;
					else
						result[i][j]+=1;
				}
					
			}
		}
		printf("Field #%d:\n", count);
		for(i=0;i<m;i++){
			for(j=1;j<n+1;j++)
				printf("%c", result[i][j]);
			printf("\n");
		}
		printf("\n");
		count++;
		
		for(i=0; i<m; i++) {
			for(j=0;j<n+1; j++) {
				mat[i][j] = '\0';
				result[i][j] = '\0';
			}
		}
	}
}
