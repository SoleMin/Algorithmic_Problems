#include <stdio.h>
#define get_value(x) ((x)/10)
#define get_suit(x) ((x)%10)

int encode(char* card)
{
	int result =0;
	
	switch(card[0])
	{
		case 'T': result=100;
			break;
		case 'J': result=110;
			break;
		case 'Q': result=120;
			break;
		case 'K': result=130;
			break;
		case 'A': result=140;
			break;
		default: result = (card[0]-'0')*10;
	}
	
	switch(card[1])
	{
		case 'H': result +=1;
			break;
		case 'D': result +=2;
			break;
		case 'S': result +=3;
			break;
		case 'C': result +=4;
			break;
	}
	return result;
}

void sort(int *value)
{
	for(int i=0;i<4;i++)
	{
		for(int j=0;j<4-i;j++)
		{
			if(value[j]<value[j+1])
			{
				int tempt = value[j];
				value[j]=value[j+1];
				value[j+1]=tempt;
			}
		}
		
	}
}

long judge(int* card)
{
	long result = 0;
	
	int suit[5]={0,};
	int value[5]={0,};
	
	for(int i=0;i<5;i++)
	{
		value[i]=get_value(card[i]);
		suit[i]=get_suit(card[i]);
	}
	
	// 스티플
	if(value[0]==value[1]+1 && suit[0]==suit[1] &&
		 value[0]==value[2]+2 && suit[0]==suit[2] &&
		 value[0]==value[3]+3 && suit[0]==suit[3] &&
		 value[0]==value[4]+4 && suit[0]==suit[4]
		)
	{
		result = (9<<20)+(value[0]<<16);
		return result;
	}
	
	// 포카드
	else if( (value[0]==value[3])
					||(value[1]==value[4])
				)
	{
		if((value[0]==value[3]))
		{
			result = (8<<20)+(value[0]<<16);
		}
		else if((value[1]==value[4]))
		{
			result = (8<<20)+(value[1]<<16);
		}
		return result;
	}
	
	// 풀하우스
	else if(((value[0]==value[2]) && (value[3]==value[4]))
					|| ((value[0]==value[1]) && (value[2]==value[4]))
				)
	{
		if((value[0]==value[2]) && (value[3]==value[4]))
		{
			result = (7<<20)+(value[0]<<16);
		}
		else if((value[0]==value[1]) && (value[2]==value[4]))
		{
			result = (7<<20)+(value[2]<<16);
		}
		return result;
	}
	
	// 플러시
	else if((suit[0]==suit[1])&&
					(suit[0]==suit[2])&&
					(suit[0]==suit[3])&&
					(suit[0]==suit[4]))
	{
		result = (6<<20)+(value[0]<<16)+(value[1]<<12)+(value[2]<<8)+(value[3]<<4)+value[4];
		return result;
	}
	
	// 스트레이트
	else if(value[0]==value[1]+1 &&
				  value[0]==value[2]+2 &&
				  value[0]==value[3]+3 &&
					value[0]==value[4]+4
				 )
	{
		result = (5<<20)+(value[0]<<16);
		return result;
	}
	
	// 트리플
	else if((value[0]==value[2]) ||
				  (value[1]==value[3]) ||
					(value[2]==value[4])
				 )
	{
		if(value[0]==value[2])
			result = (4<<20)+(value[0]<<16);
		else if(value[1]==value[3])
			result = (4<<20)+(value[1]<<16);
		else if(value[2]==value[4])
			result = (4<<20)+(value[2]<<16);
		return result;
	}
	
	//투페어
	else if(((value[0]==value[1]) && (value[2]==value[3])) ||
					((value[0]==value[1]) && (value[3]==value[4])) ||
					((value[1]==value[2]) && (value[3]==value[4])))
	{
		if((value[0]==value[1]) && (value[2]==value[3]))
			result = (3<<20)+(value[0]<<16)+(value[2]<<12)+(value[4]<<8);
		else if((value[0]==value[1]) && (value[3]==value[4]))
			result = (3<<20)+(value[0]<<16)+(value[3]<<12)+(value[2]<<8);
		else if((value[1]==value[2])&&(value[3]==value[4]))
			result = (3<<20)+(value[1]<<16)+(value[3]<<12)+(value[0]<<8);

		return result;
	}
	
	//페어
	else if(value[0]==value[1] ||
					value[1]==value[2] ||
					value[1]==value[3] ||
					value[3]==value[4]
				 )
	{
		if(value[0]==value[1])
			result = (2<<20)+(value[0]<<16)+(value[2]<<12)+(value[3]<<8)+(value[4]<<4);
		else if(value[1]==value[2])
			result = (2<<20)+(value[1]<<16)+(value[0]<12)+(value[3]<<8)+(value[4]<<4);
		else if(value[2]==value[3])
			result = (2<<20)+(value[2]<<16)+(value[0]<12)+(value[1]<<8)+(value[4]<<4);
		else if(value[3]==value[4])
			result = (2<<20)+(value[3]<<16)+(value[0]<<12)+(value[1]<<8)+(value[2]<<4);
		
		return result;
	}
	
	//하이
	else 
	{
		result = (1<<20)+(value[0]<<16)+(value[1]<<12)+(value[2]<<8)+(value[3]<<4)+value[4];
		return result;
	}
}

int main()
{

	while(1)
	{
		char black[5][3]={0,};
		char white[5][3]={0,};
		int b_card[5]={0,};
		int w_card[5]={0,};
		long b_result=0;
		long w_result=0;
		
		for(int i=0;i<10;i++)
		{
			if(i<5)
			{
				if(scanf("%s",black[i])==EOF)
					return 0;
				else
				b_card[i]=encode(black[i]);
			}
			else
			{
				scanf("%s",white[i-5]);
				w_card[i-5]=encode(white[i-5]);
			}
		}
		
		sort(b_card);
		sort(w_card);
		
		b_result=judge(b_card);
		w_result=judge(w_card);
	
		if(b_result > w_result)
			printf("Black wins.\n");
		else if(b_result < w_result)
			printf("White wins.\n");
		else if(b_result == w_result)
			printf("Tie.\n");
		
	}
	
	return 0;
	
}
