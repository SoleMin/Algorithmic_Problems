#include <iostream>
#include <string>
using namespace std;
int main() {
	string line;
	char answer[10000];

	while(getline(cin,line)){
		for(int i=0;i<line.length();i++){
			if(line[i]==' ') answer[i] = ' ';
			if(line[i]=='1') answer[i] = '`';
			if(line[i]=='2') answer[i] = '1';
			if(line[i]=='3') answer[i] = '2';
			if(line[i]=='4') answer[i] = '3';
			if(line[i]=='5') answer[i] = '4';
			if(line[i]=='6') answer[i] = '5';
			if(line[i]=='7') answer[i] = '6';
			if(line[i]=='8') answer[i] = '7';
			if(line[i]=='9') answer[i] = '8';
			if(line[i]=='0') answer[i] = '9';
			if(line[i]=='-') answer[i] = '0';
			if(line[i]=='=') answer[i] = '-';
			if(line[i]=='W') answer[i] = 'Q';
			if(line[i]=='E') answer[i] = 'W';
			if(line[i]=='R') answer[i] = 'E';
			if(line[i]=='T') answer[i] = 'R';
			if(line[i]=='Y') answer[i] = 'T';
			if(line[i]=='U') answer[i] = 'Y';
			if(line[i]=='I') answer[i] = 'U';
			if(line[i]=='O') answer[i] = 'I';
			if(line[i]=='P') answer[i] = 'O';
			if(line[i]=='[') answer[i] = 'P';
			if(line[i]==']') answer[i] = '[';
			//if(line[i]=='\') answer[i] = ']';
			if(line[i]=='S') answer[i]='A';
			if(line[i]=='D') answer[i]='S';
			if(line[i]=='F') answer[i]='D';
			if(line[i]=='G') answer[i]='F';
			if(line[i]=='H') answer[i]='G';
			if(line[i]=='J') answer[i]='H';
			if(line[i]=='K') answer[i]='J';
			if(line[i]=='L') answer[i]='K';
			if(line[i]==';') answer[i]='L';
			//if(line[i]==''') answer[i]=';';
			if(line[i]=='X') answer[i]='Z';
			if(line[i]=='C') answer[i]='X';
			if(line[i]=='V') answer[i]='C';
			if(line[i]=='B') answer[i]='V';
			if(line[i]=='N') answer[i]='B';
			if(line[i]=='M') answer[i]='N';
			if(line[i]==',') answer[i]='M';
			if(line[i]=='.') answer[i]=',';
			if(line[i]=='/') answer[i]='.';
		}
		for(int i=0;i<line.length();i++)
			cout<<answer[i];
		cout<<endl;
	}
	return 0;
}