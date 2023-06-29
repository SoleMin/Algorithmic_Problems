#include <stdio.h>
int main() {
	char input[100];
	
	while(fgets(input, 100, stdin)!=NULL){
		if(input[0]=='0'){
			int hex=0;
			sscanf(input + 2,"%x",&hex);
			printf("%d\n",hex);
		}
		else{
			int dec=0;
			sscanf(input,"%d",&dec);
			printf("0x%X\n",dec);
		}
	}
	return 0;
}
