#include <stdio.h>

int main()
{
	int n, m, count = 1;
	
	while(1){
		scanf("%d %d", &n, &m);
		if(n == 0 && m == 0)
			break;
		
		char str[101][101] = {0,};
		for(int i=0; i < n; i++){
			scanf("%s", str[i]);
			for(int j=0; str[i][j] != '\0'; j++)
				if(str[i][j]=='.')
					str[i][j]='0';
		}
		
		for(int i=0; i < n; i++){
			for(int j=0; j<m; j++){
				if(str[i][j] == '*'){
					for(int a = i-1; a<=i+1; a++){
						if(a<0 || a>=n)
							continue;
						for(int b=j-1; b<=j+1; b++)
						{
							if(b<0 || b>=m || str[a][b] == '*')
								continue;
							str[a][b]++;
						}
					}
				}
			}
		}
		printf("Field #%d:\n", count++);
		for(int i=0; i<n; i++)
			printf("%s\n", str[i]);
		printf("\n");
	}
	return 0;
}