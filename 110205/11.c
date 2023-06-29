#include <stdio.h>

#define NUM_CARDS 52
#define MAX_SHUFFLES 100

void main(void) {
	int shuffle[MAX_SHUFFLES+1][NUM_CARDS+1];
	int deck[NUM_CARDS+1],old_deck[NUM_CARDS+1];
	char line[100];
	int num_cases, num_shuffles;
	int t,i,j,k,suit,value;
	
	scanf("%d",&num_cases);  //테스트 케이스의 개수를 입력
	for(t=0;t<num_cases;t++) 
	{
		scanf("%d",&num_shuffles); //섞는 방법의 개수를 입력
		for(i=1;i<=num_shuffles;i++)
		{
			for(j=1;j<=NUM_CARDS;j++)
				scanf("%d",&shuffle[i][j]); // 딜러가 섞은 카드의 순서를 이차원배열에 저장, 딜러가 어떻게섞을지 X 카드의 개수
		}
		for(i=1;i<=NUM_CARDS;i++)
		{
			deck[i]=i; //카드 덱을 초기화
		}
		gets(line); //
		while(gets(line)&&*line)
		{
			sscanf(line,"%d",&k); //k번째 방법을 썼다는 정보를 받기위해 k를 sscanf로 받음
			for(i=1;i<=NUM_CARDS;i++)
				old_deck[i]=deck[i];
			for(i=1;i<=NUM_CARDS;i++)
				deck[i]=old_deck[shuffle[k][i]];//카드섞는것을 배열속 이차원배열을 통해 구현
		}
		if(t>0)
			putchar('\n'); // 빈 줄 출력
		
		for(i=1;i<=52;i++)
		{//각 숫자와 무늬를 숫자로 변환하여 인코드
			value=(deck[i]-1)%13;
			suit=(deck[i]-1)/13;
			switch(value)
			{
				case 9 : printf("Jack");break;
				case 10 : printf("Queen");break;
				case 11 : printf("King");break;
				case 12 : printf("Ace");break;
				default : printf("%d",value+2);break;
			}
			printf(" of ");
			switch(suit)
			{
				case 0 : puts("Clubs");break;
				case 1 : puts("Diamonds");break;
				case 2 : puts("Hearts");break;
				case 3 : puts("Spades");break;
			}
		}
	}
}
