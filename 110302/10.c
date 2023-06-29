#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

int main() {
	char input[51], blank[100];
	int x[8] = {-1, -1, -1, 0, 0, 1, 1, 1};
	int y[8] = {1, 0, -1, 1, -1, 1, 0, -1};
	int m, n, t, i, j, k, l, t_i, t_j, t_x, t_y, index, check;
	
	scanf("%d", &t);
	while(t--){
		scanf("%d %d", &m, &n);
		char map[51][51];
		for(i=0; i<m; i++){
			scanf("%s", input);
			for(j=0; j<n; j++){
				map[i][j] = tolower(input[j]);
			}
		}
		
		scanf("%d", &k);
		while(k--){
			char find[51];
			scanf("%s", find);
			for(i=0; i<strlen(find); i++){
				find[i] = tolower(find[i]);
			}
			for(i=0; i<m; i++){
				for(j=0; j<n; j++){
					for(index=0; index<8; index++){
						t_i = i;
						t_j = j;
						t_x = m;
						t_y = n;
						l = 0;
						check = 0;
						while(t_i>=0 && t_i<m && t_j>=0 && t_j<n && map[t_i][t_j]==find[l]){
							t_i += x[index];
							t_j += y[index];
							l++;
							if(find[l]=='\0'){
								printf("%d %d\n", i+1, j+1);
								break;
							}
						}
						if(find[l]=='\0'){
							break;
						}
					}
					if(find[l]=='\0'){
						break;
					}
				}
				if(find[l]=='\0'){
					break;
				}
			}
		}
		if(t>0){
			printf("\n");
		}
	}
}