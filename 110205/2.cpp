#include <iostream>
#include<cstdio>
//#include<vector>
//#include<algorithm>
#include<string>
//#include<cstring>
//#include<queue>
//#include<stack>
//#include<list>
#include<sstream>
//#include<bitset>
//#include<cmath>

//#include<map>
using namespace std;
int main(){
	char su[][9]={"Clubs","Diamonds","Hearts","Spades"};
	char val[][6]={"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
	int t,n,k;
	string l;
	int ps[100][52];
	int c[52],next[52];
	bool b=true;
	cin>>t;
	while(t--){
		cin>>n;
		for(int i=0;i<n;i++){
			for(int j=0;j<52;j++){
				cin>>ps[i][j];
				--ps[i][j];
			}
		}
		for(int i=0;i<52;i++)
			c[i]=i;
		getline(cin,l);
		while(getline(cin,l)){
			if(l.empty()) break;
			istringstream is(l);
			is>>k;
			--k;
			for(int i=0;i<52;i++) next[i]=c[ps[k][i]];
			for(int i=0;i<52;i++)c[i]=next[i];
		}
		if(!b) printf("\n");
		b=false;
		for(int i=0;i<52;i++)
			printf("%s of %s\n", val[c[i]%13],su[c[i]/13]);
	}
	return 0;
}