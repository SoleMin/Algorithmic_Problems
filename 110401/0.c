#include <stdio.h>
#include <math.h>
int main() {
	int num;
	int num1;
	int i,j;
	int min = 21000000;
	int S[30000];
	int D[30000];
	int sum;
	int temp;
	scanf("%d", &num);
	while(num!=0){
		scanf("%d", &num1);
		for(i=0;i<num1;i++){
			scanf("%d", &S[i]);
		}
		for(i=0;i<num1;i++){
			for(j=0;j<num1;j++){
				if(i == j)
					D[i] += 0;
				else{
					if(S[i] == S[j])
						D[i] += 0;
					else
						D[i] += abs(S[i]-S[j]);
				}
			}
		}
		for(i=0;i<num1;i++){
			for(j=0;j<num1;j++){
				if(D[i]<D[j]){
					temp = D[i];
					D[i] = D[j];
					D[j] = temp;
				}
			}
		}	
		printf("%d\n", D[0]);
		for(i=0;i<30000;i++){
			S[i] =NULL;
			D[i] = NULL;
		}
		num--;
		min = 21000000;
	}
}
