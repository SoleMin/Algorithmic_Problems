#include <stdio.h>
#include <stdlib.h>
#define cmp(x, y) ((x)>(y) ? 1 : ((x)<(y) ? -1 : 0))

int compare(int x, int y){
	return cmp(x, y);
};

int main() {
	int v_fam[500];
	int t, n, i, v_home, temp, sum;
	scanf("%d", &t);
	while(t--){
		scanf("%d", &n);
		for(i=0; i<n; i++){
			scanf("%d", &v_fam[i]);
		}
		
		qsort(v_fam, sizeof(v_fam)/sizeof(int), sizeof(int), compare);
		
		v_home = v_fam[n/2];
		sum = 0;
		for(i=0; i<n; i++){
			if(v_fam[i]==v_home){
				continue;
			}
			if(v_fam[i]<v_home){
				sum += v_home-v_fam[i];
			}
			else{
				sum += v_fam[i]-v_home;
			}
		}
		printf("%d\n", sum);
	}
	return 0;
}
