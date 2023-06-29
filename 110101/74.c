#include <stdio.h>
int main() {
	long n,m,n0,m0,temp;
	long i,j,length,max_len;
	
	while(scanf("%ld %ld", &n, &m)==2){
			n0=n;
			m0=m;
		if(n>m){
			temp=n;
			n=m;
			m=temp;
		}
		max_len=0;
		for(i=n;i<=m;i++){
			j=i;
			length=1;
			while(j!=1){
				if(j&1){
					j=j*3+1;
					length++;
				}
				while(!(j&1)){
					j>>=1;
					length++;
				}
			}
		if(length>max_len)
			max_len=length;

	}printf("%ld %ld %ld\n",n0,m0,max_len);
}
}