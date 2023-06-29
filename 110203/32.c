#include <stdio.h>
int main() {
	int t, period, party, shutdown, i, j, k;
	scanf("%d", &t);
	while(t-->0){
		scanf("%d", &period);
		scanf("%d", &party);
		int h[100] = {0,};
		for(i=0; i<party; i++){
			scanf("%d", &h[i]);
		}
		shutdown = 0;
		for(j=1; j<=period; j++){
			if(j%7==6 || j%7==0)
				continue;
			for(k=0; k<party; k++){
				if(j%h[k]==0){
					shutdown++;
					break;
				}
			}
		}
		printf("%d\n", shutdown);
	}
}