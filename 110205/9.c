#include <stdio.h>
#define CARD_NUM 52
#define BUFSIZE 10
int main() {
	int testNum,n;
	int howShuffle[100][CARD_NUM]={0,};
	char* suit[4] = {"Clubs", "Diamonds", "Hearts", "Spades"};
	char* number[13] = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
	char line[BUFSIZE];
	int deck1[CARD_NUM];
	int deck2[CARD_NUM];
	int i,j,k;
	
	scanf("%d", &testNum);
	while(testNum > 0){
		scanf("%d", &n);
		for(i=1; i<n+1;i++){
			for(j=1; j<CARD_NUM+1; j++){
				scanf("%d",&howShuffle[i][j]);
			}
		}
		for(i=1; i<CARD_NUM+1; i++)
			deck1[i] = i;
		gets(line);
		while(gets(line) && *line != NULL){
			sscanf(line,"%d",&k);
			for(i=1; i<CARD_NUM+1; i++)
				deck2[i] = deck1[i];
			for(i=1; i<CARD_NUM+1; i++)
				deck1[i] = deck2[howShuffle[k][i]];
		}
		printf("\n");
		for(i=1; i<CARD_NUM+1; i++)
			printf("%s of %s\n",number[(deck1[i]-1)%13], suit[(deck1[i]-1)/13]);
		testNum--;
	}
	return 0;
}
