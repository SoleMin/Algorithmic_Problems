#include <iostream>
#include <string>
#include <sstream>
using namespace std;

int main() {
	string line;
	int n;
	while(getline(cin,line)){
		stringstream iss(line);
		if(line[0] == '0'){
			iss >> hex >> n;
			cout << dec << n << endl;
		}
		else{
			iss >> n;
			cout << "0x";
			cout << hex << uppercase << n << endl;
		}
	}
	return 0;
}