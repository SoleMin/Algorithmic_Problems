#include <stdio.h>
int main() {
	long min, max, num, low, up, tmp;
	
	
	while(scanf("%ld %ld", &min, &max)==2){
		long length = 0, count = 0;
		low = min, up = max;
		
		if(max < min){
			tmp = min;
			min = max;
			max = tmp;
		}
		
		for(long i = min; i <= max; i++){
			count = 1;
			num = i;
		
		while(num != 1){
				if(num & 1){
					num = num*3 + 1;
					count++;
				}
				while(!(num & 1)){
					num = num >> 1;
					count++;
				}
			}
			if (length < count)
				length = count;
		}
		printf("%ld %ld %ld\n", low, up, length);
	}
	return 0;
}
