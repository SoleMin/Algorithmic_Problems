#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int main() {
	int t;
	cin >> t;
	while(t--) {
		int r;
		cin >> r;
		vector<int> s_r(r);
		for(int i = 0; i < r; ++i) cin >> s_r[i];
		sort(s_r.begin(), s_r.end());
		if(s_r.size() % 2) {
			int center = s_r[s_r.size() / 2], result = 0;
			for(auto i: s_r) result += abs(center - i);
			cout << result << endl;
		} else {
			int center[2] = {s_r[s_r.size() / 2], s_r[s_r.size() / 2 - 1]}, result[2] = {0};
			for(auto i: s_r) {
				result[0] += abs(center[0] - i);
				result[1] += abs(center[1] - i);
			}
			cout << min(result[0], result[1]) << endl;
		}
	}
	return 0;
}