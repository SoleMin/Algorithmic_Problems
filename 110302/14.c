#include <stdio.h>
#include <string.h>

// 가로 세로 길이
#define MAX_M 50
#define MAX_N 50

static char a[MAX_M][MAX_N];
static int m, n;

int match(char word[], int sta_i, int sta_j)
{
	static int di[8] = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int dj[8] = {-1, 0, 1, 1, 1, 0, -1, -1};
	int i, j, t, dic;
	
	for(dic=0; dic<8; dic++) {
		i = sta_i;
		j = sta_j;
		t = 0;
		while(i >= 0 && i < m && j >= 0 && j < n
				 && word[t] != '\0' && word[t] == a[i][j]) {
			i += di[dic];
			j += dj[dic];
			t++;
		}
		if (word[t] == '\0')
			return 1;
	}
	return 0;
}
void main (void)
{
	int num, t, i , j, k;
	char line[256], word[256];
	
	scanf("%d", &num);
	for(t = 0; t < num; t++) {
		if (t > 0)
			putchar('\n');
		gets(line);
		
		scanf("%d %d", &m, &n);
		gets(line);
		for(i=0; i<m; i++) {
			for(j=0; j<n; j++) {
				a[i][j] = getchar();
				if(a[i][j] >= 'A' && a[i][j] <= 'Z')
					a[i][j] += ('a'-'A');
			}
			gets(line);
		}
		scanf("%d", &k);
		gets(line);
		while (k-- > 0) {
			gets(word);
			for (i=0; i < strlen(word); i++)
				if(word[i] >= 'A' && word[i] <='Z')
					word[i] += ('a' - 'A');
			for(i=0; i < m; i++)
				for(j=0; j < n; j++)
					if(match(word, i, j)) {
						printf("%d %d\n", i+1, j+1);
						goto end_i;
					}
			end_i:
			;
		}
	}
}
