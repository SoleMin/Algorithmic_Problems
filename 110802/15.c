#include <stdio.h>
#include <stdlib.h>
#define MAXMOVE 50

static int MAXDEPTH;
static int move[4][2] = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
static char movechar[4] = { 'U', 'R', 'D', 'L' };
static int solved, puzzle[4][4];
static int mtop, movestack[MAXMOVE];

void input(void);
void output(void);
int cost(void);
void back(int, int, int);
void solve(void);

int main() {
	int i, t;
	scanf("%d", &t);
	for (i = 0; i < t; i++) {
		input();//숫자를 읽어 puzzle에 저장
		mtop = 0;//몇개의 값이 무브스택에 저장되어 있는가
		solved = 0; //답이 있냐 없냐
		solve(); 
		output();
	}
}

void input(void) {
  int i, j;
  for (i = 0; i < 4; i++)
  for (j = 0; j < 4; j++)
  scanf("%d", &puzzle[i][j]);
}

void output(void) {
	int i;
	if (solved) {
		for (i = 0; i < mtop; i++)
			printf("%c", movechar[movestack[i]]);
		printf("\n");
	}
	else
		printf("This puzzle is not solvable.\n");
}

int cost(void) {//맨하탄 디스턴스; 현재 보드에서 가로, 세로로 거리를 구해서 합산
	int i, j;
	int md1, md2;
	md1 = 0;
	for (i = 0; i < 4; i++) {
		for (j = 0; j < 4; j++) {
			if (puzzle[i][j] != 0)
				md1 += abs(i - ((puzzle[i][j] - 1) / 4));
		}
	}
	md2 = 0;
	for (i = 0; i < 4; i++) {
		for (j = 0; j < 4; j++) {
			if (puzzle[i][j] != 0)
				md2 += abs(j - ((puzzle[i][j] - 1) % 4));
		}
	}
	return md1 + md2;
}

void solve(void) {
	int i, j, k, l, value, x, y;
	value = 0; //전도수
	for (i = 0; i < 4; i++) {
		for (j = 0; j < 4; j++) {
			if (puzzle[i][j] == 0) {
				value += i; //빈칸이 짝수인지 홀수인지
				x = i;
				y = j;
			}
			for (k = i; k < 4; k++) {
				if (k == i)
					l = j + 1;
				else
					l = 0;
				for (; l < 4; l++) {
					if (puzzle[k][l] != 0 && puzzle[i][j] > puzzle[k][l])
						value++;
				}
			}
		}
	}
	if (value % 2 == 0)
		return; //짝수 행이고 전도수가 짝수인경우
  //여기서부터 짝수 행 + 전도수 홀수 or 홀수 행 + 전도수 짝수
  
  //처음에 뎁스를 코스트로 지정, 뎁스를 2씩 키워가며 맥스무브가 50이 될때까지
  //백트래킹 반복
	for (MAXDEPTH = cost(); !solved && MAXDEPTH <= MAXMOVE; MAXDEPTH += 2)
		back(0, x, y);
}

//a: 현재 댑스: g(n)
void back(int a, int nowx, int nowy) {
	int i, c;
	int nextx, nexty;
	c = cost();
	if (c == 0) {//코스트가 0이다 모든 셀들이 자기 위치에 있다.
		solved = 1;
		return;
	}
	if (a + c > MAXDEPTH) //g(n) + c(f(n))
		return;
	for (i = 0; i < 4; i++) {//네개의 움직임 업앤다운에 대해 모두 테스트
		if (mtop > 0 && (movestack[mtop - 1] + 2) % 4 == i)
			continue; //현재 무브랑 대치되는 상황이면 무시한다.
		//(중략) //위에 걸리지 않고 무브를 할 수 있다. 여기서 백트래킹
    nextx = nowx + move[i][0];
    nexty = nowy + move[i][1];
    //퍼즐을 바꿔줘야 함 ㅇㅇ
    int temp = puzzle[nextx][nexty];
    puzzle[nextx][nexty] = 0;
    puzzle[nowx][nowy] = temp;



		movestack[mtop++] = i;
		back(a + 1, nextx, nexty);
		if (solved)
			return;
		mtop--;
    puzzle[nextx][nexty] = temp;
    puzzle[nowx][nowy] = 0;
		//(중략) 여기서 문제가 풀리지 않은거기에 다시 복기시켜줘야함
	}
}