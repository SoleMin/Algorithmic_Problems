#include <stdio.h>
#define CARD_MAX 52
#define SKILL_MAX 100

void printCard(int value, int pattern){
	
	if(value == 0) printf("2");
	else if(value == 1) printf("3");
	else if(value == 2) printf("4");
	else if(value == 3) printf("5");
	else if(value == 4) printf("6");
	else if(value == 5) printf("7");
	else if(value == 6) printf("8");
	else if(value == 7) printf("9");
	else if(value == 8) printf("10");
	else if(value == 9) printf("Jack");
	else if(value == 10) printf("Queen");
	else if(value == 11) printf("King");
	else if(value == 12) printf("Ace");
	
	printf(" of ");
	
	if(pattern == 0) printf("Clubs\n");
	else if(pattern == 1) printf("Diamonds\n");
	else if(pattern == 2) printf("Hearts\n");
	else if(pattern == 3) printf("Spades\n");
}

int main() {
	int before_card[CARD_MAX + 1];
	int after_card[CARD_MAX + 1];
	int shuffle[SKILL_MAX+1][CARD_MAX + 1];
	int n,skill_num, i , j , k, l, tmp, value, pattern;
	char temp;
	
	scanf("%d", &n);
	
	for(i = 0; i < n; i++){
		
		for(j = 1; j <= CARD_MAX; j++){
			after_card[j] = j;
			before_card[j] = j;
		}
		
		scanf("%d", &skill_num);
		for(k = 1; k <= skill_num; k++){
			 for(l = 1; l <= CARD_MAX; l++){
				 scanf("%d", &shuffle[k][l]);
			 }
		}
		
		
		scanf("%c", &temp); 
		scanf("%c", &temp);
		
		while(temp!='\n'){
			tmp = temp - '0';
			for(j = 1; j <= CARD_MAX; j++){
				before_card[j] = after_card[j];
			}
			for(j = 1; j <= CARD_MAX; j++){
				after_card[j] = before_card[shuffle[tmp][j]];
			}
			scanf("%c", &temp);
			scanf("%c", &temp);
		}
		
		if (i > 0) printf("\n");
		for(j = 1; j <= CARD_MAX; j++){
			value = (after_card[j] - 1 ) % 13;  // 나머지로 값을 구함
			pattern = (after_card[j] - 1) / 13; // 몫으로 무늬를 구함
			printCard(value, pattern);
		}
		
	}
	
	return 0;
}
