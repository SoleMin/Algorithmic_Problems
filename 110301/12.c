#include <stdio.h>
#include <string.h>
	
int main() {
	char typing[1000];
	

	char *original_type = "1234567890-=QWERTYUIOP[]\ASDFGHJKL;'ZXCVBNM,./";
	int len_original = strlen(original_type);
	
	while(gets(typing)){
		
		int len_input = strlen(typing);

		int i, j;
		for(i=0; i<len_input; i++) {
			for(j=0; j<len_original; j++){
				
				if(typing[i] == original_type[j]){
					typing[i] = original_type[j-1];
					break;
	
				}
				
				else if(typing[i] == ' ')
					break;
			}
		}
		
		printf("%s\n", typing);
	}

	return 0;
}
