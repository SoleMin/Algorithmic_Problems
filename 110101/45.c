#include <stdio.h>
void main()
{
	long start;
	long finish;
	long output1;
	long output2;
	long n;

	
	long count = 1;
	long maxnum;
	
	while(scanf("%ld %ld", &start, &finish) != EOF){
	maxnum = 0;
	output1 = start;
	output2 = finish;
		if(start > finish){
			int temp = start;
			start = finish;
			finish = temp;
		}
	
	for(int i = start; i < finish + 1; i++){
		n = i;
		count = 1;
		while(n != 1){
			if(n & 1){
				n = n * 3 + 1;
				count++;
			}
			while(!(n & 1)){
				n >>= 1;
				count++;
			}
		}
		if(count > maxnum){
			maxnum = count;
		}

	}
	printf("%ld %ld %ld\n", output1, output2, maxnum);
	}
}
