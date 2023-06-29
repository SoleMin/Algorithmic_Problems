#include <stdio.h>
#include <stdlib.h>
#define MAX_METHOD 100
#define MAX_BUF 2048

typedef struct _card {
	int num;
	int order;
} card;

void change_card(int m_num, int method[MAX_METHOD][52], card array[52]);
void restore_order(card array[52]);
void print_array(card array[52]);

int main(void) {
	char line[MAX_BUF];
	int i, j;
	int cas;
	int method[MAX_METHOD][52]; // [i][52] i번째 방법으로 섞은 카드 52 저장 배열
	int m_num;
	card array[52]; // 카드 배열
	int in;
	
	fgets(line, MAX_BUF, stdin);   // case 입력 구문
	cas = atoi(line);
	fgets(line, MAX_BUF, stdin);   // 빈 줄 입력 구문
	while(cas--) {
		for(i = 0; i < 52; i++) { // 카드 배열 초기화 (원래 순서대로)
			array[i].num = i + 1;
			array[i].order = i + 1;
		}
		
		fgets(line, MAX_BUF, stdin); // 딜러가 알고 있는 방법 갯수
		m_num = atoi(line);
		
		for(i = 0; i < m_num; i++) { // 방업의 카드 배열
			for(j = 0; j < 52; j++) {
				scanf("%d", &in);
				method[i][j] = in;
			}
			fgets(line, MAX_BUF, stdin); // 줄 넘기기
		}
		
		while(fgets(line, MAX_BUF, stdin) != NULL) {
			if(line[0] == '\n')
				break;
			in = atoi(line) - 1; 
			change_card(in, method, array);
			restore_order(array);
		}
		print_array(array);
		printf("\n");
	}
	
	return 0;
}

void change_card(int m_num, int method[MAX_METHOD][52], card array[52]) { // 카드 섞는 함수
	int i, j;
	int tmp;
	for(j = 0; j < 52; j++) {
		for(i = 0; i < 52; i++) {
			if(method[m_num][i] != array[i].order) {
				tmp = array[i].order;
				array[i].order = array[method[m_num][i] - 1].order;
				array[method[m_num][i] - 1].order = tmp;
				tmp = array[i].num;
				array[i].num = array[method[m_num][i] - 1].num;
				array[method[m_num][i] - 1].num = tmp;
			}
		}
	}
}

void restore_order(card array[52]) { // 순서 랭킹 갱신 함수
	int i;
	for(i = 0; i < 52; i++)
		array[i].order = i + 1;
}

void print_array(card array[52]) { // 출력 함수
	int i;
	int value;
	for(i = 0; i < 52; i++) {
		value = array[i].num;
		switch (value % 13) {
			case 10: printf("Jack ");  break;
			case 11: printf("Queen "); break;
			case 12: printf("King ");  break;
			case 0 : printf("Ace ");   break;
			default: printf("%d ", value % 13 + 1);
		}
		printf("of ");
		switch ( (value - 1) / 13 ) {
			case 0: printf("Clubs\n");    break;
			case 1: printf("Diamonds\n"); break;
			case 2: printf("Hearts\n");   break;
			case 3: printf("Spades\n");   break;
		}
	}
}