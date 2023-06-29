#include <stdio.h>
int main() {
	long i, j, count=1, max_count=0, k, num, a, b, temp;
	for(;scanf("%ld %ld", &a, &b) == 2;){
		i=a, j=b;
		if(i>j){
			temp = i;
			i=j;
			j=temp;
		}
		max_count = 0;
		for(k=i;k<=j;k++){
			count = 1;
			num = k;
			for(;num!=1;){
				if(num%2 == 0){
					num = num/2;
					count++;
				}
				else{
					num = (3*num) + 1;
					count++;
				}
			}
			if(max_count<count){
				max_count = count;
			}
		}
		printf("%ld %ld %ld\n", a, b, max_count);
	}
	return 0;
}
