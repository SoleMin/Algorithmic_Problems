#include <iostream>
#include <cstring>
using namespace std;

int n, e, ne, start, finish, reachable, edge[1000][4], check[100][2];
int front, rear, queue[10000];
char city[100][33];

int getcity(char *name) {
	
	for(int i = 0; i < n; i++) {
		if(strcmp(name, city[i]) == 0) return i;	
	}
	
	strcpy(city[n], name);
	return n++;
}

void input() {
	
	int t1, t2;
	char name1[33], name2[33];
	
	n = ne = 0;
	
	cin >> e;
	for(int i = 0; i < e; i++) {
		cin >> name1 >> name2 >> t1 >> t2;
		t1 = t1 % 24;
		
		if((t1 >= 6 && t1 < 18) || (t1 < 6 && t2 > 6 - t1) || (t1 >= 18 && t2 > 30 - t1)) continue;
		
		edge[ne][0] = getcity(name1);
		edge[ne][1] = getcity(name2);
		edge[ne][2] = (t1 + 12) % 24;
		edge[ne][3] = t2;
		ne += 1;
	}
	
	cin >> name1 >> name2;
	start = getcity(name1);
	finish = getcity(name2);
	
}

void bfs() {
	
	int now[3];
	front = 0;
	rear = 0;
	reachable = 0;
	
	for(int i = 0; i < n; i++) check[i][0] = 10000;
	
	queue[rear++] = start;
	check[start][0] = 0;
	check[start][1] = 0;
	
	while(front < rear) {
		
		now[0] = queue[front++];
		now[1] = check[now[0]][0];
		now[2] = check[now[0]][1];
		
		if(now[0] == finish) {
			reachable = 1;
			continue;
		}
		
		for(int i = 0; i < ne; i++) {
			if(edge[i][0] != now[0]) continue;
			if(now[2] <= edge[i][2] && (check[edge[i][1]][0] > now[1] || (check[edge[i][1]][0] == now[1] && check[edge[i][1]][1] > edge[i][2] + edge[i][3]))) {
				queue[rear++] = edge[i][1];
				check[edge[i][1]][0] = now[1];
				check[edge[i][1]][1] = edge[i][2] + edge[i][3];
			}
			
			else if(check[edge[i][1]][0] > now[1] + 1 || (check[edge[i][1]][0] == now[1] + 1 && check[edge[i][1]][1] > edge[i][2] + edge[i][3])) {
				queue[rear++] = edge[i][1];
				check[edge[i][1]][0] = now[1] + 1;
				check[edge[i][1]][1] = edge[i][2] + edge[i][3];
			}
		}
		
	}
	
}

int main() {
	
	int t_case;
	cin >> t_case;
	
	for(int i = 1; i <= t_case; i++) {
		input();
		bfs();
		
		cout << "Test Case " << i << "." << endl;
		if(reachable) cout << "Vladimir needs " << check[finish][0] << " litre(s) of blood." << endl;
		else cout << "There is no route Vladimir can take." << endl;
	}
	
	return 0;
}