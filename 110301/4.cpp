#include <iostream>
#include <string>
using namespace std;
#define SIZE 47
const char keyboard[SIZE]={"`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;ZXCVBNM,./"};
int main(){
	string input;
	int a;
	while(getline(cin,input)){
		if(input=="")
			break;
		a=input.length();
		
		for(int i=0; i < a; i++){
			
				for(int j=0; j<SIZE; j++){
					if(input[i]==keyboard[j])
						input[i]=keyboard[j-1];}
		}
		cout<<input<<endl;
	}
	return 0;
}