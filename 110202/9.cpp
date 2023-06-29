#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<pair<int, char>> black, white;

int switchCardNum(char card) {
	switch(card) {
		case 'T': return 10;
		case 'J': return 11;
		case 'Q': return 12;
		case 'K': return 13;
		case 'A': return 14;
	}
}

int isStraightFlush(bool isBlack) {
	if(isBlack) {
		int sub = black[0].first;
		char shape = black[0].second;
		for(int i = 0; i < 5; i++) {
			if(black[i].first - sub != i || black[i].second != shape) return -1;
		}
		return black[4].first;
	}
	else {
		int sub = white[0].first;
		char shape = white[0].second;
		for(int i = 0; i < 5; i++)
			if(white[i].first - sub != i || white[i].second != shape) return -1;
		return white[4].first;
	}
}

// return이 -1이면 false
// 맞으면 최대값 반환
int isFourCard(bool isBlack) {
	if(isBlack) {
		int num1 = black[0].first;
		int num2 = black[4].first;
		
		int cnt = 0;
		for(int i = 0; i < 5; i++)
			if(black[i].first == num1) cnt++;
		if(cnt == 4) return num1;
		
		cnt = 0;
		for(int i = 0; i < 5; i++)
			if(black[i].first == num2) cnt++;
		if(cnt == 4) return num2;
	}
	else {
		int num1 = white[0].first;
		int num2 = white[4].first;
		int cnt = 0;
		
		for(int i = 0; i < 5; i++)
			if(white[i].first == num1) cnt++;
		if(cnt == 4) return num1;
		
		cnt = 0;
		for(int i = 0; i < 5; i++)
			if(white[i].first == num2) cnt++;
		if(cnt == 4) return num2;
	}
	return -1;
}

int isFullHouse(bool isBlack) {
	if(isBlack) {
		int num1 = black[0].first;
		int num2 = black[4].first;
		int cnt1 = 0, cnt2 = 0;
		for(int i = 0; i < 5; i++) {
			if(black[i].first == num1) cnt1++;
			else if(black[i].first == num2) cnt2++;
		}
		if(cnt1 == 2 && cnt2 == 3)
			return num2;
		if(cnt1 == 3 && cnt2 == 2)
			return num1;
	}
	else {
		int num1 = white[0].first;
		int num2 = white[4].first;
		int cnt1 = 0, cnt2 = 0;
		for(int i = 0; i < 5; i++) {
			if(white[i].first == num1) cnt1++;
			else if(white[i].first == num2) cnt2++;
		}
		if(cnt1 == 2 && cnt2 == 3)
			return num2;
		if(cnt1 == 3 && cnt2 == 2)
			return num1;
	}
	return -1;
}

long long isFlush(bool isBlack) {
	long long ret = 0;
	if(isBlack) {
		char shape = black[0].second;
		int cnt = 0;
		for(int i = 0; i < 5; i++)
			if(black[i].second == shape) cnt++;
		if(cnt != 5) return -1;
		
		for(int i = 4; i >= 0; i--) {
			ret *= 100;
			ret += black[i].first;
		}
		return ret;
	}
	else {
		char shape = white[0].second;
		int cnt = 0;
		for(int i = 0; i < 5; i++)
			if(white[i].second == shape) cnt++;
		if(cnt != 5) return -1;
		
		for(int i = 4; i >= 0; i--) {
			ret *= 100;
			ret += white[i].first;
		}
		return ret;
	}
}

int isStraight(bool isBlack) {
	if(isBlack) {
		int sub = black[0].first;
		int cnt = 0;
		for(int i = 0; i < 5; i++) 
			if(black[i].first - sub == i) cnt++;
		if(cnt == 5)
			return black[4].first;
	}
	else {
		int sub = white[0].first;
		int cnt = 0;
		for(int i = 0; i < 5; i++)
			if(white[i].first - sub == i) cnt++;
		if(cnt == 5)
			return white[4].first;
	}
	return -1;
}

int isThreeCard(bool isBlack) {
	if(isBlack) {
		for(int i = 0; i < 5; i++) {
			int curCard = black[i].first;
			int cnt = 0;
			for(int j = 0; j < 5; j++) 
				if(black[j].first == curCard) cnt++;
			if(cnt == 3) 
				return curCard;
		}
	}
	else {
		for(int i = 0; i < 5; i++) {
			int curCard = white[i].first;
			int cnt = 0;
			for(int j = 0; j < 5; j++)
				if(white[j].first == curCard) cnt++;
			if(cnt == 3)
				return curCard;
		}
	}
	return -1;
}

// 큰 카드부터 더한값들을 앞자리부터 채워서
// 가장 큰 수가 크면 무조건 큰 방식을 이용
long long isTwoPair(bool isBlack) {
	int cnt = 0;
	long long ret = 0;
	bool visited[5] = {0, };
	if(isBlack) {
		for(int i = 4; i > 0; i--) {
			if(black[i].first == black[i - 1].first) {
				visited[i] = visited[i - 1] = true;
				ret *= 100;
				ret += black[i].first;
				cnt++;
				i--;
			}
		}
		if(cnt == 2) {
			for(int i = 0; i < 5; i++) {
				if(!visited[i]) {
					ret *= 100;
					ret += black[i].first;
				}
			}
			return ret;
		}
	}
	else {
		for(int i = 4; i > 0; i--) {
			if(white[i].first == white[i - 1].first) {
				visited[i] = visited[i - 1] = true;
				ret *= 100;
				ret += white[i].first;
				cnt++;
				i--;
			}
		}
		if(cnt == 2) {
			for(int i = 0; i < 5; i++) {
				if(!visited[i]) {
					ret *= 100;
					ret += white[i].first;
				}
			}
			return ret;
		}
	}
	return -1;
}

