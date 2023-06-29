#include <bits/stdc++.h>
using namespace std;
struct eds {
	int to, l, r;
	eds(int a, int b, int c):
	to(a), l(b), r(c){}
};
vector<eds> g[205];
void sss(int st, int ed) {
	int dist[205][35];
	int inq[205][35] = {};
	memset(dist, 63, sizeof(dist));
	int oo = dist[0][0];
	int i, j, k, w;
	for(i = 0; i < 35; i++)
		dist[st][i] = 0;
	queue<int> Qn, Qt;
	Qn.push(st), Qt.push(18);
	while(!Qn.empty()) {
		int tn = Qn.front();
		int tt = Qt.front();
		Qn.pop(), Qt.pop();
		inq[tn][tt] = 0;
		for(vector<eds>::iterator it = g[tn].begin();
				it != g[tn].end(); it++) {
			if(it->l >= tt)
				w = 0;
			else
				w = 1;
			if(dist[it->to][it->r] > dist[tn][tt] + w) {
				dist[it->to][it->r] = dist[tn][tt] + w;
				if(inq[it->to][it->r] == 0) {
					inq[it->to][it->r] = 1;
					Qn.push(it->to), Qt.push(it->r);
				}
			}
		}
	}
	int ret = oo;
	for(i = 0; i < 35; i++)
		ret = min(ret, dist[ed][i]);
	if(ret == oo)
		cout<<"There is no route Vladimir can take."<<endl;
	else
		printf("Vladimir needs %d litre(s) of blood.\n", ret);
}
int main() {
	int test, cases = 0;
	int n, i, j;
	char s1[105], s2[105];
	cin>>test;
	while(test--){
		cin>>n;
		map<string, int> R;
		for(i=0; i < 200; i++)
			g[i].clear();
		int size = 0;
		while(n--) {
			int stime, htime;
			cin>>s1>>s2>>stime>>htime;
			int &x = R[s1];
			int &y = R[s2];
			if(x == 0)
				x = ++size;
			if(y == 0)
				y = ++size;
			if(stime < 6)
				stime += 24;
			if(stime + htime > 24 + 6 || stime < 18)
				continue;
			g[x].push_back(eds(y, stime, stime+htime));
		}
		cin>>s1>>s2;
		printf("Test Case %d.\n", ++cases);
		int &x = R[s1];
		int &y = R[s2];
		if(x == 0)
			x = ++size;
		if(y == 0)
			y = ++size;
		sss(x, y);
	}
	return 0;
}