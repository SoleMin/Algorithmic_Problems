#include <iostream>
#include <algorithm>
using namespace std;

// 10 5 2 = 17
// 50 20 40
// 12 1 11 1 2

int n, t;
int arr[1001];


int main() {
	cin >> t;
	while(t--) {
		cin >> n;
		for(int i = 0; i < n; i++) 
			cin >> arr[i];
		sort(arr, arr + n);
		
		int sum = 0;
		int cnt = n;
		
		while(cnt != 0) {
			if(cnt > 3) {
				int case1 = arr[0] * 2 + arr[cnt - 1] + arr[cnt - 2];
				int case2 = arr[0] + 2 * arr[1] + arr[cnt - 1];
				
				sum += min(case1, case2);
				cnt -= 2;
			}
			else if(cnt == 3) {
				sum += arr[0] + arr[1] + arr[2];
				cnt -= 3;
			}
			else if(cnt == 2) {
				sum += arr[1];
				cnt -= 2;
			}
			else {
				sum += arr[0];
				cnt -= 1;
			}
		}
		cout << sum << "\n\n";
		
		// if(n == 1) {
		// 	sum = arr[0];
		// }
		// else if(n == 2) {
		// 	sum = arr[1];
		// }
		// else if(n & 0x1) {			// odd
		// 	for(int i = 2; i < n; i += 2)
		// 		sum += arr[i];
		// 	int k = n / 2;
		// 	sum += arr[1] * k;
		// 	sum += arr[0] * k;
		// 	sum += arr[1] * (k - 1);
		// }
		// else {						// even
		// 	for(int i = 3; i < n; i += 2) 
		// 		sum += arr[i];
		// 	int k = n / 2 - 1;
		// 	sum += arr[1] * (k + 1);
		// 	sum += arr[0] * k;
		// 	sum += arr[1] * k;
		// }
		// cout << sum << "\n\n";
	}
	
	return 0;
}