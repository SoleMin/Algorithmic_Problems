#include <iostream>
#include <algorithm>
using namespace std;

#define MAX 30000
int address[MAX];

int main(void) {
	int tc, n, i, median, distance;
	
	scanf("%d", &tc);
	for (int c = 0; c < tc; c++) {
		median = 0; distance = 0;
		scanf("%d", &n);
		for (i = 0; i < n; i++) {	// 주소 입력 받기
			scanf("%d", &address[i]);
		}
		// 정렬
		sort(address, address+n);
		// 출력
		median = n/2;
		//cout << address[median] << endl;
		for (i = 0; i < median; i++) {
			distance += address[median] - address[i];
			//cout << "distance: " << distance << endl;
		}
		for (i = median + 1; i < n; i++) {
			distance += address[i] - address[median];
			//cout << "distance: " << distance << endl;
		}
		cout << distance << endl;
	}
	return 0;
}