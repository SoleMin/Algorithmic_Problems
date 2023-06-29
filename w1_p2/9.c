#include <stdio.h>

#define BUFFSIZE 1024

int main() 
{
	char line[BUFFSIZE];
	
	while(fgets(line,BUFFSIZE,stdin)!=NULL)
	{
		if(line[0] =='0' && line[1]=='x')
		{
			int hex=0;
			sscanf(line+2, "%x",&hex);
			printf("%d\n",hex);
		}
		else
		{
			int dec = 0;
			sscanf(line,"%d", &dec);
			printf("0x%X\n",dec);
		}
	}
	
	
}
