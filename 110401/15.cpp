#include <iostream>
#include <algorithm>
using namespace std;

#define MAX 500

int main() {
	int tc;
	int r;
	int s[MAX];
	cin >> tc;
	while(tc--){
		int sum = 0;
		cin >> r;
		for(int i=0; i<r; i++){
			cin >> s[i];
		}
		sort(s, s+r);
		int median = s[(r-1)/2];
		for(int i=0; i<r; i++){
			sum += abs(median - s[i]);
		}
		cout << sum << "\n";
	}
}