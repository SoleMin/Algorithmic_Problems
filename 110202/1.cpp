#include <iostream>
#define get_value(x) ((x)/10)
#define get_suit(x) ((x)%10)
#define SWAP(a,b) {int t; t=a; a=b; b=t;}
using namespace std;

int encode_card(string card){
	int result;
	
	switch(card[0]){
		case 'T': result = 100; break;
		case 'J': result = 110; break;
		case 'Q': result = 120; break;
		case 'K': result = 130; break;
		case 'A': result = 140; break;
		default: result = (card[0] - '0') * 10;
	}
	
	switch(card[1]){
		case 'H': result += 1; break;
		case 'D': result += 2; break;
		case 'S': result += 3; break;
		case 'C': result += 4; break;
	}
	return result;
}

void get_hand_value(int hand[5], int score[2]){
	int i, j, n, check = 3;
	int temp = 0, count = 0;
	int value[5], suit[5];
	int pair[3] = {0, };
	
	for(i = 0; i < 5; i++){
		for(j = 0; j < 4; j++){
			if(hand[j] > hand[j + 1]) SWAP(hand[j], hand[j+1]);
		}
	}
	
	for(i = 0; i < 5; i++){
		value[i] = get_value(hand[i]);
		suit[i] = get_suit(hand[i]);
	}
	
	for(i = 0; i < 5; i++){
		for(j = 0; j < 5; j++){
			if(i == j) continue;
			if(value[i] == value[j]) temp++;
		}
		
		if((temp - count) >= 2){
			score[1] = value[i];
		}
		else if((temp - count) == 1){
			if(i == 0) pair[1] = value[0];
			else if(pair[1] != value[i]) pair[2] = value[i];
		}
		else if((temp - count) == 0){
			if(i == 0) pair[0] = value[0];
			else if(pair[0] < value[i]) pair[0] = value[i];
		}
		count = temp;
	}

	for(i = 1; i < 5; i++){
		if(!(suit[0] == suit[i])){
			check -= 1;
			break;
		}
	}

	for(i = 0; i < 4; i++){
		if(!((value[i + 1] - value[i]) == 1)){
			check -= 2;
			break;
		}
	}
	
	switch(count){
		case 2:
			score[0] = 1;
			score[1] = pair[1] * 100 + pair[0];
			break;
		case 4:
			score[0] = 2;
			if(pair[1] < pair[2]) SWAP(pair[1], pair[2]);
			score[1] = pair[1] * 10000 + pair[2] * 100 + pair[0];
			break;
		case 6:
			score[0] = 3;
			break;
		case 8:
			score[0] = 6;
			break;
		case 12:
			score[0] = 7;
			break;
		default:
			score[0] = score[1] = 0;
			temp = 1;
			for(i = 0; i < 5; i++){
				score[1] += value[i] * temp;
				temp *= 100;
			}
			break;
	}
	
	switch(check){
		case 1:
			if(score[0] < 5) score[0] = 5;
			score[1] = 0;
			temp = 1;
			for(i = 0; i < 5; i++){
				score[1] += value[i] * temp;
				temp *= 100;
			}
			break;
		case 2:
			score[0] = 4;
			score[1] = value[4];
			break;
		case 3:
			score[0] = 8;
			score[1] = value[4];
			break;
	}
}

void winner(int bscore[2], int wscore[2]){
	if(bscore[0] > wscore[0]) cout << "Black wins.";
	else if(bscore[0] < wscore[0]) cout << "White wins.";
	else{
		if(bscore[1] > wscore[1]) cout << "Black wins.";
		else if(bscore[1] < wscore[1]) cout << "White wins.";
		else cout << "Tie.";
	}
	cout << endl;
}


int main() {
	int i,exit=0;
	char input[3];
	int black[5], white[5];
	int black_score[2], white_score[2];
	
	while(1){
		for(i = 0; i < 10; i++){
			cin >> input;
			if(cin.eof()) exit = 1;
			
			if(i < 5) black[i] = encode_card(input);
			else white[i - 5] = encode_card(input);
		}
		if(exit) break;
		
		get_hand_value(black, black_score);
		get_hand_value(white, white_score);
		
		winner(black_score, white_score);
	}	
	return 0;
}