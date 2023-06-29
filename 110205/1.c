#include <stdio.h>

void display(int num)
{
	char suit[4][9] = {"Clubs","Diamonds","Hearts","Spades"};
	int s;
	int x = num;
	// 1~13 C 2~10 JQKA
	// 14~26 D 2~10 JQKA
	// 27~39 H 2~10 JQKA
	// 40~52 S 2~10 JQKA
	// 1~9 14~22 27~35 40~48 숫자
	// 10~13 23~26 36~39 49~52 문자
	//printf("num:%d\n",num);
	if(x<=13)
		s = 0;
	else if(x>=14 && x<=26)
		s = 1;
	else if(x>=27 && x<=39)
		s = 2;
	else if(x>=40 && x<=52)
		s = 3;
		
	
	if(x>13)
		x = x % 13;

	if(x<10 && x>0)
		printf("%d of %s\n",x+1,suit[s]);
	else if(x==10)
		printf("Jack of %s\n",suit[s]);
	else if(x==11)
		printf("Queen of %s\n",suit[s]);
	else if(x==12)
		printf("King of %s\n",suit[s]);
	else if(x==0 || x==13)
		printf("Ace of %s\n",suit[s]);
	else
		printf("error %d\n",num);
}
int main() {

 // 카드 52장  
 // 무늬마다 값 1~13
 // C D H S 순
 // 1~52
	char buff[100];
	int card[53];
	int tmp[53];
	int shuffle[101][53];
	int case_, n, k, i;
	scanf("%d",&case_); // 케이스 개수


	
	for(i=0;i<case_;i++)
	{
		scanf("%d",&n); // 셔플방법 개수
		for(int sf=1;sf<=n;sf++)
		{
			for(int j=1;j<53;j++)
				scanf("%d",&shuffle[sf][j]); // 					
			for(int j=1;j<53;j++)
				card[j] = j; //초기화
		}
		
		gets(buff);
		while(gets(buff) && *buff)
		{
			sscanf(buff,"%d",&k);
			for(int j=1;j<53;j++)
				tmp[j] = card[j];
			for(int j=1;j<53;j++)
				card[j] = tmp[shuffle[k][j]];

		}
		
		for(int b=1;b<53;b++)
			display(card[b]);
		
		printf("\n");
	}	
}
