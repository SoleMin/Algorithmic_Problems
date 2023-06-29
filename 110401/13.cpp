#include <iostream>
#include <cmath>

using namespace std;

int house[500];

int main() {
	int tc;
	cin >> tc;
	while (tc-- != 0) {
		int n;
		cin >> n;
		int ans = 0;
		for (int i = 0; i < n; i++)
			cin >> house[i];
		int vito = house[n / 2];
		for (int i = 0; i < n; i++)
			ans += (abs(vito - house[i]));
		cout << ans << '\n';
	}
	return 0;
}