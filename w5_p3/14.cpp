#include <iostream>
#include <string>
#include <vector>
using namespace std;

vector <int> compute_Next(string p) {
	
	vector <int> cn(p.length());
	
	int j = 0;
	for(int i = 1; i < p.length(); i++) {
		
		while(j > 0 && p[i] != p[j]) {
			j = cn [j-1];
		}
		if(p[i] == p[j])
			cn[i] = ++j;
	}
	return cn;
}

vector<int> kmp (string t, string p) {
	
	vector <int> kmp_v = compute_Next(p), v;
	
	int j = 0;
	for(int i = 0; i < t.length(); i++) {
		while(j > 0 && t[i] != p[j]) {
			j = kmp_v[j-1];
		}
		
		if(t[i] == p[j]) {
			if(j == p.length()-1) {
				v.push_back(i-j+1);
				j = kmp_v[j];
			}
			else
				j++;
		}
	}
	return v;
}

int main() {
	
	string t, p;
	getline(cin, t);
	getline(cin, p);
	
	vector <int> ans = kmp(t, p);
	
	cout << ans.size() << endl;
	
	for(auto i : ans) {
		cout << i << " ";
	} 
	return 0;
}