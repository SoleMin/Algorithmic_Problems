#include <iostream>
#include <string>
using namespace std;
int main() {
	string line;
	
	while(getline(cin,line)){
		int word=0, letter=0;
		for(int i = 0; i<line.length(); i++){
			if((line[i]!=' ') && ((line[i])!='\t'))
				letter++;
			if((i>0 && (line[i]== '\t' || line[i]== ' ') && (line[i-1]!='\t' && line[i-1]!=' ')) || (i == line.length()-1 && (line[i]!=' '&& line[i]!='\t')))
				 word++;
		}
		cout << letter << " " << word << endl;
	}
	return 0;
}