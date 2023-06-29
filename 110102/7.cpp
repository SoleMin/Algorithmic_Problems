#include <iostream>

char board[101][101];
int ans[101][101];

int px[8] = {-1, -1, -1, 0, 0, 1, 1, 1};
int py[8] = {-1, 0, 1, -1, 1, -1, 0, 1};

using namespace std;

int main() {
	int a, b;
	int tc = 1;
	while (cin >> a >> b) {
		if (a == 0 && b == 0)
			break;
		for (int i = 1; i <= a; i++)
			for (int j = 1; j <= b; j++)
				cin >> board[i][j];
		
		for (int i = 1; i <= a; i++) {
			for (int j = 1; j <= b; j++) {
				if (board[i][j] == '*') {
					for (int k = 0; k < 8; k++)
						ans[i + px[k]][j + py[k]] += 1;
				}
			}
		}
		
		cout << "Field #" << tc++ << ":\n";
		for (int i = 1; i <= a; i++) {
			for (int j = 1; j <= b; j++) {
				if (board[i][j] == '*')
					cout << "*";
				else
					cout << ans[i][j];
			}
			cout << "\n";
		}
		
		cout << "\n";
		
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				ans[i][j] = 0;
				board[i][j] = ' ';
			}
		}
	}
	return 0;
}