#include <iostream>

using namespace std;

int main() {
	int n;
	while (cin >> n) {
		if (n == 0)
			break;
		int* G = new int[n + 1];
		G[1] = 1;
		int boundary = 1;
		int i = 2;
		
		while (n > boundary) {
			G[i] = 1 + G[i - G[G[i - 1]]];
			boundary += G[i++];
		}
		
		cout << i - 1 << '\n';
	}
	return 0;
}