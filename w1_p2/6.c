#include <stdio.h>
#include <string.h>
int atoi(char* input)
{
	int x = 0;
	if(*input == '\0')
		return 0;
	
	while(*input)
	{
		if(*input >= 48 && *input <= 57)
			x= x*10 + *input - 48;
		input++;
	}
	return x;
}
int power(int x, int y)
{
	if(y==0)
		return 1;
	return x*power(x,y-1);
}
int main() {
	int x=0 ,pos = 0;
	char input[100] = {0};
	while(scanf("%s",input) != EOF)
	{
		if(input[1] == 'x')
		{
			for(int i = strlen(input)-1; i>=2; i--)
			{
				char tmp = input[i];
					
				if(tmp >= 48 && tmp <= 57) // 0~9
					x=x+(tmp-48) * power(16, pos);
				else if(tmp >= 65 && tmp <= 70) // A-Z
					x=x+(tmp-55) * power(16, pos);
				else if(tmp >=97 && tmp <= 102)// a-z
					x=x+(tmp-87) * power(16, pos);
				
				pos++;
			}					
			printf("%d\n", x);
			x = 0;
			pos = 0;
		}
		else
		{
			x = atoi(input);
			printf("0x%X\n",x);
			x = 0;
		}
	}
	return 0;
}
