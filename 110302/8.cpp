#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
using namespace std;

string find(vector<vector<char>> grid, string s) {
	string result;
	int p[2][8] = {
		0,1,1,1,0,-1,-1,-1,
		-1,-1,0,1,1,1,0,-1
	};
	
	for(int i = 0; i < grid.size(); ++i) {
		for(int j = 0; j < grid[0].size(); ++j) {
			int start[8][2] = {
				i,j,
				i,j,
				i,j,
				i,j,
				i,j,
				i,j,
				i,j,
				i,j
			};
			string comp[8];
			
			for(int k = 0; k < 8; ++k) {
				for(int l = 0; l < s.length(); ++l) {
					if(
						start[k][0] >= 0 && start[k][0] < grid.size() &&
						start[k][1] >= 0 && start[k][1] < grid[0].size()) {
						comp[k] += grid[start[k][0]][start[k][1]];
						start[k][0] += p[0][k];
						start[k][1] += p[1][k];
					}
				}
			}
			
			for(auto k: comp) {
				if(k == s) {
					result.append(to_string(++i));
					result.append(" ");
					result.append(to_string(++j));
					return result;
				}
			}
		}
	}
	return result;
}

int main() {
	int t, m, n, k;
	
	string s;
	cin >> t;
	while(t--) {
		getline(cin, s);
		cin >> m >> n;
		
		vector<vector<char>> grid;
		vector<char> word;
		vector<string> search;
		
		for(int i = 0; i < m; ++i) {
			cin >> s;
			for(char j: s) {
				j = tolower(j);
				word.push_back(j);
			}
			grid.push_back(word);
			word.clear();
		}
		
		cin >> k;
		while(k--) {
			cin >> s;
			for(char &i: s) i = tolower(i);
			search.push_back(s);
		}
		
		for(const auto &i: search) cout << find(grid, i) << endl;
		cout << endl;
	}
	
	return 0;
}