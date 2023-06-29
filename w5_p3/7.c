#include <stdio.h>
#include <stdlib.h>
#include <string.h>

unsigned char text[1000001] = {'\0'}, pattern[1000001] = {'\0'};
unsigned int fix[1000001] = {0}, index_arr[1000001] = {0};
unsigned int i, j, count;

int main() {
	fgets(text, sizeof(text), stdin);
	text[strlen(text)-1] = '\0';
	fgets(pattern, sizeof(pattern), stdin);
	pattern[strlen(pattern)-1] = '\0';
	
	int t_len = strlen(text), p_len = strlen(pattern);
	
	j=0;
	for(i=1; i<p_len; i++){
		while(j>0 && pattern[i]!=pattern[j]){
			j = fix[j-1];
		}
		if(pattern[i]==pattern[j]){
			fix[i] = ++j;
		}
	}
	
	j = count = 0;
	for(i=0; i<t_len; i++){
		while(j>0 && text[i]!=pattern[j]){
			j = fix[j-1];
		}
		if(text[i]==pattern[j]){
			if(j==p_len-1){
				index_arr[count++] = i-j+1;
				j = fix[j];
			}
			else{
				j++;
			}
		}
	}
	
	printf("%d\n", count);
	for(i=0; i<count; i++){
		if(i!=0){
			printf(" ");
		}
		printf("%d", index_arr[i]);
	}
	return 0;
}
