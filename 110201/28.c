#include <stdio.h>
#define abs(x) ((x) < 0 ? (-(x)) : (x))

void main(void){
	int jumper[3000];
	char line[3000];
	int jolly;
	int back;
	int front;
	int sub;
	int n;
	
	
	while(scanf("%d", &n) != EOF){
		jolly = 1;
		for(int i = 0; i < n; i++){
			jumper[i] = 0;
		}
		
		scanf("%d", &back);
		for(int j = 0; j < n - 1; j++){
			scanf("%d", &front);
			sub = abs(front - back);
			if(sub <= 0 || sub >= n || jumper[sub]){
				jolly = 0;
				break;
			}
			jumper[sub] = 1;
			back = front;
		}
		
		gets(line);
		puts(jolly ? "Jolly" : "Not jolly");
	}
}