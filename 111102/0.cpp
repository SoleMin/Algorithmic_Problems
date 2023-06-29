#include <stdio.h>
#include <string.h>
const int MAX = 10005, MIN = 105;

int t, i, j, n, m;
int A[MIN], B[MIN], C[MIN];
char a[MAX], b[MIN], c[MIN], dp[MIN][MAX][MIN];

void add(char* a, char* b) {
	memset(c, 0, sizeof(c));
	memset(A, 0, sizeof(A));
	memset(B, 0, sizeof(B));
	memset(C, 0, sizeof(C));
	int i, lena = strlen(a), lenb = strlen(b), len;
	for (i = 0; i < lena; i++)
		A[lena - 1 - i] = a[i] - '0';
	for (i = 0; i < lenb; i++)
		B[lenb - 1 - i] = b[i] - '0';
	len = lena > lenb ? lena : lenb;
	for (i = 0; i < len; i++) {
		C[i] += A[i] + B[i];
		C[i + 1] += C[i] / 10;
		C[i] %= 10;
	}
	while (C[len] == 0 && len > 0)
		len--;
	for (i = len; i >= 0; i--) {
		c[len - i] = C[i] + '0';
	}
}
int main() {
	scanf("%d", &t);
	while (t--) {
		memset(dp, 0, sizeof(dp));
		scanf("%s%s", a, b);
		n = strlen(a); m = strlen(b);
		for (i = 0; i <= n; i++)
			strcpy(dp[0][i], "1");
		for (i = 1; i <= m; i++) {
			for (j = 1; j <= n; j++) {
				strcpy(dp[i][j], dp[i][j - 1]);
				if (b[i - 1] == a[j - 1]) {
					add(dp[i][j], dp[i - 1][j - 1]);
					strcpy(dp[i][j], c);
				}
			}
		}
		printf("%s\n", dp[m][n]);
	}
	return 0;
}