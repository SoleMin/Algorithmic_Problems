#include <iostream>
using namespace std;

#define MAX 1000000
int fn[MAX+1];

int main(void) {
	int n, index, sum, cur, k;
	fn[1] = 1;
	fn[2] = 2;
	cur = fn[2];
	while (scanf("%d", &n)) {
		if (n == 0) break;
		sum = fn[1] + fn[2];
		index = sum; k = index;
		cur = fn[2];
		
		while (1) {
			fn[index] = cur;
			sum += cur;
			if (sum >= n) break;
			if (index == k) {
				k += fn[++cur];
			}
			index++;
		}
		
		// 출력
		if (n < 2) index = 1;
		else if (n < 4) index = 2;
		
		cout << index << endl;
	}
	
	return 0;
}