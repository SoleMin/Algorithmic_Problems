#include <iostream>
#include <string>
#include <cstring>
#include <sstream>
using namespace std;

int ident, n;
int state[10];
int ret[40];
string s;
bool isRight;


void dfs(int idx) {
	if(idx == n + 1) {
		if(ret[0] == ret[n] && ret[1] == ret[n + 1])
			isRight = true;
		return;
	}
	
	int cur = s[idx - 1] - '0';
	
	for(int i = 1; i <= 8; i++) {
		if(state[i] == cur) {
			int curState = i - 1;
			if(idx != 1 && (ret[idx - 1] != !!(curState & 0x4) || ret[idx] != !!(curState & 0x2))) {
				continue;
			}
			ret[idx - 1] = !!(curState & 0x4);
			ret[idx] = !!(curState & 0x2);
			ret[idx + 1] = !!(curState & 0x1);
			
			dfs(idx + 1);
			
			
		}
	}
}

void solve() {
	for(int i = 1; i <= 8; i++) {
		state[i] = !!(ident & (1 << (i - 1)));
	}
	
	dfs(1);
}

int main() {
	
	while(true) {
		cin >> ident >> n >> s;
		if(cin.eof()) break;
		
		isRight = false;
		memset(ret, -1, sizeof(ret));
		
		solve();
		
		if(isRight)
			cout << "REACHABLE\n";
		else
			cout << "GARDEN OF EDEN\n";
	}
	
	return 0;
}