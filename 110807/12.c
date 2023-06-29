#include <stdio.h>
#define MAXDEPTH 16
static int remainto[11][11] = { {0, 1, 1, 0, 1, 2, 3, 2, 3, 3, 3},
																{1, 2, 2, 0, 0, 1, 2, 3, 4, 4, 4},
																{0, 2, 3, 1, 1, 0, 1, 4, 5, 3, 5},
																{1, 1, 2, 2, 2, 0, 0, 3, 4, 2, 4},
																{0, 0, 1, 2, 3, 1, 1, 2, 3, 1, 3},
																{1, 0, 0, 1, 2, 2, 2, 1, 2, 2, 2},
																{0, 1, 1, 2, 3, 3, 3, 0, 1, 2, 3},
																{1, 2, 2, 3, 4, 4, 4, 0, 0, 1, 2},
																{0, 2, 3, 4, 5, 3, 5, 1, 1, 0, 1},
																{1, 1, 2, 3, 4, 2, 4, 2, 2, 0, 0},
																{0, 0, 1, 2, 3, 1, 3, 2, 3, 1, 1} };
//각각의 숫자가 특정 위치에 있을때 솔루션까지 최소 몇칸을 이동해야하는지
//이걸로 휴리스틱을 계산

static int finalstate[24] = { 0, 3, 4, 3, 0, 5, 6, 5, 0, 1, 2, 1, 0, 7, 8, 7, 0, 9, 10, 9, 0, 1, 2, 1 }; //정답
static int state[24], point[2], count[2], stack[MAXDEPTH], result[MAXDEPTH], rn, solveable;

void back(int a);
int right(int base, int offset);
int left(int base, int offset);

int main(void) {
	int n, i, j;
	scanf("%d", &n);
	for (i = 0; i < n; i++) {
		for (j = 0; j < 24; j++)
			scanf("%d", &state[j]); //입력을 받고
		count[0] = count[1] = 0; //카운트를 초기화
		point[0] = 0; //왼쪽의 기준을 포인팅
		point[1] = 12; //오른쪽의 기준을 포인팅
		rn = MAXDEPTH + 1; //몇번 반복하는지 뎁스값을 저장
		solveable = 0; //문제가 풀렸으면 1로
		back(0);
		if (solveable) {
			if (rn == 0)
				printf("PUZZLE ALREADY SOLVED\n");
			else {
				for (j = 0; j < rn; j++)
					printf("%d", result[j]);
				printf("\n");
			}
		}
		else
			printf("NO SOLUTION WAS FOUND IN %d STEPS\n", MAXDEPTH);
	}
}

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
//오프셋이 따로 있는 이유? 정방향 역방향 ㅇㅇ
//그럼 그 알맞은 값은 무엇일까요?
//결국 포인터에서 얼마나 간 값을 반환하는지에 대한 함수임 ㅎ

