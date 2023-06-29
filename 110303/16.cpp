#include <iostream>
#include <string>
#include <algorithm>

using namespace std;
int main() {
	
	while(true) {
		string a, b;
		if(!getline(cin, a)) break;
		if(!getline(cin, b)) break;
		//if(cin.eof()) break;
		
		sort(a.begin(), a.end());
		sort(b.begin(), b.end());
		
		string ret = "";
		int start = 0;
		for(int i = 0; i < a.length(); i++) {
			int idx = start;
			while(idx < b.length()) {
				if(a[i] == b[idx]) {
					ret.push_back(a[i]);
					break;
				}
				idx++;
			}
			// 일치하는 문자를 찾으면 
			if(idx < b.length()) {
				start = idx + 1;
			}
		}
		cout << ret << '\n';
	}
	
	return 0;
}