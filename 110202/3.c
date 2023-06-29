#include <stdio.h>
void cal(char str[], int arr[]);
void whoWin(int arr[]);

void main()
{
	char str[31];
	int arr[10]={0,};
	while(gets(str)){
		cal(str, arr);
		whoWin(arr);
		
		for(int i=0; i<31; i++) str[i]=0;
		for(int i=0; i<10; i++) arr[i]=0;
	}
}
void cal(char str[], int arr[])
{
	int min, tmp;
	for(int i=0; i<=31; i++)
	{
		if(i%3==0)		// 카드 숫자
		{
			switch(str[i]){
				case 'A':
					arr[i/3]=140;
					break;
				case 'K':
					arr[i/3]=130;
					break;
				case 'Q':
					arr[i/3]=120;
					break;
				case 'J':
					arr[i/3]=110;
					break;
				case 'T':
					arr[i/3]=100;
					break;
				default:
					arr[i/3]=(str[i]-48)*10;
					break;
			}
		}
		else if((i-1)%3 == 0){	// 카드 문자 계산 
			switch(str[i]){
				case 'D':
					arr[i/3]+=1;
					break;
				case 'H':
					arr[i/3]+=2;
					break;
				case 'S':
					arr[i/3]+=3;
					break;					
			}
		}
	}
	
	for(int i=0; i<5; i++){
		min=i;
		for(int j=i+1; j<5; j++){
			if(arr[min]>arr[j])
				min=j;
		}
		tmp=arr[min];
		arr[min]=arr[i];
		arr[i]=tmp;
	}
	for(int i=5; i<10; i++){
		min=i;
		for(int j=i+1; j<10; j++){
			if(arr[min]>arr[j])
				min=j;
		}
		tmp=arr[min];
		arr[min]=arr[i];
		arr[i]=tmp;
	}
	
}
void whoWin(int arr[])
{
	int score[2];
	char chr[2][5];
	int num[2][5], count[15], cardMax, cardMin, k;

	for(int i=0; i<10; i++){
		if(i<5){
			num[0][i]=arr[i]/10;
			chr[0][i]=arr[i]%10;
		}
		else{
			num[1][i%5]=arr[i]/10;
			chr[1][i%5]=arr[i]%10;
		}
	}
	
	for(int i=0; i<2; i++){
		for(int j=0; j<15; j++) count[j]=0;				//count 배열 초기화
		if(chr[i][0]==chr[i][1] && chr[i][0] == chr[i][2] && chr[i][0]==chr[i][3] && chr[i][0] == chr[i][4]){
			int check=1;
			for(int j=1; j<5; j++){
				if(num[i][0]!=num[i][j] +j)
					check=0;
			}
			if(check)
				score[i]=(8<<20) + (num[i][4]<<16);			//스트레이트 플러쉬
			else
				score[i]=(5<<20) + (num[i][4]<<16);			// 플러쉬
		}
		else			//무늬가 모드 같지 않은경우
		{
			for(int j=0; j<5; j++)
				count[num[i][j]]++;						//각 카드가 몇번 나왔나 세기
			cardMax=0, cardMin=0;
			for(int j=2; j<15; j++){
				if(count[j]>count[cardMax])
					cardMax=j;
			}
			for(int j=2; j<15; j++){
				if(count[j]>count[cardMin] && j!=cardMax)
					cardMin=j;
			}
			
			if(count[cardMax]==4){						//포카드
				score[i]=(7<<20) + (cardMax<<16);
			}else if(count[cardMax]==3 && count[cardMin]==2){		//풀하우스
				score[i]=(6<<20) + (cardMax<<16);
			}else if(num[i][0]+1==num[i][1] && num[i][0]+2==num[i][2] && num[i][0]+3 == num[i][3] && num[i][0]+4==num[i][4] )								//스트레이트
				score[i]=(4<<20) + (num[i][4]<<16);
			else if(count[cardMax]==3){					//트리플
				score[i]=(3<<20) + (num[i][2]<<16);
			}
			else if(count[cardMax]==2 && count[cardMin] == 2){	// 투페어
				for(k=14; count[k]!=1; k--);
				score[i] = (2<<20) + (cardMax<<16) + (2<<12) + (cardMin<<8) + k;
			}else if(count[cardMax]==2){				//원페어
				for(k=14; count[k]!=1; k--);
				score[i] = (2<<20) + (cardMax<<16) + k;	
			}else{										//하이 카드
				score[i] = 1<<21;
				for(k=14; k>=2; k--)
					if(count[k])
						score[i] += (1<<k);
			}
		}
	}
	
	if(score[0]>score[1])
		printf("Black wins.\n");
	else if(score[0]<score[1])
		printf("White wins.\n");
	else
		printf("Tie.\n");
}
