#include <iostream>
using namespace std;
int main() {
	int t, n, p, pd, i, j, k;
	cin >> t;
	int *caseResult = new int[t];
	for (i = 0; i < t; i++)
		caseResult[i] = 0;
	
	for (i = 0; i < t; i++) {
		cin >> n;
		int days[4000];
		for (j = 0; j < n + 2; j++)
			days[j] = 0;
		
		cin >> p;
		for (j = 0; j < p; j++) {
			cin >> pd;
			for (k = pd; k < n + 1; k++)
				if (k % pd == 0)
					days[k] = 1;
		}
		for (j = 0; j < n / 7 + 1; j++) {
			days[6 + j * 7] = 2;
			days[7 + j * 7] = 2;
		}
		for (j = 1; j < n + 1; j++) {
			if(days[j] == 1)
				caseResult[i]++;
		}
	}
	for (i = 0; i < t; i++)
		cout << caseResult[i] << endl;
	
	delete[] caseResult;
	return 0;
}