long long isOnePair(bool isBlack) {
	long long ret = 0;
	bool notPair = true;
	bool visited[5] = {0, };
	if(isBlack) {
		for(int i = 0; i < 4; i++) {
			if(black[i].first == black[i + 1].first) {
				visited[i] = visited[i + 1] = true;
				ret += black[i].first;
				notPair = false;
				break;
			}
		}
		if(notPair) return -1;
		
		for(int i = 4; i >= 0; i--) {
			if(!visited[i]) {
				ret *= 100;
				ret += black[i].first;
			}
		}
		return ret;
	}
	else {
		for(int i = 0; i < 4; i++) {
			if(white[i].first == white[i + 1].first) {
				visited[i] = visited[i + 1] = true;
				ret += white[i].first;
				notPair = false;
				break;
			}
		}
		if(notPair) return -1;
		for(int i = 4; i >= 0; i--) {
			if(!visited[i]) {
				ret *= 100;
				ret += white[i].first;
			}
		}
		return ret;
	}
}

long long isHighCard(bool isBlack) {
	long long ret = 0;
	if(isBlack) {
		for(int i = 4; i >= 0; i--) {
			ret *= 100;
			ret += black[i].first;
		}
		return ret;
	}
	else {
		for(int i = 4; i >= 0; i--) {
			ret *= 100;
			ret += white[i].first;
		}
		return ret;
	}
}

int main() {
	
	while(true) {
		string tmp;
		black.clear(); white.clear();
		for(int i = 0; i < 5; i++) {
			cin >> tmp;
			if(cin.eof()) break;
			
			if('0' <= tmp[0] && tmp[0] <= '9')
				black.push_back(make_pair(tmp[0] - '0', tmp[1]));
			else 
				black.push_back(make_pair(switchCardNum(tmp[0]), tmp[1]));
		}
		for(int i = 0; i < 5; i++) {
			cin >> tmp;
			if(cin.eof()) break;
			
			if('0' <= tmp[0] && tmp[0] <= '9')
				white.push_back(make_pair(tmp[0] - '0', tmp[1]));
			else
				white.push_back(make_pair(switchCardNum(tmp[0]), tmp[1]));
		}
		if(cin.eof()) break;
		sort(black.begin(), black.end());
		sort(white.begin(), white.end());
		
		long long blackScore = 0, whiteScore = 0;
		long long blackRet, whiteRet;
		if((blackRet = isStraightFlush(true)) != -1)
			blackScore = 8e12 + blackRet;
		else if((blackRet = isFourCard(true)) != -1)
			blackScore = 7e12 + blackRet;
		else if((blackRet = isFullHouse(true)) != -1)
			blackScore = 6e12 + blackRet;
		else if((blackRet = isFlush(true)) != -1)
			blackScore = 5e12 + blackRet;
		else if((blackRet = isStraight(true)) != -1)
			blackScore = 4e12 + blackRet;
		else if((blackRet = isThreeCard(true)) != -1)
			blackScore = 3e12 + blackRet;
		else if((blackRet = isTwoPair(true)) != -1)
			blackScore = 2e12 + blackRet;
		else if((blackRet = isOnePair(true)) != -1)
			blackScore = 1e12 + blackRet;
		else
			blackScore = isHighCard(true);
		
	
		if((whiteRet = isStraightFlush(false)) != -1)
			whiteScore = 8e12 + whiteRet;
		else if((whiteRet = isFourCard(false)) != -1)
			whiteScore = 7e12 + whiteRet;
		else if((whiteRet = isFullHouse(false)) != -1) 
			whiteScore = 6e12 + whiteRet;
		else if((whiteRet = isFlush(false)) != -1)
			whiteScore = 5e12 + whiteRet;
		else if((whiteRet = isStraight(false)) != -1)
			whiteScore = 4e12 + whiteRet;
		else if((whiteRet = isThreeCard(false)) != -1)
			whiteScore = 3e12 + whiteRet;
		else if((whiteRet = isTwoPair(false)) != -1)
			whiteScore = 2e12 + whiteRet;
		else if((whiteRet = isOnePair(false)) != -1)
			whiteScore = 1e12 + whiteRet;
		else
			whiteScore = isHighCard(false);
		
		// high card
		//if(!blackScore && !whiteScore) {
		//	blackScore = isHighCard(true);
		//	whiteScore = isHighCard(false);
		//}
		if(blackScore > whiteScore) {
			cout << "Black wins.\n";
		}
		else if(blackScore < whiteScore)
			cout << "White wins.\n";
		else
			cout << "Tie.\n";
	}
	
	return 0;
}