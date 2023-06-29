#include <stdio.h>
#define MAXIMUM 700000
static unsigned long value[MAXIMUM];
int main()
{
	unsigned input;
	unsigned total,start,i,index;
	while (scanf("%d",&input),input !=0)
	{
		value[1] = 1;
		value[2] = start = 2;
		total = index =3;
		for (i = 3; i < MAXIMUM; i++)
		{
			value[i] = start;
			total += start;
			if (total >= input)
				break;
		if (i == index)
		{
			start++;
			index += value[start];
		}
	 }
	 if (1 == input)
		 i = value[1];
	 else if(3 >= input)
		 i = value[2];
	 printf("%u\n", i);
	}
	return 0;
}