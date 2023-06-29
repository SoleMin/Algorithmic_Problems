#include <iostream>
#include <algorithm>
using namespace std;

int n;
int t[1001], s[1001];

bool comp(pair<int, double> &p1, pair<int, double> &p2) {
	if(p1.second > p2.second)
		return true;
	return false;
}

int main() {
	int c; cin >> c;
	while(c--) {
		cin >> n;
		for(int i = 0; i < n; i++) {
			cin >> t[i] >> s[i];
		}
		pair<int, double> p[1001];
		for(int i = 0; i < n; i++) 
			p[i] = {i + 1, (double)s[i] / t[i]};
		
		sort(p, p + n,  comp);
		
		for(int i = 0; i < n; i++)
			cout << p[i].first << ' ';
		cout << "\n\n";
	}
	return 0;
}