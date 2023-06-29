#include <stdio.h>
int main() {
	
	long lbound, ubound, temp, lb, ub;
	long i, j, num, max;
	
	while (scanf("%ld %ld", &lbound, &ubound) == 2){
		lb = lbound;
		ub = ubound;
		if (lb > ub){
			temp = lbound;
			lbound = ubound;
			ubound = temp;
		} //크면 바꿔주기
		
		max = 0;
		for(i=lbound; i <= ubound; i++){
			j=i;
			num=1;
			while(j != 1){ // j 1일떄까지
				if (j & 1){ // j 홀수면
					j = j * 3 + 1;
					num++;
				} 
				while(!(j & 1)){
					j >>= 1;
					num++;
				}//while(j!=1)
			}//big while(j!=1)
			if(num > max)
				max = num;
			
		}//for
		
		
		
		printf("%ld %ld %ld\n", lb, ub, max);
	} //while
	
	return 0;
}
