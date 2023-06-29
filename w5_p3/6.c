#include <stdio.h>
#include <string.h>
#define M 1000001
#define N 1000001

char str[M] = {0}, pattern[N] = {0};
int n, m, ht[N] = {0};
int num = 0;
void find_ht();
void kmp(int result[]);


int main() {
	int result[100];
	int i;
	fgets(str, N, stdin);
	if(str[strlen(str) - 1] == '\n')
		str[strlen(str) - 1] = '\0';
	
	fgets(pattern, M, stdin);
	if(pattern[strlen(pattern) - 1] == '\n')
		pattern[strlen(pattern) - 1] = '\0';
	
	n = strlen(str), m = strlen(pattern);
	find_ht();
	kmp(result);
	printf("%d\n", num);
	for(i = 0; i < num; i++) {
		printf("%d ", result[i]);
	} printf("\n");
	return 0;
}



void find_ht() {
	int i = 0, j = -1;
	ht[0] = -1;
	while(i < m) {
		if(j == -1 || pattern[i] == pattern[j]) {
			i++, j++;
			ht[i] = j;
		} else
			j = ht[j];
	}
}

void kmp(int result[]) {
	int i = 0, j = 0;
	while(i < n) {
		if(j == -1 || str[i] == pattern[j]) {
			i++, j++;
		} else
			j = ht[j];
		if(j == m) {
			result[num] =  i - m + 1;
			num++;
			j = ht[j];
		}
	}
}

