#include <stdio.h>
int main(void){
	char bnum[1024];
	
	while(fgets(bnum, 1024, stdin) != NULL){
		if(bnum[0] == '0'){
			int bnum1 = 0;
			sscanf(bnum + 2, "%x", &bnum1);
			printf("%d\n", bnum1);
		}
		else {
			int bnum2 = 0;
			sscanf(bnum, "%d", &bnum2);
			printf("0x%X\n", bnum2);
		}
	}
	
	return 0;
}
