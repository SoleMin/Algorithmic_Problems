#include <stdio.h>
int main(void) {
	long num1, num2, temp, i, result, count, max, n1,n2;
	
	while(scanf("%ld %ld",&num1,&num2) == 2){
		max=0;
		n1=num1;
		n2=num2;
		if(num1 > num2){
			temp = num1;
			num1 = num2;
			num2 = temp;
		}

		for(i=num1;i<=num2;i++){
			count=1;
			result = i;
			while(result != 1){
				if(result % 2 == 0){
					result = result /2;
					count++;
				}
				else{
					result = result * 3 +1;
					count++;
				}		
			}
			
			if(max < count){
					max = count;
			}
		}
	
	printf("%ld %ld %ld\n",n1,n2,max);
	}
	
		return 0;
}
