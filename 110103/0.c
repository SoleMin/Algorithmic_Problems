#include <stdio.h>

int main() {
	int num;
	int i,j;
	float student[1000];
	float temp;
	float temp1;
	float avg;
	
	while(1){
		temp1=0;
		temp=0;
		j=0;
		scanf("%d", &num);
		if(num == 0){
			break;
		}
		for(i=0;i<num;i++){
			scanf("%f", &student[i]);
			temp += student[i]*100;
		}
		avg = ceil(temp/num)/100;
		for(i=0;i<num;i++){
			if(avg < student[i]){
				temp1 += avg-student[i];
			}
		}	
		if(temp1<0)
			printf("$%.2f\n", -temp1);
		else
			printf("$%.2f\n", temp1);
	}
			

	return 0;
}
