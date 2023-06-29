#include <stdio.h>

#define NUM_CARDS 52
#define MAX_SHUFFLES 100

int main() {
	int mix[MAX_SHUFFLES + 1] [NUM_CARDS + 1];
	int new[NUM_CARDS + 1], tmp[NUM_CARDS + 1];
	char line[100];
	int cases, mixs;
	int witch, i, j, l;
	int value, suit;
	
	scanf("%d",&cases);
	for(i = 0; i<cases; i++){// 정수 i세트
		scanf("%d", &mixs);
		for(j=1; j<=mixs; j++) //	1세트는 52개의 정수로 구성
			for(l=1; l<=NUM_CARDS; l++)
				scanf("%d", &mix[j][l]);
		
		
		for(j=1; j<= NUM_CARDS; j++){ // 새로운 패로 새 게임 시작
			new[j] = j;
		}
		
		gets(line);
		while(gets(line) && *line){ // 무슨방법을 써서 섞는가? (섞기)
			sscanf(line, "%d", &witch);
				for(j = 1; j<=NUM_CARDS; j++)
					tmp[j] = new[j];
				for(j = 1; j<=NUM_CARDS; j++)
					new[j] = tmp[mix[witch][j]];		
		}
		if(i > 0)
			putchar('\n');
		
	// 섞은 결과를 출력하기
		for(j=1; j<=52; j++){
		
			value = (new[j]-1)%13; 
			suit = (new[j]-1)/13;
		
			switch(value){
			case 9: printf("Jack"); break;
			case 10: printf("Queen"); break;
			case 11: printf("King"); break;
			case 12: printf("Ace"); break;
				default: printf("%d", value + 2); break;
			}
			printf(" of ");
			switch(suit) {
			case 0: puts("Clubs"); break;
			case 1: puts("Diamonds"); break;
			case 2: puts("Hearts"); break;
			case 3: puts("Spades"); break;
			}
			
		}
	}
	return 0;
}
