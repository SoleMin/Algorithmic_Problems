#include <iostream>
using namespace std;

static int n, carlength, carlengthsum, m, d[100*100 + 1][2];
static int from[100 * 2 + 1][100 * 100 + 1][2], top, stack[100 * 2];

void solve(int carnum) {
	for(int i = n; i >= carlength; i--) {
		if(d[i-carlength][0] != -1 && carlengthsum - i + carlength <= n && d[i][0] < carnum) {
			d[i][0] = carnum;
			d[i][1] = carlengthsum - i + carlength;
			from[carnum][i][0] = d[i - carlength][0];
			from[carnum][i][1] = carlength;
			if(d[m][0] < d[i][0] || (d[m][0] == d[i][0] && abs(m - d[m][1]) > abs(i-d[i][1]))) m = i;
		}
	}
}

void output (int t) {
	int j, k;
	top = 0;
	for(int i = d[m][0], j = m; i > 0; j-= from[i][k][1], i = from[i][k][0]) {
		stack[top++] = 1;
		for(int k = i-1; k > from[i][j][0]; k--) {
			stack[top++] = 0;
		}
		k = j;
	}
	
	if(t > 0) {
		cout << endl;
	}
	cout << d[m][0] << endl;
}

int main() {
	
	int t;
	cin >> t;
	
	for(int i = 0; i < t; i++) {
		cin >> n;
		n *= 100;
		for(int j = 0; j <= n; j++) {
			d[j][0] = -1;
			d[j][1] = 0;
			d[j][2] = 0;
		}
		d[0][0] = 0;
		carlengthsum = 0;
		m = 0;
		
		for(int j = 0; cin >> carlength, carlength != 0; j++) {
			if(carlengthsum <= 2 * n) {
				solve(j+1);
				carlengthsum += carlength;
			}
		}
		
		output(i);
	}
	
	return 0;
}