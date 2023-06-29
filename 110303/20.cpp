#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main() {
	string a, b;
	string line = "";
	
	bool visited [1001];
		
	while(!cin.eof()) {
		for(int i = 0; i < 1001; i++) {
			visited[i] = false;
		}
		
		a = "";
		b = "";
		
		cin >> a >> b;
		
		sort(a.begin(), a.end());
		sort(b.begin(), b.end());
		
		for(int i = 0; i < a.length(); i++) {
			for(int j = 0; j < b.length(); j++) {
				
				if(!visited[j]) {
					if(a[i] == b[j]) {
						line += a[i];
						visited[j] = true;
						// cout << "b ======= " << b<< endl;
						break;
					}
				}
			}
		}
		
		sort(line.begin(), line.end());
		cout << line << endl;
		line = "";
		// cout << "a===" << a << " " << "b====" << b << endl;
	}
	
	
	return 0;
}