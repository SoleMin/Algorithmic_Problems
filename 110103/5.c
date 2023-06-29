#include <stdio.h>
int main(void) {
	int student;
	int i;
	double money[1000];
	double average, sum, result;
	
	while(1) {
		scanf("%d", &student);
		
		if(student == 0)
			break;
		
		for(i=0; i<student; i++)
			scanf("%lf", &money[i]);
		
		sum=0;
		for(i=0; i<student; i++)
			sum += money[i]*100;
		
		average = ceil(sum/student)/100;
		
		result = 0;
		for(i=0; i<student; i++)
			if(average < money[i])
				result += (money[i] - average);
		
		printf("$%.2lf", result);
		printf("\n");
		
		for(i=0; i<student; i++)
			money[i] = 0;
	}
}
