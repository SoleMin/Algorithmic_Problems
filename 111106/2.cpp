#include <iostream>
#define MAXL 100
using namespace std;
static int n, carlength, carlengthsum, mmax, dynamic[MAXL * 100 + 1][2];
static int from[MAXL * 2 + 1][MAXL * 100 + 1][2], top, stack[MAXL * 2];

void solve(int carnum) {
	for (int i = n; i >= carlength; i--) {
		if (dynamic[i - carlength][0] != -1 && carlengthsum - i + carlength <= n && dynamic[i][0] < carnum) {
			dynamic[i][0] = carnum;
			dynamic[i][1] = carlengthsum - i + carlength;
			from[carnum][i][0] = dynamic[i - carlength][0];
			from[carnum][i][1] = carlength;
			if (dynamic[mmax][0] < dynamic[i][0] || (dynamic[mmax][0] == dynamic[i][0] && abs(mmax - dynamic[mmax][1]) > abs(i - dynamic[i][1])))
				mmax = i;
		}
	}
}

void output(int t) {
	int k;
	k = top = 0;
	for (int i = dynamic[mmax][0], j = mmax; i > 0; j -= from[i][k][1], i = from[i][k][0]) {
		stack[top++] = 1;
		for (k = i - 1; k > from[i][j][0]; k--)
			stack[top++] = 0;
		k = j;
	}
	if (t > 0)
		cout << endl;
	
	cout << dynamic[mmax][0] << endl;
	
}

int main() {
	int t;
	cin >> t;
	
	for (int i = 0; i < t; i++) {
		cin >> n;
		n *= 100;
		for (int j = 0; j <= n; j++) {
			dynamic[j][0] = -1;
			dynamic[j][1] = 0;
		}
		dynamic[0][0] = 0;
		carlengthsum = 0;
		mmax = 0;
		for (int j = 0; cin >> carlength, carlength!= 0; j++) {
			if (carlengthsum <= 2 * n) {
				solve(j + 1);
				carlengthsum += carlength;
			}
		}
		output(i);
	}
}