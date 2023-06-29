#include <iostream>

#define MAX_DAY 3651

using namespace std;

int main() {
	int t, n, p, cnt, party[MAX_DAY] = {0};
	cin >> t;
	while(t--) {
		cnt = 0;
		
		cin >> n >> p;
		
		for(int i = 0; i < p; i++) {
			cin >> party[0];
			for(int j = party[0]; j < n + 1; j += party[0]) party[j]++;
		}
		
		for(int i = 0; i < n + 1; i++) {
			if(((i % 7 != 6) && (i % 7 != 0)) && party[i]) cnt++;
		}
		
		cout << cnt << endl;
		
		for(int i = 1; i < n + 1; i++) party[i] = 0;
	}
	return 0;
}