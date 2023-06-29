#include <stdio.h>
int main() {
	long a, b, aOrg, bOrg;
	long i, j, length, max_length;
	
	while (scanf("%ld %ld", &aOrg, &bOrg) == 2) {
		if(aOrg>bOrg) {a=bOrg; b=aOrg;}
		else {a=aOrg; b=bOrg;}
		
		max_length = 0;
		for(i=a; i<=b; i++){
			j=i;
			length=1;
			while(j != 1) {
				if(j & 1) {
					j = j*3 + 1;
					length++;
				}
				while (!(j & 1)) {
					j >>= 1;
					length++;
				}
			}
			if(length > max_length)
				max_length = length;
		}
		printf("%ld %ld %ld\n", aOrg, bOrg, max_length);
	}
}
