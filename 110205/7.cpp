#include <iostream>
#include <string>

using namespace std;

int main() {
	int t, n;
	string k, card[52];
	string val[13] = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
	string pattern[4] = {"Clubs", "Diamonds", "Hearts", "Spades"};
	
	for(int i=0; i<52; i++){
		card[i] = val[i%13] + " of " + pattern[i/13];
	}
	
	cin >> t;
	for(; t>0; t--){
		cin >> n;
		int result[52], input[52],cardset[n][52];
		
		for(int i=0; i<52; i++){
			input[i] = i+1;
			result[i] = i+1;
		}
		
		for(int i=0; i<n; i++){
			for(int j=0; j<52; j++){
				cin >> cardset[i][j];
			}
		}
		
		cin.ignore();
		while(getline(cin, k) && k.length()){
			int kk = stoi(k);
			for(int i=0; i<52; i++){
				result[i] = input[cardset[kk-1][i]-1];
			}
			for(int i=0; i<52; i++){
				input[i] = result[i];
			}
		}
		for(int i=0; i<52; i++){
			cout << card[result[i]-1] << endl;
		}
		cout << endl;
	}
	
	return 0;
}