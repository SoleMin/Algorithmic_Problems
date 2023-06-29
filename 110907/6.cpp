#include <iostream>
#include <string>
#include <queue>

using namespace std;

#define MAXN 100
#define MAXE 1000

static int n, e, ne, start, finish, reachable, edges[MAXN][4], check[MAXN][2];
static string city[MAXN];
static int front, rear;

int getcity(string name)
{
	int i;

	for (i = 0; i < n; i++)
	{
		if (name == city[i])
			return i;
	}

	city[n] = name;
	return n++;
}

void input()
{
	int i, a, b, t1, t2;
	string name1, name2;

	n = ne = 0;

	cin >> e;

	for (i = 0; i < e; i++)
	{
		cin >> name1 >> name2 >> t1 >> t2;
		t1 %= 24;

		if ((t1 >= 6 && t1 < 18) || (t1 < 6 && t1 + t2> 6) || (t1 >= 18 && t1 + t2 > 30))
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

void bfs()
{
	int i, t, now[3];

	reachable = 0;

	for (i = 0; i < n; i++)
		check[i][0] = 10000;

	check[start][0] = 0;
	check[start][1] = 0;

	queue<int> que;
	que.push(start);

	while (!que.empty())
	{
		now[0] = que.front();
		que.pop();
		now[1] = check[now[0]][0];
		now[2] = check[now[0]][1];

		if (now[0] == finish)
		{
			reachable = 1;
			continue;
		}

		for (i = 0; i < ne; i++)
		{
			if (edges[i][0] != now[0])
				continue;
			// 현재 도시에 도착한 시간이 현재 도시에서 출발할 시간보다 이전에 와야되며
			// 현재 도시까지 필요한 혈액량이 도착할 도시의 혈액량보다 적어야 되며
			// 현재 도시까지 필요한 혈액량이 도착할 도시의 혈액량보다 같을 경우 도착할 도시의 시간보다 현재 노선에서 출발시간 + 도착시간이 적어야 된다.
			if (now[2] <= edges[i][2] && (check[edges[i][1]][0] > now[1] || (check[edges[i][1]][0] == now[1] && check[edges[i][1]][1] > edges[i][2] + edges[i][3])))
			{
				que.push(edges[i][1]);
				check[edges[i][1]][0] = now[1];
				check[edges[i][1]][1] = edges[i][2] + edges[i][3];
			}

			// 하루뒤에 출발할 경우
			// 도착할 도시의 필요한 혈액량보다 현재 도시의 혈액량+1의 값이 적어야되며
			// 현재 도시의 필요한 혈액량이 도착할 도시의 혈액량이 같을 경우 도착할 도시의 시간보다 현재노선에서 출발시간 + 도착시간이 적어야된다.
			else if (check[edges[i][1]][0] > now[1] + 1 || (check[edges[i][1]][0] == now[1] + 1 && check[edges[i][1]][1] > edges[i][2] + edges[i][3]))
			{
				que.push(edges[i][1]);
				check[edges[i][1]][0] = now[1] + 1;
				check[edges[i][1]][1] = edges[i][2] + edges[i][3];
			}

		}
	}
}

int main()
{
	int i, t;
	cin >> t;

	for (i = 1; i <= t; i++)
	{
		input();
		bfs();
		cout << "Test Case" << ' ' << i << '.' << '\n';

		if (reachable)
			cout << "Vladimir needs " << check[finish][0] << ' ' << "litre(s) of blood.\n";
		else
			cout << "There is no route Vladimir can take.\n";
	}
}