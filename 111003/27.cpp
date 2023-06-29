#include <bits/stdc++.h>
using namespace std;
#define Inf 9999999
int pos[100];
int Dis[500][500];

void Initial(const int &N)
{
	for (int i = 1; i <= N; ++i) {
		for (int j = 1; j <= N; ++j)
			Dis[i][j] = Inf;
		Dis[i][i] = 0;
	}
}
void yd(const int &N)
{
	for (int k = 1; k <= N; ++k)
		for (int i = 1; i <= N; ++i)
			for (int j = 1; j <= N; ++j)
				if (Dis[i][k] + Dis[k][j] < Dis[i][j])
					Dis[i][j] = Dis[i][k] + Dis[k][j];
}

int main()
{
	ios::sync_with_stdio(false);
	int cc, F, I;
	cin >> cc;
	while (cc--)
	{
		cin >> F >> I;
		for (int i = 0; i < F; ++i)
			cin >> pos[i];

		Initial(I);

		string str; getline(cin, str);
		while (getline(cin, str) && !str.empty()) {
			stringstream ss(str);
			int x, y, L;
			ss >> x >> y >> L;
			Dis[x][y] = L;
			Dis[y][x] = L;
		}

		yd(I);

		int s_l[501];
		int max_s_l = 0;
		for (int i = 1; i <= I; ++i) {
			s_l[i] = Inf;
			for (int j = 0; j < F; ++j)
				s_l[i] = min(s_l[i], Dis[i][pos[j]]);
			max_s_l = max(max_s_l, s_l[i]);
		}

		int Ans = 1;
		for (int i = 1; i <= I; ++i) {
			int new_length = 0;
			for (int j = 1; j <= I; ++j) {
				int shorter = min(Dis[i][j], s_l[j]);
				new_length = max(new_length, shorter);
			}
			if (new_length < max_s_l) {
				max_s_l = new_length;
				Ans = i;
			}
		}
		cout << Ans << endl;
		if (cc) 
			cout << endl;
	}
}