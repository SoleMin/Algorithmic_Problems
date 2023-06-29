#include <stdio.h>
int main() {
	char c[1024];
	while(fgets(c,1024,stdin)!=NULL){
		if(c[0]=='0'){
			int hex=0;
			sscanf(c+2,"%x",&hex);
			printf("%d\n",hex);
		}else{
			int dec=0;
			sscanf(c,"%d",&dec);
			printf("0x%X\n",dec);
		}
	}
	return 0;
}
