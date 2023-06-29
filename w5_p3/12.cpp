#include <iostream>
#include <string>
#include <vector>
using namespace std;

int p[1000000];
int m, n;
string pat, text;

void getP() {
	int i = 1, j = 0;
	p[0] = 0;
	while(i < m) {
		while(j > 0 && pat[j] != pat[i]) {
			j = p[j - 1];
		}
		if(pat[j] == pat[i]) {
			p[i] = j + 1;
			i++; j++;
		}
		else {
			p[i] = 0;
			i++;
		}
	}
}

void kmp() {
	int cnt = 0;
	vector<int> point;
	
	int i = 0, j = 0;
	while(i < n) {
		if(text[i] == pat[j]) {
			i++; j++;
		}
		
		if(j == m) {
			cnt++;
			point.push_back(i - m + 1);
			j = p[j - 1];
		}
		
		if(text[i] != pat[j]) {
			if(j > 0)
				j = p[j - 1];
			else
				i++;
		}
	}
	
	cout << cnt << '\n';
	for(int i = 0; i < point.size(); i++)
		cout << point[i] << ' ';
	cout << '\n';
}

int main() {
	getline(cin, text);
	getline(cin, pat);
	n = text.length();
	m = pat.length();
	
	getP();
	kmp();
	
	
	return 0;
}