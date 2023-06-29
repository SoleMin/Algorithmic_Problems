#include <stdio.h>
int main() {
	long big, small, up, low, tmp;
	long i, j ,len, max_len;
	
	while(scanf("%ld %ld", &small, &big) == 2){
		low = small;
		up = big;
		if(big < small) {
			tmp = big;
			big = small;
			small = tmp;
		}
		max_len = 0;
		for(i = small; i <= big; i++){
			j = i;
			len = 1;
			while(j != 1){
				if(j % 2 == 1){
					j = j * 3 + 1;
					len++;
				}
				while(j % 2 == 0){
					j = j / 2;
					len++;
				}
			}
			if(len > max_len) max_len = len;
		}
		printf("%ld %ld %ld\n", low, up, max_len);
	}
	return 0;
}
