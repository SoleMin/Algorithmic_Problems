#include <bits/stdc++.h>
using namespace std;

vector<string> a{"Clubs", "Diamonds", "Hearts", "Spades"}; 
vector<string> b{"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"}; 

int main() {
	int t; cin>>t; 
	//cin.ignore(); 
	while(true){
		vector<string> c(53); 
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 13; j++){
				c[i * 13 + j + 1] = b[j] + " of "  + a[i]; 
			}
		}
		int n; cin>>n; 
		vector<vector<int>> v(n + 1); 
		for(int i = 1; i <= n; i++){
			v[i].resize(53); 
			for(int j = 1; j <= 52; j++){
				int p; cin>>p; 
				v[i][j] = p; 
			}
		}
		cin.ignore(); 
		string k; 
		while(1) {
			getline(cin, k);
			if(k == "") break; 
			vector<string> cc(53); 
			for(int i = 1; i <= 52; i++){
				cc[i] = c[v[stoi(k)][i]]; 
			}
			c = cc; 
		}
		for(int i = 1; i <= 52; i++){
			cout << c[i] << "\n"; 
		}
		cout << "\n"; 
		if(cin.eof()) break; 
	}
}