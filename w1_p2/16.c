#include <stdio.h>
int main() {
	char line[1024];
	
	while (fgets(line, 1024, stdin) != NULL){
		
		if(line[0] == '0'){
			int hex = 0;
			sscanf(line + 2, "%x", &hex);
			printf("%d\n", hex);
			
		} else {
			int dec = 0;
			sscanf(line, "%d", &dec);
			printf("0x%X\n", dec);
		}
		
	}
	
	return 0;
}
