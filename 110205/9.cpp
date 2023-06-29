#include <iostream>
#include <string>

using namespace std;

pair<string, string> card[53];
pair<string, string> temp[53];

int cases[101][53];

void init_() {
	string num[5] = {" ", "Jack", "Queen", "King", "Ace"};
	for (int i = 1; i <= 9; i++) {
		card[i] = make_pair(to_string(i + 1), "Clubs");
		card[i + 13] = make_pair(to_string(i + 1), "Diamonds");
		card[i + 26] = make_pair(to_string(i + 1), "Hearts");
		card[i + 39] = make_pair(to_string(i + 1), "Spades");
	}
	
	for (int i = 10; i <= 13; i++) {
		card[i] = make_pair(num[i - 9], "Clubs");
		card[i + 13] = make_pair(num[i - 9], "Diamonds");
		card[i + 26] = make_pair(num[i - 9], "Hearts");
		card[i + 39] = make_pair(num[i - 9], "Spades");
	}
	
	for (int i = 1; i <= 100; i++)
		for (int j = 1; j <= 52; j++)
			cases[i][j] = 0;
}

void print() {
	for (int j = 1; j <= 52; j++)
		cout << card[j].first << " of " << card[j].second << "\n";
	cout << "\n"; 
}

void mix(int k) {
	for (int j = 1; j <= 52; j++)
		temp[j] = card[cases[k][j]];
	
	for (int j = 1; j <= 52; j++)
		card[j] = temp[j];
}

int main() {
	int T;
	cin >> T;
	while (T-- != 0) {
		init_();
		int n;
		cin >> n;
		for (int k = 1; k <= n; k++) {
			for (int j = 1; j <= 52; j++)
				cin >> cases[k][j];
		}
		
		cin.ignore();
		string s;
		int k;
		while (getline(cin, s)) {
			if (s[0] < '0')
				break;
			k = s[0] - '0';
			mix(k);
		}
		print();
	}
	return 0;
}