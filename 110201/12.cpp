#include <iostream>
#define MAX_N 3001
#define abs(x) ((x < 0) ? (-(x)) : (x))

using namespace std;
int main() {
	
	int n, diff, sum_val = 0;
	int arr[MAX_N];
	int visited[MAX_N] = {0, };
	bool jolly = 1;
	
	while(true) {
		for(int i = 0; i < MAX_N; i++) {
			visited[i] = 0;
		}
		jolly = 1;
		
		cin >> n;
		
		if(cin.eof())
			break;
		
		for(int i = 0; i < n; i++) {
			cin >> arr[i];
		}
		
		for(int i = 0; i < n-1; i++) {
			diff = abs(arr[i+1] - arr[i]);
			if ((diff <= 0) || (diff >= n) || visited[diff] == 1) {
				jolly = 0;
				break;
			}
			visited[diff] = 1;
		}
		
		if (jolly)
			cout << "Jolly" << endl;
		else
			cout << "Not jolly" << endl;
		
	}
	
	return 0;
}