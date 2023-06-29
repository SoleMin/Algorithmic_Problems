#include <iostream>
#define MAX_N 3000
#define abs(x) ((x)<0? (-(x)) : (x))
using namespace std;
int main() {
	int present[MAX_N];
	int n,i,prev,curr, diff, jolly;
	char line[5000];
	while(cin>>n){
		jolly = 1;
		for(i = 1 ; i<=n; i++)
			present[i]=0;
		cin>>prev;
		for(i=1;i<n;i++){
			cin>>curr;
			diff=abs(curr-prev);
			if(diff <= 0||diff>=n||present[diff]){
				jolly=0;
				break;
			}
			present[diff]=1;
			prev=curr;
		}
		fgets(line,5000,stdin);
		puts(jolly?"Jolly":"Not jolly");
	}
	return 0;
}