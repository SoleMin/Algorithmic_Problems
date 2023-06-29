#include <stdio.h>

int main() {
	long lbound, ubound, lbOrg, ubOrg;
	long i, j, length, max_length;
	
	while(scanf("%ld %ld", &lbOrg, &ubOrg) == 2) {
		if(lbOrg > ubOrg){
			lbound = ubOrg;
			ubound = lbOrg;
		} else {
			lbound = lbOrg;
			ubound = ubOrg;
		}
		
		max_length = 0;
		for(i = lbound; i <= ubound; i++) {
			j = i;
			length = 1;
			while(j != 1){
				if(j % 2 == 1){
					j = j * 3 + 1;
					length++;
				}
				while(j % 2 != 1){
					j = j / 2;
					length++;
				}
			}
			if(length > max_length)
				max_length = length;
		}
		printf("%ld %ld %ld\n", lbOrg, ubOrg, max_length);
	}
	return 0;
}
