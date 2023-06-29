#include <stdio.h>
#define SIZE 1024
int main() {
	char line[SIZE];
	
	while(fgets(line, SIZE, stdin) !=NULL){
		if(line[0]=='0'){
			int hex =0;
			sscanf(line+2,"%x",&hex);
			printf("%d\n",hex);
		}else{
			int dec=0;
			sscanf(line,"%d",&dec);
			printf("0x%X\n",dec);
		}
	}
	return 0;
}
