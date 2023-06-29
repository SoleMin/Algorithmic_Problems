#include<iostream>
#include<cstring>

using namespace std;

static int train_num, n, ne, start, finish, reachable, edges[1000][4], check[100][2];
static char city[100][33];
static int front, rear, queue[10000];

int getcity(char* name)
{
	for (int i = 0;i < n; i++)
	{
		if (strcmp(name, city[i]) == 0)
			return i;
	}
	strcpy(city[n], name);
	return n++;
}

int main()
{
	
	int testcase;

	cin >> testcase;

	for (int i = 0; i < testcase; i++)
	{
		int t1, t2;
		char name1[1001], name2[1001];
		
		n = ne = 0;
		
		cin >> train_num;
		for (int j = 0; j < train_num; j++)
		{
			cin >> name1 >> name2 >> t1 >> t2;
			t1 %= 24;
			
			if ((t1 >= 6 && t1 < 18) || (t1 < 6 && t2>6 - t1) || (t1 >= 18 && t2 > 30 - t1))
			{
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
		finish = getcity(name2);
		
		int now[3];
		front = 0;
		rear = 0;
		reachable = 0;
		
		for (int j = 0; j < n; j++)
			check[j][0] = 10000;
		queue[rear++] = start;
		check[start][0] = 0;
		check[start][1] = 0;
		while (front < rear)
		{
			now[0] = queue[front++];
			now[1] = check[now[0]][0];
			now[2] = check[now[0]][1];
			if (now[0] == finish)
			{
				reachable = 1;
				continue;
			}
			for (int k = 0; k < ne; k++)
			{
				if (edges[k][0] != now[0])
					continue;
				if (now[2] <= edges[k][2] && (check[edges[k][1]][0] > now[1] || (check[edges[k][1]][0] == now[1] && check[edges[k][1]][1] > edges[k][2] + edges[k][3])))
				{
					queue[rear++] = edges[k][1];
					check[edges[k][1]][0] = now[1];
					check[edges[k][1]][1] = edges[k][2] + edges[k][3];
				}
				else if(check[edges[k][1]][0] > now[1]+1 || (check[edges[k][1]][0]==now[1]+1 && check[edges[k][1]][1]>edges[k][2]+edges[k][3]))
				{
					queue[rear++]=edges[k][1];
					check[edges[k][1]][0]=now[1]+1;
					check[edges[k][1]][1]=edges[k][2]+edges[k][3];
				}
			}
		}
		
		cout << "Test Case " << i+1 << "." << endl;
		if (reachable)
			cout << "Vladimir needs " << check[finish][0] << " litre(s) of blood." << endl;
		else
			cout << "There is no route Vladimir can take." << endl;
	}

	return 0;
}