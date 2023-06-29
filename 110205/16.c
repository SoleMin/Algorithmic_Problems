#include <stdio.h>
int main() {
	int mix[101][52][2] = {0, }, swaparr[101], deck[53];
	int testcase, mixcase, swap, buf1, min1, value, inputT, inputMix, tmp, suit, value2;
	char buf2[5];
	
	scanf("%d", &testcase);
	while (testcase != 0)
	{
		scanf("%d", &mixcase);
		for (int m = 1; m <= mixcase; m++)
		{
			swap = 0;
			for (int i = 1; i <= 52; i++)
			{
				scanf("%d", &buf1);
				if (i != buf1)
				{
					inputT = 1;
					min1 = (i > buf1)? buf1 : i;
					value = (i > buf1)? i: buf1;
					for (int j = 0; j < swap; j++)
						if (mix[m][j][0] == min1)
						{
							inputT = 0; break;
						}
					if (inputT != 0)
					{
						mix[m][swap][0] = min1;
						mix[m][swap++][1] = value;
					}
				}
				deck[i] = i;
			}
			swaparr[m] = swap;
		}
		
			fgets(buf2, sizeof(buf2), stdin);
			while (fgets(buf2, sizeof(buf2), stdin))
			{
				if (sscanf(buf2, "%d", &inputMix) == -1)
					break;
				for (int i = 0; i < swaparr[inputMix]; i++)
				{
					tmp = deck[mix[inputMix][i][0]];
					deck[mix[inputMix][i][0]] = deck[mix[inputMix][i][1]];
					deck[mix[inputMix][i][1]] = tmp;
				}
			}
			
			for (int i = 1; i <= 52; i++)
			{
				suit = (deck[i]-1)/13;
				value2 = (deck[i]-1)%13;
				switch (value2) 
				{
					case 9: printf("Jack of "); break;
					case 10: printf("Queen of "); break;
					case 11: printf("King of "); break;
					case 12: printf("Ace of "); break;
					default: printf("%d of ", value2 + 2); break;
				}
				switch (suit)
				{
					case 0: printf("Clubs\n"); break;
					case 1: printf("Diamonds\n"); break;
					case 2: printf("Hearts\n"); break;
					case 3: printf("Spades\n"); break;
				}
			}
		testcase--;
		printf("\n");
	}
	return 0;
}
