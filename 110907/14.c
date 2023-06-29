#include <stdio.h>
#include <stdbool.h>
#include <string.h>

#define MAXN 100
#define MAXE 1000
#define MAXNAME 32
#define MAXQUEUESIZE 10000

static int n, e, ne, start, finish, reachable, edges[MAXE][4], check[MAXN][2];
//reachable: 도달 가능 여부를 판단하는 boolean 변수
//finish: main의 출력에 사용됨
//check: main의 출력에 사용됨
//n: 역 번호의 갯수
//e: 총 경로
//ne: 총 가능한 경로
//start: 시작 역 번호
//finish: 도착 역 번호
//edges: 각 경로의 시작, 도착, 출발시각, 여행 시각을 담은 배열
//check: 
static char city[MAXN][MAXNAME + 1]; //단순하게 도시 이름 저장해두는 배열
static int front, rear, queue[MAXQUEUESIZE];

int getcity(char *name) {
	int i;
	for (i = 0; i < n; i++) {
		if (strcmp(name, city[i]) == 0)
			return i;
	}
	strcpy(city[n], name);
	return n++;
}//역 이름들을 배열에 저장해두었다가 각각 unique한 번호를 부여

void input(void) {
	int i, a, b, t1, t2;
	char name1[MAXNAME + 1], name2[MAXNAME + 1];
	n = ne = 0;
	scanf("%d", &e); //e: 노선의 갯수
	for (i = 0; i < e; i++) {
		scanf("%s %s %d %d", name1, name2, &t1, &t2);//name1: 출발지, name2: 도착지, t1: 출발 시각, t2: 총 여행 시간
		t1 %= 24; // 24시를 0시로 변경
		if ((t1 >= 6 && t1 < 18) || (t1 < 6 && t2 > 6 - t1) || (t1 >= 18 && t2 > 30 - t1)) {
			continue; //움직일 수 없는 시간대롤 제외한다.
		}
		// 정오를 0시로 치환하여 저장한다.
		edges[ne][0] = getcity(name1); // 출발 도시 번호
		edges[ne][1] = getcity(name2); // 도착 도시 번호
		edges[ne][2] = (t1 + 12) % 24; // 출발 시각
		edges[ne][3] = t2; // 여행 시간
		ne++; //ne = 가능한 경로의 갯수
	}
	scanf("%s %s", name1, name2); //시작지와 도착지를 입력받음
	start = getcity(name1); // 출발지 도시 번호
	finish = getcity(name2); // 도착지 도시 번호
}

void bfs(void) {
	int i, t, now[3];
	front = 0;
	rear = 0;
	reachable = 0;
	for (i = 0; i < n; i++)
		check[i][0] = 10000; // 큰 수로 초기화 (최소값을 찾기 위함); check[i][0]: i번 역에서 목적지로 가는데 필요한 혈액양
	queue[rear++] = start; //일단 시작역부터 스타트
	check[start][0] = 0; // 필요한 혈액량(여행 날짜)
	check[start][1] = 0; // 다음 도시에 도착하는 시간
	while (front < rear) { //실제 bfs 부분
		now[0] = queue[front++]; // 현재 도시 번호
		now[1] = check[now[0]][0]; // 현재까지 필요 혈액량(리터)
		now[2] = check[now[0]][1]; // 다음 도시에서의 도착 시각
		if (now[0] == finish) {//현재 도시 번호가 도착점이면 도달한거지요
			reachable = 1;
			continue;
		}
		for (i = 0; i < ne; i++) { //가능한 모든 경로를 탐색한다.
			if (edges[i][0] != now[0]) //엣지의 출발지가 현재 역이 아니라면 그 역은 사용이 불가능하다.
				continue; // 출발 도시 불일치
			bool cond1 = now[2] <= edges[i][2]; //다음도시에 도착하는 시간에 맞춰 탈 수 있는지 확인
			bool cond2 = check[edges[i][1]][0] > now[1]; //현재까지 필요한 혈액량보다 도착도시까지의 혈액량이 더 필요한지 확인?
			bool cond3 = check[edges[i][1]][0] == now[1]; //현재까지 필요한 혈액량이 도착도시까지의 혈액량이랑 같은지 확인?
			bool cond4 = check[edges[i][1]][1] > edges[i][2] + edges[i][3]; // 다음 도시에 도착하는 시간 > 출발 시간 + 여행 시간
			bool cond5 = check[edges[i][1]][1] > (edges[i][2] + edges[i][3]) % 24;
			if (cond1 && (cond2 || (cond3 && cond4))) {
				queue[rear++] = edges[i][1]; //큐에 다음 역을 추가한다.
				check[edges[i][1]][0] = now[1]; //다음 역에 도달하기 위한 혈액양은 현재까지 필요한 혈액량이랑 같다// 다음날에 출발하면 이게 + 1;
				check[edges[i][1]][1] = edges[i][2] + edges[i][3]; //다음 역에 도착하는 시간은 현재 역 출발 시간 + 다음 역 도착 시간
			}
			else if (cond2 || (cond3 && cond5)) {
			//else { //하루 후에 출발하는 경우
				queue[rear++] = edges[i][1];
				check[edges[i][1]][0] = now[1] + 1;
				//printf("%d\n", edges[i][2] + edges[i][3]);
				check[edges[i][1]][1] = (edges[i][2] + edges[i][3]) % 24;
			}
		}
	}
}

int main(void) {
	int i, t; //인덱스 i와 테스트 케이스 t
	scanf("%d", &t); //t를 입력 받고
	for (i = 1; i <= t; i++) { //t번 동안
		input(); //입력 받고
		bfs(); //명령 수행하고
		printf("Test Case %d.\n", i); //몇 번 테스트 케이스인지 표시
		if (reachable) //도달할 수 있다면
			printf("Vladimir needs %d litre(s) of blood.\n", check[finish][0]); //check[finish][0]에 답이 담김
		else
			printf("There is no route Vladimir can take.\n"); //실패 출력
	}
}