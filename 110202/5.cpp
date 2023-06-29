#include <iostream>
using namespace std;
#define get_value(x) ((x) / 10)
#define get_suit(x) ((x) % 10)

int encode_card(char *card) {
	int result;
	
	switch (card[0]) {
		case 'T': result = 100; break;
		case 'J': result = 110; break;
		case 'Q': result = 120; break;
		case 'K': result = 130; break;
		case 'A': result = 140; break;
		default: result = (card[0] - '0') * 10;
	}
	switch (card[1]) {
		case 'H': result += 1; break;
		case 'D': result += 2; break;
		case 'S': result += 3; break;
		case 'C': result += 4; break;
	}
	return result;
}

int get_hand_value(int hand[5]) {
	int i, j, max, temp;
	int value[5], suit[5];
	for (i = 0; i < 4; i++) {
		max = i;
		for (j = i + 1; j < 5; j++)
			if (hand[j] > hand[max])
				max = j;
		temp = hand[i];
		hand[i] = hand[max];
		hand[max] = temp;
	}
	for (i = 0; i < 5; i++) {
		value[i] = get_value(hand[i]);
		suit[i] = get_suit(hand[i]);
	}
	
	if (value[1] + 1 == value[0] && suit[1] == suit[0]
			&& value[2] + 2 == value[0] && suit[2] == suit[0]
		 	&& value[3] + 3 == value[0] && suit[3] == suit[0]
		 	&& value[4] + 4 == value[0] && suit[4] == suit[0])
		return 9 + value[0] * 10;
	else if ((value[0] == value[1] && value[1] == value[2] && value[2] == value[3])
					|| (value[1] == value[2] && value[2] == value[3] && value[3] == value[4]))
		return 8 + value[1] * 10;
	else if ((value[0] == value[1] && value[1] == value[2] && value[3] == value[4]) 
					|| (value[2] == value[3] && value[3] == value[4] && value[0] == value[1]))
		return 7 + value[2] * 10;
	else if (suit[0] == suit[1] && suit[1] == suit[2] && suit[2] == suit[3] 
					 && suit[3] == suit[4])
		return 6 + value[0] * 10;
	else if (value[1] + 1 == value[0] && value[2] + 1 == value[1] 
					 && value[3] + 1 == value[2] && value[4] + 1 == value[3])
		return 5 + value[0] * 10;
	else if ((value[0] == value[1] && value[1] == value[2]) 
					|| (value[1] == value[2] && value[2] == value[3]) 
					|| (value[2] == value[3] && value[3] == value[4]))
		return 4 + value[2] * 10;
	else if ((value[0] == value[1] && value[3] == value[4]) 
					|| (value[1] == value[2] && value[3] == value[4])
					|| (value[0] == value[1] && value[2] == value[3]))
		return 3 + value[1] * 10;
	else if (value[0] == value[1])
		return 2 + value[0] * 10;
	else if (value[1] == value[2])
		return 2 + value[1] * 10;
	else if (value[2] == value[3])
		return 2 + value[2] * 10;
	else if (value[3] == value[4])
		return 2 + value[3] * 10;
	else
		return value[0] * 100000000 + value[1] * 1000000
		+ value[2] * 10000 + value[3] * 100 + value[4] * 10;
}

//suit == 문양 value == 숫자
int main() {
	char blackCards[5][2];
	int encodedBlack[5];
	int blackValue;
	char whiteCards[5][2];
	int encodedWhite[5];
	int whiteValue;
	
	while(cin >> blackCards[0]) {
		for (int i = 1; i < 5; i++) 
			cin >> blackCards[i];
		for (int i = 0; i < 5; i++) 
			cin >> whiteCards[i];
		for (int i = 0; i < 5; i++)
			encodedBlack[i] = encode_card(blackCards[i]);
		for (int i = 0; i < 5; i++)
			encodedWhite[i] = encode_card(whiteCards[i]);
		blackValue = get_hand_value(encodedBlack);
		whiteValue = get_hand_value(encodedWhite);
		
		if ((blackValue % 10) > (whiteValue % 10))
			cout << "Black wins." << endl;
		else if ((blackValue % 10) < (whiteValue % 10))
			cout << "White wins." << endl;
		else
			if ((blackValue / 10) > (whiteValue / 10))
				cout << "Black wins." << endl;
			else if ((blackValue / 10) < (whiteValue / 10))
				cout << "White wins." << endl;
			else
				cout << "Tie." << endl;
	}
	
	return 0;
}