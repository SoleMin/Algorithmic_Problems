#include <iostream>
using namespace std;
int main() {
	int n, jumpers[3000], absJumpers[3000], s[3001];
	bool jolly;
	while(true) {
		cin >> n;
		if(cin.eof() == true) break;
		
		for(int i = 0; i < n; i++) s[i] = 1;
		for(int i = 0; i < n; i++) cin >> jumpers[i];
		
		for (int i = 0; i < n - 1; i++) s[abs(jumpers[i] - jumpers[i + 1])] = 0;
		
		jolly = true;
		
		for(int i = 1; i < n; i++) {
			if(s[i] == 1) {
				jolly = false;
				break;
			}
		}
		if(jolly) cout << "Jolly";
		else cout << "Not jolly";
		cout << endl;
	}
	return 0;
}