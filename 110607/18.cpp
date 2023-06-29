#include <iostream>
#include <string>
using namespace std;
int main() {
	string line;
	int num;
	int val[100000];
	long long sum=1;
	val[1]=1;
	while(getline(cin,line)){
		num=stoi(line);
		if(num==0)break;
		if(num==1)cout<<"1"<<endl;
		else{
			for(long long i =2 ;i<=num;i++){
				val[i]=1+val[i-val[val[i-1]]];
				sum+=val[i];
				if(sum>=num){
					cout<<i<<endl;
					break;
				}
			}
			sum=1;
		}
	}
	return 0;
}