#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>

void main() {
	
	int test, i;
	char line[500];
	scanf("%d", &test);
	
	for (i = 0; i < test; i++) {
		int m, n, j, k, f, a, q;
		int count = 0;
		scanf("%d %d", &m, &n);	//grid_size m x n
		gets(line);
		char grid[m][n];
		
		for (j = 0; j < m; j++) 
			gets(grid[j]);
		
		for (j = 0; j < m; j++) 
			for (k = 0; k < n; k++) 
				if(isupper(grid[j][k])) 
					grid[j][k] = tolower(grid[j][k]);

		scanf("%d", &f);	//count_num
		gets(line);
		char find[f][51];
		
		for (j = 0; j < f; j++) 
			gets(find[j]);
		
		for (j = 0; j < f; j++)
			for (k = 0; k < strlen(find[j]); k++)
				if(isupper(find[j][k]))
					find[j][k] = tolower(find[j][k]);
		
		for (a = 0; a < f; a++) {
			int start_m = 0;
			int start_n = 0;
			
			for (j = 0; j < m; j++) {
				for (k = 0; k < n; k++) {
					if (grid[j][k] == find[a][0]) {
						int leng = strlen(find[a]);
						bool top = (j+1) >= leng;
						bool bot = (m - j) >= leng;
						bool left = (k+1) >= leng;
						bool right = (n - k) >= leng;
						bool is_found = false;
						
						if(top) {
							is_found = true;
							for(q = 0; q < leng; q++) {
								if (find[a][q] != grid[j-q][k]) {
									is_found = false;
									break;
								}
							}
							if (is_found) {
								start_m = j+1;
								start_n = k+1;
								break;
							}
						}
						
						if(bot) {
							is_found = true;
							for(q = 0; q < leng; q++) {
								if (find[a][q] != grid[j+q][k]) {
									is_found = false;
									break;
								}
							}
							if (is_found) {
								start_m = j+1;
								start_n = k+1;
							}
						}
						
						if(left) {
							is_found = true;
							for(q = 0; q < leng; q++) {
								if (find[a][q] != grid[j][k-q]) {
									is_found = false;
									break;
								}
							}
							if(is_found) {
								start_m = j+1;
								start_n = k+1;
								break;
							}
						}
						
						if(right) {
							is_found = true;
							for(q = 0; q < leng; q++) {
								if (find[a][q] != grid[j][k+q]) {
									is_found = false;
									break;
								}
							}
							if(is_found) {
								start_m = j+1;
								start_n = k+1;
								break;
							}
						}
						
						if(top && left) {
							is_found = true;
							for(q = 0; q < leng; q++) {
								if(find[a][q] != grid[j-q][k-q]) {
									is_found = false;
									break;
								}
							}
							if(is_found) {
								start_m = j+1;
								start_n = k+1;
								break;
							}
						}
						
						if(top && right) {
							is_found = true;
							for(q = 0; q < leng; q++) {
								if(find[a][q] != grid[j-q][k+q]) {
									is_found = false;
									break;
								}
							}
							if(is_found) {
								start_m = j+1;
								start_n = k+1;
								break;
							}
						}
						
						if(bot && left) {
							is_found = true;
							for(q = 0; q < leng; q++) {
								if(find[a][q] != grid[j+q][k-q]) {
									is_found = false;
									break;
								}
							}
							if(is_found) {
								start_m = j+1;
								start_n = k+1;
								break;
							}
						}
						
						if(bot && right) {
							is_found = true;
							for(q = 0; q < leng; q++) {
								if(find[a][q] != grid[j+q][k+q]) {
									is_found = false;
									break;
								}
							}
							if(is_found) {
								start_m = j+1;
								start_n = k+1;
								break;
							}
						}
					}
				}
				if(start_m != 0 && start_n != 0) 
					break;
			}
			printf("%d %d\n", start_m, start_n);
		}
		printf("\n");
	}
}
