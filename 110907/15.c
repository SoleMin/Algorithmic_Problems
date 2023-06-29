#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#define MAXN 100
#define MAXE 1000
#define MAXLEN 32
#define MAXSIZE 10000

static bool reachable;
static int n, e, ne, depart, arrive, front, rear;
static int edge[MAXE][4], check[MAXN][2], queue[MAXSIZE];
static char city[MAXN][MAXLEN+1];

int getcity(char* name) {
	int i;

	for (i=0; i<n; i++) {
		if (strcmp(name, city[i])==0) {
			return i;
		}
	}
	strcpy(city[n], name);
	return n++;
}

void input() {
	int i, x, y, dt, at;
	char dpt_name[MAXLEN+1], arr_name[MAXLEN+1];

	n = ne = 0;
	scanf("%d", &e);
	for (i=0; i<e; i++) {
		scanf("%s %s %d %d", dpt_name, arr_name, &dt, &at);
		dt %= 24;

		if ((dt>=6 && dt<18) || (dt<6 && at>6-dt) || (dt>=18 && at>30-dt)) {
			continue;
		}
		edge[ne][0] = getcity(dpt_name);
		edge[ne][1] = getcity(arr_name);
		edge[ne][2] = (dt+12)%24;
		edge[ne][3] = at;
		ne++;
	}
	scanf("%s %s", dpt_name, arr_name);
	depart = getcity(dpt_name);
	arrive = getcity(arr_name);
}

void search() {
	int i, t, now[3];
	front = rear = 0;
	reachable = false;

	for (i=0; i<n; i++) {
		check[i][0] = 10000;
	}
	queue[rear++] = depart;
	check[depart][0] = check[depart][1] = 0;
	while (front<rear) {
		now[0] = queue[front++];
		now[1] = check[now[0]][0];
		now[2] = check[now[0]][1];
		if (now[0]==arrive) {
			reachable = true;
			continue;
		}
		for (i=0; i<ne; i++) {
			if (edge[i][0]!=now[0]) {
				continue;
			}
			if (now[2]<=edge[i][2] &&
				(check[edge[i][1]][0]>now[1] ||
					(check[edge[i][1]][0]==now[1] && check[edge[i][1]][1]>edge[i][2]+edge[i][3]))) {
				queue[rear++] = edge[i][1];
				check[edge[i][1]][0] = now[1];
				check[edge[i][1]][1] = edge[i][2]+edge[i][3];
			}
			else if (check[edge[i][1]][0]>now[1]+1 ||
				(check[edge[i][1]][0]==now[1]+1 && check[edge[i][1]][1]>edge[i][2]+edge[i][3])) {
				queue[rear++] = edge[i][1];
				check[edge[i][1]][0] = now[1]+1;
				check[edge[i][1]][1] = edge[i][2]+edge[i][3];
			}
		}
	}
}

int main(){ 
	int t, i;

	scanf("%d", &t);
	for (i=0; i<t; i++) {
		input();
		search();

		printf("Test Case %d.\n", i+1);
		if (reachable) {
			printf("Vladimir needs %d litre(s) of blood.\n", check[arrive][0]);
		}
		else {
			printf("There is no route Vladimir can take.\n");
		}
	}
}