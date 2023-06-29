#include <iostream>
#include <algorithm>
using namespace std;

static int n, dap;
static int x[1001], y[1001], c[1001], track[1001], sortidx[1001];
static int sol[1001];

void input() {
	int i = 0;
	while(cin >> x[i] >> y[i]) {
		sortidx[i] = i;
		i++;
	}
	// for(int j = 0; j < i; j++) {
	// 	cout << " " << x[j] << " ";
	// }
	// cout << endl;
	n = i-1;
}

void sortx(void) {
	for(int i = 0; i < n-1; i++) {
		for(int j = i+1; j < n; j++) {
			if(x[i] > x[j]) {
				swap(x[i], x[j]);
				swap(y[i], y[j]);
				swap(sortidx[i], sortidx[j]);
			}
		}
	}	
}

void dp(void) {
	int max, mi;
	
	c[0] = 1;
	track[0] = -1;
	for(int i = 1; i < n; i++) {
		max = 1;
		mi = -1;
		for(int j = 0; j < i; j++) {
			if(c[j] + 1 > max && y[i] < y[j]) {
				max = c[j] + 1;
				mi = j;
			}
		}
		c[i] = max;
		track[i] = mi;
	}
}

void traking(void) {
	int max = -1;
	int mi = -1;
	int j;
	
	for(int i = 0; i < n; i++) {
		if(max < c[i]) {
			max = c[i];
			mi = i;
		}
	}
	
	j = mi;
	dap = 0;
	while(j > 0) {
		sol[dap] = j;
		j = track[j];
		dap++;
	}
}

void output(void) {
	cout << dap << endl;
	for(int i = dap-1; i >= 0; i--) {
		cout << sortidx[sol[i]] + 1 << endl;
	}
}

int main() {
	
	input();
	sortx();
	dp();
	traking();
	output();
	
	return 0;
}