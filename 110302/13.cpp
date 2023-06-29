#include <iostream>
#include <string>

using namespace std;

/*
	대소 구분 x
	8방향
	
*/

int m, n, k;
int sr, sc;
string grid[51];
string words[21];
int dy[8] = {0, 1, 1, 1, 0, -1, -1, -1};
int dx[8] = {1, 1, 0, -1, -1, -1, 0, 1};

bool inRange(int y, int x) {
	return 0 <= y && y < m && 0 <= x && x < n;
}

bool check(int y, int x, int wordNum) {
	int len = words[wordNum].length();
	
	for(int dirNum = 0; dirNum < 8; dirNum++) {
		bool isWord = true;
		int ny = y + dy[dirNum], nx = x + dx[dirNum];
		for(int i = 1; i < len; i++) {
			if(!inRange(ny, nx) || tolower(grid[ny][nx]) != tolower(words[wordNum][i])) {
				isWord = false;
				break;
			}
			ny += dy[dirNum];
			nx += dx[dirNum];
		}
		if(isWord) 
			return true;
	}
	return false;
}

void solve() {
	for(int i = 0; i < k; i++) {
		bool isFind = false;
		
		for(int r = 0; r < m; r++) {
			for(int c = 0; c < n; c++) {
				if(tolower(grid[r][c]) == tolower(words[i][0])) {
					if(check(r, c, i)) {
						sr = r;
						sc = c;
						isFind = true;
					}	
				}
				if(isFind) break;
			}
			if(isFind) break;
		}
		cout << sr + 1 << ' ' << sc + 1 << '\n';
	}
}

int main() {
	int t; cin >> t;
	cin.get();
	while(t--) {
		cin >> m >> n;
		for(int i = 0; i < m; i++) 
			cin >> grid[i];
		cin >> k;
		for(int i = 0; i < k; i++)
			cin >> words[i];
		cin.get();
		
		solve();
		cout << '\n';
	}
	
	return 0;
}