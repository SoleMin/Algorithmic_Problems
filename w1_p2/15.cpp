#include <iostream>
#include <string>

using namespace std;
int main() {
	string line;
	int space = 0;
	int nhex = 0;
	while(getline(cin,line)){
		for(int i=0;i<line.length();i++){
			if(line[0]=='0'){
				long ndec = 0;
				space = 2;
				string a = line.substr(space, line.length());
				ndec = stol(a, nullptr, 16);
				cout<<dec<<ndec<<endl;
				break;
			}
		else{
				nhex = stoi(line);
				cout<<"0x";
				cout << hex << uppercase << nhex <<endl;
				break;
			}
		}
	}

	return 0;
}