#include <iostream>
#include <string>
#define TRICK_MAX 100
#define CARD_MAX 52
using namespace std;

void init(int a[]){
	for(int i = 0; i < CARD_MAX; i++)
		a[i] = i;
}

void print_card(int a[TRICK_MAX][CARD_MAX], int k){
	int value, suit;
	for(int x = 0; x < k; x++){
	for(int y = 0; y < CARD_MAX; y++){
		value = a[x][y] % 13;
		suit = a[x][y] / 13;
		
		switch(value){
			case 9:
				cout << "Jack";
				break;
			case 10:
				cout << "Queen";
				break;
			case 11:
				cout << "King";
				break;
			case 12:
				cout << "Ace";
				break;
			default:
				cout << value + 2; 
				break;
		}
		
		cout << " of ";
		
		switch(suit){
			case 0:
				cout << "Clubs";
				break;
			case 1:
				cout << "Diamonds";
				break;
			case 2:
				cout << "Hearts";
				break;
			case 3:
				cout << "Spades";
				break;
		}
		cout << endl;
	}
		cout << endl;
	}
}

int main() {
	int x, n, i, j, test_case, tmp1, tmp2;
	string s;
	int trick[TRICK_MAX][CARD_MAX];
	int before[CARD_MAX];
	int after[CARD_MAX];
	int ans[TRICK_MAX][CARD_MAX];
	
	cin >> test_case;
	
	for(x = 0; x < test_case; x++){
		
		init(before);
		init(after);
		cin >> n;
		
		for(i = 0; i < n; i++){
			for(j = 0; j < CARD_MAX; j++){
				cin >> trick[i][j]; 
			}
		}
		
		cin.ignore();
		while(getline(cin,s)){
			if(s[0] == NULL) break;
			
			tmp1 = (s[0] - '0') - 1;
			
			for(i = 0; i < CARD_MAX; i++){
				tmp2 = trick[tmp1][i] - 1;
				after[i] = before[tmp2];
			}
			copy(after, after + CARD_MAX, before);
		}

		copy(after, after + CARD_MAX, ans[x]);
	}
	
	print_card(ans,test_case);
	
	return 0;
}