#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#define INF 999999
#define max(x, y) (((x)>(y)) ? (x):(y))
#define min(x, y) (((x)<(y)) ? (x):(y))

static int res;
static int loc[101], cross[501][501];

void init(int n) {
	int i, j;
	for (i = 1; i <= n; ++i) {
		for (j = 1; j <= n; ++j) {
			cross[i][j] = INF;
		}
		cross[i][i] = 0;
	}
}

void floyd(int n) {
	int i, j, k;
	for (k = 1; k <= n; ++k) {
		for (i = 1; i <= n; ++i) {
			for (j = 1; j <= n; ++j) {
				if (cross[i][k] + cross[k][j] < cross[i][j]) {
					cross[i][j] = cross[i][k] + cross[k][j];
				}
			}
		}
	}
}

int main(){ 
	int t, i, j, f_num, c_num, x, y, len, temp_len, max_s, res;
	char line[100];
	scanf("%d", &t);
	while (t--) {
		scanf("%d %d", &f_num, &c_num);
		for (i = 0; i < f_num; i++) {
			scanf("%d", &loc[i]);
		}
		init(c_num);

		gets(line);
		while (true) {
			line[0] = 0;
			gets(line);
			if (line[0]=='\0') {
				break;
			}
			sscanf(line, "%d %d %d", &x, &y, &len);
			cross[x][y] = cross[y][x] = len;
		}
		floyd(c_num);

		int s[501];
		max_s = 0;
		for (i = 1; i <= c_num; ++i) {
			s[i] = INF;
			for (j = 0; j < f_num; ++j) {
				s[i] = min(s[i], cross[i][loc[j]]);
			}
			max_s = max(max_s, s[i]);
		}

		res = 1;
		for (i = 1; i <= c_num; ++i) {
			temp_len = 0;
			for (j = 1; j <= c_num; ++j) {
				int ss = min(cross[i][j], s[j]);
				temp_len = max(temp_len, ss);
			}
			if (temp_len < max_s) {
				max_s = temp_len;
				res = i;
			}
		}
		printf("%d\n", res);
		if (t > 0) {
			printf("\n");
		}
	}
}