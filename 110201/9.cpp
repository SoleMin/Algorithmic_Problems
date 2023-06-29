#include <iostream>
#include <cmath>

using namespace std;

int check[3001];

int main() {
	int n;
	while (cin >> n) {
		bool isJolly = true;
		int a, b;
		cin >> a;
		//cout << "a: " << a;
		for (int i = 1; i < n; i++) {
			cin >> b;
			//cout << " " << b;
			check[abs(a - b)] += 1;
			if (check[abs(a - b)] >= 2)
				isJolly = false;
			a = b;
		}
		for (int i = 1; i <= n - 1; i++)
			if (check[i] == 0) {
				isJolly = false;
				break;
			}
		//cout << " n: " << n << endl;
		cout << (isJolly ? "Jolly\n" : "Not jolly\n");
		for (int i = 0; i < 3001; i++)
			check[i] = 0;
	}
	return 0;
}