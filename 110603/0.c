#include <stdio.h>
#define INPUT_MAXIMUM 3000
#define WIDTH 10000
#define MAXSIZE 10000 
static unsigned temp[MAXSIZE][INPUT_MAXIMUM];
void checknum(unsigned k)
{
	int check = 0;
	for (int i = INPUT_MAXIMUM-1; i >=0 ; i--)
	{
		if(!(check == 0 && 0 == temp[k][i]))
		{
			if(check == 0)
			{
				printf("%u", temp[k][i]);
				check = 1;
			}
			else
				printf("%04u", temp[k][i]);
		}
	}
	if (check == 0)
		printf("0");
}
void add(unsigned dest, unsigned num)
{
	unsigned carry = 0; unsigned tempValue;
	for (int i = 0; i < INPUT_MAXIMUM; i++)
	{
		tempValue = temp[dest][i] + temp[num][i]+ carry;
		carry = tempValue / WIDTH; temp[dest][i] =
			tempValue % WIDTH;
	}
}
void mul(unsigned result,unsigned dest, unsigned num)
{
	unsigned carry = 0; unsigned tempValue;
	for (int i = 0; i < INPUT_MAXIMUM; i++)
	{
		tempValue = temp[result][i]+temp[dest][i]*num + carry;
		carry = tempValue / WIDTH;
		temp[result][i] = tempValue % WIDTH;
	}
}
void counting(unsigned num)
{ temp[1][0] = 2; temp[2][0] = 5; temp[3][0] = 13;
 for (int i = 4; i <= num; i++)
 { add(i, i - 3);
	add(i, i - 2);
	mul(i, i - 1, 2);
 }
}
int main()
{
	unsigned inputNumb;
	counting(1000);
	while (scanf("%u", &inputNumb) != EOF)
	{
		checknum(inputNumb);
		putchar('\n');
	}
	return 0;
}
