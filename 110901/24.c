#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#define MAX 200

static bool pos;
static int n;
static int color[MAX], map[MAX][MAX];

void search(int ndnum, int clr) {
	int i;

	color[ndnum] = clr;
	for (i=0; i<n && pos; i++) {
		if (map[ndnum][i]==0) {
			continue;
		}
		if (color[i]==0) {
			search(i, clr%2+1);
		}
		else {
			if (color[i]==clr) {
				pos = false;
				return;
			}
		}
	}
}

int main(){ 
	int i, j, l, x, y;

	while (true) {
		scanf("%d", &n);
		if (n==0) {
			break;
		}
		for (i=0; i < n; i++) {
			for (j=0; j < n; j++) {
				map[i][j] = 0;
			}
		}

		scanf("%d", &l);
		for (i=0; i<l; i++) {
			scanf("%d %d", &x, &y);
			map[x][y] = map[y][x] = 1;
		}

		for (i=0; i<n; i++) {
			color[i] = 0;
		}
		pos = true;

		search(0, 1);
		if (pos==false) {
			printf("NOT BICOLORABLE.\n");
		}
		else {
			printf("BICOLORABLE.\n");
		}
	}
}