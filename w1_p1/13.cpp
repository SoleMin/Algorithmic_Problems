#include <iostream>
#include <string>

using namespace std;
int main() {
	string line;
	
	while(getline(cin,line)){
		int word=0, letter=0;
		for(int i=0;i<line.length();i++){
		if((i==0 && line[i]!='\t')||(i==0 && line[i]!=' ')){
			word++;
		}	
		if(((i>0 && line[i-1]=='\t')||(i>0 && line[i-1]==' '))&&(line[i]!='\t' && line[i]!=' ')){
			word++;
		}
		if(line[i]!='\t' && line[i]!=' '){
			letter++;
		}
		}
		int length = line.length();
		if(length>0 && (line[0]==' '||line[0]=='\t')){
			word--;
		}
		cout<<letter<<" "<<word<<endl;
	}
	return 0;
}