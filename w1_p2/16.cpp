#include <iostream>
#include <sstream>
#include <string>
using namespace std;
int main() {
	string str;
	int n;
	
	while(true) {
		if (!getline(cin, str))
			break;
		
		istringstream iss(str);
		if (str[0] == '0') {
			iss >> hex >> n;
			cout << dec << n << endl;
		} else {
			iss >> dec >> n;
			cout << "0x" << uppercase << hex << n << endl;	
		}
	
	}
	
	return 0;
}