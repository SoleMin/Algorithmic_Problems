#include <stdio.h>
#include <string.h>


int main() {
	char input1[1000];
	char input2[1000];
	char result[1000];
	int count = 0;
	while(gets(input1)) {
		if(input1[0] == 0) break;
		count = 0;
		gets(input2);
		if(input2[0] == 0) break;
		for(int i = 0; i < strlen(input1); i++) {
			for(int j = 0; j < strlen(input2); j++) {
				if(input1[i] != '0' && input2[j] != '0' && input1[i] == input2[j]) {
						result[count++] = input1[i];
						input1[i] = '0';
						input2[j] = '0';
						break;
				}
			}
		}
		result[count] = 0;
		for(int i = 0; i < strlen(result)-1; i++) {
			for(int j = i+1; j < strlen(result); j++) {
				if(result[i] > result[j]) {
					char temp = result[i];
					result[i] = result[j];
					result[j] = temp;
				}
			}
		}
		printf("%s\n", result);
	}
	return 0;
}
