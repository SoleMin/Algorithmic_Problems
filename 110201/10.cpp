#include <iostream>
#include <algorithm>
using namespace std;
int main() {
	int n,diff,jolly;
	int arr[3000];
	int dif[2500];
	while(!(cin>>n).eof()){
		int i;

		for(i = 0; i<n; i++){
			cin>>arr[i];
		}
		for(i = 1; i<n; i++)
			dif[i]=0;

		for(i = 0; i<n-1; i++){
			diff= abs(arr[i]-arr[i+1]);
			if (diff <= 0 || diff>= n || dif[diff]){
				cout << "Not jolly" << endl;
				break;
			}
			dif[diff]=1;
		}
		if(i==n-1)
			cout<<"Jolly"<<endl;

	}
	return 0;
}