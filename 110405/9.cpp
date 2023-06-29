#include <algorithm>
#include <iostream>
using namespace std;
bool compare(const int &a, const int &b) {
	return a < b;
}

int main() {
	int c, n;
	int t[1001];
	int s[1001];
	int result[1001];
	cin >> c;
	while (c--) {
		cin >> n;
		for (int i = 0; i < n; i++) {
			cin >> t[i] >> s[i];
			result[i] = i;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (t[result[j]] * s[result[j + 1]] > t[result[j + 1]] * s[result[j]])
					swap(result[j], result[j + 1]);
				else if (t[result[j]] * s[result[j + 1]] == t[result[j + 1]] * s[result[j]] && result[j] > result[j + 1])
					swap(result[j], result[j + 1]);
			}
		}
		
		for (int i = 0; i < n; i++) {
			cout << result[i] + 1 << " ";
		}
		cout << endl << endl;
	}
	
}