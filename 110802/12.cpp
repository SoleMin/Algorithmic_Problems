# include <iostream>
# include <stdlib.h>
#define MAXMOVE (50)

using namespace std;

static int MAXDEPTH;
static int move_info[4][2] = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
static char movechar[4] = { 'U', 'R', 'D', 'L' };
static int solved, puzzle[4][4];
static int mtop, movestack[MAXMOVE];

void input(void)
{
	int i, j;
	for (i = 0; i < 4; i++)
		for (j = 0; j < 4; j++)
			scanf("%d", &puzzle[i][j]);
}

void print_puzzle(void) {
	cout << "=====<Cur Puzzle>=====" << endl;
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 4; j++) {
			cout << puzzle[i][j] << " ";
		}
		cout << endl;
	}
	cout << "======================" << endl;
}

void output(void)
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

int cost(void) {
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

void rotate(int pos1_x, int pos1_y, int pos2_x, int pos2_y) {
	
	//cout << "Rotate puzzle[" << pos1_x << "][" << pos1_y << "] => " << puzzle[pos1_x][pos1_y];
	//cout << " and puzzle[" << pos2_x << "][" << pos2_y << "] => " << puzzle[pos2_x][pos2_y] << endl;
	int temp;

	temp = puzzle[pos1_x][pos1_y];
	puzzle[pos1_x][pos1_y] = puzzle[pos2_x][pos2_y];
	puzzle[pos2_x][pos2_y] = temp;
}

void back(int a, int nowx, int nowy) {
	//cout << "P1" << endl;
	int i, c;
	int nextx = 0, nexty = 0;
	c = cost();	// 문제 해결에 필요한 이동 횟수 계산
	//cout << "P2" << endl;
	if (c == 0) {	// 0이면 정답이니 return
		solved = 1;
		return;
	}
	//cout << "P3" << endl;
	if (a + c > MAXDEPTH) return;	// 현재 node의 depth와 필요한 depth(해결을 위해 이동해야 하는 수)의 합이 최대 이동 수 보다높으면 필요 없으므로 return
	//cout << "P4" << endl;
	/*그 외의 경우에 대해서는 전형적인 backtracking 실행*/
	for (i = 0; i < 4; i++) {	// i의 값에 따라 U, R, L, D의 방향이 결정 됨
		/* 이전의 이동한 기록이 지금의 이동과 상호 보완이라면(L<=>R || U<=>D) 필요 없으므로 pruning */
		if (mtop > 0 && (movestack[mtop - 1] + 2) % 4 == i)	
			continue;
		
		nextx = nowx + move_info[i][0];
		nexty = nowy + move_info[i][1];
		/* Out of range에 대한 pruning*/
		//cout << "Cur [" << nowx << "][" << nowy << "]" << endl;
		if (nextx < 0 || nextx > 3 || nexty < 0 || nexty > 3) {
			//cout << "Break [" << nextx << "][" <<  nexty << "]" << endl;
			continue;
		}
			
		//cout << "P5" << endl;
		rotate(nowx, nowy, nextx, nexty);
		movestack[mtop++] = i;
		back(a + 1, nextx, nexty);
		if (solved) return;
		mtop--;
		rotate(nowx, nowy, nextx, nexty);
		
	}
}

void solve(void) {
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
		return;

	//cout << "Blank is [" << x << "][" << y << "]" << endl;
	for (MAXDEPTH = cost(); !solved && MAXDEPTH <= MAXMOVE; MAXDEPTH += 2)
		back(0, x, y);	// 빈 칸 부터 백트랙 시작
}

int main() {
	int i, t;
	scanf("%d", &t);
	for (i = 0; i < t; i++) {
		input();
		//print_puzzle();

		mtop = 0;
		solved = 0;

		solve();
		output();
	}
	
	return 0;
}