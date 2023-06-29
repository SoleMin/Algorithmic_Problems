#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
	int m, n;
	int field = 1;
	int count = 0;
	int i, j;
	
	while(scanf("%d %d", &m, &n) == 2) {
		if(m == 0 || n == 0)
			break;
		
		char **s = malloc(sizeof(char *) * m);
		
		for(i = 0; i < m; i++) {
			s[i] = malloc(sizeof(char) * (n + 1));
			memset(s[i], 0, sizeof(char) * (n + 1));
		}
		
		for(i = 0; i < m; i++) {
			scanf("%s", s[i]);
		}
		
		printf("Field #%d:\n", field);
		
		for(i = 0; i < m; i++) {
			for(j = 0; j < n; j++) {
				if(s[i][j] == '*'){
					printf("%c", s[i][j]);
					continue;
				}
				else{
					for(int a = i - 1; a <= i + 1; a++) {
						for(int b = j - 1; b <= j + 1; b++) {
							if(a < 0 || b < 0 || a >= m || b >= n)
								continue;
								else if(s[a][b] == '*')
									count += 1;
						}
					}
					s[i][j] = count;
					printf("%d", s[i][j]);
					count = 0;
				}
			}
			printf("\n");
		}
		printf("\n");
		field++;
	}
	return 0;
}
