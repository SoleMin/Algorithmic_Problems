#include <iostream>

using namespace std;

#define MAXDEPTH 16

static int start[24], stack[MAXDEPTH], result[MAXDEPTH], point[2], count_[2], rn, solveable;
static int answer[24] = { 0, 3, 4, 3, 0, 5, 6, 5, 0, 1, 2, 1, 0, 7, 8, 7, 0, 9, 10, 9, 0, 1, 2, 1 };
// [y][x] 라고 할 때 y자리에 있는 x값이 답의 위치까지의 거리임 ㅇㅇ
// 왼쪽 아래 분리판과 그 시계방향에 있는 삼각형이 1이고 왼쪽판은 시계방향으로 순서대로 2,3,4,5,6임
// 오른쪽 아래 분리판과 그 반시계방향에 있는 삼각형이 7이고 오른쪽판은 반시계방향으로 8 9 10 11 임 맨 가운데 있는 돌림판은 6임
// 대충 그런거 같음 ㅇㅇ
static int man_dist[11][11] = { {0, 1, 1, 0, 1, 2, 3, 2, 3, 3, 3},
												{1, 2, 2, 0, 0, 1, 2, 3, 4, 4, 4},
												{0, 2, 3, 1, 1, 0, 1, 4, 5, 3, 5},
												{1, 1, 2, 2, 2, 0, 0, 3, 4, 2, 4},
												{0, 0, 1, 2, 3, 1, 1, 2, 3, 1, 3},
												{1, 0, 0, 1, 2, 2, 2, 1, 2, 2, 2},
												{0, 1, 1, 2, 3, 3, 3, 0, 1, 2, 3},
												{1, 2, 2, 3, 4, 4, 4, 0, 0, 1, 2},
												{0, 2, 3, 4, 5, 3, 5, 1, 1, 0, 1},
												{1, 1, 2, 3, 4, 2, 4, 2, 2, 0, 0},
												{0, 0, 1, 2, 3, 1, 3, 2, 3, 1, 1}};
void back(int a);
void ans_print();

