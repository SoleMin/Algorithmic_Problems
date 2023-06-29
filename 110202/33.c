#include <stdio.h>
#include <stdlib.h>
#define getval(x) ((x)/10)
#define getsuit(x) ((x)%10)

int compare(const void *a, const void *b){
	int n1 = *(int*)a;
	int n2 = *(int*)b;
	if(n1<n2) return 1;
	if(n1>n2) return -1;
	return 0;
}

int encoding(char *ch){
	int res;
	switch(ch[0]){
		case 'T' : res = 100; break;
		case 'J' : res = 110; break;
		case 'Q' : res = 120; break;
		case 'K' : res = 130; break;
		case 'A' : res = 140; break;
		default: res = (ch[0]-'0') * 10;
	}
	switch(ch[1]){
		case 'S' : res += 1; break;
		case 'H' : res += 2; break;
		case 'D' : res += 3; break;
		case 'C' : res += 4; break;
	}
	return res;
}

long get_handVal(int hand[5]){
	int i, j, val[5], suit[5];
	long res;
	for(i=0; i<5; i++){
		val[i] = getval(hand[i]);
		suit[i] = getsuit(hand[i]);
	}
	qsort(val, sizeof(val)/sizeof(int), sizeof(int), compare);
	
	if(val[1]+1==val[0] && suit[1]==suit[0]
		 && val[2]+2==val[0] && suit[2]==suit[0]
		 && val[3]+3==val[0] && suit[3]==suit[0]
		 && val[4]+4==val[0] && suit[4]==suit[0])
		res = (9<<20)+(val[0]<<16);
	
	else if(val[0]==val[3] || val[1]==val[4])
		res = (8<<20)+(val[1]<<16);
	
	else if(val[0]==val[2] && val[3]==val[4])
		res = (7<<20)+(val[0]<<16);
	else if(val[0]==val[1] && val[2]==val[4])
		res = (7<<20)+(val[2]<<16);
	
	else if(suit[1]==suit[0] && suit[2]==suit[0]
				 && suit[3]==suit[0] && suit[4]==suit[0])
		res = (6<<20)+(val[0]<<16)+(val[1]<<12)+(val[2]<<8)+(val[3]<<4)+val[4];
	
	else if(val[1]+1==val[0] && val[2]+2==val[0]
				 && val[3]+3==val[0] && val[4]+4==val[0])
		res = (5<<20)+(val[0]<<16);
	
	else if(val[0]==val[2] || val[1]==val[3] || val[2]==val[4])
		res = (4<<20)+(val[2]<<16);
	
	else if(val[0]==val[1] && val[2]==val[3])
		res = (3<<20)+(val[1]<<16)+(val[3]<<12)+(val[4]<<8);
	else if(val[0]==val[1] && val[3]==val[4])
		res = (3<<20)+(val[1]<<16)+(val[3]<<12)+(val[2]<<8);
	else if(val[1]==val[2] && val[3]==val[4])
		res = (3<<20)+(val[1]<<16)+(val[3]<<12)+(val[0]<<8);
	
	else if(val[0]==val[1])
		res = (2<<20)+(val[0]<<16)+(val[2]<<12)+(val[3]<<8)+(val[4]<<4);
	else if(val[1]==val[2])
		res = (2<<20)+(val[1]<<16)+(val[0]<<12)+(val[3]<<8)+(val[4]<<4);
	else if(val[2]==val[3])
		res = (2<<20)+(val[2]<<16)+(val[0]<<12)+(val[1]<<8)+(val[4]<<4);
	else if(val[3]==val[4])
		res = (2<<20)+(val[3]<<16)+(val[0]<<12)+(val[1]<<8)+(val[2]<<4);
	
	else
		res = (1<<20)+(val[0]<<16)+(val[1]<<12)+(val[2]<<8)+(val[3]<<4)+val[4];
	
	return res;
}

int main() {
	char line[100];
	int hand[2][5], i, j, index;
	long result[2];
	while(gets(line)&&*line){
		index = 0;
		for(i=0; i<2; i++){
			for(j=0; j<5; j++){
				while(line[index]==' ') index++;
				hand[i][j] = encoding(line+index);
				index += 2;
			}
			result[i] = get_handVal(hand[i]);
		}
		if(result[0]>result[1])
			printf("Black wins.\n");
		else if(result[0]<result[1])
			printf("White wins.\n");
		else
			printf("Tie.\n");
	}
}
