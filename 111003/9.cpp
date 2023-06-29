#include <iostream>
#include <sstream>
#include <algorithm>
using namespace std;
#define Inf 9999999

int F_pos[101];
int Dis[501][501];

void initialize(int N)
{
	for (int i = 1; i <= N; ++i) 
	{
		for (int j = 1; j <= N; ++j)
			Dis[i][j] = Inf; //모든거리에 연결점이 없다고 가정하여 초기화
		Dis[i][i] = 0; //자기자신의 거리는 0
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
	cin >> test_case; //테스트케이스의 수를 입력받음.
	while (test_case--) 
	{
		cin >> num_fs >> num_is; //소방서의수와 교차로의수를 입력받음.
		for (int i = 0; i < num_fs; ++i) //그 소방서들이 어디에 있는가?
			cin >> F_pos[i];
		
		initialize(num_is); //교차로 정보초기화
		
		string str;
		getline(cin, str);
		
		while (getline(cin, str) && !str.empty()) //교차로의 정보를 입력받음.
		{
			stringstream ss(str);
			int x, y, L;
			ss >> x >> y >> L; //x에서 y , y에서 x까지의 거리가 L이다.
			Dis[x][y] = L;
			Dis[y][x] = L;
		}
		floyd(num_is); //각 교차로에서 다른 교차로까지들의 거리를 모두 계산.
		
		int s_l[501]; // shortest length
		int max_s_l = 0; // max shortest length
		int best[501][501]={0,};
		int good = 0;
		int answer = Inf;
		for (int i = 1; i <= num_is; ++i) 
		{
			s_l[i] = Inf;
			for (int j = 0; j < num_fs; ++j)
				s_l[i] = min(s_l[i], Dis[i][F_pos[j]]); //소방서가 세워진곳은 거리가 0으로 나올것임.
			max_s_l = max(max_s_l, s_l[i]); //현재 세워진 소방서를 기준으로 (최단거리이지만) 제일 거리가 먼교차로의 거리임.
		}
		
		int Ans = 1;
		for (int i = 1; i <= num_is; ++i) 
		{
			good = 0;
			F_pos[num_fs++] = i;
			for (int b = 1; b <= num_is; ++b)
			{
				s_l[b] = Inf;
				for (int j = 0; j < num_fs; ++j)
					s_l[b] = min(s_l[b], Dis[b][F_pos[j]]); //소방서가 세워진곳은 거리가 0으로 나올것임.
				best[i][b] = max(best[i][b] , s_l[b]);
				//printf("[%d] " , best[i][b]);
			}
			for (int b = 1; b <=num_is; ++b)
			{
				good = max(best[i][b] , good);
			}
			if(answer > good)
			{
				answer = good;
				Ans = i;
			}
			num_fs--;
		}
		cout << Ans << endl; //해를 출력.
		if (test_case) //테스트케이스가 여러개라면 개행을함.
			cout << endl;
	}
}