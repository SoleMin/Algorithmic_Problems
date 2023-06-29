#include <iostream>
#include <string>

using namespace std;

struct Poker{
	int value;
	char shape;
};

void input(Poker*, string);
void init_();

Poker black[5];
Poker white[5];

int black_compare[6];
int white_compare[6];

int black_num[15];
int white_num[15];

int check(Poker* poker, int* poker_compare, int* num) {
	bool flush = true;
	for (int i = 0; i < 4; i++) { // 무늬 체크
		if (poker[i].shape != poker[i + 1].shape) {
			flush = false;
			break;
		}
	}
	
	int min = 15;
	for (int i = 0; i < 5; i++) {
		num[poker[i].value]++;
		min = min < poker[i].value ? min : poker[i].value;
	}
	
	bool straight = true;
	for (int i = min; i < min + 5; i++) {
		if (num[i] == 0 || i >= 15) {
			straight = false;
			break;
		}
	}
	
	if (straight) { // 스트레이트 & 스트레이트 플러시
		for (int i = 0; i <= 4; i++)
			poker_compare[5 - i] = min + i;
		poker_compare[0] = flush ? 8 : 4;
		return 0;
	}
	else if (flush) { // 플러시
		int index = 1;
		poker_compare[0] = 5;
		for (int i = 14; i >= 2; i--)
			if (num[i])
				poker_compare[index++] = i;
		return 0;
	}
	
	int num_check[5] = { 0, };
	for (int i = min; i < 15; i++)
		num_check[num[i]]++;
	
	if (num_check[4]) { // 포카드
		poker_compare[0] = 7;
		for (int i = 2; i <= 14; i++) {
			if (num[i] == 4)
				poker_compare[1] = i;
			else if (num[i] == 1)
				poker_compare[5] = i;
		}
		return 0;
	}
	else if (num_check[3]) {
		if (num_check[2]) { // 풀 하우스
			poker_compare[0] = 6;
			for (int i = 2; i <= 14; i++) {
				if (num[i] == 3)
					poker_compare[1] = i;
				else if (num[i] == 2)
					poker_compare[5] = i;
			}
			return 0;
		}
		else { // 쓰리 카드
			poker_compare[0] = 3;
			int index = 4;
			for (int i = 14; i >= 2; i--) {
				if (num[i] == 3)
					poker_compare[1] = i;
				else if (num[i] == 1)
					poker_compare[index++] = i;
			}
			return 0;
		}
	}
	else if (num_check[2]) {
		if (num_check[2] == 2) { //  투 페어
			poker_compare[0] = 2;
			int index = 1;
			for (int i = 14; i >= 2; i--) {
				if (num[i] == 2)
					poker_compare[index++] = i;
				else if (num[i] == 1)
					poker_compare[5] = i;
			}
			return 0;
		}
		else { // 원 페어
			poker_compare[0] = 1;
			int index = 3;
			for (int i = 14; i >= 2; i--) {
				if (num[i] == 2)
					poker_compare[1] = i;
				else if (num[i] == 1)
					poker_compare[index++] = i;
			}
			return 0;
		}
	}
	
	int index = 1;
	for (int i = 14; i >= 2; i--)
		if (num[i])
			poker_compare[index++] = i;
	
	return 0;
}

int main() {
	string line;
	while (getline(cin, line)) {
		input(black, line.substr(0, 14));
		input(white, line.substr(15, 14));
	
		check(black, black_compare, black_num);
		check(white, white_compare, white_num);
	
		int result = 0; // 0: 비김 1: black 2: white
		if (black_compare[0] > white_compare[0])
			result = 1;
		else if (black_compare[0] < white_compare[0])
			result = 2;
		else {
			for (int i = 1; i <= 5; i++) {
				if (black_compare[i] > white_compare[i]) {
					result = 1;
					break;
				}
				else if (black_compare[i] < white_compare[i]) {
					result = 2;
					break;
				}
			}
		}
		init_();
		cout << (!result ? "Tie" : (result == 1 ? "Black wins" : "White wins")) << ".\n";
	}
	return 0;
}

void input(Poker* poker, string line) {
	for (int i = 0; i < 5; i++) {
		int index = 3 * i;
		char temp = line[index];
		if (temp == 'T')
			poker[i].value = 10;
		else if (temp =='J')
			poker[i].value = 11;
		else if (temp == 'Q')
			poker[i].value = 12;
		else if (temp == 'K')
			poker[i].value = 13;
		else if (temp == 'A')
			poker[i].value = 14;
		else
			poker[i].value = temp - '0';
		poker[i].shape = line[index + 1];
	}
}

void init_() {
	for (int i = 0; i < 6; i++) {
		white_compare[i] = 0;
		black_compare[i] = 0;
	}
		
	for (int i = 0; i < 15; i++) {
		white_num[i] = 0;
		black_num[i] = 0;
	}
}