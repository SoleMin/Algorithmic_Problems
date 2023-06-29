#include <stdio.h>
int main() {
	char alpha_ch[26];
	int alpha_in1[26];
	int alpha_in2[26];
	char buffer1[1001];
	char buffer2[1001];
	int i, j, min=0;
	for(i=0;i<26;i++){
		alpha_ch[i] = 97+i;
		alpha_in1[i] = 0;
		alpha_in2[i] = 0;
	}
	
	for(;scanf("%s", buffer1) == 1;){
		scanf("%s", buffer2);
		for(i=0;buffer1[i] != '\0';i++){
			for(j=0;j<26;j++){
				if(buffer1[i] == alpha_ch[j]){
						alpha_in1[j]++;
					}
			}
		}
		for(i=0;buffer2[i] != '\0';i++){
			for(j=0;j<26;j++){
				if(buffer2[i] == alpha_ch[j]){
						alpha_in2[j]++;
					}
			}
		}
		for(i=0;i<26;i++){
			if(alpha_in1[i]>0 && alpha_in2[i]>0){
				if(alpha_in1[i] < alpha_in2[i])
					min = alpha_in1[i];
				else
					min = alpha_in2[i];
				for(j=0;j<min;j++){
					printf("%c", alpha_ch[i]);
				}
			}
		}
		printf("\n");
		
		for(i=0;i<26;i++){
			alpha_in1[i] = 0;
			alpha_in2[i] = 0;
		}
			min = 0;
	}
	
	return 0;
}
