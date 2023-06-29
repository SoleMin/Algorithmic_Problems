#include <stdio.h>
#include <math.h>

int main() {
	int student, num1;
	int i;
	double money[10], average, sum, result, temp;
	
	while(scanf("%d", &student) ==1){
		num1 =student;
		temp = result = average = sum =0;
		if(num1 == 0)break;
		temp = result= sum = average =0.0;
		for(i =0; i< num1; i++){
			scanf("%lf" ,&money[i]);
			 sum = sum + money[i];
		}
		average = sum/num1;
		for(i =0; i <num1; i++){
			if(average > money[i]){
				temp = average- money[i];
				result = temp+ result;
			}
		}
		result = floor(result *100 )/ 100;
		printf("$%.2f\n",result);
	}
}
