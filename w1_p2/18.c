#include <stdio.h>
#define BUFSIZE 1024
int main() {
	char line[BUFSIZE];

	while(fgets(line,BUFSIZE,stdin)!=NULL)
	{
		if(line[0] =='0')
		{
			int hex = 0;
			sscanf(line +2, "%x", &hex);
			printf("%d\n", hex);
		}
		else
		{
			int dec = 0;
			sscanf(line, "%d", &dec);
			printf("0x%X\n", dec);
		}
	}
	return 0;
}
