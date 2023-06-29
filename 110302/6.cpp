#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main() {
	int t;
	cin >> t;
	cin.ignore();
	cin.ignore();
	for(; t>0; t--){
		int m, n, k;
		cin >> m >> n;
		cin.ignore();
		string grid[m];
		for(int i=0; i<m; i++){
			getline(cin, grid[i]);
			transform(grid[i].begin(), grid[i].end(), grid[i].begin(), ::tolower);
		}
		cin >> k;
		cin.ignore();
		for(; k>0; k--){
			string word;
			getline(cin, word);
			transform(word.begin(), word.end(), word.begin(), ::tolower);
			for(int i=0; i<m; i++){
				for(int a=0; a<n; a++){
					string result = "", w1 = "", w2 = "", w3 = "", w4 = "", w5 = "", w6 = "", w7 = "", w8 = "";
					if(grid[i][a] == word[0]){
						for(int j=0; j<word.length(); j++){
							if(n-a >= word.length()){
								w1 += grid[i][a+j];
							}
							if(m-i >= word.length() && n-a >= word.length()){
								w2 += grid[i+j][a+j];
							}
							if(m-i >= word.length()){
								w3 += grid[i+j][a];
							}
							if(m-i >= word.length() && a+1 >= word.length()){
								w4 += grid[i+j][a-j];
							}
							if(a+1 >= word.length()){
								w5 += grid[i][a-j];
							}
							if(i+1 >= word.length() && a+1 >= word.length()){
								w6 += grid[i-j][a-j];
							}
							if(i+1 >= word.length()){
								w7 += grid[i-j][a];
							}
							if(i+1 >= word.length() && n-a >= word.length()){
								w8 += grid[i-j][a+j];
							}
						}
						result = w1 + w2 + w3 + w4 + w5 + w6 + w7 + w8;
						if(result.find(word) != string::npos){
							cout << i+1 << " " << a+1 << endl;
							i = m;
							break;
						}
					}
				}
			}
		
		}
		cout << endl;
	}
	
	return 0;
}