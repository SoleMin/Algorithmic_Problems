#include <iostream>
#include <queue>
#include <stack>

#define MAXN 100
#define MAXE 1000
#define MAXNAME 32
#define MAXQUEUESIZE 10000

using namespace std;

class graph {
private:
	int n, e, ne, start, finish, reachable, edges[MAXE][4], check[MAXN][2];
	string city[MAXN];
	
public:
	graph() {
		n = 0;
		ne = 0;
		reachable = 0;
		
	}

	// 스타트
	void run() {
		input();
		bfs();
		print_ans();
	}

	// 그래프 값넣기
	void input() {
		int t1, t2;
		string name1, name2;
		cin >> e;
		for(int i = 0;i<e;i++){
			cin >> name1 >> name2 >> t1 >> t2;
			t1 = t1 % 24;
			
			if((t1>=6 && t1<18) || (t1<6 && t2>6-t1) || (t1>=18 && t2>30-t1))
				continue;
			edges[ne][0] = getcity(name1);
			edges[ne][1] = getcity(name2);
			edges[ne][2] = (t1 + 12) % 24;
			edges[ne][3] = t2;
			ne++;
		}
		cin >> name1 >> name2;
		start = getcity(name1);
		finish = getcity(name2);
	}
	
	int getcity(string name){
		for(int i=0;i<n;i++){
			if(name == city[i])
				return i;
		}
		city[n] = name;

		return n++;
	}
	
	void bfs() {
		queue<int> q;
		int now[3];
		
		for(int i=0;i<n;i++)
			check[i][0] = 10000;
		
		q.push(start);
		check[start][0] = 0;	// 피
		check[start][1] = 0;	// 거리
		for(;!(q.empty());){
			
			now[0] = q.front();
			q.pop();
			now[1] = check[now[0]][0];
			now[2] = check[now[0]][1];
			
			if(now[0] == finish){
				reachable = 1;
				continue;
			}
			for(int i=0;i<ne;i++){
				if(edges[i][0] != now[0]) continue;
				
				if(now[2] <= edges[i][2] && (check[edges[i][1]][0] > now[1] || 
																		 (check[edges[i][1]][0] == now[1] && check[edges[i][1]][1] > edges[i][2] + edges[i][3] ))){
					q.push(edges[i][1]);
					check[edges[i][1]][0] = now[1];
					check[edges[i][1]][1] = edges[i][2] + edges[i][3];
				}
				// 하루 후
				else if((check[edges[i][1]][0] > now[1]+1 || (check[edges[i][1]][0] == now[1]+1 && check[edges[i][1]][1] > edges[i][2] + edges[i][3] ))){
					q.push(edges[i][1]);
					check[edges[i][1]][0] = now[1]+1;
					check[edges[i][1]][1] = edges[i][2] + edges[i][3];
				}
			}
			
		}
	}

	void print_ans() {
		
		if (reachable == 1) {
			cout << "Vladimir needs "<< check[finish][0] << " litre(s) of blood." << endl;
		}
		else {
			cout << "There is no route Vladimir can take." << endl;
		}
	}

};


int main() {
	int n;
	cin >> n;
	for (int i=0; i<n;i++) {
		cout << "Test Case " << i+1 << "." <<endl;
		graph a;
		a.run();
	}
}