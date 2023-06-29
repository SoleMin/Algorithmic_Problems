#include <iostream>
#include <string>
#include <vector>
using namespace std;
vector<int> kmp(string t, string p);
vector<int> computeNext(string p);
int main() {
	string t, p;
	
	getline(cin, t);
	getline(cin, p);
	
	vector<int> result = kmp(t, p);
	cout << result.size() << endl;
	for(auto i: result) cout << ++i << ' ';
	return 0;
}

vector<int> kmp(string t, string p) {
	int n = t.length(), m = p.length(), i = 0, q = 0;
	vector<int> result;
	vector<int> next = computeNext(p);
	
	while(i < n) {
		while(q > 0 && p[q] != t[i]) q = next[q - 1];
		if(t[i] == p[q]) {
			if(q == m - 1) {
				result.push_back(i - m + 1);
				q = next[q];
			} else q++;
		}
		i++;
	}
	return result;
}

vector<int> computeNext(string p) {
	int m = p.length(), q = 1, k = 0;
	vector<int> next(m);
	
	next[0] = 0;
	
	while(q < m) {
		while(k > 0 && p[q] != p[k]) k = next[k-1];
		if(p[q] == p[k]) next[q] = ++k;
		q++;
	}
	return next;
}