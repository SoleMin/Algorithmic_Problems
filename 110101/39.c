#include <stdio.h>

int main(void) {
	
	long lbound, ubound, lbOrg, ubOrg, temp;
	long i, j, length, maxLength;
	
	while (scanf("%ld %ld", &lbound, &ubound) == 2) {
		lbOrg = lbound;
		ubOrg = ubound;
		
		if (lbound > ubound) {
			temp = lbound;
			lbound = ubound;
			ubound = temp;
		}
		
		maxLength = 0;
		for (i = lbound; i <= ubound; i++) {
			j = i;
			length = 1;
			
			while (j != 1) {
				if (j & 1) {
					j = j * 3 + 1;
					length++;
				}
				while (!(j & 1)) {
					j >>= 1;
					length++;
				}
			}
			
			if (length > maxLength) 
				maxLength = length;
	}
		
		printf("%ld %ld %ld\n", lbOrg, ubOrg, maxLength);
	
}
}
