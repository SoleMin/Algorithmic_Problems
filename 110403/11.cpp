#include <algorithm> 
#include <iostream>
using namespace std;
bool compare(const int &a, const int &b) {
	return a < b;
}

int main() {
	int pt[1001];
	int t, n, sum;
	cin >> t;
	while(t--) {
		sum = 0;
		cin >> n;
		for (int i = 0; i < n; i++) {
			cin >> pt[i];
		}
		sort(pt, pt + n, compare);
		while (1) {
			if (n == 1) {
				sum += pt[0];
				break;
			}
			else if (n == 2) {
				sum += pt[1];
				break;
			}
			else if (n == 3) {
				sum += pt[0] + pt[1] + pt[2];
				break;
			}
			
			else{
				if (pt[1] * 2 < pt[n - 2] + pt[0])
					sum += pt[0] + pt[1] * 2 + pt[n - 1];
				else
					sum += 2 * pt[0] + pt[n - 2] + pt[n - 1];
				n -= 2;
			}
		}
			
		cout << sum << endl << endl;
	}
}