#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	int T;
	cin >> T;
	while (T-- != 0) {
		int time = 0;
		vector<int> v;
		int n;
		cin >> n;
		for (int i = 0; i < n; i++) {
			int temp;
			cin >> temp;
			v.push_back(temp);
		}
		sort(v.begin(), v.end());
		while (n >= 4) {
			time += min(v[0] + 2 * v[1] + v[n - 1], 2 * v[0] + v[n - 2] + v[n - 1]);
			n -= 2;
		}
		
		if (n == 2)
			time += v[1];
		else
			time += (v[0] + v[1] + v[2]);
		
		cout << time << "\n\n";
	}
	return 0;
}