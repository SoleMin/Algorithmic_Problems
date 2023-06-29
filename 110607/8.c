#include <stdio.h>
static long m[2000000];
void main(void) {
	long i,j;
	while(scanf("%ld",&i)!=EOF){
		long sum=0;
		if(i==0){
			return 0;
		}
		if(i==1){
			return 1;
		}
		m[1]=1;
		sum+=m[1];
		for(j=2;j<=i;j++){
			m[j]=1+m[j-m[m[j-1]]];
			sum+=m[j];
			if(sum>=i)
				break;
		}
		printf("%ld\n",j);
	}
}
