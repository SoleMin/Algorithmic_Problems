#include <stdio.h>

#define get_value(x) ((x)/10)
#define get_suit(x)  ((x)%10)
int encode_card(char *card)
{
	int result;
	
	switch(card[0])
	{
		case 'T' : result = 100; break;
		case 'J' : result = 110; break;
		case 'Q' : result = 120; break;
		case 'K' : result = 130; break;
		case 'A' : result = 140; break;
		default : result = (card[0] - '0')*10;
	}
	switch(card[1])
	{
		case 'S' : result+=1; break;
		case 'D' : result+=2; break;
		case 'H' : result+=3; break;
		case 'C' : result+=4; break;
	}
	return result; //숫자화된 카드의값을 반환
}

float get_hand_value(int hand[5])
{
	int i, j, max , temp ,count=0, En_count=0;
	float value[5] , suit[5];
	float result=0, check=0 , check_down=15 , return_add=0;
	int half=100;
	for(i=0; i<4; i++) //카드값을 오름차순으로 정렬
	{
		max = i;
		for(j=i+1; j<5; j++)
		{
			if(hand[j]<hand[max])
			{
				max=j;
			}
		}
		temp=hand[i];
		hand[i] = hand[max];
		hand[max] = temp;
	}
	for(i=0; i<5; i++) //숫자값과 알파벳값을 따로 분류하여 저장
	{
		value[i] = get_value(hand[i]);
		suit[i] = get_suit(hand[i]);
	}
	
	for(i=0; i<5; i++)
	{
		for(j=0; j<5; j++)
		{
			if(value[i]==value[j] && i!=j)
			{
				if(check < value[i])
				{
					check = value[i]; //페어 중에서 큰것
				}
				else if(check_down > value[i])
				{
					check_down = value[i]; //페어중에서 작은것(투페어와 풀하우스를 위한코드)
				}
				count++;
			}
			if(suit[i] == suit[j]) //모양이 같은지 확인(플러시와 스트레이트 플러시를 위함)
			{
				En_count++;
			}
		}
	}
	
	if(En_count == 25) // 모양이 전부 같은경우
	{
		for(i=0; i<4; i++)
		{
			if(value[i]+1 == value[i+1]) continue;
			else return 6+(value[4]/100)+(value[3]/10000)+(value[2]/1000000)+(value[1]/100000000)+(value[0]/10000000000); // """플러시"""
		}
		return 9+(value[4]/100); //"""스트레이트 플러시 """ 
	}
	else if(count==0) //같은 숫자가 1개도 없을경우
	{
		for(i=0; i<4; i++)
		{
			if(value[i]+1 == value[i+1]) continue;
			else return 1+(value[4]/100)+(value[3]/10000)+(value[2]/1000000)+(value[1]/100000000)+(value[0]/10000000000); // """탑""" 
		}
		return 5+(value[4]/100); //"""스트레이트"""
	}
	switch(count)
	{	
		case 2 :  //"""원페어"""
		{
			for(int search=0; search<5; search++)
			{
				if(value[4-search] == check) continue; //페어를 제외하고서 큰값을 찾음
				else
				{
					half = half*100;
					return_add = return_add + value[4-search]/half; //찾은값을 계산하여 저장.
				}
			}
			return 2+(check/100)+return_add; break;
		}
		case 4 : //"""투페어"""
		{
			for(int search=0; search<5; search++)
			{
				if(value[4-search]==check || value[4-search]==check_down) //(투)페어 를 제외하고서 제일큰값을 찾음
				{
					continue;
				}
				else
				{
					half = half*10000;
					return_add = return_add + value[4-search]/half; //찾은 값을 계산하여 저장.
				}
			}
			return 3+(check/100)+(check_down/10000)+return_add; break;
		}
		case 6 : return 4+(check/100); break;//"""쓰리카드""" 
		case 8 : return 7+(check/100); break;//"""풀하우스""" 
		case 12 : return 8+(check/100); break;//"""포카드""" 
	}
}

int main() {
	
	int black_card[5];
	int white_card[5];
	float black_grade=-1 , white_grade=-1;
	char card[2];
	int check=0;
	while(scanf("%s",&card)==1)
	{
		if(check<5)
		{
			black_card[check] = encode_card(card);
			check++;
		}
		else
		{
			white_card[check-5]= encode_card(card);
			check++;
		}
		if(check==10)
		{
			check=0;
			black_grade = get_hand_value(black_card); //입력받은 값을 토대로 카드패의 점수를 게산
			white_grade = get_hand_value(white_card);
			
			if(black_grade > white_grade) printf("Black wins.\n"); //카드값을 비교하여 승부를 가림.
			else if(black_grade < white_grade) printf("White wins.\n");
			else  printf("Tie.\n");
		}
	}
}
