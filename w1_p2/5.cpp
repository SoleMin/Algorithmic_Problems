#include <iostream>
#include <string>
#include <sstream>
using namespace std;
int main() {
	string number;
	int n=0;
	while(getline(cin, number)){
		istringstream iss(number);
		if(number[0]=='0'){
			iss >> hex >> n;
			cout<< dec << n << endl;
		}
		else{
			iss >> n ;
			cout<<"0x";
			cout<< hex << uppercase <<n << endl;
		}
	}
	return 0;
}