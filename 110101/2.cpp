#include <iostream>
using namespace std;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int i = 0, j = 0;
	int x = 0, y = 0;
	
	while (cin >> i >> j) {
		int cycle = 0;
		int tmp = 0;
		x = i;
		y = j;
		if (i > j) {
			tmp = i;
			i = j;
			j = tmp;
		}
		for (int index = i; index <= j; index++) {
			int result = 1;
			long long n = (long) index;
			while (n != 1) {
				if (n & 1) {
					result++;
					n = (3 * n) + 1;
				}
				while (!(n & 1)) {
					result++;
					n >>= 1;
				}
			}
			cycle = (cycle < result) ? result : cycle;
		}
		cout << x << " " << y << " " << cycle << "\n";
	}
}