#include <bits/stdc++.h>
using namespace std;

int nod[201][201], c[201], last[201],bi,n;

void dfs(int index) {
	for (int i = 0; i < last[index]; i++) {
		if (c[nod[index][i]] < 0) {
			c[index] == 0 ? c[ nod[index][i]] =1:c[nod[index][i]] = 0;
			dfs(nod[index][i]);
		}
		if (c[nod[index][i]] == c[index]) {
			bi = 0;
			return;
		}
	}
	return;
}

int main()
{
	int q, a, b;

	cin>>n;
	while (n != 0) {
		for (int i = 0; i < 201; i++) {
			for (int j = 0; j <201; j++)
				nod[i][j] = -1;
			last[i] = 0;
			c[i] = -1;
		}

		cin>>q;
		while (q--) {
			cin>>a>>b;
			nod[a][last[a]++] = b;
			nod[b][last[b]++] = a;
		}

		bi = 1;
		c[0] = 0;
		dfs(0);

		if (bi == 0)
			cout<<"NOT BICOLORABLE."<<endl;
		else
			cout<<"BICOLORABLE."<<endl;
		cin>>n;
	}
	return 0;
}