#include <iostream>
using namespace std;
int t,n,p;
int day[100];
bool weekend(int k){
	for(int i =0; i<p;i++){
		if(k%day[i]==0)
			return true;
	}
	return false;
}
int main() {
	//int res;
	cin>>t;
	while(t--){
		cin>>n>>p;//날 수p;
		int count =0;
		//int day[p];
		for(int i = 0; i<p; i++){
			cin>>day[i];
		}
		for(int i = 1; i<=n; ++i){
			if (i%7 !=0 && i%7 != 6 && weekend(i))
				count++;
		}
		cout<<count<<endl;
		
	}
}