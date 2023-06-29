#include <iostream>
#include <string>
#include <sstream>

using namespace std;
int main() {
	string s;
	int n;
	while(getline(cin, s)) {
		
		istringstream iss(s);
		if(s[0] == '0') {
			iss >> hex >> n;
			cout << dec << n << endl;
		}
		else {
			iss >> dec >> n;
			cout << "0x" << uppercase << hex << n << endl;;
		}
	}
	
	return 0;
}