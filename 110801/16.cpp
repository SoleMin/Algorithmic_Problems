#include <iostream>

using namespace std;

int n, k;
int ans;
int board[9][9];

void on_bishop(int, int);
void off_bishop(int, int);
void back_tracking(int, int, int);
void init_();

int main() {
	while (cin >> n >> k) {
		if (!n && !k)
			break;
		back_tracking(0, 1, 1);
		cout << ans << '\n';
		init_();
	}
	return 0;
}

void on_bishop(int x, int y) {
	int i = x; int j = y;
	while (i != 1 && j != 1) {
		i--; j--;
	}
	do {
		board[i++][j++] += 1;
	} while (i <= n && j <= n);

	i = x; j = y;
	while (i != 1 && j != n) {
		i--; j++;
	}
	do {
		board[i++][j--] += 1;
	} while (i <= n && j >= 1);
}

void off_bishop(int x, int y) {
	int i = x; int j = y;
	while (i != 1 && j != 1) {
		i--; j--;
	}
	do {
		board[i++][j++] -= 1;
	} while (i <= n && j <= n);

	i = x; j = y;
	while (i != 1 && j != n) {
		i--; j++;
	}
	do {
		board[i++][j--] -= 1;
	} while (i <= n && j >= 1);
}

void back_tracking(int cnt, int x, int y) {
	if (k == cnt) {
		ans++;
		return;
	}

	for (int j = y; j <= n; j++) {
		if (!board[x][j]) {
			on_bishop(x, j);
			back_tracking(cnt + 1, x, j + 1);
			off_bishop(x, j);
		}
	}

	for (int i = x + 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			if (!board[i][j]) {
				on_bishop(i, j);
				back_tracking(cnt + 1, i, j + 1);
				off_bishop(i, j);
			}
		}
	}
}

void init_() {
		ans = 0;
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= n; j++)
				board[i][j] = 0;
}