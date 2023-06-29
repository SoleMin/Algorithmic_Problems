#include <stdio.h>
#include <malloc.h>
#include <string.h>

int main() {
	int num1, num2, n1, n2, i, j, field=1;
	int x,y, count =0;
	char input[10][10];

	while(scanf("%d %d", &num1, &num2) == 2){
		n1 = num1;
		n2 = num2;
		if(num1 == 0 || num2 == 0)
			break;
		// 지뢰판 입력
		for(i=0; i <n1; i++){
			scanf("%s",input[i]);
		}
		//출력
		printf("Field #%d:\n",field++);
		for(i = 0; i <n1; i++){
			for(j =0; j <n2; j++){
					if(input[i][j] == '*') continue; 
				
					else if(input[i][j] == '.'){
						count =0;
						for(y = i-1; y<= i+1; y++){
							for(x =j-1; x<= j+1; x++){
							 if(x <0 || y<0 || y>= n1 || x>= n2) continue;
								else if(input[y][x] == '*') count++;
							}
						}
						input[i][j] =count +48;
					}
				
			}
			printf("%s\n", input[i]);
		}
		printf("\n");
	}
	return 0;
}
