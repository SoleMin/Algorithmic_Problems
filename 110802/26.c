#include <stdio.h>
#include <stdlib.h>
#define _CRT_SECURE_NO_WARNINGS
#define MAXMOVE 50
static int MAXDEPTH;
static int move[4][2] = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
static char movechar[4] = { 'U', 'R', 'D', 'L' };
static int solved, puzzle[4][4];
static int mtop, movestack[MAXMOVE];

void input(void)
{
	int i, j;
	for (i = 0; i < 4; i++)
		for (j = 0; j < 4; j++)
			scanf("%d", &puzzle[i][j]);
}
void output(void)
{
	int i;
	if (solved)
	{
		for (i = 0; i < mtop; i++)
			printf("%c", movechar[movestack[i]]);
		printf("\n");
	}
	else
		printf("This puzzle is not solvable.\n");
}int cost(void) {
	int i, j;
	int md1, md2;
	md1 = 0;
	for (i = 0; i < 4; i++) {
		for (j = 0; j < 4; j++) {
			if (puzzle[i][j] != 0)
				md1 += abs(i - ((puzzle[i][j] - 1) / 4));
		}
	}
	md2 = 0;
	for (i = 0; i < 4; i++) {
		for (j = 0; j < 4; j++) {
			if (puzzle[i][j] != 0)
				md2 += abs(j - ((puzzle[i][j] - 1) % 4));
		}
	}
	return md1 + md2;
}void back(int a, int nowx, int nowy) {
	int i, c;
	int temp, zero, b;
	int nextx, nexty;
	c = cost();
	if (c == 0) {
		solved = 1;
		return;
	}
	if (a + c > MAXDEPTH) return;
	for (i = 0; i < 4; i++) {
		if (mtop > 0 && (movestack[mtop - 1] + 2) % 4 == i)
			continue;
		zero = puzzle[nowx][nowy];
		if (nowx + move[i][0] < 0 || nowx + move[i][0]>3 || nowy + move[i][1] < 0 || nowy + move[i][1]>3) continue;
		nextx = nowx + move[i][0];
		nexty = nowy + move[i][1];
		b = puzzle[nextx][nexty];
		temp = puzzle[nowx][nowy];
		puzzle[nowx][nowy] = puzzle[nextx][nexty];
		puzzle[nextx][nexty] = temp;

		movestack[mtop++] = i;
		back(a + 1, nextx, nexty);
		if (solved) return;
		mtop--;
		puzzle[nowx][nowy] =zero;
		puzzle[nextx][nexty] =b;

	}
}
void solve(void) {
	int i, j, k, l, value, x, y;
	value = 0;
	for (i = 0; i < 4; i++) {
		for (j = 0; j < 4; j++) {
			if (puzzle[i][j] == 0) {
				value += i;
				x = i;
				y = j;
			}
			for (k = i; k < 4; k++) {
				if (k == i)
					l = j + 1;
				else
					l = 0;
				for (; l < 4; l++) {
					if (puzzle[k][l] != 0 && puzzle[i][j] > puzzle[k][l])
						value++;
				}
			}
		}
	}
	if (value % 2 == 0)
		return;
	for (MAXDEPTH = cost(); !solved && MAXDEPTH <= MAXMOVE; MAXDEPTH += 2)
		back(0, x, y);
}
void main() {
	int i, t;
	scanf("%d", &t);
	for (i = 0; i < t; i++) {
		input();
		mtop = 0;
		solved = 0;
		solve();
		output();
	}
}/*

1
1 2 3 4
5 6 7 8
9 10 11 12
13 14 0 15

*/