#include <iostream>
#include<cmath>
#include<cstdio>
using namespace std;

int arr[3000];
int difference[2999];
int main() {
	
	int num;
	while(!(cin>>num).eof())
	{
		int j;
    for(j=0;j<num;j++){
			cin>>arr[j];
}
		for(j=0;j<num;j++){
			difference[j]=0;
		}
		for(j=0;j<num-1;j++){
			int a=abs(arr[j]-arr[j+1]);
			if(a<1||a>num-1||difference[a]==1){
				cout<<"Not jolly"<<endl;
				break;
}
			difference[a]=1;
}
		if(j==num-1){
			cout<<"Jolly"<<endl;
		}
	}	
	return 0;
}