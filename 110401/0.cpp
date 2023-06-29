#include <iostream>
#include <cstdio>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	int t, r, vito;
	int result=0;
	scanf("%d",&t);
	while(t--){
		scanf("%d",&r);
		vector<int> s(r,0);
		for(int i=0;i<r;i++) scanf("%d",&s[i]);
		sort(s.begin(),s.end());

		vito=r/2;
		for(int i=0;i<vito;i++) result+=(s[vito]-s[i]);
		for(int i=vito+1;i<r;i++) result+=(s[i]-s[vito]);
		printf("%d\n",result);
		result=0; s.clear();
	}
}