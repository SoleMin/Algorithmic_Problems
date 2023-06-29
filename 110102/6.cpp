#include <iostream>
#include <string>
using namespace std;

string arr[101], ret[101];
int n, m;
int dy[8] = {0, 1, 0, -1, 1, 1, -1, -1};
int dx[8] = {1, 0, -1, 0, 1, -1, -1, 1};

bool inRange(int y, int x) {
	return 0 <= y && y < n && 0 <= x && x < m;
}

void solve() {
	
	for(int i = 0; i < n; i++) {
		for(int j = 0; j < m; j++) {
			int cnt = 0;
			if(arr[i][j] == '*') {
				ret[i] += "*";
				continue;
			}
			
			for(int dirNum = 0; dirNum < 8; dirNum++) {
				int ny = i + dy[dirNum], nx = j + dx[dirNum];
				if(!inRange(ny, nx)) continue;
				if(arr[ny][nx] == '*')
					cnt++;
			}
			ret[i] += to_string(cnt);
		}
	}
}

int main() {
	int field = 1;
	while(true) {
		cin >> n >> m;
		if(!n && !m) break;
		
		for(int i = 0; i < n; i++) 
			cin >> arr[i];
		for(int i = 0; i < n; i++)
			ret[i] = "";
		solve();
		cout << "Field #" << field << ":\n";
		for(int i = 0; i < n; i++) {
			cout << ret[i] << '\n';
		}
		cout << '\n';
		
		field++;
	}
	
	return 0;
}