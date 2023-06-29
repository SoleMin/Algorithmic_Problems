#include <iostream>
#define MAX 200

using namespace std;

int n, g[MAX][MAX];
int result, ncolor[MAX];

void dfs(int nd, int c){
	ncolor[nd] = c;
	for(int i=0; i<n && result; i++){
		if(g[nd][i] == 0)
			continue;
		if(ncolor[i] == 0){
			dfs(i, c%2 + 1);
		}
		else if(ncolor[i] == c){
			result = 0;
			return;
		}
	}
}

int main() {
	int l, a, b;
	while(1){
		cin >> n;
		if(!n)
			break;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				g[i][j] = 0;
			}
			ncolor[i] = 0;
		}
		cin >> l;
		for(int i=0; i<l; i++){
			cin >> a >> b;
			g[a][b] = g[b][a] = 1;
		}
		
		result = 1;
		dfs(0, 1);
		if(result)
			cout << "BICOLORABLE." << endl;
		else
			cout << "NOT BICOLORABLE." << endl;
	}

	return 0;
}