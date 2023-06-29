# include <iostream>
# include <string>
# include <vector>
# include <algorithm>
# define DECK_SIZE (52)
# define MAX_SHUFFLE (100)

using namespace std;

static int deck[DECK_SIZE];
static int temp_deck[DECK_SIZE];

void reset_deck() {
	for (int i = 0; i < DECK_SIZE; i++) {
		deck[i] = i + 1;
	}
}

void printf_card(int _suit, int _value) {
	string suit;
	string value;
	
	/*문양처리*/
	if (_suit == 0) {
		suit = "Clubs";
	}
	else if (_suit == 1) {
		suit = "Diamonds";
	}
	else if (_suit == 2) {
		suit = "Hearts";
	}
	else if (_suit == 3) {
		suit = "Spades";
	}
	/*문양처리*/
	
	/*값 처리*/
	if (_value < 10 && _value != 1) {
		value = _value + '0';
	}
	else if (_value == 10) {
		value = "10";
	}
	else if (_value == 11) {
		value = "Jack";
	}
	else if (_value == 12) {
		value = "Queen";
	}
	else if (_value == 13) {
		value = "King";
	}
	else if (_value == 1) {
		value = "Ace";
	}
	/*값 처리*/
	
	cout << value << " of " << suit << endl;
}

int main() {
	
	int test_case = 0;
	string dump;
	
	cin >> test_case;
	cin.ignore();
	getline(cin, dump);
	
	while (test_case-- > 0) {
		reset_deck();
		vector<int> shuffle_way[MAX_SHUFFLE];
		
		int n = 0;
		cin >> n;
		
		/*섞기 방법 입력 처리*/
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < DECK_SIZE; j++) {
				int input;
				cin >> input;
				shuffle_way[i].push_back(input);
			}
		}
		/*섞기 방법 입력 처리*/
		
		string way;
		getline(cin, way);
		while (getline(cin, way)) {
			copy(deck, deck + DECK_SIZE, temp_deck);
			if (way == "") {
				break;
			}
			for (int card_position = 0; card_position < DECK_SIZE; card_position++) {
				deck[card_position] = temp_deck[shuffle_way[stoi(way) - 1][card_position] - 1];
			}
		}
		
		for (int i = 0; i < DECK_SIZE; i++) {
			int suit = (deck[i] - 1) / 13;
			int value = (deck[i] % 13) + 1;
			
			printf_card(suit, value);
		}
		
		cout << endl;
	}	// EOW (Test Case)
	
	
	return 0;
}





