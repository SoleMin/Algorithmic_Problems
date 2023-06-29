#include <stdio.h>

int main(void)
{
	char line[1024];
	
	while(fgets(line, 1024, stdin)!=NULL)
	{
		if(line[0]=='0') 
		{
			if(line[1]==NULL) //십진수 0에대해서 예외처리
			{
				printf("0x0\n");
				continue;
			}
			int hex = 0;
			sscanf(line+2, "%x", &hex);
			printf("%d\n", hex);
		}
		else
		{
			int dec=0;
			sscanf(line, "%d", &dec);
			printf("0x%X\n", dec);
		}
	}
	return 0;
}