#include <iostream>
#define MAX 300000
using namespace std;
long long start[MAX];
long long last[MAX];

long long find(long long x){
	for(long long i=1; i<MAX; i++){
		if((start[i]<=x)&&(last[i]>=x))
			return i;
	}
	return 0;
}

void solve(){
	start[1]=1;
	last[1]=1;
	start[2]=2;
	last[2]=3;
	for(long long i=3; i<MAX; i++){
		start[i]=last[i-1]+1;
		last[i]=last[i-1]+find(i);
	}
}
void print(long long x){
	cout<<find(x)<<endl;
}

int main() {
	long long x;
	solve();
	while(cin>>x){
		if(x==0)
			break;
		print(x);
	}
	return 0;
}