#include <iostream>
#include <string>
using namespace std;
int main() {
	bool changed;
	int result[1001] = {0,};
	int cmpindex = 0, matchcount = 0, count, i, j;
	string t, p;
	getline(cin, t);
	getline(cin, p);

	while (cmpindex <= t.length() - p.length()) {
		changed = false;
		
		if (t.substr(cmpindex, p.length()) == p) {
			result[matchcount] = cmpindex + 1;
			matchcount++;
		}
		
		for (i = 1; i < p.length(); i++) {
			if (t.substr(cmpindex + i, p.length() - i) == p.substr(0, p.length() - i)) {
				changed = true;
				break;
			}
		}
		if (changed) 
			cmpindex += i;
		else
			cmpindex += p.length();
	}
	
	cout << matchcount << endl;
	for (int i = 0; i < matchcount; i++) {
		cout << result[i];
		if (i != matchcount - 1)
			cout << " ";
	}
}