#include <stdio.h>
#include <stdlib.h>

#define MAX_MOVE 50
static int MAXDEPTH;
static int move[4][2] = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} }; // [y][x]
static char movechar[4] = { 'U', 'R', 'D', 'L' };
static int solved, puzzle[4][4];
static int mtop, movestack[MAX_MOVE];

void input(void);
void output(void);
int cost(void);
void solve(void);
void back(int a, int nowx, int nowy);

int main(void) {
	int i, t;
	scanf("%d", &t);
	
	for(i = 0; i < t; i++) {
		input();
		mtop = 0;
		solved = 0;
		solve();
		
		output();
	}
	
	return 0;
}

void input(void) {
	int i, j;
	for(i = 0; i < 4; i++) {
		for(j = 0; j < 4; j++) {
			scanf("%d", &puzzle[i][j]);
		}
	}
}

void output(void) {
	int i;
	if(solved) {
		for(i = 0; i < mtop; i++) {
			printf("%c", movechar[movestack[i]]);
		} printf("\n");
	}
	else
		printf("This puzzle is not solvable.\n");
}

int cost(void) {
	int i, j;
	int md1, md2;
	
	md1 = 0;
	for(i = 0; i < 4; i++) {
		for(j = 0; j < 4; j++) {
			if(puzzle[i][j] != 0)
				md1 += abs(i - ((puzzle[i][j] - 1) / 4));
		}
	}
	md2= 0;
	for(i = 0; i < 4; i++) {
		for(j = 0; j < 4; j++) {
			if(puzzle[i][j] != 0)
				md2 += abs(j - ((puzzle[i][j] - 1) % 4));
		}
	}
	
	return md1 + md2;
}

void solve(void) {
	int i, j, k, l, value, x, y;
	value = 0;
	for(i = 0; i < 4; i++) {
		for(j = 0; j < 4; j++) {
			if(puzzle[i][j] == 0) {
				value += i;
				x = j;
				y = i;
			}
			for(k = i; k < 4; k++) {
				if(k == i) {
					l = j + 1;
				}
				else {
					l = 0;
				}
				for(; l < 4; l++) {
					if(puzzle[k][l] != 0 && puzzle[i][j] > puzzle[k][l])
						value++;
				}
			}
		}
	}
	if(value % 2 == 0) {
		return;
	}
	
	for(MAXDEPTH = cost(); !solved && MAXDEPTH <= MAX_MOVE; MAXDEPTH += 2) {
		// printf("MAXDEPTH = %d\n", MAXDEPTH);
		back(0, x, y);
	}
}

void back(int a, int nowx, int nowy) {
	int i, c;
	int nextx, nexty;
	c = cost();
	if(c == 0) {
		solved = 1;
		return;
	}
	if(a + c > MAXDEPTH) return;
	
	for(i = 0; i < 4; i++) {
		if(mtop > 0 && (movestack[mtop - 1] + 2) % 4 == i)
			continue;
		
		nextx = nowx + move[i][1];
		nexty = nowy + move[i][0];
		
		if(nextx < 0 || nextx > 3 || nexty < 0 || nexty > 3)
			continue;
		puzzle[nowy][nowx] = puzzle[nexty][nextx];
		puzzle[nexty][nextx] = 0;
		//printf("Before: [%d][%d] = %d -> [%d][%d] = %d\n", nowy, nowx, puzzle[nowy][nowx], nexty, nextx, puzzle[nexty][nextx]);
		
		movestack[mtop++] = i;
		back(a + 1, nextx, nexty);
		if(solved) return;
		mtop--;

		puzzle[nexty][nextx] = puzzle[nowy][nowx];
		puzzle[nowy][nowx] = 0;
		//printf("After: [%d][%d] = %d -> [%d][%d] = %d\n", nexty, nextx, puzzle[nexty][nextx], nowy, nowx, puzzle[nowy][nowx]);
	}
	
}




