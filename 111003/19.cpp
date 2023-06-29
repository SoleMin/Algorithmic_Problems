#include <iostream>
#include <sstream>
#include <string>
#include <algorithm>
#define Inf 9999999

using namespace std;

int f_pos[101], dis[501][501];

void floyd(int N){
	for(int k=1; k<=N; k++)
		for(int i=1; i<=N; i++)
			for(int j=1; j<=N; j++)
				if(dis[i][k] + dis[k][j] < dis[i][j])
					dis[i][j] = dis[i][k] + dis[k][j];
}

int main() {
	int t, nf, ni;
	cin >> t;
	for(; t>0; t--){
		cin >> nf >> ni;
		for(int i=0; i<nf; i++){
			cin >> f_pos[i];
		}
		
		for (int i=1; i<=ni; i++) {
			for (int j=1; j<=ni; j++)
				dis[i][j] = Inf;
			dis[i][i] = 0;
		}
		
		cin.ignore();
		string line;
		while(getline(cin, line) && line.length()){
			stringstream ss(line);
			int x, y, L;
			ss >> x >> y >> L;
			dis[x][y] = L;
			dis[y][x] = L;
		}
		
		floyd(ni);
		
		int s_l[501];
		int max_s_l = 0;
		for(int i=1; i<=ni; i++){
			s_l[i] = Inf;
			for(int j=0; j<nf; j++)
				s_l[i] = min(s_l[i], dis[i][f_pos[j]]);
			max_s_l = max(max_s_l, s_l[i]);
		}
		int ans = 1;
		for(int i=1; i<=ni; i++){
			int s[501];
			int m = 0;
			if(s_l[i] == 0)
				continue;
			for(int j=1; j<=ni; j++){
				s[j] = min(s_l[j], dis[j][i]);
				m = max(m, s[j]);
			}
			if(m < max_s_l){
				max_s_l = m;
				ans = i;
			}
		}
		cout << ans << endl << endl;
	}
	return 0;
}