#include <stdio.h>

void main(void) {
	long a , b, c, d, temp;
	long i, j, leng, max_leng;
	
	while (scanf("%ld %ld", &a , &b ) == 2){
		c = a;
		d = b;
		if(a > b){
			temp = a;
			a = b;
			b = temp;
		}
		max_leng = 0;
		for(i = a; i <= b; i++){
			j = i;
			leng = 1;
			while(j != 1){
				if(j& 1){
					j = j *3 +1;
					leng++;
				}
				while(!(j&1)){
					j >>= 1;
					leng++;
				}
			}
			if(leng > max_leng)
				max_leng = leng;
		}
		printf("%ld %ld %ld\n", c, d, max_leng);
	}
	
}
