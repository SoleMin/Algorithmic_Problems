#include <iostream>
#include <cmath>
#define MAXN 100
#define MAXINT 100000

using namespace std;
static int n, check[MAXN];
static double dot[MAXN][2], minval[MAXN], result;

void solve(void);


void input(void) {
	int i;
	cin>>n;
	for (i = 0; i < n; i++) {
		cin>>dot[i][0]>>dot[i][1];
	}
}
double dist(int a, int b) {
	return sqrt(pow(dot[a][0] - dot[b][0], 2) +
		pow(dot[a][1] - dot[b][1], 2));
}
void solve(void) {
	int i, k=0;
	result = 0;
	for (i = 0; i < n; i++) {
		check[i] = 0;
	}
	for (i = 1; i < n; i++) {
		minval[i] = dist(0, i);
	}
	for (i = 0; i < n - 1; i++) {
		double dista;
		if (check[k] == 0) {
			check[k] = 1;
			for (int j = 1; j < n; j++) {
				if (k == j)continue;
				int w = j;
				double weight = dist(k,j);
				if ((minval[w] > weight) && (check[w] == 0)) {
					minval[w] = weight;
				}
			}
			k = 1;
			dista = MAXINT;
			for (int j = 1; j < n; j++) {
				if ((check[j] == 0) && (dista > minval[j])) {
					dista = minval[j];
					k = j;	
				}
			}
			result += dista;
		}
	}
	
}
int main(void)
{
	int i, t;
	cin>>t;
	for (i = 0; i < t; i++)
	{
		input();
		solve();
		if (i > 0)
			cout<<endl;
		printf("%0.2lf\n", result);
	}
}

