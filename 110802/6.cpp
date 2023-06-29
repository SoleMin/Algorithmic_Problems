#include <algorithm>
#include <iostream>
#define MAXMOVE 50
using namespace std;
static int MAXDEPTH;
static int howmove[4][2] = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
static char movechar[4] = { 'U', 'R', 'D', 'L' };
static int solved, puzzle[4][4];
static int mtop, movestack[MAXMOVE];

void input(void) {
	for (int i = 0; i < 4; i++) 
		for (int j = 0; j < 4; j++)
			cin >> puzzle[i][j];
}

void output(void) {
	if (solved) {
		for (int i = 0; i < mtop; i++)
			cout << movechar[movestack[i]];
		cout << endl;
	}
	else
		cout << "This puzzle is not solvable." << endl;
}

int cost(void) {
	int md1, md2;
	
	md1 = 0;
	for (int i = 0; i < 4; i++)
		for (int j = 0; j < 4; j++)
			if (puzzle[i][j] != 0)
				md1 += abs(i - ((puzzle[i][j] - 1) / 4));
	
	md2 = 0;
	for (int i = 0; i < 4; i++)
		for (int j = 0; j < 4; j++)
			if (puzzle[i][j] != 0)
				md2 += abs(j - ((puzzle[i][j] - 1) % 4));
	
	return md1 + md2;
}
void back(int a, int nowx, int nowy) {
	int c, nextx, nexty;
	
	c = cost();
	if (c == 0) {
		solved = 1;
		return;
	}
	if (a + c > MAXDEPTH)
		return;
	for (int i = 0; i < 4; i++) {
		if (mtop > 0 && (movestack[mtop - 1] + 2) % 4 == i)
			continue;
		nextx = nowx + howmove[i][0];
		nexty = nowy + howmove[i][1];
		if (nextx >= 0 && nextx < 4 && nexty >= 0 && nexty < 4)
			swap(puzzle[nowx][nowy], puzzle[nextx][nexty]);
		movestack[mtop++] = i;
		back(a + 1, nextx, nexty);
		if (solved)
			return;
		mtop--;
		// 롤백
		if (nextx >= 0 && nextx < 4 && nexty >= 0 && nexty < 4)
			swap(puzzle[nowx][nowy], puzzle[nextx][nexty]);
	}
}

void solve(void) {
	int value = 0, l, x, y;
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 4; j++) {
			if (puzzle[i][j] == 0) {
				value += i;
				x = i;
				y = j;
			}
			for (int k = i; k < 4; k++) {
				if (k == i)
					l = j + 1;
				else
					l = 0;
				for (; l < 4; l++)
					if (puzzle[k][l] != 0 && puzzle[i][j] > puzzle[k][l])
						value++;
			}
		}
	}
	if (value % 2 == 0)
		return;
	
	for (MAXDEPTH = cost(); !solved && MAXDEPTH <= MAXMOVE; MAXDEPTH += 2)
		back(0, x, y);
}

int main() {
	int t;
	cin >> t;
	for (int i = 0; i < t; i++) {
		input();
		mtop = 0;
		solved = 0;
		solve();
		
		output();
	}
}