#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#define MAX 5607
#define INF 99999

static int n, res;
static int w[MAX], s[MAX], dpmap[2][MAX];

void sort(int left, int right) {
	int i, l, r, temp;
	l = left; r = right;
	i = s[(left+right)/2];

	while (l < r) {
		for (; s[l] < i; l++);
		for (; s[l] > i; r--);
		if (l <= r) {
			temp = w[l]; w[l] = w[r]; w[r] = temp;
			temp = s[l]; s[l] = s[r]; s[r] = temp;
			l++; r--;
		}
	}
	if (left < r) {
		sort(left, r);
	}
	if (l < right) {
		sort(l, right);
	}
}

int main(){ 
	int i, j;

	n=0;
	while(scanf("%d %d", &w[n], &s[n])!=EOF){
		n++;
	}
	sort(0, n - 1);
	for (i = 0; i < n; i++) {
		dpmap[0][i] = INF;
	}
	dpmap[0][0] = w[0];

	for (i = 1; i < n; i++) {
		for (j = 0; j < n; j++) {
			dpmap[i % 2][j] = dpmap[(i - 1) % 2][j];
			if (dpmap[(i - 1) % 2][j - 1] + w[i] <= s[i] && dpmap[(i - 1) % 2][j - 1] + w[i] < dpmap[i % 2][j]) {
				dpmap[i % 2][j] = dpmap[(i - 1) % 2][j - 1]+w[i];
			}
		}
	}
	for (i = n - 1; i >= 0; i--) {
		if (dpmap[(n - 1) % 2][i] < INF) {
			res = i + 1;
			break;
		}
	}
	printf("%d\n", res);
}