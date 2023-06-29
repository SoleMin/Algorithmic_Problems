#include <iostream>
#include <string>
using namespace std;
int main() {
	char key[47] = {
		'`','1', '2', '3', '4', '5', '6', '7' , '8', '9', '0', '-', '='
		,'Q', 'W', 'E', 'R','T','Y','U','I','O','P', '[', ']',
			'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', ';', '\'',
		'Z', 'X' ,'C','V' ,'B' ,'N', 'M', ',', '.', '/'
	};
	
	string str;
	while(getline(cin,str)){
	for(int i=0; i<str.length(); i++){
		if(str[i] == 32){
			cout << " ";
			continue;
		}
		for(int j=0; j<47; j++){
			if(str[i] == key[j])
				cout << key[j-1];
		}
	}
		cout << endl;
	}
}