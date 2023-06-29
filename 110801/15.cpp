#include <iostream>
#include <cstring>
using namespace std;

int visited[10][10];
int n, k;
int ret;

// opr : 1 or -1
void choice(int y, int x, int opr) {
	// for(int i = 0; i <= y + x; i++) {
	// 	visited[i][j] += opr;
	// }
	// for(int i = 0; i < )
	
	for(int i = 0; i < n; i++) {
		for(int j = 0; j < n; j++) {
			if(i + j == y + x)
				visited[i][j] += opr;
			else if(i - j == y - x)
				visited[i][j] += opr;
		}
	}
}

void solve(int num, int len) {
	if(num >= k || len == 2 * n - 1) {
		if(num == k)
			ret++;
		return;
	}
	
	if(len < n) {
		for(int i = 0; i <= len; i++) {
			if(visited[i][len - i]) continue;
			choice(i, len - i, 1);
			solve(num + 1, len + 1);
			choice(i, len - i, -1);
		}
	}
	else {
		for(int i = len - n + 1; i < n; i++) {
			if(visited[i][len - i]) continue;
			choice(i, len - i, 1);
			solve(num + 1, len + 1);
			choice(i, len - i, -1);
		}
	}
	solve(num, len + 1);
}

int main() {
	
	while(true) {
		ret = 0;
		memset(visited, 0, sizeof(visited));
		
		cin >> n >> k;
		if(!n && !k) break;
		solve(0, 0);
		cout << ret << '\n';
	}
	
	
	return 0;
}