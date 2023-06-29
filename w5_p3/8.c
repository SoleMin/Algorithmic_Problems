#include <stdio.h>
#include <string.h>
#define MAX 1000000
int next[MAX];
int ans[MAX];
int an=0;

void compute_next(char *s) {
	int m = strlen(s);
	next[0] = 0;
	int k = 0;
	int q = 1;
	while(q<=m) {
		while(k > 0 && s[k] != s[q])
			k = next[k-1];
		if(s[k] == s[q])
			next[q] = ++k;
		q++;
	}
}
void kmp(char *st, char *sp) {
	int n = strlen(st);
	int m = strlen(sp);
	int i = 0;
	int q = 0;
	compute_next(sp);
	while (i < n) {
		while(q > 0 && sp[q] != st[i]) 
			q = next[q-1];
		if(sp[q] == st[i])
			q++;
		if(q == m)
			ans[an++] = i - m + 2;
		i++;
	}
}

int main() {
	char st[MAX];
	char sp[MAX];
	gets(st);
	gets(sp);
	kmp(st,sp);
	printf("%d\n", an);
	for(int i = 0; i < an; i++)
		printf("%d ", ans[i]);
	return 0;
}
