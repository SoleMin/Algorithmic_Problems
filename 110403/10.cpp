#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
using namespace std;
int main() {
	int t;
	string s;
	cin >> t;
	cin.ignore();
	getline(cin, s);
	while(t--) {
		int n;
		cin >> n;
		vector<int> bridge(n);
		for(int i = 0; i < n; ++i) cin >> bridge[i];
		sort(bridge.begin(), bridge.end());
		
		int time = 0;
		while(bridge.size() > 3) {
			int fast1 = bridge[0], fast2 = bridge[1], slow1 = bridge[bridge.size() - 1], slow2 = bridge[bridge.size() - 2];
			int answer[2] = {fast1 + fast2 * 2 + slow1, fast1 * 2 + slow1 + slow2};
			if(answer[0] < answer[1]) time += answer[0];
			else time += answer[1];
			bridge.pop_back(); bridge.pop_back();
		}
		
		if(bridge.size() == 3) for(auto i: bridge) time += i;
		else time += bridge[1];
		
		cout << time << endl;
		cout << endl;
	}
	return 0;
}