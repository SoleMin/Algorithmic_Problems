#include <stdio.h>

int main() 
{
	char a[32];
	
	int A = 50;
	int pair = 500;
	int three = 3000;
	int straight = 4000;
	int flush = 5000;
	int fullHouse = 6000;
	int four = 7000;
	int straightFlush = 8000;
	
	while (fgets(a, 32, stdin) != NULL)
	{
		int player[2] = {0};
		int arr[10] = {0};
		int arrIndex = 0;
		for (int i = 0; i < 2; i++)
		{
			int high = 0;
			int num[17] = {0};
			for (int j = 0; j < 5; j++)
			{
				switch (a[15*i + 3*j])
				{
					case 'A': num[0]++; num[13]++; break;
					case '2': num[1]++; num[14]++; break;
					case '3': num[2]++; num[15]++; break;
					case '4': num[3]++; num[16]++; break;
					case '5': num[4]++; break;
					case '6': num[5]++; break;
					case '7': num[6]++;	break;
					case '8': num[7]++; break;
					case '9': num[8]++; break;
					case 'T': num[9]++; break;
					case 'J': num[10]++; break;
					case 'Q': num[11]++; break;
					case 'K': num[12]++; break;
				}
				
			}
			
			for (int j = 0; j < 13; j++)
			{
				if (num[j] == 1)
				{
					arr[arrIndex] = j;
					arrIndex++;
				}
				if (num[j] == 2)
				{
					player[i] += pair;
					if (num[0] == 2)
						high = A;
					else
						high = j;
					
				}
				if (num[j] == 3)
				{
					if(player[i] == pair)
					{
						player[i] = fullHouse;
						if (num[0] == 3)
							high = A;
						else
							high = j;
					}
					else
					{
						player[i] = three;
						if (num[0] == 3)
							high = A;
						else
							high = j;
					}
				}	
				if (num[j] == 4)
				{
					player[i] = four;
					if (num[0] == 4)
						high = A;
					else
						high = j;
				}
			}
			for (int j = 0; j < 13; j++)
			{
				if (num[j] == 1 && num[j+1] == 1 && num[j+2] == 1 && num[j+3] == 1 && num[j+4] == 1)
				{
					player[i] = straight;
					if (num[0] == 1)
						high = A;
					else
						high = j + 4;
				}	
			}
				
			if ((a[15*i+1] + a[15*i+4] + a[15*i+7] * a[15*i+10] + a[15*i+13]) / 5 == a[15*i+1])
			{
				if (player[i] == straight)
				{						
					player[i] = straightFlush;
				}
				else
				{
					player[i] = flush;
					if (num[0] != 0)
						high = A;
					else 
					{
						for (int j = 0; j < 13; j++)
							high = j;
					}
				}
			}
					
			player[i] += high;
		}
		
		if (player[0] + player[1] == 0)
		{
			if (arr[0] == 0 &&  arr[5] != 0)
			{
				player[0] = 1;
			}
			else if (arr[0] != 0 && arr[5] == 0)
			{
				player[1] = 1;
			}
			else
			{
				for (int i = 4; i >= 0; i--)
				{
					if (arr[i] > arr[i+5])
					{
						player[0] = 1;
						break;
					}
					else if (arr[i] < arr[i+5])
					{
						player[1] = 1;
						break;
					}
				}
			}
		}
	
		if (player[1] > player[0])
			printf("White wins.\n");
		else if (player[1] == player[0])
			printf("Tie.\n");
		else
			printf("Black wins.\n");
	}
	return 0;
}