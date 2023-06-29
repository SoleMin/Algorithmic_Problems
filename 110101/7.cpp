#include <iostream>

using namespace std;

int cycle[1000001];

void swap(int* a, int* b) {
	int temp = *a;
	*a = *b;
	*b = temp;
}

int main() {
	int a, b;
	while (cin >> a >> b) {
		int ans = -1;
		int count;
		cout << a << " " << b << " ";
		if (a > b)
			swap(a, b);
		for (int i = a; i <= b; i++) {
			if (!cycle[i]) {
				count = 1;
				long long n = i;
				while (n != 1) {
					if (n & 1) {
						n = n * 3 + 1;
						count++;
					}
					while (!(n & 1)) {
						n >>= 1;
						count++;
					}
				}
				cycle[i] = count;
			}
			count = cycle[i];
			ans = ans > count ? ans : count;
		}
		cout << ans << "\n";
	}
	return 0;
}