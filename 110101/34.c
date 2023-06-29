/* Idea: be sure to track every input variable you changed */

#include <stdio.h>
#include <stdbool.h>

int main(void) {
	long lower;
	long upper;
	long max;

	while (scanf("%ld %ld", &lower, &upper) == 2) {
		bool flag = false;
		if (lower > upper) {
			lower = lower + upper;
			upper = lower - upper;
			lower = lower - upper;
			flag = true;
		}
		
		max = 0;
		for (long i = lower; i <= upper; i++) {
			long count = 1;
			long num = i;
			
			while (num != 1) {
				if (num % 2 != 0)
					num = num * 3 + 1;
				else
					num /= 2;
				count++;
			}
			
			if (count > max)
				max = count;
		}
		if (flag)
			printf("%ld %ld %ld\n", upper, lower, max);
		else
			printf("%ld %ld %ld\n", lower, upper, max);
	}
	return 0;
}