#include <stdio.h>

void main() {
	
	int test;
	int i, j, x, y, work, temp;
	char line[500];
	
	scanf("%d", &test);
	
	for(i = 0; i < test; i++) {
		gets(line);
		scanf("%d", &work);
		
		int t[1000];
		int s[1000];
		int job[1000];
		
		for(j = 0; j < work; j++) {
			scanf("%d", &t[j]);
			scanf("%d", &s[j]);
			job[j] = j;
		}
		
		for(x = 1; x < work; x++) {
			for(y = 0; y < work - x; y++) {
				if(t[job[y]] * s[job[y+1]] > t[job[y+1]] * s[job[y]]) {
					temp = job[y];
					job[y] = job[y+1];
					job[y+1] = temp;
				}
			}
		}
		
		for(j = 0; j < work; j++)
			printf("%d ", job[j] + 1);
		
		printf("\n");
		
		if (i < test)
			printf("\n");
	}
}
