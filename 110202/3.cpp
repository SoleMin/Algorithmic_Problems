#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

char value[] = {'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};

bool compareDeck(const pair<int, char> &a, const pair<int, char> &b)
{
	return a.first < b.first;
}

int straightFlush(vector<pair<int, char>> &deck)
{
	int result = 0;
	char suit = deck[0].second;
	
	for (int i = 0; i < 5; i++)
	{
		if (suit != deck[i].second)
			return 0;
	}
	
	int find = deck[0].first;
	for (int i = 0; i < 5; i++)
	{
		if (find != deck[i].first)
			return 0;
		find++;
		if (find >= 13)
			find = 1;
	}
	result = 9 << 12;
	result += deck[4].first << 10;
	result += deck[3].first << 8;
	result += deck[2].first << 6;
	result += deck[1].first << 4;
	result += deck[0].first << 2;
	
	return result;
}

int fourCard(vector<pair<int, char>> &deck)
{
	int result = 0;
	
	if (deck[0].first == deck[1].first && deck[1].first == deck[2].first && deck[2].first == deck[3].first)
	{
		result = 8 << 12;
		result = deck[0].first << 10;
		result = deck[4].first << 8;
	}
	else if (deck[1].first == deck[2].first && deck[2].first == deck[3].first && deck[3].first == deck[4].first)
	{
		result = 8 << 12;
		result = deck[4].first << 10;
		result = deck[0].first << 8;
	}
	return result;
}

int fullHouse(vector<pair<int, char>> &deck)
{
	int result = 0;
	
	if (deck[0].first == deck[1].first && deck[2].first == deck[3].first && deck[3].first == deck[4].first)
	{
		result = 7 << 12;
		result += deck[4].first << 10;
		result += deck[0].first << 8;
	}
	else if (deck[0].first == deck[1].first && deck[1].first == deck[2].first && deck[3].first == deck[4].first)
	{
		result = 7 << 12;
		result += deck[0].first << 10;
		result += deck[4].first << 8;
	}
	
	return result;
}

int flush(vector<pair<int, char>> &deck)
{
	int result = 0;
	char suit = deck[0].second;
	
	for (int i = 0; i < 5; i++)
	{
		if (suit != deck[i].second)
			return 0;
	}
	result = 6 << 12;
	result += deck[4].first << 10;
	result += deck[3].first << 8;
	result += deck[2].first << 6;
	result += deck[1].first << 4;
	result += deck[0].first << 2;
	
	return result;
}

int straight(vector<pair<int, char>> &deck)
{
	int result = 0;
	int find = deck[0].first;
	for (int i = 0; i < 5; i++)
	{
		if (find != deck[i].first)
			return 0;
		find++;
		if (find >= 13)
			find = 1;
	}
	result = 5 << 12;
	result += deck[4].first << 10;
	result += deck[3].first << 8;
	result += deck[2].first << 6;
	result += deck[1].first << 4;
	result += deck[0].first << 2;
	
	return result;
}

int threeCard(vector<pair<int, char>> &deck)
{
	int result = 0;
	
	if (deck[0].first == deck[1].first && deck[1].first == deck[2].first)
	{
		result = 4 << 12;
		result += deck[0].first << 10;
		result += deck[4].first << 8;
		result += deck[3].first << 6;
	}
	else if (deck[1].first == deck[2].first && deck[2].first == deck[3].first)
	{
		result = 4 << 12;
		result += deck[1].first << 10;
		result += deck[4].first << 8;
		result += deck[0].first << 6;
	}
	else if (deck[2].first == deck[3].first && deck[3].first == deck[4].first)
	{
		result = 4 << 12;
		result += deck[4].first << 10;
		result += deck[1].first << 8;
		result += deck[0].first << 6;
	}
	
	return result;
}

int twpPair(vector<pair<int, char>> &deck)
{
	int result = 0;
	
	if (deck[0].first == deck[1].first && deck[2].first == deck[3].first)
	{
		result = 3 << 12;
		result += deck[3].first << 10;
		result += deck[0].first << 8;
		result += deck[4].first << 6;
	}
	else if (deck[0].first == deck[1].first && deck[3].first == deck[4].first)
	{
		result = 3 << 12;
		result += deck[4].first << 10;
		result += deck[1].first << 8;
		result += deck[2].first << 6;
	}
	else if (deck[1].first == deck[2].first && deck[3].first == deck[4].first)
	{
		result = 3 << 12;
		result += deck[4].first << 10;
		result += deck[1].first << 8;
		result += deck[0].first << 6;
	}
	
	return result;
}

int onePair(vector<pair<int, char>> &deck)
{
	int result = 0;
	
	if (deck[0].first == deck[1].first)
	{
		result = 2 << 12;
		result += deck[0].first << 10;
		result += deck[4].first << 8;
		result += deck[3].first << 6;
		result += deck[2].first << 4;
	}
	else if (deck[1].first == deck[2].first)
	{
		result = 2 << 12;
		result += deck[1].first << 10;
		result += deck[4].first << 8;
		result += deck[3].first << 6;
		result += deck[0].first << 4;
	}
	else if (deck[2].first == deck[3].first)
	{
		result = 2 << 12;
		result += deck[3].first << 10;
		result += deck[4].first << 8;
		result += deck[1].first << 6;
		result += deck[0].first << 4;
	}
	else if (deck[3].first == deck[4].first)
	{
		result = 2 << 12;
		result += deck[4].first << 10;
		result += deck[2].first << 8;
		result += deck[1].first << 6;
		result += deck[0].first << 4;
	}
	
	return result;
}

int highCard(vector<pair<int, char>> &deck)
{
	int result = 0;
	result += deck[4].first << 10;
	result += deck[3].first << 8;
	result += deck[2].first << 6;
	result += deck[1].first << 4;
	result += deck[0].first << 2;
	
	return result;
}

int whoWin(vector<pair<int, char>> &black, vector<pair<int, char>> &white)
{
	int bResult, wResult;
	bResult = straightFlush(black);
	wResult = straightFlush(white);
	if (bResult || wResult)
	{
		if (bResult == wResult)
			return 3;
		else
			return ((bResult > wResult) ? 1 : 2);
	}
	
	bResult = fourCard(black);
	wResult = fourCard(white);
	if (bResult || wResult)
	{
		if (bResult == wResult)
			return 3;
		else
			return ((bResult > wResult) ? 1 : 2);
	}
	
	bResult = fullHouse(black);
	wResult = fullHouse(white);
	if (bResult || wResult)
	{
		if (bResult == wResult)
			return 3;
		else
			return ((bResult > wResult) ? 1 : 2);
	}
	
	bResult = flush(black);
	wResult = flush(white);
	if (bResult || wResult)
	{
		if (bResult == wResult)
			return 3;
		else
			return ((bResult > wResult) ? 1 : 2);
	}
	
	bResult = straight(black);
	wResult = straight(white);
	if (bResult || wResult)
	{
		if (bResult == wResult)
			return 3;
		else
			return ((bResult > wResult) ? 1 : 2);
	}
	
	bResult = threeCard(black);
	wResult = threeCard(white);
	if (bResult || wResult)
	{
		if (bResult == wResult)
			return 3;
		else
			return ((bResult > wResult) ? 1 : 2);
	}
	
	bResult = twpPair(black);
	wResult = twpPair(white);
	if (bResult || wResult)
	{
		if (bResult == wResult)
			return 3;
		else
			return ((bResult > wResult) ? 1 : 2);
	}
	
	bResult = onePair(black);
	wResult = onePair(white);
	if (bResult || wResult)
	{
		if (bResult == wResult)
			return 3;
		else
			return ((bResult > wResult) ? 1 : 2);
	}
	
	bResult = highCard(black);
	wResult = highCard(white);
	if (bResult || wResult)
	{
		if (bResult == wResult)
			return 3;
		else
			return ((bResult > wResult) ? 1 : 2);
	}
	
	return 0;
}

int main(void)
{
	string st;
	bool tmp = true;
	string input = "";
	vector<pair<int, char>> black, white;
	
	while (tmp)
	{
		black.clear();
		white.clear();
		for (int i = 0; i < 10; i++)
		{
			tmp = static_cast<bool>(cin >> input);
			if (!tmp)
				break;
			if (input[0] > '1' && input[0] <= '9')
				input[0] -= '2';
			else if (input[0] == 'T')
				input[0] = 8;
			else if (input[0] == 'J')
				input[0] = 9;
			else if (input[0] == 'Q')
				input[0] = 10;
			else if (input[0] == 'K')
				input[0] = 11;
			else
				input[0] = 12;
			if (i < 5)
				black.push_back(pair<int, char>(input[0], input[1]));
			else
				white.push_back(pair<int, char>(input[0], input[1]));
		}
		if (!tmp)
			break;
		sort(black.begin(), black.end());
		sort(white.begin(), white.end());
		
		if (whoWin(black, white) == 1)
			cout << "Black wins.\n";
		else if (whoWin(black, white) == 2)
			cout << "White wins.\n";
		else
			cout << "Tie.\n";
	}
	
	return 0;
}