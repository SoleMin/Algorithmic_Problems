#include <stdio.h>
#define get_value(x) ((x) / 10)
#define get_suit(x) ((x) % 10)

int encode_card(char *card) {
	int result;
	
	switch (card[0]) {
	
		case 'T' : result = 100; break;
	
		case 'J' : result = 110; break;
	
		case 'Q' : result = 120; break;
	
		case 'K' : result = 130; break;
	
		case 'A' : result = 140; break;
	
		default : result = (card[0] - '0') * 10;
	}
	switch (card[1]) {
	case 'H' : result += 1; break;
	case 'D' : result += 2; break;
	case 'S' : result += 3; break;
	case 'C' : result += 4; break;
	}
	return result;
}

long get_hand_value(int hand[5]) {
	int i, j, max, temp, check;
	int value[5], suit[5];
	int rep[2] = {0,0};
	long result;
	for (i = 0; i < 4; i++) {
		max = i;
		for (j = i + 1; j < 5; j++)
			if (hand[j] > hand[max])
				max = j;
		temp = hand[i];
		hand[i] = hand[max];
		hand[max] = temp;
	}
	
	for ( i = 0; i < 5; i++) {
		value[i] = get_value(hand[i]);
		suit[i] = get_suit(hand[i]);
	}
	
	temp = 0;
	for ( i = 1; i < 5; i++) {
		if((value[i-1] == value[i])) {
			if(rep[temp] == 0)
				rep[temp] = (value[i]*10 + 2);
			else
				rep[temp] += 1;
		}
		else {
			if(rep[temp] != 0) 
				temp += 1;
		}
	}
	
	check = 1;
	for (i = 0; i < 4; i++) {
		if(value[i] + 1 != value[i+1]) {
			check = 0;
			break;
		}
	}
	
	if (check && suit[0] == suit[1] && suit[0] == suit[2] && suit[0] == suit[3] && suit[0] == suit[4])
		result = (9 << 20) + (value[0] << 16);
	else {
		int m,n;
		m = rep[0] % 10;
		n = rep[1] % 10;

		if(n > m) {
			rep[0] ^= rep[1];
			rep[1] ^= rep[0];
			rep[0] ^= rep[1];
			m ^= n;
			n ^= m;
			m ^= n;
		}
		max = rep[0]/10;
		if(m == 4) 
			result = (8 << 20) + (max << 16);
		else if(m == 3 && n == 2) {
			result = ( 7 << 20) + (max << 16);
		}
		else if(suit[0] == suit[1] && suit[0] == suit[2] && suit[0] == suit[3] && suit[0] == suit[4])
			result = (6 << 20) + (value[0] << 16) + (value[1] << 12) + (value[2] << 8) + (value[3] << 4) + (value[4]);
		else {
			if(check) 
				result = (5 << 20) + (value[0] << 16) + (value[1] << 12) + (value[2] << 8) + (value[3] << 4) + (value[4]);
			else if(m == 3) 
				result = (4 << 20) + (max << 16);
			else if(m == n && m == 2) {
				result = 0;
				if(rep[0]/10 < rep[1]/10) {
					rep[0] ^= rep[1];
					rep[1] ^= rep[0];
					rep[0] ^= rep[1];
					max = rep[0]/10;
				}
				
				for(i = 0 ; i < 5; i++) {
					if(value[i] != max && value[i] != (rep[1]/10)) {
						result = (3 << 20) + (max << 16) + ( (rep[1]/10) << 12) + (value[i] << 8);
						break;
					}
				}	
			}
			else if(m == 2) {
				result = (2 << 20) + (max << 16);
				temp = 2;
				for(i = 0; i < 5; i++) {
					if(value[i] != max) {
						result += (value[i] << (16/temp));
						temp *= 2;
					}
				}
			}
			else
				result = (1 << 20) + (value[0] << 16) + (value[1] << 12) + (value[2] << 8) + (value[3] << 4) + (value[4]);			 
		}
		return result;
	}
}

int main() {
	char b[2],w[2],line[1];
	int bh[5],wh[5];
	int i;
	long br,wr;
	while(scanf("%s",b) == 1) {
		bh[0] = encode_card(b);
		for(i = 1; i < 5; i++) {
			scanf("%s",b);
			bh[i] = encode_card(b);
		}
		for(i = 0; i < 5; i++) {
			scanf("%s",w);
			wh[i] = encode_card(w);
		}
		br = get_hand_value(bh);
		wr = get_hand_value(wh);
		if(wr > br) 
			puts("White wins.");
		else if ( br > wr) 
			puts("Black wins.");
		else 
			puts("Tie.");
		
		scanf("%*[^\n]",line);
					 
	}
	return 0;
}

