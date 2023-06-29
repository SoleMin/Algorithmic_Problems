#include <stdio.h>
#include <string.h>

char T[1000001], P[1000001];
int k[1000001], result[1000001];
int n, m;

void get_k(char *p, int *k) {
	int i ,j = 0;
	for (i = 1; i < strlen(p); i++) {
		while (j > 0 && p[i] != p[j]) {
			j = k[j - 1];
		}
		if (p[i] == p[j])
			k[i] = ++j;
	}
}

int main(void) {

	int i, j, count = 0;

	gets(T);
	fflush(stdin);
	gets(P);

	n = strlen(T);
	m = strlen(P);
	
	get_k(P, k);
	
	i = 0; j = 0;
	while (i < n - m + j +1) {
		if (j == -1 || T[i] == P[j]) {
			i++;
			j++;
		}
		else {
			if (j == 0)
				i++;
			else
				j = j - (j - k[j - 1]);
		}
		if (j == m) {
			result[count] = i - j + 1;
			count++;
			j = k[j - 1];
		}
	}

	printf("%d\n", count);
	for (i = 0; i < count; i++)
		printf("%d ", result[i]);
}