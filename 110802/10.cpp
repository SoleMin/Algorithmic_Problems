#include <iostream>
#include <stdlib.h>
#define MAXMOVE 50

using namespace std;

void input();
void output();
int cost();
void solve();
void back(int, int, int);

int MAXDEPTH;
int movex[4] = { -1, 0, 1, 0 };
int movey[4] = { 0, 1, 0, -1 };
char movechar[4] = { 'U', 'R', 'D', 'L' };
int puzzle[4][4];
int mtop, movestack[MAXMOVE];
bool solved;

int main() {
	int T;
	cin >> T;
	while (T-- != 0) {
		input();
		mtop = 0;
		solved = false;
		solve();
		output();
	}
	return 0;
}

void input() {
	for (int i = 0; i < 4; i++)
		cin >> puzzle[i][0] >> puzzle[i][1] >> puzzle[i][2] >> puzzle[i][3];
}

void output() {
	if (solved)
		for (int i = 0; i < mtop; i++)
			cout << movechar[movestack[i]];
	else
		cout << "This puzzle is not solvable.";
	cout << '\n';
}

int cost() {
	int i, j;
	int md1, md2;
	md1 = 0;
	for (i = 0; i < 4; i++)
		for (j = 0; j < 4; j++)
			if (puzzle[i][j] != 0)
				md1 += abs(i - ((puzzle[i][j] - 1) / 4));
	md2 = 0;
	for (i = 0; i < 4; i++)
		for (j = 0; j < 4; j++)
			if (puzzle[i][j] != 0)
				md2 += abs(j - ((puzzle[i][j] - 1) % 4));
	return md1 + md2;
}

void solve() {
	int x, y;
	int value = 0;
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 4; j++) {
			if (!puzzle[i][j]) {
				value += i;
				x = i;
				y = j;
			}
			for (int k = i; k < 4; k++) {
				int l = (k == i ? j + 1 : 0);
				for (; l < 4; l++)
					if (puzzle[k][l] && puzzle[i][j] > puzzle[k][l])
						value++;
			}
		}	
	}
	if (!(value & 1))
		return;
	for (MAXDEPTH = cost(); !solved && MAXDEPTH <= MAXMOVE; MAXDEPTH += 2)
		back(0, x, y);
}

void back(int a, int nowx, int nowy) {
	int nextx, nexty;
	int c = cost();
	if (!c) {
		solved = true;
		return;
	}
	if (a + c > MAXDEPTH)
		return;
	for (int i = 0; i < 4; i++) {
		if (mtop > 0 && (movestack[mtop - 1] + 2) % 4 == i)
			continue;
		nextx = nowx + movex[i];
		nexty = nowy + movey[i];
		
		if (0 <= nextx && nextx <= 3 && 0 <= nexty && nexty <= 3) {
			puzzle[nowx][nowy] = puzzle[nextx][nexty];
			puzzle[nextx][nexty] = 0;
		
			movestack[mtop++] = i;
			back(a + 1, nextx, nexty);
			if (solved)
				return;
			mtop--;
			puzzle[nextx][nexty] = puzzle[nowx][nowy];
			puzzle[nowx][nowy] = 0;
		}
	}
}