#include <stdio.h>
#include <stdlib.h>
int main() 
{
	int T, k, n, i, j, l, m, tmp, ima, num;
	int arr[100][53];
	int result[53], pre[53];
	char str[10];
	
	scanf("%d", &T);
	
	for(i=0; i<T; i++)
	{
		
		scanf("%d", &n);
		
		for(j=1; j<=n; j++)
		{
			for(l=1; l<=52; l++)
				scanf("%d", &arr[j][l]);
		}
		
		for(j=1; j<=52; j++)
			result[j]=j;
		fgets(str, 10, stdin);
		while(fgets(str,10,stdin))
		{
			if(str[0]=='\n') break;
			k=atoi(str);
			for(j=1; j<=52; j++)
				pre[j]=result[arr[k][j]];
			for(j=1; j<=52; j++)
				result[j]=pre[j];
		}
		
		for(j=1; j<=52; j++)
		{
			ima = (result[j]-1)/13;
			num = (result[j]-1)%13;
			switch(num){
				case 0: printf("2 of ");break;
				case 1: printf("3 of ");break;
				case 2: printf("4 of ");break;
				case 3: printf("5 of "); break;
				case 4: printf("6 of "); break;
				case 5: printf("7 of "); break;
				case 6: printf("8 of "); break;
				case 7: printf("9 of "); break;
				case 8: printf("10 of "); break;
				case 9: printf("Jack of "); break;
				case 10: printf("Queen of "); break;
				case 11: printf("King of ");break;
				case 12: printf("Ace of ");break;
			}
			switch(ima){
				case 0: printf("Clubs\n"); break;
				case 1: printf("Diamonds\n"); break;
				case 2: printf("Hearts\n"); break;
				case 3: printf("Spades\n"); break;
			}
			
		}
		printf("\n");
	}
	return 0;
}
