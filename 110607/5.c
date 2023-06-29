#include <stdio.h>
#define MAX_NUM 700000

static int list[MAX_NUM];

int main(void) {
	int n;
	int total, start, i, end;
	
	while(1) {
		scanf("%d", &n);
		if(n == 0)
			break;
		list[1] = 1;
		list[2] = 2;
		start = 2;
		total = 3;
		end = 3;
		for(i = 3; i < MAX_NUM; i++) {
			list[i] = start;
			total += start;
			if(total >= n)
				break;
			if(i == end) {
				start++;
				end += list[start];
			}
		}
		if(n == 1)
			i = list[1];
		else if(n <= 3)
			i = list[2];
		
		printf("%d\n", i);
	}
}