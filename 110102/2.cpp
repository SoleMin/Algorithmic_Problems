#include <iostream>
using namespace std;

int MINE[100][100];
void plusnumber(int maxX, int maxY, int x, int y) {
	if (x - 1 >= 0 && y - 1 >= 0 && MINE[x-1][y-1] != -1)
		MINE[x-1][y-1]++;
	if (x - 1 >= 0 && MINE[x-1][y] != -1)
		MINE[x-1][y]++;
	if (x - 1 >= 0 && y + 1 <= maxY && MINE[x-1][y+1] != -1)
		MINE[x-1][y+1]++;
	if (y - 1 >= 0 && MINE[x][y-1] != -1)
		MINE[x][y-1]++;
	if (y + 1 <= maxY && MINE[x][y+1] != -1)
		MINE[x][y+1]++;
	if (x + 1 <= maxX && y - 1 >= 0 && MINE[x+1][y-1] != -1)
		MINE[x+1][y-1]++;
	if (x + 1 <= maxX && MINE[x+1][y] != -1)
		MINE[x+1][y]++;
	if (x + 1 <= maxX && y + 1 <= maxY && MINE[x+1][y+1] != -1)
		MINE[x+1][y+1]++;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int x, y, count = 1;
	while (cin >> x >> y) {
		if (x == 0 && y == 0) break;
		// Init array
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				MINE[i][j] = 0;
			}
		}
		
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				char a = cin.get();
				if (a == '\n' || a == '\r')
					a = cin.get();
				if (a == '*') {
					MINE[i][j] = -1;
					plusnumber(x, y, i, j);
				}
			}
		}
		
		cout << "Field #" << count++ << ":\n";
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (MINE[i][j] == -1)
					cout << "*";
				else
					cout << MINE[i][j];
			}
			cout << "\n";
		}
		cout << "\n";
	}
}