#include <iostream>
#include <string>
#include <vector>
using namespace std;

vector<int> compute_next(string p){
	int m, k = 0;
	m = p.size();
	vector<int> next(m,0);
	//next[0] = 0;
	for(int i = 1; i < m; i++){
		while(k > 0 && p[k] != p[i]){
			k = next[k - 1];
		}
		if(p[k] == p[i]){
			k = k+1;
			next[i] = k;
		}
			
	}

	return next;

}
vector<int> kmp(string t, string p){
	int n, m, q;
	vector<int> ans;
	vector<int> next;
	n = t.size();
	m = p.size();
	next = compute_next(p);
	q = 0;

	for(int i = 0; i < n; i++){
		while(q > 0 && p[q] != t[i]){
			q = next[q-1];
		}
		/*
		if(p[q]==t[i]) q++;
		if(q == m - 1){
			ans.push_back(i - m + 2);
			q = next[q];
		}*/
		if(p[q] == t[i]){
			if(q == m - 1){
			ans.push_back(i - m + 2);
			q = next[q];
			}
			else q++;
		}
	}
	return ans;
}




int main() {
	string t, p;
	int size;
	vector<int> v;
	getline(cin, t);
	getline(cin, p);
	
	v = kmp(t , p);
	size = v.size();
	cout << size << endl;
	for(int i = 0; i < size; i++){
		cout << v[i] << " ";
	}
	
	
	return 0;
}