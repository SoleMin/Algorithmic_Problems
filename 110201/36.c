#include <stdio.h>
#define abs(x) ((x) < 0 ? (-(x)) : (x))

int main() {
	int n;
	
	while(scanf("%d", &n) == 1){
		int input[n];
		int jolly = 1;
		char line[5000];
		
		for(int i=0; i<n; i++){
			scanf("%d", &input[i]);
			if(i != 0){
				input[i-1] = abs(input[i] - input[i-1]);
				if(input[i-1] > 0 && input[i-1] < n){
					for(int j=0; j<i-1; j++){
						if(input[i-1] == input[j]){
							jolly = 0;
							break;
						}
					}
					if(jolly == 0)
						break;
				}
				else{
					jolly = 0;
					break;
				}
			}
		}
		fgets(line, sizeof(line), stdin);
		
		printf(jolly ? "Jolly\n" : "Not jolly\n");
	}
	
	return 0;
}
