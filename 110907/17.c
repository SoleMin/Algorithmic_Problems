#include <stdio.h>
#include <string.h>
#define MAXN 100
#define MAXE 1000
#define MAXNAME 32
#define MAXQUEUESIZE 10000
static int n, e, ne, start, finish, reachable, edges[MAXE][4], check[MAXN][2];
static char city[MAXN][MAXNAME + 1];
static int front, rear, queue[MAXQUEUESIZE];
int getcity(char *name)
{
	int i;
	for (i = 0; i < n; i++) {
		if (strcmp(name, city[i]) == 0)
			return i;
	}
	strcpy(city[n], name);
	return n++;
}
void input(void) {
	int i, a, b, t1, t2;
	char name1[MAXNAME + 1], name2[MAXNAME + 1];
	n = ne = 0;
	scanf("%d", &e);
	for (i = 0; i < e; i++) {
		scanf("%s %s %d %d", name1, name2, &t1, &t2);
		t1 %= 24; // 24시를 0시로 변경
		if ((t1 >= 6 && t1 < 18) || (t1 < 6 && t2 > 6 - t1) || (t1 >= 18 && t2 > 30 - t1)) {
			continue;
		}
		// 정오를 0시로 치환하여 저장한다.
		edges[ne][0] = getcity(name1); // 출발 도시 번호
		edges[ne][1] = getcity(name2); // 도착 도시 번호
		edges[ne][2] = (t1 + 12) % 24; // 출발 시각
		edges[ne][3] = t2; // 여행 시간
		ne++;
	}
	scanf("%s %s", name1, name2);
	start = getcity(name1); // 출발지 도시 번호
	finish = getcity(name2); // 도착지 도시 번호
}
void bfs(void)
{
	int i, t, now[3];
	front = 0;
	rear = 0;
	reachable = 0;
	for (i = 0; i < n; i++)
		check[i][0] = 10000; // 큰 수로 초기화 (최소값을 찾기 위함)
	queue[rear++] = start;
	check[start][0] = 0; // 필요한 혈액량(여행 날짜)
	check[start][1] = 0;
	while (front < rear) {
		now[0] = queue[front++]; // 현재 도시 번호
		now[1] = check[now[0]][0]; // 현재까지 필요 혈액량(리터)
		now[2] = check[now[0]][1]; // 다음 도시에서의 도착 시각
		if (now[0] == finish){
			reachable = 1;
			continue;
		}
		for (i = 0; i < ne; i++) {
			if (edges[i][0] != now[0]) continue; // 출발 도시 불일치
			if (now[2] <= edges[i][2] && // 출발 시각 확인
					(check[edges[i][1]][0] > now[1] || // 누적 날짜 확인
							(check[edges[i][1]][0] == now[1] &&
							check[edges[i][1]][1] > edges[i][2] + edges[i][3]))) { // 도착 시각 확인
				queue[rear++] = edges[i][1]; // 더 짧은 경로 설정
				check[edges[i][1]][0] = now[1];
				check[edges[i][1]][1] = edges[i][2] + edges[i][3];
			}
			else if (check[edges[i][1]][0] > now[1] + 1 || // 누적 날짜 확인
					(check[edges[i][1]][0] == now[1] + 1 &&
					check[edges[i][1]][1] > edges[i][2] + edges[i][3])) { // 도착 시각 확인
				queue[rear++] = edges[i][1]; // 더 짧은 경로 설정
				check[edges[i][1]][0] = now[1] + 1;
				check[edges[i][1]][1] = edges[i][2] + edges[i][3];
			}
		}
	}
}
void main(void)
{
	int i, t;
	scanf("%d", &t);
	for (i = 1; i <= t; i++){
		input();
		bfs();
		printf("Test Case %d.\n", i);
		if (reachable)
			printf("Vladimir needs %d litre(s) of blood.\n", check[finish][0]);
		else
			printf("There is no route Vladimir can take.\n");
	}
}