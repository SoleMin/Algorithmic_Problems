#include <iostream>
#include <string>
using namespace std;
int main() {
	int t, n, c, k, temp;
	string line, ks;
	cin >> t;
	while (t--){
		int result[53];
		int shuffled[53];
		int to[53] = {0};
		int from[53] = {0};
		int casenum[5202] = {0};
		int nCount = 1;
		
		for (int i = 0; i < 53; i++)
			result[i] = shuffled[i] = i;
		
		cin >> n;
		for (int i = 1; i < n + 1; i++)
			for (int j = 1; j < 53; j++){
				cin >> c;
				if (c != j) {
					to[nCount] = j;
					from[nCount] = c;
					nCount++;
				}
				casenum[i] = nCount;
			}

		cin.ignore();
		getline(cin, ks);
		while (ks != ""){
			k = stoi(ks);
			for (int i = casenum[k - 1]; i < casenum[k]; i++)
				result[to[i]] = shuffled[from[i]];

			for (int i = 1; i < 53; i++)
				shuffled[i] = result[i];
				getline(cin, ks);
		}
		
		for (int i = 1; i < 53; i++){
			switch (result[i] % 13){
				case 1:
					cout << 2;
					break;
				case 2:
					cout << 3;
					break;
				case 3:
					cout << 4;
					break;
				case 4:
					cout << 5; 
					break;
				case 5:
					cout << 6;
					break;
				case 6:
					cout << 7;
					break;
				case 7:
					cout << 8;
					break;
				case 8:
					cout << 9;
					break;
				case 9:
					cout << 10;
					break;
				case 10:
					cout << "Jack";
					break;
				case 11:
					cout << "Queen";
					break;
				case 12:
					cout << "King";
					break;
				default:
					cout << "Ace";
			}
			cout << " of ";
			
			switch ((result[i] - 1) / 13) {
				case 0:
					cout << "Clubs" << endl;
					break;
				case 1:
					cout << "Diamonds" << endl;
					break;
				case 2:
					cout << "Hearts" << endl;
					break;
				default:
					cout << "Spades" << endl;
			}
		}
		cout << endl;
	}
	return 0;
}