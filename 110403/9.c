#include <stdio.h>
#include <stdlib.h>
#define cmp(x, y) ((x)>(y) ? 1 : ((x)<(y) ? -1 : 0))

int compare(int x, int y){
	return cmp(x, y);
}

int main() {
	int t, n, i, j, temp;
	int a, b, c, d, total;
	int time[1000];
	scanf("%d\n", &t);
	for(; t>0; t--){
		scanf("%d", &n);
		for(i=0; i<n; i++){
			scanf("%d", &time[i]);
		}
		
		for(i=1; i<n; i++){
			for(j=0; j<n-i; j++){
				if(time[j]>time[j+1]){
					temp = time[j];
					time[j] = time[j+1];
					time[j+1] = temp;
				}
			}
		}
		
		total = 0;
		if(n==1){
			total += time[0];
		}
		else if(n==2){
			total += time[1];
		}
		else if(n==3){
			total += time[0]+time[1]+time[2];
		}
		else if(n>3){
			for(; n>3; n-=2){
				a = time[0];
				b = time[1];
				c = time[n-2];
				d = time[n-1];
				if((a+d+b*2)<(2*a+c+d)){
					total += b+a+d+b;
				}
				else{
					total += c+a+d+a;
				}
			}
			if(n==3){
				total += time[0]+time[1]+time[2];
			}
			else{
				total += time[1];
			}
		}
		
		printf("%d\n", total);
		if(t>0){
			printf("\n");
		}
	}
	return 0;
}