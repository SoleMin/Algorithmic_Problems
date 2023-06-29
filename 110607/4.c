#include <stdio.h> 
static int a[1000001];
int main() {
	long long n, sum;
	int i;
	int cnt;
	a[1] = 1;
	while(1){
		scanf("%lld", &n);
		if(n == 0) break;
		for(i = 1;i < 1000000;i++){
			a[i + 1] = 1 + a[i + 1 - a[a[i]]];
		}
		sum = 0;
		for(i = 1;i < 1000000;i++){
			sum += a[i];
			if(sum >= n) break;
		}
		printf("%d\n", i);
	}
	return 0;
}
