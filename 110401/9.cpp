#include <algorithm>
#include <iostream>
using namespace std;

bool compare(const int &a, const int &b) {
	return a < b;
}

int main() {
	int t, case_num, a, m, result;
	int address[1000];
	cin >> t;
	while(t--) {
		result = 0;
		cin >> case_num;
		for (int i = 0; i < case_num; i++)
			cin >> address[i];
		
		sort(address, address + case_num, compare);
		
		m = address[case_num / 2];
		
		for (int i = 0; i < case_num; i++) {
			if (address[i] - m > 0)
				result += address[i] - m;
			else
				result += m - address[i];
		}
		cout << result << endl;
	}
}