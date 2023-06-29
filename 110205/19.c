#include <stdio.h>
#define MAX_MIX 100
#define CARD 52
#define get_value(x) ((x) % 13)
#define get_suit(x) ((x) / 13)

void main(void)
{
	int mix[MAX_MIX + 1][CARD + 1], deck[CARD + 1], temp_deck[CARD + 1];
	int case_number;
	char str[MAX_MIX];
	int test_case, n;
	int i, j, k, suit, value;
	
	/* 케이스 수 입력 */
	scanf("%d", &test_case);
	for (i = 1; i <= test_case; i++)
	{
		/* 섞는 방법 수(100이하의 정수 n) 입력 */
		scanf("%d", &n);
		for (j = 1; j <= n; j++)
		{
			/* 섞는 방법을 n행의 세트로 된 52개의 정수가 든 배열로 만든다. */
			for (k = 1; k <= CARD; k++)
			{
				scanf("%d", &mix[j][k]);
			}
		}
		
		/* 52개의 수가 오름차순으로 정렬된 패를 만든다. */
		for (j = 1; j <= CARD; j++)
		{
			deck[j] = j;
		}
		
		/* 카드섞기 */
		gets(str);
		while (gets(str) && *str)
		{
			/* 입력받은 문자열 str을 정수형 k로 변환한다. */
			sscanf(str, "%d", &k);
			/* 섞은덱을 중개할 temp_deck */
			for (j = 1; j <= CARD; j++)
			{
				temp_deck[j] = deck[j];
			}
			/* 딜러의 k번째 섞기 방법의 카드를 섞어넣는다. */
			for (j = 1; j <= CARD; j++)
			{
				deck[j] = temp_deck[mix[k][j]];
			}
		}
			
		if (i > 1)
		{
			printf("\n");
		}
		
		for (j = 1; j <= CARD; j++)
		{
			value = get_value(deck[j] - 1);	// 0~12의 값
			suit = get_suit(deck[j] - 1);		// 0~3의 값
			if (value == 9)
			{
				printf("Jack");
			}
			else if (value == 10)
			{
				printf("Queen");
			}
			else if (value == 11)
			{
				printf("King");
			}
			else if (value == 12)
			{
				printf("Ace");
			}
			else
			{
				printf("%d", value + 2);
			}
			
			printf(" of ");
			
			if (suit == 0)
			{
				printf("Clubs\n");
			}
			else if (suit == 1)
			{
				printf("Diamonds\n");
			}
			else if (suit == 2)
			{
				printf("Hearts\n");
			}
			else if (suit == 3)
			{
				printf("Spades\n");
			}
		}
	}
}
