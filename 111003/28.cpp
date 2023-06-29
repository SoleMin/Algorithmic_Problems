#include <iostream>
#include <sstream>
#include <algorithm>
using namespace std;
#define Inf 999999
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
		cin >> num_fs >> num_is; //fs = 기존의 소방서개수 is = 교차로 개수
		for (int i = 0; i < num_fs; ++i)
			cin >> F_pos[i]; //기존의소방서의 교차로 번호
		initialize(num_is); // 교차로 개수 초기화
		string str;
		getline(cin, str);
		while (getline(cin, str) && !str.empty()) {
			stringstream ss(str);//x = 교차로 번호,  y= 다른교차로의 번호, L = 두 교차로를 연결하는 도로의 길(weight)
			int x, y, L;
			ss >> x >> y >> L;
			Dis[x][y] = L;
			Dis[y][x] = L;
		} // 교차로 edge 가중치 설정
		floyd(num_is); // 플로이드 알고리즘 실행
		int s_l[501]; // shortest length 최단경로
		int max_s_l = 0; // max shortest length 최단경로중 가장 큰 값
		int Ans=0;
		for (int i = 1; i <= num_is; ++i) {
			s_l[i] = Inf;
			for (int j = 0; j < num_fs; ++j)
				s_l[i] = min(s_l[i], Dis[i][F_pos[j]]); // 기존 소방서와 i의 거리와 교차로의 최단거리
			if (max_s_l > max(max_s_l, s_l[i]))Ans = i;
			max_s_l = max(max_s_l, s_l[i]);// 현재소방서들의 위치에서 도달할 수 있는 가장 먼 교차로 까지의 거리
			
		}
		int result=Inf;
		max_s_l = 0;
		for (int i = 1; i <= num_is; ++i) {//첫번째 교차로 부터 마지막 교차로까지
			//소방서가 존재하지 않는 모든 교차로에 새로운 소방서가 만들어졌다고 가정하고 가장 먼 교차로까지의 거리를 계산한 후 이 거리가 가장 짧은 교차로 번호를 출력한다.
			max_s_l = 0;
			for (int k = 1; k <= num_is; ++k) {
				s_l[k] = Inf;
				for (int j = 0; j < num_fs; ++j)
					s_l[k] = min(s_l[k], Dis[k][F_pos[j]]); // 기존 소방서와 k의 거리와 교차로의 최단거리
				s_l[k] = min(s_l[k], Dis[k][i]);
				max_s_l = max(max_s_l, s_l[k]);// 현재소방서들의 위치에서 도달할 수 있는 가장 먼 교차로 까지의 거리
			}
			if (result > max_s_l) {
				Ans = i;
				result = max_s_l;
			}
		}
		cout << Ans << endl;
		if (test_case)
			cout << endl;
	}
}
