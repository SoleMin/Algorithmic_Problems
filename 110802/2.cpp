#include <iostream>
#include <queue>
using namespace std;

void run();
void run2();
void back(int a, int x, int y);
int Manhattan_distance();
void print_mat(int a, int mv);
void print_ans();

int puzzle[4][4];
int Distance[2][16];
int MAXDEPTH;
bool is_solve = 0;
int movestack[50];
int mtop = 0;
int movee[4][2] = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
char movechar[4] = { 'U', 'R', 'D', 'L' };

void run() {
	int num;
	is_solve = 0;
	mtop = 0;
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 4; j++) {
			cin >> num;
			puzzle[i][j] = num;
		}
	}
	run2();
	print_ans();
}

void run2() {
	int x, y;
	int jundo = 0, temp = 0;
	int gijun = 16;
	int i, j, k, l, value=0;
	
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

	for (MAXDEPTH = Manhattan_distance(); !is_solve && (MAXDEPTH <= 30); MAXDEPTH += 2)
		back(0, x, y);
}

void back(int a, int x, int y) {
	int mv;
	int nextx, nexty, i;
	//priority_queue<>

	mv = Manhattan_distance();
	if (mv == 0) {					// 답 찾음
		is_solve = 1;
		for(int tt=0;tt<a;tt++){
			cout << movechar[movestack[tt]];
		}
		cout << endl;
		return;
	}
	
	if (a + mv > MAXDEPTH) return;
	
	for (i = 0; i < 4; i++) {  // 0:위, 1 : 오른쪽, 2:아래, 3: 왼
		if (mtop > 0 && (movestack[mtop - 1] + 2) % 4 == i) //만약 전에 했던게 이번에 할 방향이랑 반대방향이면 그냥 안하고 넘어감
			continue;
		// 가장자리 있을 때 그 쪽으로 못감 ㅇㅇ
		if (x == 0 && i == 0) continue;
		else if (x == 3 && i == 2) continue;
		if (y == 0 && i == 3) continue;
		else if (y == 3 && i == 1) continue;


		// 초동역학 위치전환기
		nextx = x + movee[i][0];
		nexty = y + movee[i][1];
		puzzle[x][y] = puzzle[nextx][nexty];
		puzzle[nextx][nexty] = 0;
		//print_mat(a, mv);

		// 백트 들어감
		movestack[mtop++] = i;
		back(a + 1, nextx, nexty);
		if (is_solve) return;

		// 롤백
		mtop--;
		puzzle[nextx][nexty] = puzzle[x][y];
		puzzle[x][y] = 0;


	}
}

int Manhattan_distance() {
	
	int x, y, k;
	int num = 0;
	int move = 0;
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 4; j++) {
			if (puzzle[i][j] != 0) {
				x = (puzzle[i][j] - 1) / 4;
				x = x - i;
				num = abs(x);
				k = (puzzle[i][j]-1) % 4;
				y = k - j;
				num += abs(y);
				move += num;
				//Distance[0][puzzle[i][j]] = x;
				//Distance[1][puzzle[i][j]] = y;
			}
		}
	}
	return move;
}

void print_mat(int a, int mv) {
	cout << a  << " : " << mv << endl;
	for (int c = 0; c < 4; c++) {
		for (int v = 0; v < 4; v++) {
			cout << puzzle[c][v] << " ";
		}
		cout << endl;
	}
	cout << endl;
}

void print_ans() {
	if(is_solve == 0){
		cout << "This puzzle is not solvable." << endl;
	}
}

int main() {
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		run();
		//cout << endl;
	}
	return 0;
}