#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define N (1000 + 1)

int compare(const void* a, const void* b) {
	return *(char*)a - *(char*)b;
}

int main(void) {
	char a[N];
	char b[N];
	char c[N];
	while (fgets(a, N, stdin) != NULL) {
		fgets(b, N, stdin);
		if (a[strlen(a) - 1] == '\n')
			a[strlen(a) - 1] = '\0';
		if (b[strlen(b) - 1] == '\n')
			b[strlen(b) - 1] = '\0';
		qsort(a, strlen(a), sizeof(char), compare);
		qsort(b, strlen(b), sizeof(char), compare);
		char* ap = a;
		char* bp = b;
		char* cp = c;
		while (*ap && *bp) {
			if (*ap > *bp)
				bp++;
			else if (*ap < *bp)
				ap++;
			else {
				*cp++ = *ap;
				ap++;
				bp++;
			}
		}
		*cp = '\0';
		printf("%s\n", c);
	}
}