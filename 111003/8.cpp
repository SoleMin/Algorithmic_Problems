#include <iostream>
#include <sstream>
#include <algorithm>
using namespace std;
#define Inf 9999999

int F_pos[101];
int Dis[501][501];

void First(const int &N);
void Second(const int &N);

int main()
{
	int Testcase, F, I;
	cin >> Testcase;
	while (Testcase--)
	{
		cin >> F >> I;
		for (int i = 0; i < F; ++i)
			cin >> F_pos[i];

		First(I);

		string str; getline(cin, str);
		while (getline(cin, str) && !str.empty()) 
		{
			stringstream ss(str);
			int x, y, L;
			ss >> x >> y >> L;
			Dis[x][y] = L;
			Dis[y][x] = L;
		}

		Second(I);

		int s_l[501];  
		int max_s_l = 0;  
		for (int i = 1; i <= I; ++i) 
		{
			s_l[i] = Inf;
			for (int j = 0; j < F; ++j)
				s_l[i] = min(s_l[i], Dis[i][F_pos[j]]);
			max_s_l = max(max_s_l, s_l[i]);
		}

		int Ans = 1;
		for (int i = 1; i <= I; ++i) 
		{
			int new_length = 0;
			for (int j = 1; j <= I; ++j)
			{
				int tmp = min(Dis[i][j], s_l[j]);
				new_length = max(new_length, tmp);
			}
			if (new_length < max_s_l)
			{
				max_s_l = new_length;
				Ans = i;
			}
		}
		
		cout << Ans << endl;
		
		if (Testcase)
			cout << endl;
	}
}

void First(const int &N)
{
	for (int i = 1; i <= N; ++i)
	{
		for (int j = 1; j <= N; ++j)
			Dis[i][j] = Inf;
		Dis[i][i] = 0;
	}
}
void Second(const int &N)
{
	for (int k = 1; k <= N; ++k)
	for (int i = 1; i <= N; ++i)
	for (int j = 1; j <= N; ++j)
	if (Dis[i][k] + Dis[k][j] < Dis[i][j])
		Dis[i][j] = Dis[i][k] + Dis[k][j];
}