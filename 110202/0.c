#include <stdio.h>
int main() {
	char black[5];
	char black1[5];
	char white[5];
	char white1[5];
	int i,j;
	char temp;
	int bcnt=0;
	int wcnt=0;
	int bcnt1=0;
	int wcnt1=0;
	int bresult;
	int wresult;
	char b,w;
	char bmax=48;
	char wmax=48;
	while(scanf("%c",&black[0])==1){
		scanf("%c ",&black1[0]);
		for(i=1;i<5;i++){
			scanf("%c%c%*c",&black[i],&black1[i]);
		}
		for(i=0;i<5;i++){
			if(black[i] == 'T')
				black[i] = 58;
			else if(black[i] == 'J')
				black[i] = 59;
			else if(black[i] == 'Q')
				black[i] = 60;
			else if(black[i] == 'K')
				black[i] = 61;
			else if(black[i] == 'A')
				black[i] = 62;
		}
		for(i=0;i<5;i++){
			if(i==4)
				scanf("%c%c", &white[i],&white1[i]);
			else
				scanf("%c%c%*c", &white[i],&white1[i]);
			if(white[i]=='T')
				white[i]=58;
			else if(white[i]=='J')
				white[i]=59;
			else if(white[i]=='Q')
				white[i]=60;
			else if(white[i]=='K')
				white[i]=61;
			else if(white[i]=='A')
				white[i]=62;
		}
		for(i=0;i<5;i++){
			for(j=0;j<4;j++){
				if(black[j]>black[j+1]){
					temp = black[j];
					black[j] = black[j+1];
					black[j+1] = temp;
					temp = black1[j];
					black1[j] = black1[j+1];
					black1[j+1] = temp;
				}	
			}
		}// 정렬
		for(i=0;i<5;i++){
			for(j=0;j<4;j++){
				if(white[j]>white[j+1]){
					temp = white[j];
					white[j] = white[j+1];
					white[j+1] = temp;
					temp = white1[j];
					white1[j] = white1[j+1];
					white1[j+1] = temp;
				}
			}
		}// 정렬
		for(i=1;i<5;i++){
			if(black[i]==black[i-1]){
				bcnt++;
				b = black[i];
				if(bcnt == 2){//투 페어
					if(black[i-1]!=black[i-2]){
						if(black[i-1] == black[i+1]){
							bcnt+=0;
						}
						else{
							bcnt = 10;
							b=black[i];
						}
					}
				}
				if(bcnt == 3){//풀하우스
					if(black[1]!=black[3]){
						bcnt = 20;
						if(black[i]!=black[i-2])
							b= black[i-2];
						else
							b = black[i];
					}
				}
			}
			if(white[i] == white[i-1]){
				wcnt++;
				w = white[i];
				if(wcnt==2){//투 페어
					if(white[i-1]!=white[i-2]){
						if(white[i]==white[i+1])
							wcnt +=0;
						else{
							wcnt = 10;
							w = white[i];
						}
					}
				}
				if(wcnt ==3 ){//풀하우스
					if(white[1]!=white[3]){
						wcnt =20;
						if(white[i]!=white[i-2])
							w=white[i-2];
						else
							w=white[i];
					}
				}
			}
		} // 원 페어 투 페어 쓰리 카드 풀하우스 포 카드
		if(bcnt == 0){
			bresult = 0;
			if(black[4] == white[4]){
				if(black[3] == white[3]){
					if(black[2] == white[2]){
						if(black[1] == white[1]){
							if(black[0] == white[0]){
								b = black[0];
							}
							else
								b= black[0];
						}
						else
							b=black[1];
					}
					else
						b= black[2];
				}
				else
					b = black[3];
			}
			else
				b = black[4];
		}
		if(wcnt == 0){
			wresult =0;
			if(black[4] == white[4]){
				if(black[3] == white[3]){
					if(black[2] == white[2]){
						if(black[1] == white[1]){
							if(black[0] == white[0]){
								w=white[0];
							}
							else
								w=white[0];
						}
						else
							w=white[1];
					}
					else
						w= white[2];
				}
				else
					w= white[3];
			}
			else
				w = white[4];
		}// 하이 카드
		if(bcnt == 1)
			bresult = 1;
		if(wcnt == 1)
			wresult = 1;// 원페어
		if(bcnt >=10)
			bresult = 2;
		if(wcnt >= 10)
			wresult = 2;// 투페어
		if(bcnt == 2)
			bresult = 3;
		if(wcnt == 2)
			wresult = 3;// 쓰리카드
		if(bcnt>=20)
			bresult = 6;
		if(wcnt>=20)
			wresult = 6;// 풀하우스
		if(bcnt == 3)
			bresult = 7;
		if(wcnt == 3)
			wresult = 7;// 포카드
	
		bcnt = 0;
		wcnt = 0;
		if(bresult==0){
			for(i=1;i<5;i++){
				if(black[i]==black[i-1]+1)
					bcnt++;
				else
					bcnt+=0;
			}
			for(i=1;i<5;i++){
				if(black1[i]==black1[i-1])
					bcnt1++;
				else
					bcnt1+=0;
			}
		}
		if(wresult==0){
			for(i=1;i<5;i++){
				if(white[i]==white[i-1]+1)
					wcnt++;
				else
					wcnt+=0;
			}
			for(i=1;i<5;i++){
				if(white1[i]==white1[i-1])
					wcnt1++;
				else
					wcnt1+=0;
			}
		}//스트레이트
		
		if(bcnt == 4){
			bresult = 4;
			b = black[4];
		}
		if(wcnt == 4){
			wresult = 4;
			w = white[4];
		}
		if(bcnt1 == 4){
			if(bresult == 4)
				bresult = 8;
			else
				bresult = 5;
		}
		if(wcnt1 == 4){
			if(wresult == 4)
				wresult = 8;
			else
				wresult = 5;
		}
		
		if(bresult == 2 && wresult == 2){
			if(b==w){
				if(black[4]==black[3]){
					if(black[1]==black[0])
						b=black[2];
					else if(black[2]==black[1])
						b=black[0];
				}
				if(white[4]==white[3]){
					if(white[1]==white[0])
						w=white[2];
					else if(white[2]==white[1])
						w=white[0];
				}	
			}	
		}
		if(bresult ==1 && wresult ==1){
			if(b==w){
				for(i=0;i<5;i++){
					if(black[i] == b)
						black[i]=48;
					if(white[i] == w)
						white[i]=48;
				}
				for(i=0;i<5;i++){
					if(black[i]>bmax)
						bmax = black[i];
					if(white[i]>wmax){
						wmax = white[i];
					}
				}
				if(wmax == bmax){
					for(i=0;i<5;i++){
						if(black[i]==bmax)
							black[i]=48;
						if(white[i]==wmax)
							white[i]=48;
					}
					bmax=48;
					wmax=48;
					for(i=0;i<5;i++){
						if(black[i]>bmax)
							bmax = black[i];
						if(white[i]>wmax)
							wmax = white[i];
					}
					if(bmax == wmax){
						for(i=0;i<5;i++){
							if(black[i]==bmax)
								black[i]=48;
							if(white[i]==wmax)
								white[i]=48;
						}
						for(i=0;i<5;i++){
							if(black[i]!=48)
								bmax = black[i];
							if(white[i]!=48)
								wmax = white[i];
						}
					}
				}
			}
				else
					break;
				b= bmax;
				w= wmax;
				bmax=48;
				wmax=48;
		}
		
		if(bresult>wresult)
			printf("Black wins.\n");
		else if(wresult>bresult)
			printf("White wins.\n");
		else if(wresult == bresult){
			if(b>w)
				printf("Black wins.\n");
			else if(b<w)
				printf("White wins.\n");
			else
				printf("Tie.\n");
		}
		scanf("%*c");
		
		bcnt1=0;
		wcnt1=0;
		bcnt=0;
		wcnt=0;
		bresult = 0;
		wresult = 0;
		b='\0';
		w='\0';
		for(i=0;i<5;i++){
			black[i] = '\0';
			black1[i] = '\0';
			white[i] = '\0';
			white1[i] = '\0';
		}	// 값 초기화
		
	}
}
