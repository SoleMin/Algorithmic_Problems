#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;

int main() {
	
	int test_case, n, mid, result;
	int house [501];
	
	cin >> test_case;
	
	while(test_case != 0) {
		result = 0;
		cin >> n;
		for(int i = 0; i < n; i++) {
			cin >> house[i];
		}
		
		sort(house, house + n);
		
		mid = n / 2;
		for(int i = 0; i < n; i++) {
			result += abs(house[mid] - house[i]);
		}
		
		cout << result << endl;
		test_case -= 1;
	}
	
	
	return 0;
}