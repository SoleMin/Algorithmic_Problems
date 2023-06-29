#include <iostream>
# include <string>

using namespace std;

int main() {
	
	string input;
	
	while(cin >> input){
		if(input.length() >= 2){
			if(input[0] == '0' && input[1] == 'x'){
				cout << stoi(input, nullptr, 16) << endl;
				continue;
			}
		}
		
		printf("0x%X\n", stoi(input));
	}
	
	
	
	return 0;
}