#include<bits/stdc++.h>
#define ss 1000000
#define ll long long
using namespace std;
ll f[ss] = { 1, 1, 2, 2 };
ll i, j, x, a=4;
ll b, bb, n;
int main(){
	for(i=3;a<ss;++i){
		for(j=0; j<f[i] && a<ss; ++j ){
			f[a++] = i;
		}
	}
	while(cin>>n,n){
		if(n<ss){
			cout<<f[n]<<endl;
			continue;
		}
		x=3,b=4,bb=6;
		while(bb+f[x]*x<n){
			bb+=x*f[x];
			b+=f[x];
			++x;
		}
		cout<<(b+(n-bb)/x)<<endl;
	}
}
