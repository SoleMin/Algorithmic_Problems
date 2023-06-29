#include <iostream>
#include <algorithm>
#define MAXN 5607
#define INF 1000000

using namespace std;

int n, w[MAXN+1], s[MAXN+1], d[MAXN+1][MAXN+1];

void sort(){
	for(int i=1; i<=n; i++){
		for(int j=i+1; j<=n; j++){
			if(s[i] > s[j]){
				swap(s[i], s[j]);
				swap(w[i], w[j]);
			}
		}
	}
}

int dp(){
	int result;
	for(int i=1; i<=n; i++){
		for(int j=1; j<=i; j++){
			if(i-1 < j)
				d[i-1][j] = INF;
			if(d[i-1][j-1] + w[i] <= s[i])
				d[i][j] = min(d[i-1][j-1] + w[i], d[i-1][j]);
			else
				d[i][j] = d[i-1][j];
		}
	}
	for(int i=0; i<=n; i++){
		if(d[n][i] != INF)
			result = i;
	}
	return result;
}

int main() {
	n = 1;
	d[0][0] = 0;
	while(cin >> w[n] >> s[n]){
		d[n][0] = 0;
		d[0][n] = INF;
		n++;
	}
	n = n - 1;
	sort();
	cout << dp() << endl;
	return 0;
}