#include <stdio.h>
#include <stdlib.h>
#include <string.h>

static char input_min[101], input_max[101], min[101], max[101], fibo[3][101], temp[101];
static int len_min, len_max, len[3], res;

int compare(int fi, char* num, int l){
	int i;
	if(len[fi]<l){
		return -1;
	}
	if(len[fi]>l){
		return 1;
	}
	for(i=l-1; i>=0; i--){
		if(fibo[fi][i]<num[i]){
			return -1;
		}
		if(fibo[fi][i]>num[i]){
			return 1;
		}
	}
	return 0;
}

void count(int t, int n, int m){
	int l, c;
	l = 0;
	c = 0;
	for(; l<len[n] && l<len[m]; l++){
		fibo[t][l] = (fibo[n][l]+fibo[m][l]+c);
		if(fibo[t][l]>=10){
			c = 1;
		}
		else{
			c = 0;
		}
		fibo[t][l] %= 10;
	}
	if(l<len[n]){
		for(; l<len[n]; l++){
			fibo[t][l] = (fibo[n][l]+c);
			if(fibo[t][l]>=10){
				c = 1;
			}
			else{
				c = 0;
			}
			fibo[t][l] %= 10;
		}
	}
	else{
		for(; l<len[m]; l++){
			fibo[t][l] = (fibo[m][l]+c);
			if(fibo[t][l]>=10){
				c = 1;
			}
			else{
				c = 0;
			}
			fibo[t][l] %= 10;
		}
	}
	if(c){
		fibo[t][l++] = 1;
	}
	len[t] = l;
}

int main() {
	int i;
	while(1){
		scanf("%s%s", input_min, input_max);
		if(!strcmp(input_min, "0") && !strcmp(input_max, "0")){
			break;
		}
		len_min = strlen(input_min);
		len_max = strlen(input_max);
		for(i=0; i<len_min; i++){
			min[i] = input_min[len_min-i-1]-'0';
		}
		for(i=0; i<len_max; i++){
			max[i] = input_max[len_max-i-1]-'0';
		}
		len[0] = len[1] = 1;
		fibo[0][0] = fibo[1][0] = 1;
		
		for(i=1; compare(i%3, min, len_min)<0; i++){
			count((i+1)%3, i%3, (i-1)%3);
		}
		res = i;
		for(; compare(i%3, max, len_max)<=0; i++){
			count((i+1)%3, i%3, (i-1)%3);
		}
		res = i-res;
		printf("%d\n", res);
	}
}
