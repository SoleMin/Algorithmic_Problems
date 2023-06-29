#include <iostream>
#include <string>
#include <queue>
#define MAXN 100
#define MAXE 1000
#define MAXQ 10000

using namespace std;

int n, ne, start, fin, result, edges[MAXE][4], check[MAXN][2];
string city[MAXN];

int getcity(string name)
{
	for(int i=0; i<n; i++){
		if(name == city[i])
			return i;
	}
	city[n] = name;
	return n++;
}

void input(){
	int e, t1, t2;
	string name1, name2;
	n = ne = 0;
	cin >> e;
	for(int i=0; i<e; i++){
		cin >> name1 >> name2 >> t1 >> t2;
		t1 %= 24;
		if((t1 >= 6 && t1 < 18) || (t1 < 6 && t2 > 6 - t1) || (t1 >= 18 && t2 > 30 - t1)){
			continue;
		}
		edges[ne][0] = getcity(name1);
		edges[ne][1] = getcity(name2);
		edges[ne][2] = (t1 + 12) % 24;
		edges[ne][3] = t2;
		ne++;
	}
	cin >> name1 >> name2;
	start = getcity(name1);
	fin = getcity(name2);
}

void bfs(){
	int now[3];
	queue<int> q;
	result = 0;
	for(int i=0; i<n; i++){
		check[i][0] = 10000;
	}
	q.push(start);
	check[start][0] = 0;
	check[start][1] = 0;
	while(!q.empty()){
		now[0] = q.front();
		now[1] = check[now[0]][0];
		now[2] = check[now[0]][1];
		q.pop();
		if(now[0] == fin){
			result = 1;
			continue;
		}
		for(int i=0; i<ne; i++){
			if(edges[i][0] != now[0])
				continue;
			if(now[2] <= edges[i][2] && (check[edges[i][1]][0] > now[1] || (check[edges[i][1]][0] == now[1] && check[edges[i][1]][1] > edges[i][2] + edges[i][3]))){
				q.push(edges[i][1]);
				check[edges[i][1]][0] = now[1];
				check[edges[i][1]][1] = edges[i][2] + edges[i][3];
			}
			else if(now[2] > edges[i][2] && (check[edges[i][1]][0] > now[1] || (check[edges[i][1]][0] == now[1] && check[edges[i][1]][1] > edges[i][2] + edges[i][3]))){
				q.push(edges[i][1]);
				check[edges[i][1]][0] = now[1] + 1;
				check[edges[i][1]][1] = edges[i][2] + edges[i][3];
			}
		}
	}
}


int main() {
	int t;
	cin >> t;
	for(int i=1; i<=t; i++){
		input();
		bfs();
		
		cout << "Test Case " << i << "." << endl;
		if(result)
			cout << "Vladimir needs " << check[fin][0] << " litre(s) of blood." << endl;
		else
			cout << "There is no route Vladimir can take." << endl;
	}

	return 0;
}