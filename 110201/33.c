#include <stdio.h>
#include <stdbool.h>

int main() {
 
	int num1; // 입력할 정수의 갯수
	int array[100], n1, i, temp, count[100]={};
	bool result;
	char line[5000];
	
	while(scanf("%d",&num1) == 1){
		n1 =num1;
		result = true;
		for(i = 0; i < n1; i++)
			count[i] =0;
		for(i = 0; i <n1; i ++){
			scanf("%d", &array[i]);
			if(n1 == 1)
				break;
			if(i == 0) continue;
			else{
				temp = array[i] - array[i-1];
				if(temp < 0)
					temp = -temp;
				
				if(temp > (n1-1)){
					result = false;
					break;
				}
				else{
					count[temp]++;
				}
			}
		}//for
		for(i = 1; i<= n1-1; i++)
			if(count[i] !=1) result = false;
		
		gets(line); //한줄을 다 읽지 못햇을 경우도 있으므로
		
		if(result == true)
			printf("Jolly\n");
		else
			printf("Not jolly\n");
		
	}//while
}
