#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
	
	int test_case, n, day, penalty;
	double x;
	vector<pair<double, int>> v;
	
	cin >> test_case;
	while(test_case != 0) {
		v.clear();
		
		cin >> n;
		for(int i = 0; i < n; i++) {
			cin >> day >> penalty;
			x = (double)penalty / day;
			v.push_back(make_pair(x, i));
		}
		sort(v.begin(), v.end(), greater<>());
		for(int i = 0; i < v.size()-1; i++) {
			if(v[i].first == v[i+1].first) {
				if(v[i].second > v[i+1].second) {
					swap(v[i], v[i+1]);
				}
			}
		}
		
// 		for(int i = 0; i < v.size(); i++) {
// 			cout << v[i].first << " " << v[i].second << endl;
// 		}
		
		for(int i = 0; i < n; i++) {
			cout << v[i].second + 1 << " ";
		}
		
		cout << endl;
		test_case -= 1;
		cout << endl;
	}
	
	
	
	return 0;
}