#include <stdio.h>
#define MAX 1000000

static long f[MAX];
static int i, n, cnt, fn, sum;

void print(){
	for(i=1; i<3; i++){
		f[i] = i;
	}
	cnt = 3;
	fn = 2;
	sum = 3;
	for(i=3; i<MAX; i++){
		f[i] = fn;
		sum += fn;
		if(sum>=n){
			break;
		}
		if(i==cnt){
			fn++;
			cnt += f[fn];
		}
	}
	if(n==1){
		i = 1;
	}
	else if(n<=3){
		i = 2;
	}
	printf("%d\n", i);
}

int main() {
	while(scanf("%d", &n), n!=0){
		print();
	}
}
