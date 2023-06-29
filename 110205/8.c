#include <stdio.h>
int main() 
{
	int T=0;
	int n=0;

	scanf("%d",&T);
	printf("\n");
	
	for(int i=0;i<T;i++)
	{
		if(i>0)
			printf("\n");
		
		int shuffle[101][53]={0,};
		int card[53]={0,};
		int old_card[53]={0,};
		int number=0;
		int pattern=0;
		int k=0;
		char tempt[10];
		
		for(int j=1;j<=52;j++)
		{
			card[j]=j;
		}
		
		scanf("%d",&n);
		for(int j=1;j<=n;j++)
		{
			for(int k=1;k<=52;k++)
			{
				scanf("%d",&(shuffle[j][k]));
			}
		}

		getchar();
		
		while(gets(tempt) && tempt[0] != '\0')
		{
			sscanf(tempt,"%d",&k);
			for(int j=1;j<=52;j++)
			{
				old_card[j]=card[j];
			}
			for(int j=1;j<=52;j++)
			{
				int index = shuffle[k][j];
				card[j]=old_card[index];
			}
		}
		
		for(int j=1;j<=52;j++)
		{
			number = (card[j]) % 13;
			pattern = (card[j]-1) / 13;
			
			if(number==0)
				printf("Ace");
			else if(number==12)
				printf("King");
			else if(number==11)
				printf("Queen");
			else if(number==10)
				printf("Jack");
			else if(number>=1 && number<=9)
				printf("%d",number+1);
			
			printf(" of ");
			
			if(pattern ==0)
				printf("Clubs\n");
			else if(pattern ==1)
				printf("Diamonds\n");
			else if(pattern ==2)
				printf("Hearts\n");
			else if(pattern ==3)
				printf("Spades\n");
				
		}
		
	}
	
	
}
