#include <bits/stdc++.h>
using namespace std;

int main() {
	string a, b; 
	while(cin >> a >> b){
		map<char, int> M; 
		for(auto i : a) M[i]++; 
		vector<char> v; 
		for(auto i : b){
			if(M[i]>0) {
				v.push_back(i);
				M[i]--; 
			}
		}
		sort(v.begin(), v.end()); 
		for(auto i : v){
			cout << i << ""; 
		}
		cout << "\n"; 
	}
}