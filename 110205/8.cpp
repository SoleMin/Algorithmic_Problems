#include <iostream>
#include <string>
#include <vector>
#include <sstream>
#define CARD_NUM 52
using namespace std;

int t, n;
int arr[101][53];
vector<pair<int, string>> card;
vector<pair<int, string>> tmp;

void init() {
	for(int i = 2; i <= 14; i++) 
		card.push_back({i, "Clubs"});
	for(int i = 2; i <= 14; i++)
		card.push_back({i, "Diamonds"});
	for(int i = 2; i <= 14; i++)
		card.push_back({i, "Hearts"});
	for(int i = 2; i <= 14; i++)
		card.push_back({i, "Spades"});
}

void printCard() {
	for(int i = 0; i < card.size(); i++) {
		int curNum = card[i].first;
		if(curNum == 11) cout << "Jack";
		else if(curNum == 12) cout << "Queen";
		else if(curNum == 13) cout << "King";
		else if(curNum == 14) cout << "Ace";
		else cout << curNum;
		
		cout << " of " << card[i].second << '\n';
	}
	cout << '\n';
}

int main() {
	
	cin >> t;
	while(t--) {
		card.clear();
		init();
		
		cin >> n;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < CARD_NUM; j++) {
				cin >> arr[i][j];
				arr[i][j]--;
			}
		}
		
		int kNum;
		getchar();
		while(true) {
			string k;
			tmp.clear();
			getline(cin, k);
			
			if(k == "") {
				break;
			}
			else {
				istringstream iss(k);
				iss >> kNum;
			}
			kNum--;
			
			for(int i = 0; i < CARD_NUM; i++) {
				tmp.push_back(card[arr[kNum][i]]);
			}
			card = tmp;
		}
		printCard();
	}
	
	return 0;
}