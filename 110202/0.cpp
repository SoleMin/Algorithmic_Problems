#include <cstdio>
// 2,3,4,5,6,7,8,9,10,11,12,13,14
class cardHand{
	private:
		int num[15];
		int pattern[5];
	public:
		int lv;
		void init(){ for(int i=0;i<15;i++){ num[i]=0; if(i<5) pattern[i]=0; } }
		//----------------------------------------------------------
		void put_num(char n){ //숫자 입력
			if('2' <= n && '9'>= n) ++num[n-48];
			else{
				switch(n){
					case 'T': ++num[10]; break;
					case 'J': ++num[11]; break;
					case 'Q': ++num[12]; break;
					case 'K': ++num[13]; break;
					case 'A': ++num[14]; break;
				}
			}
		}
		void put_pattern(char p){ //무늬 입력
			switch(p){
				case 'C': ++pattern[0]; break;
				case 'D': ++pattern[1]; break;
				case 'H': ++pattern[2]; break;
				case 'S': ++pattern[3]; break;
			}
		}
		//-------------------------------------------------------------
		//스플9, 포카8, 풀하7, 플러6, 스트5, 트리플4, 투페어3, 원페어2, 하이1
	
		int least_straight(){ //숫자가 연속됨. 스플or스트.
			for(int i=0;i<5;i++) if(pattern[i] == 5) return 9;
			return 5;
		}
		
		int least_triple(){ //숫자가 3개 같음. 트리플 or 풀하.													 
			for(int i=2;i<15;i++) if(num[i] == 2) return 7;
			return 4; //같은게 3장이기만 한 경우.
		}
		
		int least_onepair(int start){ //숫자쌍이 2개. 즉 투페어거나 원페어거나 아무것도 아니거나.
			for(int i=start+1;i<15;i++) if(num[i] == 2) return 3; //숫자쌍 이후에 또 숫자쌍 = 투페어.
			return 2; //없으면 원페어.
		}
			
		int hand_level(){ //패 판정
			
			/*
				숫자로 판정하는건 연속, 4개공통, 3개공통으로 나뉘며, 
				연속은 스플 스트
				4개공통은 포카드
				3개공통은 트리플 or 풀하우스
				일 확률이 높다.
			*/
			for(int i=2;i<15;i++){
				if(num[i]==1 && num[i+1]==1 && num[i+2]==1 && num[i+3]==1 && num[i+4]==1 && i<11) return least_straight(); //스플 or 스트
				else if(num[11]==1 && num[12]==1 && num[13]==1 && num[14]==1 && num[2]==1) return least_straight();
				else if(num[12]==1 && num[13]==1 && num[14]==1 && num[2]==1 && num[3]==1) return least_straight();
				else if(num[13]==1 && num[14]==1 && num[2]==1 && num[3]==1 && num[4]==1) return least_straight();
				else if(num[14]==1 && num[2]==1 && num[3]==1 && num[4]==1 && num[5]==1) return least_straight();
				
				if(num[i] >= 4) return 8; //포카드
				else if(num[i] == 3) return least_triple(); //트리플, 풀하.
			}
			
			for(int i=0;i<5;i++) if(pattern[i] == 5) return 6; //플러시
			for(int i=2;i<15;i++) if(num[i] == 2) return least_onepair(i); //원페어, 투페어.
			return 1;
		}
	
		int high_card(int max){
			for(int i=max;i>=2;i--) if(num[i]>0) return i;
			return -1;
		}
};
int main() {
	cardHand hand[2];
	char str[2];
	int k;
	
	while(scanf("%s",str) == 1){
	k=4;
	for(int i=0;i<2;i++){
		hand[i].init();
		if(i==0){ hand[0].put_num(str[0]); hand[0].put_pattern(str[1]);}
		else k=5;
		for(int j=0;j<k;j++){
			scanf("%s",str);
			if(str)
			hand[i].put_num(str[0]);
			hand[i].put_pattern(str[1]);
		}
		hand[i].lv=hand[i].hand_level();
	}
	
	if(hand[0].lv == hand[1].lv){
		int max=14;
		while(max>0){
			hand[0].lv=hand[0].high_card(max);
			hand[1].lv=hand[1].high_card(max);
			if(hand[0].high_card(max) == hand[1].high_card(max))
				max=hand[0].high_card(max)-1;
			else break;
		}
	}
	if(hand[0].lv > hand[1].lv) printf("Black wins.\n");
	else if(hand[0].lv < hand[1].lv) printf("White wins.\n");
	else printf("Tie.\n");
	}
	
}