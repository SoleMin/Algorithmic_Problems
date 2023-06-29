#include <iostream>
using namespace std;
int main() {
	int ar[3659],T,num,a,j,b,sums,k;
cin>>T;
	sums=0;
	while(T--){
		cin>>num>>a;
		for(j=1;j<=num;j++){
			ar[j]=0;
		}
		for(j=1;j<=a;j++){
			cin>>b;
			for(k=b;k<=num;k=k+b){
				ar[k]=1;
				
			}
		}
		sums=0;
		for(j=1;j<=num;j++){
			if(j%7!=0&&j%7!=6){
				sums=sums+ar[j];
			}
			
		}		
		cout<<sums<<endl;
	}
return 0;
}