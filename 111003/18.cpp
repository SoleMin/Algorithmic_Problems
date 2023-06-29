#include <iostream>
#include <string>
#include <cstring>
#include <sstream>
#include <climits>
#include <cmath>
using namespace std;

int main() {
	int d[501][501], f, n;
	bool b[501];
	int t;
	string s;
	cin >> t;
	while (t--) {
		cin >> f >> n;
		memset(d, 0x3F, sizeof(d));
		memset(b, 0, sizeof(b));
		
		for (int i = 0; i < f; i++) {
			int a;
			cin >> a;
			b[a] = true;
		}
		getline(cin, s);
		while(getline(cin, s), cin && s != "") {
			int a, b, c;
			stringstream ss(s);
			ss >> a >> b >> c;
			d[a][b] = d[b][a] = c;
		}
		
		for (int k = 1; k <= n; k++) {
			d[k][k] = 0;
			for (int i = 1; i <= n; i++)
				for (int j = 1; j <= n; j++)
					d[i][j] = min(d[i][j], d[i][k] + d[k][j]);
		}
		
		int mn = INT_MAX, mv;
		for (int i = 1; i <= n; i++) {
			int ma = 0;
			for (int j = 1; j <= n; j++) {
				int near = INT_MAX;
				for (int k = 1; k <= n; k++) {
					if (!b[k] && k != i)
						continue;
					near = min(near, d[k][j]);
				}
				ma = max(ma, near);
			}
			if (ma < mn) {
				mn = ma;
				mv = i;
			}
		}
		cout << mv << endl;
		cout << endl;
		
	}
	return 0;
}