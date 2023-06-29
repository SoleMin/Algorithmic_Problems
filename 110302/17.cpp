#include <iostream>
#include <string>

using namespace std;

int main() {
	
	int t, m, n, k, nx, ny, ans_x, ans_y;
	string map [51];
	string word[21];
	string line = "";
	int dx [8] = {-1, 0, 1, 0, -1, -1, 1, 1};
	int dy [8] = {0, 1, 0, -1, -1, 1, 1, -1};
	bool visited [21];
	
	cin >> t;
	
	while (t != 0) {
		cin >> m >> n;

		for(int i = 0; i < m; i++) {
			cin >> map[i];
		}

		cin >> k;
		for(int i = 0; i < k; i++) {
			cin >> word[i];
		}

		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = tolower(map[i][j]);
			}
		}

		for(int i = 0; i < k; i++) {
			for(int j = 0; j < word[i].length(); j++) {
				word[i][j] = tolower(word[i][j]);
			}
		}

		for(int a = 0; a < k; a++) {
			for(int v = 0; v < k; v++) {
				visited[v] = false;
			}
			
			for(int x = 0; x < m; x++) {
				for(int y = 0; y < n; y++) {
					for(int i = 0; i < 8; i++) {

						nx = x + dx[i];
						ny = y + dy[i];

						if(nx >= m || nx < 0 || ny >= n || ny < 0)
							continue;

						line = "";
						ans_x = x + 1;
						ans_y = y + 1;
						line += map[x][y];

						for(int b = 0; b < word[a].length(); b++) {
							line += map[nx][ny];
							nx = nx + dx[i];
							ny = ny + dy[i];

							if(nx > m || nx < -1 || ny > n || ny < -1)
								break;
							
							if(!visited[a]) {
								if(line == word[a]) {
									cout << ans_x << " " << ans_y << endl;
									visited[a] = true;
									break;
								}
							}
							
						}
					}
				}
			}
		}
		t -= 1;
		cout << endl;
	}
	return 0;
}