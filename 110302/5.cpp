#include <iostream>
#include <string>
using namespace std;
int main() {
	int t, rows, cols, k, wl, sc;
	bool find;
	char c;
	string word;
	cin >> t;
	
	while (t--) {
		char grid[50][50];
		cin >> rows;
		cin >> cols;
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++) {
				cin >> c;
				grid[i][j] = tolower(c);
			}
		
		cin >> k;
		while (k--) {
			find = false;
			cin >> word;
			wl = word.length();
			for (int i = 0; i < wl; i++)
				word[i] = tolower(word[i]);
			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < cols; c++) {
					if (word[0] == grid[r][c]) {
						if (c + wl - 1 < cols) {
							sc = 0;
							for (int i = 0; i < wl; i++) 
								if (grid[r][c + i] == word[i])
									sc++;
							if (sc == wl)
								find = true;
						}
						if (r + wl - 1 < rows) {
							sc = 0;
							for (int i = 0; i < wl; i++)
								if (grid[r + i][c] == word[i])
									sc++;
							if (sc == wl)
								find = true;
						}
						if (c > wl - 2) {
							sc = 0;
							for (int i = 0; i < wl; i++)
								if (grid[r][c - i] == word[i])
									sc++;
							if (sc == wl) 
								find = true;
						}
						if (r > wl - 2) {
							sc = 0;
							for (int i = 0; i < wl; i++)
								if (grid[r - i][c] == word[i])
									sc++;
							if (sc == wl) 
								find = true;
						}
						if ((c + wl - 1 < cols) && (r + wl - 1 < rows)) {
							sc = 0;
							for (int i = 0; i < wl; i++)
								if (grid[r + i][c + i] == word[i])
									sc++;
							if (sc == wl)
								find = true;
						}
						if ((c + wl - 1 < cols) && (r > wl - 2)) {
							sc = 0;
							for (int i = 0; i < wl; i++)
								if (grid[r - i][c + i] == word[i])
									sc++;
							if (sc == wl)
								find = true;
						}
						if ((c > wl - 2) && (r + wl - 1 < rows)) {
							sc = 0; 
							for (int i = 0; i < wl; i++)
								if (grid[r + i][c - i]== word[i])
									sc++;
							if (sc == wl)
								find = true;
						}
						if ((c > wl - 2) && (r > wl - 2)) {
							sc = 0;
							for (int i = 0; i < wl; i++)
								if (grid[r - i][c - i] == word[i])
									sc++;
							if (sc == wl)
								find = true;
						}
						
					}
					if (find == true){
						cout << r + 1 <<  " " << c + 1 << endl;
						break;
					}
				}
				if (find == true)
					break;
			}
		}
	cout << endl;
	}
	return 0;
}