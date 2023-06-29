#include <stdio.h>
int main() {
	
	long org1, org2, i, j, a, b;
	long count, maxCount;
	
	while(scanf("%ld %ld", &org1, &org2) != EOF){
		maxCount=0;
		a = org1, b = org2;
		if(org1 > org2){
			long temp = org1;
			a = org2;
			b = temp;
		}
		
		for(i = a; i <=b; i++) {
			count = 1;
			j = i;
			while( j != 1){
				if (j % 2 == 0) {
					j = j / 2;
					count++;
				}
				else {
					j = 3 * j + 1;
					count++;
				}
			}
			if(count > maxCount)
				maxCount = count;
		}
		printf("%ld %ld %ld\n", org1, org2, maxCount);
	}
	return 0;
}
