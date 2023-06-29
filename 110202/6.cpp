#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int changeNumber(char c) {
	if(c == 'A') return 14;
	else if(c == '2') return 2;
	else if(c == '3') return 3;
	else if(c == '4') return 4;
	else if(c == '5') return 5;
	else if(c == '6') return 6;
	else if(c == '7') return 7;
	else if(c == '8') return 8;
	else if(c == '9') return 9;
	else if(c == 'T') return 10;
	else if(c == 'J') return 11;
	else if(c == 'Q') return 12;
	else if(c == 'K') return 13;
	return 0;
}
	
bool straight(const int card[]) {
	int c[17] = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 2, 3, 4, 5};
	for(int i = 0; i < 5; i++) if(c[card[0] - 2] + i != card[i]) return false;
	return true;
}
	
bool flush(const char card[]) {
	for(int i = 1; i < 5; i++) if(card[0] != card[i]) return false;
	return true;
}
	
int fullHouse(const int card[]) {
	int n[13] = {0}, cnt2 = 0, cnt3 = 0, cnt4 = 0;
		
	for(int i = 0; i < 5; i++) {
		if(card[i] == 14) n[0]++;
		else n[card[i] - 1]++;
	}
		
	for(int i : n) {
		if(i == 2) cnt2++;
		else if(i == 3) cnt3++;
		else if(i == 4) cnt4++;
	}
		
	if(cnt4) return 4;
	else if(cnt2 && cnt3) return 5;
	else if(cnt3) return 3;
	else if(cnt2 == 2) return 2;
	else if(cnt2 == 1) return 1;
	else return 0;
}

int last(const int card[], const int card2[]) {
	int n[15] = {0}, n2[15] = {0};
	
	for(int i = 0; i < 5; i++) n[card[i]]++;
	for(int i = 0; i < 5; i++) n2[card2[i]]++;
	for(int i = 14; i > 1; i--) {
		if(n[i] || n2[i]) {
			if(n[i] > n2[i]) return 1;
			else if(n[i] < n2[i]) return -1;
		}
	}
	return 0;
}

int score(int card[], char suit[]) {
	if(straight(card) && flush(suit)) return 9;
	else if(fullHouse(card) == 4) return 8;
	else if(fullHouse(card) == 5) return 7;
	else if(flush(suit)) return 6;
	else if(straight(card)) return 5;
	else if(fullHouse(card) == 3) return 4;
	else if(fullHouse(card) == 2) return 3;
	else if(fullHouse(card) == 1) return 2;
	else return 1;
}
	
int main() {
	int bp, wp, bn[5], wn[5];
	char bs[5], ws[5];
	string b[5], w[5], s;
	
	while(getline(cin, s)) {
		for(int i = 0; i < 5; i++) b[i] = s.substr(i * 3, 2);
		for(int i = 0; i < 5; i++) w[i] = s.substr(i * 3 + 15, 2);
		
		for(int i = 0; i < 5; i++) {
			bs[i] = b[i][1];
			ws[i] = w[i][1];
		}
		
		for(int i = 0; i < 5; i++) {
			bn[i] = changeNumber(b[i][0]);
			wn[i] = changeNumber(w[i][0]);
		}
		
		sort(bn, bn + 5);
		sort(wn, wn + 5);
		
		bp = score(bn, bs);
		wp = score(wn, ws);
		
		if(bp > wp) cout << "Black wins.";
		else if(bp < wp) cout << "White wins.";
		else {
			if(last(bn, wn) == 1) cout << "Black wins.";
			else if(last(bn, wn) == -1) cout << "White wins.";
			else cout << "Tie.";
		}
		cout << endl;
	}
	return 0;
}