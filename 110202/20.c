#include <stdio.h>
#define getValue(x) ((x)/10)
#define getSuit(x) ((x)%10)
typedef struct {
	int card[5];
	long score;
} player;

int encodeCard(char *card)
{
	int result;
	switch(card[0])
	{
			case'T' : result = 100; break;
			case'J' : result = 110; break;
			case'Q' : result = 120; break;
			case'K' : result = 130; break;
			case'A' : result = 140; break;
		default: result = (card[0] - '0') * 10;
	}
	switch(card[1])
	{
		case 'H': result += 1; break;
		case 'D': result += 2; break;
		case 'S': result += 3; break;
		case 'C': result += 4; break;
	}
		return result;
}

long getScore(int hand[5])
{
	int i, j, max, tmp;
	int value[5], suit[5];
	long result;
	for (i = 0; i < 4; i++)
	{
		max = i;
		for (j = i + 1; j < 5; j++)
			if(hand[j] > hand[max])
				max = j;
		tmp = hand[i];
		hand[i] = hand[max];
		hand[max] = tmp;
	}
	for (i = 0; i < 5; i++)
	{
		value[i] = getValue(hand[i]);
		suit[i] = getSuit(hand[i]);
	}
	//SF
	if (value[1] + 1 == value[0] && suit[1] == suit[0] 
			&& value[2] + 2 == value[0] && suit[2] == suit[0]
			&& value[3] + 3 == value[0] && suit[3] == suit[0]
			&& value[4] + 4 == value[0] && suit[4] == suit[0])
		result = (9 << 20) + (value[0] << 16);
	//4C
	else if (value[1] == value[0] && value [2] == value[0] && value [3] == value[0])
		result = (8 << 20) + (value[0] << 16);
	else if (value[2] == value [1] && value [3] == value[1] && value[4] && value[1])
		result = (8 << 20) + (value[1] << 16);
	//FH
	else if (value[1] == value[0] && value [2] == value[0] && value[3] == value[4])
		result = (7 << 20) + (value[0] << 16);
	else if (value[1] == value [0] && value [2] == value[3] && value[2] == value[4])
		result = (7 << 20) + (value[2] << 16);
	//FLSH
	else if (suit[0] == suit[1] && suit[0] == suit[2] && suit[0] == suit[3] && suit[0] == suit[4])
		result = (6 << 20) + (value[0] << 16);
	//ST
	else if (value[1] + 1 == value[0] && value[2] + 2 == value[0] && value[3] + 3 == value[0] && value[4] + 4 ==value[0])
		result = (5 << 20) + (value[0] << 16);
	//3C
	else if (value[0] == value [1] && value[0] == value[2])
		result = (4 << 20) + (value[0] << 16);
	else if (value[1] == value [2] && value [1] == value[3])
		result = (4 << 20) + (value[1] << 16);
	else if (value[2] == value[3] && value[2] == value[4])
		result = (4 << 20) + (value[2] << 16);
	//2F
	else if (value[0] == value[1] &&(value[2] == value[3] || value[3] == value[4]))
		result = (3 << 20) + (value[0] << 16);
	else if (value[1] == value[2] && value[3] == value[4])
		result = (3 << 20) + (value[1] << 16);
	//1F
	else if (value[0] == value[1] || value[1] == value[2] || value[2] == value[3] || value[3] == value[4] )
		result = (2 << 20) + (value[0] << 16);
	else
		result = (1 << 20 ) + (value[0] << 16) + (value[1] << 12) + (value[2] << 8) + (value[3] << 4) + value[4];
	
	
	
	return result;
}

int main() {
	player p1, p2;
	char buf[10][2];
	while (scanf("%s %s %s %s %s %s %s %s %s %s", &buf[0], &buf[1], &buf[2], &buf[3], &buf[4], &buf[5], &buf[6], &buf[7], &buf[8], &buf[9]) == 10)
	{
		for (int i = 0; i< 10; i++)
			if(i < 5)
				p1.card[i] = encodeCard(buf[i]);
			else
				p2.card[i-5] = encodeCard(buf[i]);
	p1.score = getScore(p1.card);
	p2.score = getScore(p2.card);
	
	if (p1.score > p2.score)
		printf("Black wins.\n");
	else if (p1.score < p2.score)
		printf("White wins.\n");
	else
		printf("Tie.\n");
	}
}
