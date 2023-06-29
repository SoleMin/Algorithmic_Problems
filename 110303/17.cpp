#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	string a, b;
	while (cin >> a >> b) {
		sort(a.begin(), a.end());
		sort(b.begin(), b.end());
		string ans;
		int i = 0;
		int j = 0;
		int a_length = a.length();
		int b_length = b.length();
		while (i < a_length && j < b_length) {
			if (a[i] == b[j]) {
				ans += a[i];
				i++;
				j++;
			}
			else if (a[i] > b[j])
				j++;
			else
				i++;
		}
		sort(ans.begin(), ans.end());
		cout << ans << "\n";
	}
	return 0;
}