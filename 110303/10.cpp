#include <iostream>
#include <string>
#define SIZE 1000
using namespace std;
int main() {
	string fword;
	string sword;
	int count;
	char temp;

	while(getline(cin,fword),getline(cin,sword)){
		count=0;
		char array[SIZE]={};
		for(int i=0;i<fword.length();i++)
			for(int j=0; j<sword.length();j++)
				if(fword[i]==sword[j]){
					array[count++]=fword[i];
					sword[j]='.';
					j=sword.length()-1;
				}
		for(int i=0; i<SIZE; i++){
			for(int j=i+1; j<SIZE;j++){
				if(array[i]>array[j]){
					temp=array[j];
					array[j]=array[i];
					array[i]=temp;
				}
			}
		}
		for(int i=0; i<SIZE; i++){
			if(array[i]!='\0')
				cout<<array[i];}
		cout<<endl;
	}
	return 0;
}