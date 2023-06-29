#include <bits/stdc++.h>
using namespace std;

int TC, N, D, sum;
int h[3651], c[100];

int main() {
	cin>>TC;
	while(TC--){
		memset(h, 0, sizeof(h));
		sum =0 ;
		cin>>D>>N;
		for(int i=0 ; i<N ; ++i)
			cin>>c[i];
		for(int i=0 ; i<N ; ++i)
			for(int j=c[i]-1 ; j<D ; j += c[i])
				++h[j];
		for(int i=0 ; i<D ; i++)
			if(i % 7 != 5 && i % 7 != 6 && h[i])
				++sum;
		
		cout<<sum<<"\n";
	}
}