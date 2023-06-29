#include <iostream>
using namespace std;
int main() {
	int i,j,k, n, party, day, rest, result;
	int rest_day[7]={1,1,1,1,1,0,0};
	
	cin>>n;
	for(i=0; i<n; i++){
		int calendar[3650]={};
		result=0;
		cin>>day;
		cin>> party;
		for(j=0; j<party; j++){
			cin>>rest;
			for(k =0; k<day;k++){
				if((k+1)%rest==0)
					calendar[k] =1;
			}
		}
		for(j = 0; j< day; j++){
			calendar[j]=calendar[j]&&rest_day[(j%7)];
			result+=calendar[j];
		}
		cout<<result<<endl;
	}
	return 0;
}