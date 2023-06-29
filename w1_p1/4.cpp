#include <iostream>
#include <string>
using namespace std;
int main() {
	string target;
	while(getline(cin, target)){
		int words = 0;
		int letters = 0;
		for(int i = 0; i < target.length(); i++){
			if((i==0&&(target[i] != ' ' && target[i] !='\t')) || (i>0 && (target[i-1]==' ' || target[i-1] =='\t')) && (target[i] != ' ' && target[i] != '\t'))
				words++;
			if(target[i] != ' ' && target[i] != '\t')
				letters++;
		}
		cout <<letters<<" "<<words<<endl;
	}
	return 0;
}