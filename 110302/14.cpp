#include <iostream>
#include <string>
#include <cctype>

using namespace std;

char grid[51][51];
pair<int, int> ans;

int px[9] = { 0, -1, -1, -1, 0, 0, 1, 1, 1 };
int py[9] = { 0, -1, 0, 1, -1, 1, -1, 0, 1 };

int m, n;

bool find_first_letter(string);
bool find_direction(int, int, string);
bool find_word(int, int, int, string);

int main() {
	int T;
	cin >> T;
	while (T-- != 0) {
		cin >> m >> n;
		for (int i = 1; i <= m; i++)
			for (int j = 1; j <= n; j++)
				cin >> grid[i][j];
		
		int k;
		cin >> k;
		
		while (k-- != 0) {
			string s;
			cin >> s;
			find_first_letter(s);
			cout << ans.first << " " << ans.second << "\n";
		}
		cout << "\n";
	}
	return 0;
}

bool find_first_letter(string s) {
	char first_letter = toupper(s[0]);
	for (int i = 1; i <= m; i++) {
		for (int j = 1; j <= n; j++) {
			if (toupper(grid[i][j]) == first_letter)
				if (find_direction(i, j, s))
					return true;
		}
	}
	return false;
}

bool find_direction(int x, int y, string s) {
	char second_letter = toupper(s[1]);
	for (int i = 1; i <= 8; i++) {
		if (x + px[i] > m || y + py[i] > n)
			continue;
		if (toupper(grid[x + px[i]][y + py[i]]) == second_letter) { // 두 번째 글자를 찾음
			if (find_word(x, y, i, s))
				return true;
		}
	}
	return false;
}

bool find_word(int x, int y, int p, string s) {
	ans.first = x;
	ans.second = y;
	int length = s.length();
	for (int i = 0; i < length; i++) {
		if (x > m || y > n || toupper(grid[x][y]) != toupper(s[i]))
			return false;
		x += px[p];
		y += py[p];
	}
	return true;
}
