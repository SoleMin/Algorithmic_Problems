#include <stdio.h>
#include <string.h>

#define min(x, y) ((x) < (y) ? (x) : (y))

void main(void) {
	unsigned char *x, line_1[1001], line_2[1001];
	unsigned int count_1[256], count_2[256];
	unsigned int a, b;
	
	while (gets(line_1)) {
		gets(line_2);
		for (a = 0; a<256; a++) {
			count_1[a] = count_2[a] = 0;
		}
		for (x = line_1; *x; x++)
			count_1[*x]++;
		for (x = line_2; *x; x++)
			count_2[*x]++;
		for(a = 0; a < 256; a++) {
			for(b = 0; b <min(count_1[a], count_2[a]); b++)
				putchar((char)a);
		}
		putchar('\n');
	}
}
