#include <iostream>
#include <sstream>
#include <algorithm>

using namespace std;

#define INF 9999999;

int F_pos[101];
int Dis[501][501];

void initialize(int n)
{
	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= n; j++)
			Dis[i][j] = INF;
		Dis[i][i] = 0;
	}
}

void floyd(int n)
{
	for (int k = 1; k <= n; k++)
	{
		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= n; j++)
			{
				if (Dis[i][k] + Dis[k][j] < Dis[i][j])
					Dis[i][j] = Dis[i][k] + Dis[k][j];;
			}
		}
	}
}

int main()
{
	int test_case, num_fs, num_is;
	cin >> test_case;
	while (test_case--)
	{
		cin >> num_fs >> num_is;
		for (int i = 0; i < num_fs; i++)
			cin >> F_pos[i];

		initialize(num_is);

		string str;
		getline(cin, str);
		while (getline(cin, str) && !str.empty())
		{
			stringstream ssr(str);
			int x, y, L;
			ssr >> x >> y >> L;
			Dis[x][y] = L;
			Dis[y][x] = L;
		}

		floyd(num_is);

		int s_l[501];
		int max_s_l = 0;

		for (int i = 1; i <= num_is; i++)
		{
			s_l[i] = INF;
			for (int j = 0; j < num_fs; j++)
				s_l[i] = min(s_l[i], Dis[i][F_pos[j]]);
			max_s_l = max(max_s_l, s_l[i]);
		}

		int Ans = 1;

		for (int i = 1; i <= num_is; i++)
		{
			int new_length = 0;
			int short_length = 0;
			for (int j = 1; j <= num_is; j++)
			{
				short_length = min(Dis[i][j], s_l[j]); 
				//소방서 거리하고 도로간 거리중에 짧은 거리 선택
				new_length = max(new_length, short_length);
				// 새로운 거리하고 짧은거리중에서 더 먼 거리 선택
			}

			//만약 새로운 거리가 계산한 소방서의 거리보다 짧을경우 
			// 그곳으로 소방서 세움
			if (new_length < max_s_l)
			{
				max_s_l = new_length;
				Ans = i;
			}
		}

		cout << Ans << '\n';
		if (test_case)
			cout << '\n';
	}




}