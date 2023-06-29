#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#define MAX 32

static bool pos;
static int n, id;
static char automata[8], prev[MAX], cell[MAX+1];

void bt(int a) {
	int i;
	if (a == n-1) {
		if (automata[prev[a - 1] * 4 + prev[a] * 2 + prev[0]] == cell[a] && automata[prev[a] * 4 + prev[0] * 2 + prev[1]] == cell[0]) {
			pos = true;
		}
		return;
	}
	for (i = prev[a - 1] * 4 + prev[a] * 2; i <= prev[a - 1] * 4 + prev[a] * 2 + 1; i++) {
		if (automata[i] == cell[a]) {
			prev[a + 1] = i % 2;
			bt(a + 1);
			if (pos) {
				break;
			}
		}
	}
}

int main() {
	int i;
	while (scanf("%d %d %s", &id, &n, cell) != EOF) {
		for (i = 0; i < n; i++) {
			cell[i] -= '0';
		}
		for (i = 0; i < 8; i++) {
			automata[i] = id % 2;
			id /= 2;
		}
		pos = false;
		for (i = 0; i < 8; i++) {
			if (automata[i] == cell[1]) {
				prev[0] = (i / 4) % 2;
				prev[1] = (i / 2) % 2;
				prev[2] = i % 2;
				bt(2);
				if (pos) {
					break;
				}
			}
		}
		if (pos) {
			printf("REACHABLE\n");
		}
		else {
			printf("GARDEN OF EDEN\n");
		}
	}
}