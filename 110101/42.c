#include <stdio.h>
int main() {
	long lbound, ubound, lbOrg, ubOrg, temp;
	long i, j, length, max_length;
	
	while(scanf("%ld %ld", &lbound, &ubound) == 2) { // scanf 반환값은 입력개수
		lbOrg = lbound;
		ubOrg = ubound;
		if(lbound > ubound) { // 교환
			temp = lbound;
			lbound = ubound;
			ubound = temp;
		}
		max_length = 0;
		for(i = lbound; i <= ubound; i++) {
			j = i;
			length = 1;
			while(j != 1) {
				if(j & 1) {
					j = j * 3 + 1;
					length++;
				}
				while(!(j & 1)) {
					j >>= 1;
					length++;
				}
			}
			if(length > max_length)
				max_length = length;
		}
		printf("%ld %ld %ld\n", lbOrg, ubOrg, max_length);
	}
}