void run() {
	int num, i;

	for (i = 0; i < 24; i++) {
		cin >> start[i];
	}
	//초기값 설정
	count_[0] = 0;
	count_[1] = 0;
	point[0] = 0;
	point[1] = 12;
	rn = MAXDEPTH + 1;
	solveable = 0;

	//벡트래킹 시작
	back(0);

	ans_print();
}
// 왼쪽은 반시계방향, 오른쪽은 시계방향
int left(int base, int offset) {
	if (base < 12) {
		base += offset;
		if (base >= 12)
			base -= 12;
	}
	else {
		base += offset;
		if (base >= 24)
			base -= 12;
	}
	return base;
}
// 왼쪽은 시계방향, 오른쪽은 반시계방향
int right(int base, int offset) {
	if (base < 12) {
		base -= offset;
		if (base < 0)
			base += 12;
	}
	else {
		base -= offset;
		if (base < 12)
			base += 12;
	}
	return base;
}
void back(int a) {
	int i, j, issame, temp1, temp2, minmove;
	if (a >= rn)
		return;
	// 답인지 확인
	issame = 1;

	for (i = 0; i < 12 && issame; i++)
		if (start[left(point[0], i)] != answer[i])
			issame = 0;
	for (i = 0; i < 12 && issame; i++)
		if (start[left(point[1], i)] != answer[i + 12])
			issame = 0;

	if (issame) {
		for (i = 0; i < a; i++) {
			result[i] = stack[i];
		}
		rn = a;
		solveable = 1;
		return;
	}
	
	// 휴리스틱 확인
	minmove = 0;
	for (i = 0; i < 21; i++) {
		temp1 = start[left(point[(i / 12)], (i % 12))];
		if (minmove < man_dist[(i / 2)][temp1]){
			minmove = man_dist[(i / 2)][temp1];
		}
	}
	if (a == MAXDEPTH || a + minmove > MAXDEPTH || a + minmove >= rn)
		return;

	for (i = 1; i < 5; i++) {
		if (a >= rn - 1)
			break;
		stack[a] = i;
		if (i == 1) { // 왼쪽 시계방향
			if (count_[0] > 0 || count_[0] == -5) continue;

			// 시작하는 지점 설정해줌
			point[0] = right(point[0], 2);
			// 오른쪽 판 왼족판 공유하는 3개 설정해줌(가운데 3개)
			for (j = 1; j <= 3; j++)
				start[right(point[1], j)] = start[right(point[0], j)];

			// 돌리는 방향에 따라 돌린횟수 설정
			temp1 = count_[0];
			temp2 = count_[1];
			count_[0]--;
			count_[1] = 0;

			back(a + 1);

			//롤백
			count_[0] = temp1;
			count_[1] = temp2;

			point[0] = left(point[0], 2);
			for (j = 1; j <= 3; j++) {
				start[right(point[1], j)] = start[right(point[0], j)];
			}
		}
		else if (i == 2) { // 오른쪽 시계방향
			if (count_[1] < 0 || count_[1] == 5) continue;

			// 시작하는 지점 설정해줌
			point[1] = left(point[1], 2);
			// 오른쪽 판 왼족판 공유하는 3개 설정해줌(가운데 3개)
			for (j = 1; j <= 3; j++)
				start[right(point[0], j)] = start[right(point[1], j)];

			// 돌리는 방향에 따라 돌린횟수 설정
			temp1 = count_[0];
			temp2 = count_[1];
			count_[0] = 0;
			count_[1]++;

			back(a + 1);

			//롤백
			count_[0] = temp1;
			count_[1] = temp2;

			point[1] = right(point[1], 2);
			for (j = 1; j <= 3; j++) {
				start[right(point[0], j)] = start[right(point[1], j)];
			}
		}
		else if (i == 3) { // 왼쪽 반시계방향

			if (count_[0] < 0 || count_[0] == 5) continue;

			// 시작하는 지점 설정해줌
			point[0] = left(point[0], 2);
			// 오른쪽 판 왼족판 공유하는 3개 설정해줌(가운데 3개)
			for (j = 1; j <= 3; j++)
				start[right(point[1], j)] = start[right(point[0], j)];

			// 돌리는 방향에 따라 돌린횟수 설정
			temp1 = count_[0];
			temp2 = count_[1];
			count_[0]++;
			count_[1] = 0;

			back(a + 1);

			//롤백
			count_[0] = temp1;
			count_[1] = temp2;

			point[0] = right(point[0], 2);
			for (j = 1; j <= 3; j++) {
				start[right(point[1], j)] = start[right(point[0], j)];
			}
		}
		else { // 오른쪽 반시계방향
			if (count_[1] > 0 || count_[1] == -5) continue;

			// 시작하는 지점 설정해줌
			point[1] = right(point[1], 2);
			// 오른쪽 판 왼족판 공유하는 3개 설정해줌(가운데 3개)
			for (j = 1; j <= 3; j++)
				start[right(point[0], j)] = start[right(point[1], j)];

			// 돌리는 방향에 따라 돌린횟수 설정
			temp1 = count_[0];
			temp2 = count_[1];
			count_[0] = 0;
			count_[1]--;

			back(a + 1);

			//롤백
			count_[0] = temp1;
			count_[1] = temp2;

			point[1] = left(point[1], 2);
			for (j = 1; j <= 3; j++) {
				start[right(point[0], j)] = start[right(point[1], j)];
			}
		}
	}

}
void ans_print() {
	if (solveable == 1) {
		if (rn == 0)
			cout << "PUZZLE ALREADY SOLVED" << endl;
		else {
			for (int i = 0; i < rn; i++) {
				cout << result[i];
			}
			cout << endl;
		}
	}
	else {
		cout << "NO SOLUTION WAS FOUND IN 16 STEPS" << endl;
	}
}

int main() {
	int n, i;
	cin >> n;
	for (i = 0; i < n; i++) {
		run();
	}
	return 0;
}