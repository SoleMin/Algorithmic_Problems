#include <stdio.h>
#include <string.h>
int main() {
	char T[1000001];
	char P[1000001];
	int Pi[1000001];
	int result[100001];
	int result1=0;
	int i,j;
	int temp;
	int lenp;
	int lent;
	
	for(i=0;i<1000001;i++){
		scanf("%c", &T[i]);
		if(T[i] == '\n'){
			T[i] = '\0';
			 break;
		}
	}
	for(i=0;i<1000001;i++){
		scanf("%c", &P[i]);
		if(P[i] == '\n'){
			P[i] = '\0';
			break;
		}
	}
	lent = strlen(T);
	lenp = strlen(P);
	j=0;
	for(i=1;i<lenp;i++){
		while(j>0 && P[i] != P[j]){
			j = Pi[j-1];
		}
		if(P[i] == P[j]){
			Pi[i] = ++j;
		}
	}
	j=0;
	temp = 0;
	for(i=0;i<lent;i++){
		while(j>0 && T[i] != P[j]){
			j=Pi[j-1];
		}
		if(T[i] == P[j]){
			if(j==lenp-1){
				result1++;
				result[temp] = i-lenp+2;
				j = Pi[j];
				temp++;
			}
			else
				j++;
		}
	}
	
	printf("%d\n", result1);
	for(i=0;i<temp;i++){
			printf("%d ", result[i]);
	}
}