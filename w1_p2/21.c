#include <stdio.h>
#define SIZE 1024

int main(void) {
	char str[SIZE];
	int a1=0, a2=0;

	while(fgets(str, SIZE, stdin) != NULL) {
		
		if(str[0] == '0') {
			sscanf(str+2,"%x",&a1);
			printf("%d\n",a1);
		}
		else{
			sscanf(str, "%d",&a2);
			printf("0x%X\n",a2);
		}
	}
	return 0;
}