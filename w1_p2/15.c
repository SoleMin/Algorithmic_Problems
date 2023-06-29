#include <stdio.h>
int main(void) {
	char num[1000];
	
	while(fgets(num,sizeof(num),stdin) != NULL){
		if ( num[0] == '0'){
			int hex =0;
			sscanf(num+2,"%x", &hex);
			printf("%d\n",hex);
		}
		else{
			int dec =0;
			sscanf(num, "%d", &dec);
			printf("0x%X\n",dec);
		}
	}
	return 0;
}
