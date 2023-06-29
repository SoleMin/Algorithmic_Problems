#include <string.h>
#include <stdio.h>

int pi[1000001];
char T[1000001];
char P[1000001];
int result[1000001]={0, };

void setPi(const char * p) {
	int i, j, k, plen = strlen(p);
	for (k = 0; k < 1000001; k++)pi[k] = 0;

	j = 0;
	for (i = 1; i < plen; i++) {
		while (j > 0 && p[i] != p[j]) {
			j = pi[j - 1];
		}
		if (p[i] == p[j]) {
			pi[i] = ++j;
		}
	}
}

int main()
{
	int i, j, Tlen, Plen, cnt;

	fgets(T, 1000001, stdin);
	fgets(P, 1000001, stdin);

	T[strlen(T) - 1] = '\0';
	P[strlen(P) - 1] = '\0';

	Tlen = strlen(T);
	Plen = strlen(P);

	setPi(P);
	j = 0;
	cnt = 0;
	for (i = 0; i < Tlen; i++)
	{
		while (T[i] != P[j] && j > 0) {
			j = pi[j - 1];
		}
		
		if (T[i] == P[j])
		{
			if (j == Plen - 1) {
				result[cnt++] =  i-Plen+2;
			}
			j++;
		}
	}
	printf("%d\n", cnt);
	for(i=0; i<cnt; i++)
		printf("%d ", result[i]);

}