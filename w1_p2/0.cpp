#include <cstdio>
#include <cstdlib>

int main() {
	char str[255];
	while(fgets(str,255,stdin) != NULL){
		if(str[0] == '0' && str[1] == 'x') {printf("%ld\n",strtol(str,NULL,16));}
		else {printf("0x%X\n",strtol(str,NULL,10));}
	}
}