void back(int a) {
	int i, j, temp1, temp2, issame, minmove;
	if (a == rn)
		return; //뎁스보다 커지면 풀이 불가능
	issame = 1; //솔루션과 같냐?
	for (i = 0; i < 12 && issame; i++)
		if (state[left(point[0], i)] != finalstate[i])
			//파이널스테이트 0부터 11까지
			//왼쪽 원판의 숫자들과 동일한지 확인
			issame = 0;
	for (i = 0; i < 12 && issame; i++)
		if (state[left(point[1], i)] != finalstate[i + 12])
			issame = 0;
	//솔루션과 다른거 하나라도 잇는지 확인중
	if (issame) {
		for (i = 0; i < a; i++) {
			result[i] = stack[i]; //스택: 지금까지 어느 회전인지를 저장한 배열
			//리절트 정답 출력때 사용됨
		}
		rn = a; //현재 댑스를 저장; 이 만큼만 출력됨
		solveable = 1;
		return;
	}
	//여기서부터 휴리스틱 부분
	//현재 구성에서 정답까지 최소 몇번 움직여야 하는지 구함
	minmove = 0; //일단 0으로 초기화
	for (i = 0; i < 21; i++) {
		temp1 = state[left(point[i / 12], i % 12)];
		if (minmove < remainto[i / 2][temp1])
			//지금현재 특정 숫자가 어느 위치에 있을때 최소 몇번을 이동해야하는지
			minmove = remainto[i / 2][temp1];
	}
	if (a == MAXDEPTH || a + minmove > MAXDEPTH || a + minmove >= rn)
		return;
	
	
	
	
	for (i = 1; i <= 4; i++) {//4개의 액션을 하나씩 테스트함
		if (a >= rn - 1)
			break;
		stack[a] = i;//일단 이걸 하기로 함, 되면? 좋아 : 아니면 롤백해야지 ㅋㅋ
		switch (i) {

			case 1: //왼쪽을 시계방향으로 회전
				if (count[0] > 0 || count[0] == -5)
					break;
				point[0] = right(point[0], 2); //이게 아니니까 왼쪽으로 2칸 이동시킴
				for (j = 1; j <= 3; j++)
					state[right(point[1], j)] = state[right(point[0], j)];
				//중간의 값들은 왼쪽을 옮겨도 똑같이 옮겨지기에 같이 옮겨줘야함
				temp1 = count[0];
				temp2 = count[1];
				count[0]--;
				count[1] = 0; //최근에 왼족바퀴를 움직인거니까 오른쪽 바퀴는 초기화
				back(a + 1); //여기서 실패하면 하는게 밑에 백업 부분 ㅇㅇ ㅎ
				count[0] = temp1;
				count[1] = temp2;
				point[0] = left(point[0], 2); //오른쪽으로 두 칸 민거 다시 왼쪽으로 두칸
				for (j = 1; j <= 3; j++)
					state[right(point[1], j)] = state[right(point[0], j)];
				//중간 값도 복원
				break;

			case 3: //왼쪽을 반시계방향으로 회전
				if (count[0] < 0 || count[0] == 5)
					break;
				point[0] = left(point[0], 2); //이게 아니니까 왼쪽으로 2칸 이동시킴
				for (j = 1; j <= 3; j++)
					state[right(point[1], j)] = state[right(point[0], j)];
				//중간의 값들은 왼쪽을 옮겨도 똑같이 옮겨지기에 같이 옮겨줘야함
				temp1 = count[0];
				temp2 = count[1];
				count[0]++;
				count[1] = 0; //최근에 왼족바퀴를 움직인거니까 오른쪽 바퀴는 초기화
				back(a + 1); //여기서 실패하면 하는게 밑에 백업 부분 ㅇㅇ ㅎ
				count[0] = temp1;
				count[1] = temp2;
				point[0] = right(point[0], 2); //오른쪽으로 두 칸 민거 다시 왼쪽으로 두칸
				for (j = 1; j <= 3; j++)
					state[right(point[1], j)] = state[right(point[0], j)];
				//중간 값도 복원
				break;
	
			case 2: //오른쪽 시계
				if (count[1] < 0 || count[1] == 5)
					break;
				point[1] = left(point[1], 2); //이게 아니니까 왼쪽으로 2칸 이동시킴
				for (j = 1; j <= 3; j++)
					state[right(point[0], j)] = state[right(point[1], j)];
				//중간의 값들은 왼쪽을 옮겨도 똑같이 옮겨지기에 같이 옮겨줘야함
				temp1 = count[0];
				temp2 = count[1];
				count[0] = 0;
				count[1]++; //최근에 왼족바퀴를 움직인거니까 오른쪽 바퀴는 초기화
				back(a + 1); //여기서 실패하면 하는게 밑에 백업 부분 ㅇㅇ ㅎ
				count[0] = temp1;
				count[1] = temp2;
				point[1] = right(point[1], 2); //오른쪽으로 두 칸 민거 다시 왼쪽으로 두칸
				for (j = 1; j <= 3; j++)
					state[right(point[0], j)] = state[right(point[1], j)];
				//중간 값도 복원
				break;
				
			case 4: //오른쪽을 반시계방향으로 회전
				if (count[1] > 0 || count[1] == -5)
					break;
				point[1] = right(point[1], 2); //이게 아니니까 왼쪽으로 2칸 이동시킴
				for (j = 1; j <= 3; j++)
					state[right(point[0], j)] = state[right(point[1], j)];
				//중간의 값들은 왼쪽을 옮겨도 똑같이 옮겨지기에 같이 옮겨줘야함
				temp1 = count[0];
				temp2 = count[1];
				count[0] = 0;
				count[1]--;
				back(a + 1); //여기서 실패하면 하는게 밑에 백업 부분 ㅇㅇ ㅎ
				count[0] = temp1;
				count[1] = temp2;
				point[1] = left(point[1], 2); //오른쪽으로 두 칸 민거 다시 왼쪽으로 두칸
				for (j = 1; j <= 3; j++)
					state[right(point[0], j)] = state[right(point[1], j)];
				//중간 값도 복원
				break;
		}
	}
}