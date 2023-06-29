#include <iostream>
#include <algorithm>
using namespace std;

#define MAX_NUM 1000
int person[MAX_NUM];

int main(void) {
	int tc, i, n, time;
	//queue<int> rightBridge;
	
	cin>>tc;
	cin.get();
	for (int c = 0; c < tc; c++) {
		time = 0;
		scanf("%d", &n);
		// 다리 건너는 시간 입력 받기
		for (i = 0; i < n; i++) {
			scanf("%d", &person[i]);
		}
		// 정렬
		sort(person, person + n);
		// 다리 건너기
		if (n == 1)
			time += person[0];
		else if (n == 2)
			time += person[0] + person[1];
		else if (n == 3)
			time += person[0] + person[1] + person[2];
		else if (n > 3) {
			int len = n;
			while (len > 3) {
				if (person[0] + 2*person[1] + person[len-1] < 2*person[0] + person[len-1] + person[len-2]) {
					time += person[0] + 2*person[1] + person[len-1];
					len-=2;
				}
				else {
					time += 2*person[0] + person[len-2] + person[len-1];
					len-=2;
				}
			}
			if (len == 3)	// 홀수
				time += person[0] + person[1] + person[2];
			else if (len == 2)	// 짝수
				time += person[1];
		}
		
		
		cout << time << endl;
		cout << endl;
	}
	return 0;
}