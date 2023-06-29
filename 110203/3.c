#include <stdio.h>
#define MAX_N 3650
#define MAX_P 100
int main() {

	int t,i,k;
	scanf("%d",&t);
	int result[t];
	
	for(k=0;k<t;k++){
		int n,j,p;
		scanf("%d", &n);
		int days[n];
		
		scanf("%d", &p);
		int h[p];
		
		for(i=0; i<p; i++){
			scanf("%d",&h[i]);
		}

		for(i=0;i<n;i++){
			days[i] =0;
		}
		for(j=0;j<p;j++){
			for(i=0;i<n;i++){
				if((i+1)%h[j] == 0)
				days[i] = 1;
			}
		}

		
		int fri=5,sat=6;
		while(fri<n){
			days[fri] =0;
			fri+=7;
		}
		while(sat<n){
			days[sat]=0;
			sat+=7;
		}

		int count=0;

		for(i=0;i<n;i++){ 
			if(days[i])
				count++;
		}
		
		result[k]=count;
	}
	
	for(i=0;i<t;i++)
	printf("%d\n",result[i]);
	
	return 0;
}
