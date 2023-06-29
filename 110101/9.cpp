#include <iostream>
using namespace std;

long long cycle_cnt(long long x, long long y) {
	long long max_cnt = 0;
	
	for(int i = x; i <= y; i++) {
		long long num = i;
		long long cnt = 1;
		
		while(num != 1) {
			
			if(num % 2 == 0) {
				num /= 2;
				cnt += 1;
			} else {
				num = num * 3 + 1;
				cnt += 1;
			}
		}
		max_cnt = cnt > max_cnt ? cnt : max_cnt;
	
	}
	return max_cnt;
}

int main() {
	long long result;
	long long x, y;
	while(true) {
		cin >> x >> y;
		if (cin.eof()) {
			break;
		}
		
		if(x > y) 
			result = cycle_cnt(y, x);
		else 
			result = cycle_cnt(x, y);
		cout << x << " " << y << " " << result << endl;
	}
	
	
	
	return 0;
}

