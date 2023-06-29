#include <iostream>
#include <queue>
using namespace std;

const int MAX = 20000;

int arr[MAX];

int main() {
	// int idx = 4;
	// bool br = false;
	// arr[1] = 1;
	// arr[2] = arr[3] = 2;
	// for(int i = 3; i <= MAX; i++) {
	// 	for(int j = 0; j < arr[i]; j++) {
	// 		arr[idx++] = i;
	// 		if(idx == MAX) {
	// 			br = true;
	// 			break;
	// 		}
	// 	}
	// 	if(br) break;
	// }
	int n;
	while(true) {
		queue<pair<int, int>> q;
		q.push({3, 2});
		int idx = 4;
		
		cin >> n;
		if(!n) break;
		if(n == 1) cout << 1 << '\n';
		else if(n == 2 || n == 3) cout << 2 << '\n';
		else {
			bool isFinish = false;
			while(!isFinish) {
				pair<int, int> cur = q.front();
				q.pop();
				for(int i = 0; i < cur.second; i++) {
					if(idx == n) {
						cout << cur.first << '\n';
						isFinish = true;
						break;
					}
					q.push({idx, cur.first});
					idx++;
				}
			}	
		}
	}
	
	return 0;
}