#include <stdio.h>
#include <string.h>

#define min(x, y) ((x) < (y) ? (x) : (y))

int main() {
	char *s, input[1000], input1[1000];
	int a[500], b[500];
	
	while(gets(input)) {
		gets(input1);
		for(int i = 0; i < 500; i++)
			a[i] = b[i] = 0;
		for(s = input; *s; s++)
			a[*s]++;
		for(s = input1; *s; s++)
			b[*s]++;
		for(int i = 0; i < 500; i++)
			for(int j = 0; j < min(a[i], b[i]); j++)
				putchar((char)i);
		putchar('\n');
	}
	return 0;
}
