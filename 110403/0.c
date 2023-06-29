#include <stdio.h>

int main() {
	int num;
	int num1;
	int i,j;
	int people[1000];
	char line;
	int result;
	int temp;
	
	scanf("%d", &num);
	scanf("%c", &line);
	while(num != 0){
		scanf("%d", &num1);
		
		for(i=0;i<num1;i++){
			scanf("%d", &people[i]);
		}
		for(i=0;i<num1;i++){
			for(j=0;j<num1;j++){
				if(people[i]<people[j]){
					temp = people[i];
					people[i] = people[j];
					people[j] = temp;
				}
			}
		}
		result = 0;
		while(num1>3){
			if(people[1]*2>people[0]+people[num1-2]){
				result += people[0] + people[num1-2] + people[num1-1]+people[0];
			}
			else{
				result += people[0]+people[1]+people[num1-1]+people[1];
			}
			num1 -= 2;
		}
		if(num1 == 3){
			result += people[0]+people[1]+people[2];
		}
		else if(num1 == 2){
			result += people[1];
		}
		else if(num1 ==1){
			result += people[0];
		}
		printf("%d\n", result);
		printf("\n");
		num--;
	}
}
