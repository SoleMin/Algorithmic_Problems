#include <iostream>
using namespace std;
int main() {
	int a;
	string s;
	string word = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";
	while(getline(cin,s)){
		string sen="";
		
		for(int i =0;i<s.length();i++){
			if(s[i]!='Q' && s[i]!='A' && s[i]!='Z' && s[i]!=' '){
				a=word.find(s[i]);
				sen.append(word,a-1,1);
			}
			else
				sen+=s[i];
		}
		cout<<sen<<endl;
	}
	return 0;
}