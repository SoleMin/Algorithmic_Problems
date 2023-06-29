#include <stdio.h>
#include <stdlib.h>
#include <string.h>
void shuffle(int how[][52], int choice_N[] , int count)
{
	int card_print[52] , during[52]; //출력을할 카드패를 저장 , 중간과정 카드패를 저장
	
	for(int i=0; i<52; i++) 
	{
		during[i]=i+1;
		card_print[i] = during[i];
	}
	
	for(int i=0; i<count; i++) //count == 셔플횟수만큼 반복
	{
		for(int j=0; j<52; j++)   card_print[j] = during[how[choice_N[i]-1][j]]; //셔플규칙에따라 셔플
		for(int j=0; j<52; j++)   during[j] = card_print[j]; // 셔플의 중간상태를 저장
	}
	PRINT_CARD(card_print);
}
void PRINT_CARD(int card[])
{
	for(int i=0; i<52; i++)
	{
		int number = card[i]%13 +1;
		if(card[i] <= 13)
		{
			if(number == 1) printf("Ace of Clubs\n");
			else if(number == 13) printf("King of Clubs\n");
			else if(number == 11) printf("Jack of Clubs\n");
			else if(number == 12) printf("Queen of Clubs\n");
			else printf("%d of Clubs\n" , number);
		}
		else if(card[i] <=26)
		{
			if(number == 1) printf("Ace of Diamonds\n");
			else if(number == 13) printf("King of Diamonds\n");
			else if(number == 11) printf("Jack of Diamonds\n");
			else if(number == 12) printf("Queen of Diamonds\n");
			else printf("%d of Diamonds\n" ,number);
		}
		else if(card[i] <=39)
		{
			if(number == 1) printf("Ace of Hearts\n");
			else if(number == 13) printf("King of Hearts\n");
			else if(number == 11) printf("Jack of Hearts\n");
			else if(number == 12) printf("Queen of Hearts\n");
		  else	printf("%d of Hearts\n" , number);
		}
		else if(card[i] <=52)
		{
			if(number == 1)printf("Ace of Spades\n");
			else if(number == 13)printf("King of Spades\n");
			else if(number == 11)printf("Jack of Spades\n");
			else if(number == 12)printf("Queen of Spades\n");
			else printf("%d of Spades\n" , number);
		}
	}
}


int main(void)
{
	int cases , many , number , count , choice_N[100] , how[100][52];
	char buffer[4];
	
	scanf("%d" , &cases); //케이스의수
	for(int i=0; i<cases; i++) //케이스의수만큼 반복
	{
		count = 0;
		char choice[4]={-1,-1,-1,-1};
		scanf("%d" , &many); //한케이스에 대해서 몇가지 섞는방법이 존재하는가
		for(int j=0; j<many; j++) //섞는 방법개수만큼 반복
		{
			for(int k=0; k<52; k++)
			{
				scanf("%d" , &number);  //섞는 방법에 대해서 카드입력
				how[j][k] = number-1;
			}
		}	
		gets(buffer);

		while(scanf("%[^\n]s" , choice) == 1) //셔플방법을 입력받음 
		{
			getchar();
			choice_N[count++] = atoi(choice);
		}
	  shuffle(how , choice_N , count);
		printf("\n");
	}
}