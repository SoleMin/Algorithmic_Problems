#include <iostream>
#include <algorithm>

#define Inf 9999999

using namespace std;

void init_(int);
void floyd(int);
int solve(int*, int);

int F_pos[101];
int Dis[501][501];
int num_fs, num_is;

int main() {
	int T;
	cin >> T;
	while (T--) {
		bool F[101] = { 0, };
		cin >> num_fs >> num_is;
		for (int i = 0; i < num_fs; ++i) {
			cin >> F_pos[i];
			F[F_pos[i]] = true;
		}
		init_(num_is);
		for (int i = 0; i < num_is; i++) {
			int x, y, L;
			cin >> x >> y >> L;
			Dis[x][y] = L;
			Dis[y][x] = L;
		}
		floyd(num_is);
		int s_l[501]; // shortest length
		int max_s_l = 0; // max shortest length
		for (int i = 1; i <= num_is; ++i) {
			s_l[i] = Inf;
			for (int j = 0; j < num_fs; ++j)
				s_l[i] = min(s_l[i], Dis[i][F_pos[j]]); // 가장 가까운 소방서 계산
			max_s_l = max(max_s_l, s_l[i]);
		}
		int min_i = Inf;
		int Ans = 1;
		for (int i = 1; i <= num_is; i++) {
			if (!F[i]) {
				int temp = solve(s_l, i);
				if (min_i > temp) {
					min_i = temp;
					Ans = i;
				}
			}
		}
		cout << Ans << endl;
		if (T)
			cout << endl;
	}
}

void init_(int N) {
	for (int i = 1; i <= N; ++i) {
		for (int j = 1; j <= N; ++j)
			Dis[i][j] = Inf;
		Dis[i][i] = 0;

	}
}

void floyd(int N) {
	for (int k = 1; k <= N; ++k)
		for (int i = 1; i <= N; ++i)
			for (int j = 1; j <= N; ++j)
				if (Dis[i][k] + Dis[k][j] < Dis[i][j])
					Dis[i][j] = Dis[i][k] + Dis[k][j];
}

int solve(int s_l[501], int new_F) {
	int temp[501];
	for (int i = 0; i < 501; i++)
		temp[i] = s_l[i];
	int max_s_l = 0;
	for (int i = 1; i <= num_is; ++i) {
		temp[i] = min(temp[i], Dis[i][new_F]);
		max_s_l = max(max_s_l, temp[i]);
	}
	return max_s_l;
}