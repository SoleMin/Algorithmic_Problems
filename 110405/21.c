#include <stdio.h>
#include <stdlib.h>

int main() {
	int time[1000], fee[1000], index[1000];
	int t, n, i, j, temp, case1, case2;
	scanf("%d", &t);
	while(t--){
		scanf("%d", &n);
		for(i=0; i<n; i++){
			scanf("%d %d", &time[i], &fee[i]);
			index[i] = i;
		}
		for(i=1; i<n; i++){
			for(j=0; j<n-i; j++){
				case1 = time[index[j]]*fee[index[j+1]];
				case2 = time[index[j+1]]*fee[index[j]];
				if(case1>case2){
					temp = index[j];
					index[j] = index[j+1];
					index[j+1] = temp;
				}
			}
		}
		for(i=0; i<n; i++){
			if(i!=0 && i!=n){
				printf(" ");
			}
			printf("%d", index[i]+1);
		}
		if(t>0){
			printf("\n\n");
		}
	}
	return 0;
}