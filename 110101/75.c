#include <stdio.h>

void main()
{
	
	long lbound, ubound, lb0rg, ub0rg, temp;
	long i, j, len, max_len;
	
	while(scanf("%ld %ld", &lbound, &ubound)==2) {
		lb0rg = lbound;
		ub0rg = ubound;
		
		if(lbound > ubound) {
			temp = lbound;
			lbound = ubound;
			ubound = temp; }
		
		max_len = 0;
		for(i=lbound; i<=ubound; i++) {
			j = i;
			len = 1;
			while(j!=1){
				if(j&1) {
					j= j*3+1;
					len++; 
				}
					
				while(!(j&1)){
					j>>= 1;
					len++; }	
			} 
	
			if (len > max_len)
				max_len = len;
		}
	printf("%ld %ld %ld\n", lb0rg, ub0rg, max_len);
	}
	return 0;
	
}
