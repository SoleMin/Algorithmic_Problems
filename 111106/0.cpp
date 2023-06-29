#include <iostream>
#define MAXL 100

using namespace std;

int n, carl, sum, m, d[MAXL*100 + 1][2];

void solve(int carn){
	for(int i=n; i>=carl; i--){
		if(d[i - carl][0] != -1 && sum - i + carl <= n && d[i][0] < carn){
			d[i][0] = carn;
			d[i][1] = sum - i + carl;
			if(d[m][0] < d[i][0] || (d[m][0] == d[i][0] && abs(m - d[m][1]) > abs(i - d[i][1])))
				m = i;
		}
	}
}

int main() {
	int t;
	cin >> t;
	for(; t>0; t--){
		cin >> n;
		n *= 100;
		for(int i=0; i<=n; i++){
			d[i][0] = -1;
			d[i][1] = 0;
		}
		d[0][0] = 0;
		sum = 0;
		m = 0;
		for(int i=0; cin >> carl, carl != 0; i++){
			if(sum <= 2*n){
				solve(i + 1);
				sum += carl;
			}
		}
		cout << d[m][0] << endl << endl;
	}

	return 0;
}