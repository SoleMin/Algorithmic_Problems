#include <stdio.h>
#define SIZE 1024
int main() {
	char l[SIZE];
	while(fgets(l,SIZE,stdin)!=NULL){
		if(l[0]=='0'&& l[1]=='x'){
			int h=0;
			sscanf(l+2,"%x",&h);
			printf("%d\n",h);
			
		}else{
			int di=0;
			sscanf(l,"%d",&di);
			printf("0x%X\n",di);
		}
	}
	
	return 0;
}
