#include <stdio.h>
#include <string.h>
#define MAX_DIGIT 500
#define MAX_NUM 1000

static char a[MAX_DIGIT + 1];
static char gustavo[MAX_NUM][MAX_DIGIT + 1];
static int  length[MAX_NUM];


void make_gustavo(int n);
void plus(int t, int a, int b, int c);

int main(void) {
	int i, j;
	int n;
	for(i = 0; i < MAX_NUM; i++) 
		memset(gustavo[i], 0, MAX_DIGIT);
	for(i = 1; i <= 1000; i++){
		//printf("make_gustavo(%d)\n", i);
		make_gustavo(i);
	}
		
	while(scanf("%d", &n) == 1) {
		for(i = 0; i < length[n - 1]; i++) {
			printf("%d", gustavo[n - 1][length[n - 1] - i - 1]);
		} printf("\n");
	}
	
}

void make_gustavo(int n) {
	int len = 0, carry = 0;
	int current_i = n - 1;
	if(n == 1) {
		gustavo[current_i][0] = 2;
		length[current_i] = strlen(gustavo[current_i]);
		
	} else if(n == 2) {
		gustavo[current_i][0] = 5;
		length[current_i] = strlen(gustavo[current_i]);
		
	} else if(n == 3) {
		gustavo[current_i][0] = 3;
		gustavo[current_i][1] = 1;
		length[current_i] = strlen(gustavo[current_i]);
		
	} else {  // n >= 4
		//printf("n = %d\n", n);
		plus(n, n - 1, n - 2, n - 3);
	}
}

void plus(int t, int a, int b, int c) {
	int len = 0, carry = 0;
	int ti = t - 1;
	int ai = a - 1;
	int bi = b - 1;
	int ci = c - 1;
	int i;
	/*
	for(i = 0; i < length[ai]; i++) {
		printf("%d", gustavo[ai][length[ai] - i - 1]);
	} printf("\n");
	for(i = 0; i < length[bi]; i++) {
		printf("%d", gustavo[bi][length[bi] - i - 1]);
	} printf("\n");
	for(i = 0; i < length[ci]; i++) {
		printf("%d", gustavo[ci][length[ci] - i - 1]);
	} printf("\n");
	*/
	for(len = 0; len < length[ai]; len++) {
		gustavo[ti][len] = (gustavo[ai][len] * 2 + gustavo[bi][len] + gustavo[ci][len] + carry);
		//printf("gustavo = %d\n", gustavo[ti][len]);
		if(gustavo[ti][len] >= 10)
			carry = gustavo[ti][len] / 10;
		else
			carry = 0;
		gustavo[ti][len] %= 10;
	}
	
	if(carry > 0)
		gustavo[ti][len++] = carry;
	length[ti] = len;
	//printf("result = ");
	
	
}