#include <iostream>
#include <map>
#include <string>
#define get_value(x) ((x)/10)
#define get_suit(x) ((x)%10)

using namespace std;
int encode_card(char* card){
	int result;
	switch(card[0]) {
		case 'T': result = 100; break;
		case 'J': result = 110; break;
		case 'Q': result = 120; break;
		case 'K': result = 130; break;
		case 'A': result = 140; break;
		default: result = (card[0]-'0')*10;
	}
	switch(card[1]){
		case 'H': result += 1; break;
		case 'D': result += 2; break;
		case 'S': result += 3; break;
		case 'C': result += 4; break;
	}
	return result;
	}
long get_hand_value(int hand[5]){
	int i, j, max, temp;
	int value[5], suit[5];
	long result;
	for(i=0;i<4;i++){
		max = i;
		for(j=i+1;j<5;j++)
			if(hand[j]>hand[max])
				max=j;
		temp = hand[i];
		hand[i]= hand[max];
		hand[max] = temp;
	}
	for(i=0; i<5;i++){
		value[i]=get_value(hand[i]);
		suit[i] = get_suit(hand[i]);
	}
	if(value[1]+1 ==value[0] && suit[1]==suit[0]
		&& value[2]+2 == value[0]&&suit[2]==suit[0]
		&&value[3]+3==value[0]&&suit[3]==suit[0]
		&&value[4]+4==value[0]&&suit[4]==suit[0])
		result = (9<<20) + value[0];
	else if((value[1]==value[0]&&value[2]==value[0]&&value[3]==value[0])
				 ||(value[2]==value[1]&&value[3]==value[1]&&value[4]==value[1]))
		result = (8<<20) + value[3];
	else if(value[1]==value[0]&&value[2]==value[0]&&value[3]==value[4])
		result = (7<<20) + value[0];
	else if(value[1]==value[0]&&value[2]==value[3]&&value[3]==value[4])
		result = (7<<20) + value[4];
	else if(suit[1]==suit[0]&&suit[2]==suit[0]&&suit[3]==suit[0]&&suit[4]==suit[0])
		result = (6<<20) + value[0] * 10000+value[1]*1000+value[2]*100+value[3]*10+value[4];
	else if(value[1]+1==value[0]&&value[2]+2==value[0]&&value[3]+3==value[0]&&value[4]==value[0])
		result = (5<<20)+value[0];
	else if((value[1]==value[0]&&value[2]==value[0])||(value[3]==value[2]&&value[4]==value[2]))
		result=(4<<20)+value[2];
	else if(value[1]==value[0]&&value[2]==value[3])
		result=(3<<20)+value[0]*10000+value[2]*1000+value[4]*100;
	else if(value[1]==value[2]&&value[3]==value[4])
		result = (3<<20)+ value[1]*10000+value[3]*1000+value[0]*100;
	else if(value[0]==value[1]&&value[3]==value[4])
		result = (3<<20)+ value[0]*10000+ value[3]*1000+value[2]*100;
	
	else if(value[0]==value[1])
		result = (2<<20)+value[0]*10000+value[2]*1000+value[3]*100+value[4]*10;
	else if(value[1]==value[2])
		result = (2<<20)+value[1]*10000+value[0]*1000+value[3]*100+value[4]*10;
	else if(value[2]==value[3])
		result = (2<<20)+value[2]*10000+value[0]*1000+value[1]*100+value[4]*10;
	else if(value[3]==value[4])
		result = (2<<20)+value[3]*10000+value[0]*1000+value[1]*100+value[2]*10;
	
	else{
		result = (1<<20)+(value[0]<<16)+(value[1]<<15)+(value[2]<<14)+(value[3]<<13)+(value[4]<<12);
	}
	return result;
}
int main(){
	string line;
	char card[2]={0, };
	int bhand[5] = {0,};
	int whand[5] = {0,};
	long bresult = 0;
	long wresult = 0;
	while(getline(cin,line)){
		card[0] = line[0];
		card[1] = line[1];
		bhand[0] = encode_card(card);
		
		card[0] = line[3];
		card[1] = line[4];
		bhand[1] = encode_card(card);
		
		card[0] = line[6];
		card[1] = line[7];
		bhand[2] = encode_card(card);
		
		card[0] = line[9];
		card[1] = line[10];
		bhand[3] = encode_card(card);
		
		card[0] = line[12];
		card[1] = line[13];
		bhand[4] = encode_card(card);
		bresult = get_hand_value(bhand);
		
		card[0] = line[15];
		card[1] = line[16];
		whand[0] = encode_card(card);
		
		card[0] = line[18];
		card[1] = line[19];
		whand[1] = encode_card(card);
		
		card[0] = line[21];
		card[1] = line[22];
		whand[2] = encode_card(card);
		
		card[0] = line[24];
		card[1] = line[25];
		whand[3] = encode_card(card);
		
		card[0] = line[27];
		card[1] = line[28];
		whand[4] = encode_card(card);
		wresult = get_hand_value(whand);
		
		if(bresult==wresult) cout<<"Tie."<<endl;
		if(bresult>wresult) cout<<"Black wins."<<endl;
		if(bresult<wresult) cout<<"White wins."<<endl;
	}
		return 0;
}
