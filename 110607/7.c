#include <stdio.h>

#define SIZE 100000

static  long list[SIZE];

int main() {
	int n, fn, i, count, sum;
	
	while(scanf("%d", &n) != EOF){
		if(n == 0)
			break;
		
		list[1] = 1;
		list[2] = 2;
		count = 3;
		fn = 2;
		sum = 3;
		
		for(i = 3; i < SIZE; i++){
			list[i] = fn;
			sum += fn;
			
			if(sum >= n)
				break;
			
			if(i == count){
				fn++;
				count += list[fn];
			}
		}
		
		if(n == 1)
			i = 1;
		else if(n <= 3)
			i = 2;
		
		printf("%d\n", i);
	}
	return 0;
}
