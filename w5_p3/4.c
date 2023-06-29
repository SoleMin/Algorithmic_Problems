#include <stdio.h>
#include <string.h>
#define MAX 1000002
char t[MAX];
char p[MAX];
int result[MAX];
int table[MAX];
int main() {

	int i, j, t_len, p_len, cnt = 0;

	fgets(t, MAX, stdin);
	fgets(p, MAX, stdin);
	p_len = strlen(p);

	j = 0;
	for (i = 1; i < p_len; i++)
	{
		while (j > 0 && p[i] != p[j])
			j = table[j - 1];
		if (p[i] == p[j])
			table[i] = ++j;
	}
	t_len = strlen(t);
	j = 0;
	for (i = 0; i < t_len; i++)
	{
		while (j > 0 && t[i] != p[j])
			j = table[j - 1];
		if (t[i] == p[j])
			j++;
		if (j == p_len - 1) 
			result[cnt++] = i - p_len + 3;
	}
	printf("%d\n", cnt);
	for (i = 0; i < cnt; i++)
		printf("%d ", result[i]);
}