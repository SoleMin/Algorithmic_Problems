#include <stdio.h>
#define NUM_CARD 52
#define MAX_HOW 100

void main(void){
	int shuffle[MAX_HOW+1][NUM_CARD+1];
	int deck[NUM_CARD+1],old_deck[NUM_CARD+1];
	char line[100];
	int numberCase,numberHow;
	int a,i,j,k,value,suit;
	
	scanf("%d",&numberCase);
	for(a=0;a<numberCase;a++){
		scanf("%d",&numberHow);
		for(i=1;i<=numberHow;i++)
			for(j=1;j<=NUM_CARD;j++)
				scanf("%d",&shuffle[i][j]);
		for(i=1;i<=NUM_CARD;i++)
			deck[i]=i;
		
		gets(line);
		while(gets(line)&&*line){
			sscanf(line,"%d",&k);
			for(i=1;i<=NUM_CARD;i++)
				old_deck[i]=deck[i];
			for(i=1;i<=NUM_CARD;i++)
				deck[i]=old_deck[shuffle[k][i]];
		}
		if(a>0)
			putchar('\n');
		
		for(i=1;i<=52;i++){
			value=(deck[i]-1)%13;
			suit=(deck[i]-1)/13;
			switch(value){
				case 9: printf("Jack");
					break;
				case 10: printf("Queen");
					break;
				case 11: printf("King");
					break;
				case 12: printf("Ace");
					break;
				default: printf("%d",value+2);
					break;
					
			}
			printf(" of ");
			switch(suit){
				case 0: puts("Clubs");
					break;
				case 1: puts("Diamonds");
					break;
				case 2: puts("Hearts");
					break;
				case 3: puts("Spades");
					break;
			}
		}
	}
}
