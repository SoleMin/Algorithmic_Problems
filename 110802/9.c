#include <stdio.h>
#include <stdlib.h>
#define MAXMOVE 50
static int MAXDEPTH;
static int move[4][2] = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
static char movechar[4] = { 'U', 'R', 'D', 'L' };
static int solved, puzzle[4][4]; // 입력받은 퍼즐
static int mtop, movestack[MAXMOVE]; // 이동한 경로

int main() {
	int i, t;
	
	scanf("%d", &t);
	for (i = 0; i < t; i++) {
	input();
	mtop = 0; // 이동 횟수
	solved = 0; // 0 해결안됨 1 해결
	solve();
	output();
	}
	return 0;
}

void input(void) // 입력
{
	int i, j;
	for (i = 0; i < 4; i++)
		for (j = 0; j < 4; j++)
			scanf("%d", &puzzle[i][j]);
}

void output(void) // 출력
{
	int i;
	if (solved)
	{
		for (i = 0; i < mtop; i++)
			printf("%c", movechar[movestack[i]]);
		printf("\n");
	}
	else
		printf("This puzzle is not solvable.\n");
}

int cost(void) { // 현재보드의 cost를 계산해주는 맨하튼 함수
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

void solve(void) { // 전도수 새기
	int i, j, k, l, value, x, y;
	value = 0;
	for (i = 0; i < 4; i++) {
		for (j = 0; j < 4; j++) {
			if (puzzle[i][j] == 0) {
				value += i;
				x = i;
				y = j;
			}
			for (k = i; k < 4; k++) {
				if (k == i) l = j + 1;
				else l = 0;
				for (; l < 4; l++) {
					if (puzzle[k][l] != 0 && puzzle[i][j] > puzzle[k][l]) value++;
				}
			}
		}
	}
	
	if (value % 2 == 0) return; // 풀릴 수 없다
	
	for (MAXDEPTH = cost(); !solved && MAXDEPTH <= MAXMOVE; MAXDEPTH += 2) // 50이 될 때 까지 백트래킹
		back(0, x, y);
}

void back(int a, int nowx, int nowy) {
	int i, c;
	int nextx, nexty;
	
	c = cost();
	
	if (c == 0) { // 이미 정답위치에 있다
		solved = 1;
		return;
	}
	
	if (a + c > MAXDEPTH) return; // 안되는 경우
	
	for (i = 0; i < 4; i++) {
		
		if (mtop > 0 && (movestack[mtop - 1] + 2) % 4 == i) // R 다음 L이다 혹은 U 다음 D이다 생략
			continue;
		
		int newX = nowx + move[i][0];
		int newY = nowy + move[i][1];
		
		if(newX < 0 || newX > 3 || newY < 0 || newY > 3) continue;
		
		int temp = puzzle[nowx][nowy];
		puzzle[nowx][nowy] = puzzle[newX][newY];
		puzzle[newX][newY] = temp;
		
		movestack[mtop++] = i;
		back(a + 1, newX, newY);
		if (solved) return;
		mtop--;

		temp = puzzle[nowx][nowy];
		puzzle[nowx][nowy] = puzzle[newX][newY];
		puzzle[newX][newY] = temp;
	
	}
}
