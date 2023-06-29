#include <iostream>
#include <sstream>
#include <algorithm>
using namespace std;
#define Inf 9999999
int F_pos[101];
int Dis[501][501];
void initialize(int N)
{
	for (int i = 1; i <= N; ++i) {
		for (int j = 1; j <= N; ++j)
			Dis[i][j] = Inf;
		Dis[i][i] = 0;
	}
}
void floyd(int N)
{
	for (int k = 1; k <= N; ++k)
		for (int i = 1; i <= N; ++i)
			for (int j = 1; j <= N; ++j)
				if (Dis[i][k] + Dis[k][j] < Dis[i][j])
					Dis[i][j] = Dis[i][k] + Dis[k][j];
}
int main()
{
	int test_case, num_fs, num_is;
	cin >> test_case;
	while (test_case--) {
		cin >> num_fs >> num_is;
		for (int i = 0; i < num_fs; ++i)
			cin >> F_pos[i];
		initialize(num_is);
		string str;
		getline(cin, str);
		while (getline(cin, str) && !str.empty()) {
			stringstream ss(str);
			int x, y, L;
			ss >> x >> y >> L;
			Dis[x][y] = L;
			Dis[y][x] = L;
		}
		floyd(num_is);
		/*for (int aa = 1; aa <= num_is; aa++) {
			for (int bb = 1; bb <= num_is; bb++)
				printf("%3d ", Dis[aa][bb]);
			printf("\n");
		}*/
		int s_l[501]; // shortest length
		int max_s_l = 0; // max shortest length
		for (int i = 1; i <= num_is; ++i) {
			s_l[i] = Inf;
			for (int j = 0; j < num_fs; ++j)
				s_l[i] = min(s_l[i], Dis[i][F_pos[j]]);
			max_s_l = max(max_s_l, s_l[i]);
		}
		int Ans = 1;
		int cnt = 0;
		int maxl = 9999999;
		for (int i = 1; i <= num_is; ++i) {
			//(어디 교차로에 소방서를 새로 새워야 할까 ? )
			cnt = 0;
			for (int j = 1; j <= num_is; j++) {
				cnt = max(min(Dis[i][j], s_l[j]),cnt);
			}
			//printf("%d에 소방서 세울 때 max : %d\n",i,cnt);
			if (maxl > cnt) {
				Ans = i;
				maxl = cnt;
			}
		}
		cout << Ans << endl;
		if (test_case)
			cout << endl;
	}
}

/*
1

5 12
2
5
4
12
9
1 2 20
2 3 10
3 4 15
4 5 20
5 6 10
6 1 10
7 2 5
8 7 10
9 10 20
10 1 50
11 8 3
12 3 20

*/