#include <algorithm>
#include <iostream>
using namespace std;
int main() {
	int n, k, result;
	while (scanf("%d %d", &n, &k) == 2){
		if (n == 0 && k == 0)
			break;
		if (k == 0 || n == 1) {
			cout << 1 << endl;
			continue;
		}
		result = 0;
		int r1[20] = {0,}, r2[20] = {0,};
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if ((i + j) % 2)
					r1[(i + j) / 2]++;
				else
					r2[(i + j) / 2]++;
		sort(r1, r1 + n - 1);
		sort(r2, r2 + n);
		int d1[20][20] = {0,}, d2[20][20] = {0,};
		d1[0][0] = 1, d1[0][1] = r1[0];
		d2[0][0] = 1, d2[0][1] = r2[0];
		for (int i = 1; i < n - 1; i++) {
			d1[i][0] = 1;
			for (int j = 1; j <= r1[i]; j++)
				d1[i][j] = d1[i - 1][j] + d1[i - 1][j - 1] * (r1[i] - j + 1);
		}
		for (int i = 1; i < n; i++) {
			d2[i][0] = 1;
			for (int j = 1; j <= r2[i]; j++)
				d2[i][j] = d2[i - 1][j] + d2[i - 1][j - 1] * (r2[i] - j + 1);
		}
		for (int i = 0; i <= k; i++)
			result += d1[n - 2][i] * d2[n - 1][k - i];
		cout << result << endl;
	}
}