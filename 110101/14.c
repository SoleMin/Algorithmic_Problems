#include <stdio.h>
int main() {
	long lb,ub,lbo,ubo,temp;
	long i,j,len,length;
	while(scanf("%ld %ld",&lb,&ub)==2){
		lbo=lb;
		ubo=ub;
		if(lb>ub)
		{
			temp=lb;
			lb=ub;
			ub=temp;
		}
		length=0;
		for(i=lb;i<=ub;i++){
			j=i;
			len=1;
			while(j!=1){
				if(j&1){
					j=j*3+1;
					len++;
					
				}
				while(!(j&1)){
					j>>=1;
					len++;
					
				}
			}
			if(len>length)
				length=len;
		}
		printf("%ld %ld %ld\n",lbo,ubo,length);
					 }
	return 0;
}
