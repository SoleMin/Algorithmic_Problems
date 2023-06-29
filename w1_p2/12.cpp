#include <iostream>
#include <string>
#include <math.h>

using namespace std;

int main() {
	string n;
	while (cin >> n) {
		if (n[0] == '0') {
			int ans = 0;
			for (int i = 0; i < n.length() - 2; i++) {
				char temp = n[n.length() - 1 - i];
				if ('A' <= temp && temp <= 'F')
					ans += ((temp - 'A' + 10) * pow(16, i));
				else
					ans += ((temp - '0') * pow(16, i));
			}
			cout << dec << ans << "\n";
		}
		else
			cout << hex << uppercase << "0x" << stoi(n) << "\n";
	}
	return 0;
}