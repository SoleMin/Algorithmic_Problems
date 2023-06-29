#include <iostream>
#include <cstdlib>
#define MAXMOVE 50

using namespace std;
static int MAXDEPTH;
static int mover[4][2] = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
static char movechar[4] = { 'L', 'D','R', 'U' };
static int solved, puzzle[4][4];
static int mtop, movestack[MAXMOVE];

void input(void)
{
	int i, j;
	for (i = 0; i < 4; i++)
		for (j = 0; j < 4; j++)
			cin >> puzzle[i][j];
}
void output(void)
{
	int i;
	if (solved)
	{
		for (i = 0; i < mtop; i++)
			cout << movechar[movestack[i]];
		cout << endl;;
	}
	else
		cout << "This puzzle is not solvable." << endl;
}
int cost(void) {
	int i, j;
	int md1, md2;
	md1 = 0;
	for (i = 0; i < 4; i++) {
		for (j = 0; j < 4; j++) {
			if (puzzle[i][j] != 0)							//빈칸이 아니면
				md1 += abs(i - ((puzzle[i][j] - 1) / 4));	//맨하탄거리구하기 (y1-y2구하기) i = 현재행 , (puzzle[i][j]-1)/4=실제값이 몇번째 행에 있어야하는지
		}
	}
	md2 = 0;
	for (i = 0; i < 4; i++) {
		for (j = 0; j < 4; j++) {
			if (puzzle[i][j] != 0)							//빈칸이 아니면
				md2 += abs(j - ((puzzle[i][j] - 1) % 4));	//맨하탄거리구하기 (x1-x2구하기) j = 현재열, (puzzle[i][j]-1)/4=실제값이 몇번째 열에 있어야하는지
		}
	}
	return md1 + md2;		//멘하탄거리 다더해서 return 최소 그만큼은 움직여야한다., 0이면 정렬완료
}
void back(int a, int nowx, int nowy) {
	int i, c;
	int nextx, nexty;
	c = cost();
	if (c == 0) {				//전도수 0이면 해결
		solved = 1;
		return;
	}
	if (a + c > MAXDEPTH) return;		//50번이상 안되면 실패
	for (i = 0; i < 4; i++) {
		if (mtop > 0 && (movestack[mtop - 1] + 2) % 4 == i)
			continue;
		nextx = nowx + mover[i][1];
		nexty =	nowy + mover[i][0];
		swap(puzzle[nowx][nowy], puzzle[nextx][nexty]);
		movestack[mtop++] = i;
		back(a + 1, nextx, nexty); //현재까지 action 횟수와 다음 빈칸활용
		if (solved) return;
		mtop--;
		swap(puzzle[nowx][nowy], puzzle[nextx][nexty]);
	}
}
void solve(void) {
	int i, j, k, l, value, x, y;
	value = 0;								//전도수
	for (i = 0; i < 4; i++) {
		for (j = 0; j < 4; j++) {
			if (puzzle[i][j] == 0) {		//빈칸이면
				value += i;					//빈칸의 행을 value에 더함
				x = i;						//x는 빈칸의 행
				y = j;						//y는 빈칸의 열
			}
			for (k = i; k < 4; k++) {		//초기값 k = i = 현재행이고 현재행에서 마지막행까지 반복 
				if (k == i)					//첫번째 반복일때 l = j+1 (현재열 + 1)
					l = j + 1;
				else
					l = 0;					//첫번째 이후의 반복일때 l = 0;
				for (; l < 4; l++) {		//l의 값부터 4까지 반복
					if (puzzle[k][l] != 0 && puzzle[i][j] > puzzle[k][l]) //전도수구하기 puzzle[i][j]가 그이후의 값보다 크면
						value++;			//value 1증가
				}
			}
		}
	}
	if (value % 2 == 0)						//전도수의 값이 짝수면 
		return;
	for (MAXDEPTH = cost(); !solved && MAXDEPTH <= MAXMOVE; MAXDEPTH += 2)//최소 이만큼은 해야한다 (맨하탄거리 초기값으로) 백트래킹 돌림 뎊스 2씩키우면서 계산
		back(0, x, y);						// 빈칸의 위치를 넣고 백트래킹
}

int main() {
	int i, t;
	cin >> t;
	for (i = 0; i < t; i++) {
		input();
		mtop = 0;
		solved = 0;
		solve();
		output();
	}
}