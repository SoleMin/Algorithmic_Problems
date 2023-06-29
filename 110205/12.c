#include <stdio.h>
#include <string.h>

int main() {
	
	int tcase,i,j,k,shuffle,scan_shuf,tmp,value,suit;
	int shuffle_arr[101][53];
	int deck[53], tmp_arr[53];
	char line[100];
	
	scanf("%d",&tcase); //테스트 케이스
	
	for(i=0;i<tcase;i++){
		 printf("\n");//맨 처음 엔터
		
		for(k=1;k<=52;k++)
			deck[k] = k;        // deck[k] 1~52로 초기화
		
		scanf("%d",&shuffle); //총 셔플 세트 갯수
		
		for(j=1;j<=shuffle;j++){
		for(k=1;k<=52;k++)
		scanf("%d",&shuffle_arr[j][k]);
		}
		//52개 입력받음
		gets(line);
		while(gets(line) && *line) {
			sscanf(line,"%d",&scan_shuf);
			for(k=1;k<=52;k++)
				tmp_arr[k] = deck[k];
			for(k=1;k<=52;k++)
				deck[k] = tmp_arr[shuffle_arr[scan_shuf][k]];
			//printf("shuf %d\n",scan_shuf);
		}
		//123456789 J10 Q11 K12 A13    1~9   10~13 
		for(k=1;k<=52;k++){
			value = (deck[k] - 1) % 13;
			suit = (deck[k] - 1) / 13;
			switch(value){
				case 9 : printf("Jack"); break;
				case 10 : printf("Queen"); break;
				case 11 : printf("King"); break;
				case 12 : printf("Ace"); break;
				default : printf("%d",value+2); break;
			}
			printf(" of ");
			switch(suit){
				case 0 : printf("Clubs"); break;
				case 1 : printf("Diamonds"); break;
				case 2 : printf("Hearts"); break;
				case 3 : printf("Spades"); break;
			}
			printf("\n");
		}
	}
	return 0;
}
