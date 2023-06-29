#include <stdio.h>
int main() {

	int t, n, p, i, j, k, m, tmp, h[100], days[3651], cnt;
	
	scanf("%d",&t);
	
	for(i=0;i<t;i++) {
		
		cnt = 0;
		
		scanf("%d",&n);
		scanf("%d",&p);
		
		for(j=0;j<p;j++) {
			scanf("%d",&(h[j]));
		}
		
		for(j=0;j<=n;j++){
			days[j] = 0; 
		}
		
		for(j=6;j<=n;j+=7){
			days[j] = -1;
			days[j+1] = -1;
		}
		
		for(j=0;j<p;j++){
			for(k = h[j]; k <= n; k += h[j]) {
				if(days[k] == 0){
					days[k] = 1;
					cnt++;
				}
			}
		}

		printf("%d\n",cnt);
		
	} //for (i)
	
	
	return 0;
} //main
