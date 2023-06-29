#include <stdio.h>

int main() 
{
	char input[100];
	
	while (fgets(input, 100, stdin) != NULL)
	{
		if (input[1] == 'x')
		{
			int hexa;
			sscanf(input + 2, "%x", &hexa);
			printf("%d\n", hexa);
		}	
		else
		{
			printf("0x%X\n", atoi(input));
		}
	}
	return 0;
}
