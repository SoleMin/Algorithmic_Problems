#include <iostream>
using namespace std;
int main() {
	
	int a, b;
	while(true) {
		cin >> a >> b;
		if(cin.eof()) break;
		bool swapFlag = false;
		if(a > b) {
			swap(a, b);
			swapFlag = true;
		}
		
		long long mx = 0;
		for(int i = a; i <= b; i++) {
			long long curNum = i, cnt = 1;
			while(curNum != 1) {
				if(curNum & 1) {
					curNum = curNum * 3 + 1;
					cnt++;
				}
				else {
					while(!(curNum & 1)) {
						curNum /= 2;
						cnt++;
					}
				}
			}
			mx = (mx > cnt) ? mx : cnt;
		}
		if(swapFlag)
			swap(a, b);
		cout << a << ' ' << b << ' ' << mx << '\n';
		//printf("%d %d %ld\n", a, b, mx);
	}
	
	return 0;
}