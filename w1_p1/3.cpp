#include <iostream>
#include <string>
using namespace std;
int main() {
	string line;
	while(getline(cin, line)) {
		int letters = 0, words = 0;
		for(int i = 0; i < line.length(); i++){
			if((i==0&&(line[i]!='\t'&&line[i]!=' '))||(i>0&&(line[i]!='\t'&&line[i]!=' ')&&(line[i-1]=='\t'||line[i-1]==' ')))
				words++;
			if(line[i]!='\t'&&line[i]!=' ')
				letters++;
		}
	cout << letters << " " << words << endl;
	}
	return 0;
}