#include <iostream>
#include <string>
#include <sstream>
using namespace std;
int main() {
	string line;
	int i;
	while(getline(cin,line)){
		if(line[0]=='0'){
			istringstream iss(line);
			/*string sub = line.substr(2,line.length()-1);
			int a = stoi(sub,nullptr,16);
			cout<<a<<endl;*/
			iss>>hex>>i;
			cout<<dec<<i<<endl;
		}
		else{
			int b = stoi(line,nullptr,10);
			cout<<"0x"<<hex<<uppercase<<b<<endl;
		}
	}
	return 0;
}