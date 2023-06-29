#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;
int main() {
	int t,a,b;
	cin>>t;
	while(t--){
		int r = 0,min2,ans=0;
		//double min = 888;
		double rr;
		vector <int> v;
		cin>>a;
		for(int i =0; i<a; i++){
			cin>>b;
			v.push_back(b);
			r+=b;
		}
		rr=(double)r/v.size();
		sort(v.begin(),v.end());
		if(v.size()%2==1){
			min2=v[v.size()/2];
		}else{
			if(abs(v[(v.size()-1)/2]-rr)<abs(v[(v.size()+1)/2]-rr))
				min2=v[(v.size()-1)/2];
			else
				min2=v[(v.size()+1)/2];
		}
		for(int k=0;k<v.size();k++){
			if(v[k]>min2)
				ans+=v[k]-min2;
			else if(v[k]<min2)
				ans+=min2-v[k];
		}
		cout<<ans<<endl;
	}
}