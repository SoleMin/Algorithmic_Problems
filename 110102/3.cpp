#include <iostream>
using namespace std;
int main() {
	int m, n, fieldNumber = 0, mineCount;
	while(scanf("%d %d", &n, &m) == 2) {
		if (m == 0 && n == 0)
			break;
		char **mine = new char *[n];
		for (int i = 0; i < n; i++)
			mine[i] = new char[m];
		
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				cin >> mine[i][j];
		
		for (int i = 0; i < n; i++){
			for (int j = 0; j < m; j++)
				if (mine[i][j] == '.') {
					mineCount = 0;
					for (int k = -1; k <= 1; k++)
						for (int l = -1; l <= 1; l++) {
							if (i + k < 0 || i + k > n - 1 || j + l < 0 || j + l > m - 1)
								continue;
							if (mine[i + k][j + l] == '*')
								mineCount++;
						}
					mine[i][j] = (char)(mineCount+48);
				}
		}
		
		cout << "Field #" << ++fieldNumber << ":" << endl;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++)
				cout << mine[i][j];
			cout << endl;
			}
		cout << endl;
		for (int i = 0; i < n; i++)
			delete[] mine[i];
		delete[] mine;
	}
	return 0;
}