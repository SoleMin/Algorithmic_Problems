#include <iostream>
#include <cmath>
#define MAX 100

using namespace std;

int n, check[MAX];
double result, dot[MAX][2], minv[MAX];

double dist(int a, int b){
	return sqrt(pow(dot[a][0] - dot[b][0], 2) + pow(dot[a][1] - dot[b][1], 2));
}

void solve(){
	int a;
	result = 0;
	for (int i=0; i<n; i++){
		check[i] = 0;
	}
	check[0] = 1;
	for (int i=1; i<n; i++){
		minv[i] = dist(0, i);
	}
	for (int i=0; i<n-1; i++){
		double m = 1000.0;
		for(int j=0; j<n; j++){
			if(check[j])
				continue;
			if(minv[j] < m){
				a = j;
				m = minv[j];
			}
		}
		result += m;
		check[a] = 1;
		for (int j=0; j<n; j++){
			m = dist(a, j);
			if(m < minv[j])
				minv[j] = m;
		}
	}
}

int main() {
	int t;
	cin >> t;
	for(; t>0; t--){
		cin >> n;
		for(int i=0; i<n; i++){
			cin >> dot[i][0] >> dot[i][1];
		}
		result = 0;
		solve();
		cout << fixed;
		cout.precision(2);
		cout << result << endl << endl;
	}

	return 0;
}