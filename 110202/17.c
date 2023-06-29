#include <stdio.h>

#define HIGH    1
#define ONE     2
#define TWO     3
#define THREE   4
#define ST      5
#define FL      6
#define FULL    7
#define FOUR    8
#define STFL    9

typedef struct _win {
	int what;
	int max;
} win;

typedef struct _draw {
	char num;
	char pattern;
	int rating;
} draw;

void rate(draw arr[]);
void sort(draw arr[]);
void check(draw arr[], win* deck);
void whowin(draw wd[], draw bd[], win wdeck, win bdeck);

int main(void) {
	draw Dwhite[5], Dblack[5];
	win white, black;
	int i;
	char n, pa;
	
	while(scanf("%c%c ", &n, &pa) == 2) {
		Dblack[0].num = n;
		Dblack[0].pattern = pa;
		for(i = 1; i < 5; i++) {  // black의 카드 draw
			scanf("%c%c ", &n, &pa);
			Dblack[i].num = n;
			Dblack[i].pattern = pa;
		}
		
		for(i = 0; i < 5; i++) {  // white의 카드 draw
			scanf("%c%c ", &n, &pa);
			Dwhite[i].num = n;
			Dwhite[i].pattern = pa;
		}
		
		rate(Dblack);
		rate(Dwhite);
		
		sort(Dblack);
		sort(Dwhite);
		/*
		for(i = 0; i < 5; i++) {  // white의 카드 draw
			printf("%c%c ", Dblack[i].num, Dblack[i].pattern);
		}
		printf("\n");
		
		for(i = 0; i < 5; i++) {  // white의 카드 draw
			printf("%c%c ", Dwhite[i].num, Dwhite[i].pattern);
		}
		printf("\n");
		*/
		
		check(Dblack, &black);
		check(Dwhite, &white);
		/*
		printf("B: %d %d W: %d %d", black.what, black.max, white.what, white.max);
		printf("\n");
		*/
		
		whowin(Dwhite, Dblack, white, black);
	}
	
	
	return 0;
}


void rate(draw arr[]) {
	int i;
	for(i = 0; i < 5; i++) {
		switch (arr[i].num) {
			case '2':
				arr[i].rating = 1;
				break;
			case '3':
				arr[i].rating = 2;
					break;
			case '4':
				arr[i].rating = 3;
				break;
			case '5':
				arr[i].rating = 4;
				break;
			case '6':
				arr[i].rating = 5;
				break;
			case '7':
				arr[i].rating = 6;
				break;
			case '8':
				arr[i].rating = 7;
				break;
			case '9':
				arr[i].rating = 8;
				break;
			case '10':
				arr[i].rating = 9;
				break;
			case 'J':
				arr[i].rating = 10;
				break;
			case 'Q':
				arr[i].rating = 11;
				break;
			case 'K':
				arr[i].rating = 12;
				break;
			case 'A':
				arr[i].rating = 13;
				break;
		}
	}
}

void sort(draw arr[]) {
	draw tmp;
	int i, j;
	for(i = 0; i < 4; i++) {
		for(j = i; j < 5; j++) {
			if(arr[i].rating > arr[j].rating) {
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
	}
}

void check(draw arr[], win* deck) {
	int checkST = 0, checkFL = 0;
	int	i, j;
	int d, maxd, max, istwo, maxt, maxF;
	int token_p = 0, token_n = 0;
	
	for(i = 0; i < 4; i++) { // 같은 문양 개수 token_p에 기록
		if(arr[i].pattern == arr[i + 1].pattern) // 같은 문양 개수 token_p에 기록
			token_p++;
		if(arr[i].rating == arr[i + 1].rating - 1 )
			token_n++;
	}
	if(token_p == 4)	
		checkFL = 1;
	if(token_n == 4)
		checkST = 1;
		
	if(checkFL == 1 && checkST == 1) { // 스트레이트 플러시 확인
		deck->what = STFL;
		deck->max = arr[4].rating;
		return;
	}
	if(checkFL == 1) { // 플러시 확인
		deck->what = FL;
		deck->max = arr[4].rating;
		return;
	}
	if(checkST == 1) { // 스트레이트 확인
		deck->what = ST;
		deck->max = arr[4].rating;
		return;
	}
	
	maxd = 0;  // 같은 카드 수 저장 변수 maxd;
	for(i = 0; i < 5; i++) { // THREE, FOUR, FULL 확인.
		d = 0; // 같은 수 카드 확인 변수 b
		istwo = 0; // 투카드 확인 변수 istwo; 
		for(j = 0; j < 5; j++) {		// 자신을 포함한같은 카드 확인.
			if(arr[i].rating == arr[j].rating) {
				d++;
				max = j;
				istwo++;
			}
			//printf("%d %d: %d\n", i, j, maxd);
		}
		if(maxd == 3 && d == 2 || maxd == 2 && d == 3) { // 풀하우스 확인
			deck->what = FULL;
			deck->max = arr[max].rating;
			return;
		}
		
		if(d > maxd) {
			// printf("d = %d ", d);
			maxd = d;
			//	printf("maxd = %d ", maxd);
			
		}
		if(istwo > maxt)
			maxt = istwo;
		
		
		if(maxd == 4) {              // 포카드이면 포카드
				deck->what = FOUR;
				deck->max = arr[max].rating;
				return;
		}
		
	}
	//printf("%d\n", maxd);
	
	if(maxd == 1) { // 하이 카드 확인.
		deck->what = HIGH;
		//printf("max = %d, ratnig = %d \n", max,arr[max].rating);
		deck->max = arr[max].rating;
		//printf("max = %d, ratnig = %d \n", max,arr[max].rating);
		return;
	} 
	if(maxd == 2) {
		if(maxt == 8) {
			deck->what = TWO;
			deck->max = arr[max].rating;
			return;
		}
		deck->what = ONE;
		deck->max = arr[max].rating;
		return;
	}
	if(maxd == 3) {
		deck->what = THREE;
		deck->max = arr[max].rating;
		return;
	}
	
}

void whowin(draw wd[], draw bd[], win wdeck, win bdeck) {
	int i;
	if(wdeck.what != bdeck.what) // 족보가 다른 경우
		(wdeck.what > bdeck.what) ? printf("White wins.\n") : printf("Black wins.\n");
	else { // 족보가 같은경우
		if(wdeck.what == HIGH) { // 그 중 하이 카드인 경우.
			for(i = 4; i >= 0; i--) { // 값이 달라질 때 까지 -1
				if(wd[i].rating != bd[i].rating)
					break;
			}
			if(i == -1)
				printf("Tie.\n");
			else
				(wd[i].rating > bd[i].rating) ? printf("White wins.\n") : printf("Black wins.\n");
		}
		else { // 나머지 경우
			if(wdeck.max == bdeck.max)
				printf("Tie.\n");
			else
			(wdeck.max > bdeck.max) ? printf("White wins.\n") : printf("Black wins.\n");
		}
	}
}