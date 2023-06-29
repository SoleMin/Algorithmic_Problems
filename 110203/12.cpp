#include <iostream>

using namespace std;

short date[3651];

int main() {
	int T;
	cin >> T;
	while (T-- != 0) {
		int N, P;
		cin >> N >> P;
		while (P-- != 0) {
			int h;
			cin >> h;
			for (int i = 1; h * i <= N; i++)
				date[h * i] += 1;
		}
		
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			if ((i % 7 != 6) && (i % 7 != 0) && date[i])
				ans++;
			date[i] = 0;
		}
		cout << ans << "\n";
	}
	return 0;
}