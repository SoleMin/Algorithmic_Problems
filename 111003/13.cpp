#include <iostream>
#include <sstream>
#include <algorithm>

using namespace std;

#define Inf 9999999

int F_pos[101]; //소방서의 위치
int Dis[501][501]; //교차로와 교차로의 거리

void initialize(int N) {
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

int main(void) {
	int test_case, num_fs, num_is; //테케 갯수, 소방서 개수, 교차로 개수
	cin >> test_case;
	while (test_case--) {
		cin >> num_fs >> num_is;
		for (int i = 0; i < num_fs; ++i)
			cin >> F_pos[i]; //소방서의 위치를 입력받기
		initialize(num_is);
		string str; //갑분 문자열
		getline(cin, str); //한줄 입력받아
		while (getline(cin, str) && !str.empty()) {
			stringstream ss(str);
			int x, y, L;
			ss >> x >> y >> L;
			Dis[x][y] = L;
			Dis[y][x] = L;
		}// 단순하게 파싱하는 역할
		floyd(num_is);

		int s_l[501]; // shortest length
		int max_s_l = 0; // max shortest length
		for (int i = 1; i <= num_is; ++i) {
			s_l[i] = Inf;
			for (int j = 0; j < num_fs; ++j)
				s_l[i] = min(s_l[i], Dis[i][F_pos[j]]); //현재 노드에서 가장 가까운 소방서와의 거리
			//cout << "i: " << s_l[i] << endl;
			max_s_l = max(max_s_l, s_l[i]); //가장 먼 거리를 가지는 현재 노드에서 가장 먼 소방서와의 거리
		}
		//cout << max_s_l << endl;
		int Ans = 1;
		int max_val = max_s_l;
		for (int i = 1; i <= num_is; i++) {
			int alt[501];
			int alt_max = 0;
			F_pos[num_fs] = i;
			for (int j = 1; j <= num_is; j++) {
				alt[j] = Inf;
				for (int k = 0; k <= num_fs; k++) {
					alt[j] = min(alt[j], Dis[j][F_pos[k]]);
					//cout << "fire: " << F_pos[k] << endl;
				}
				alt_max = max(alt_max, alt[j]);
			}
			if (alt_max < max_val) {
				max_val = alt_max;
				//cout << "here";
				Ans = i;
			}
			//cout << "alt_max: " << alt_max << endl;
		}
		
		cout << Ans << endl;
		if (test_case)
			cout << endl;
	}
}