#include <stdio.h>
void bsort(int* num,char* pattern){
	int tmp;
	char tmp2;
	for(int i=0;i<5;i++)
		for(int j=0;j<4;j++)
		{
			if(num[j]>num[j+1])
			{
				tmp = num[j];
				tmp2 = pattern[j];
				num[j] = num[j+1];
				pattern[j] = pattern[j+1];
				num[j+1] = tmp;
				pattern[j+1] = tmp2;
			}
		}
}
int get_rank(int *nums,char *pattern,int *rank,int *num){
	// C = 클로버 D = 다이아 H = 하트 S = 스페이드
	// 하이카드 < 원페어 (5장중 2장이 같은카드) < 투페어 ( 두쌍이 같은카드) < 쓰리카드 (5장중 3장이 같은카드)
	// < 스트레이트 (5장의 카드가 연속적인값) < 플러시 (다섯장의 카드무늬같고 연) < 풀하우스 (세장의 카드가 값은값 두장의 카드가 같은값)
	// < 포카드 (네장의 카드가 같은값) < 스트레이트 플러시 (무늬가 같으며 연속적인값)
	// 2 3 4 5 6 7 8 9 T =10 J =11 Q=12 K=13 A=14
	//                 
	// rank 1 2 3 4 5 6 7 8 9
	// freq
	int flush=0,straight=0,full_h=0,four_c=0,three_c=0;
	int pair_cnt=0,max=0,max2=0,total=0,m15 = 1,max_freq = 0,max_val=0,sec_freq=0,sec_val=0;
	int freq[15];
	bsort(nums,pattern);
	
	for(int i=0;i<15;i++)
		freq[i] = 0;
	
	for(int i=0;i<5;i++)
	{
		total += nums[i] * m15;
		m15 *= 15;
	}
	flush = 1;
	for(int i=0;i<4;i++)
	{
		if(pattern[i] != pattern[i+1])
		{
			flush = 0;
			break;
		}
	}
	straight = 1;
	for(int i=0;i<4;i++)
	{
		if(nums[i]+1 != nums[i+1])
		{
			straight = 0;
			break;
		}
	}
	
	for(int i=0;i<5;i++)
	{
		freq[nums[i]]++;
		if(freq[nums[i]] > max_freq)
		{
			max_freq = freq[nums[i]];
			max_val = nums[i];
		}
	}
	for(int i=0;i<15;i++)
	{
		if(max_val != i)
		{
			if(freq[i] > sec_freq)
			{
				sec_freq = freq[i];
				sec_val = i;
			}
		}
	}
	
	//등급 판별
	if(flush == 1 && straight == 1)
	{
		*rank = 9; // 스트레이트 플러시
		*num = nums[4];
		return;
	}
	else if(max_freq == 4)
	{
		*rank = 8; // 포카드
		*num = max_val;
		return;
	}
	else if(max_freq == 3 && sec_freq == 2)
	{
		*rank = 7; // 풀하우스
		*num = max_val;
		return;
	}
	else if(flush == 1)
	{
		*rank = 6; // 플러시
		*num = nums[4];
		return;
	}
	else if(straight == 1)
	{
		*rank = 5; // 스트레이트
		*num = nums[4];
		return;
	}
	else if(max_freq == 3)
	{
		*rank = 4; // 쓰리카드
		*num = max_val;
		return;
	}
	else if(max_freq == 2 && sec_freq == 2)
	{
		*rank = 3; //투페어
		*num = (max_val > sec_val ? max_val : sec_val) * 15 * 15 + (max_val < sec_val ? max_val : sec_val) * 15;
		for(int i=0;i<15;i++)
			if(freq[i] == 1)
				*num += i;
		return;
	}
	else if(max_freq == 2)
	{
		*rank = 2;//원페어
		*num = max_val * 759375 + total;
		return;
	}
	else
	{
		*rank = 1; // 하이카드
		*num = total;
		return;
	}
	
		
	
}

int main() {	
	
	int BlackNumber[5] ,WhiteNumber[5];
	char BlackPattern[5], WhitePattern[5];
	char input = 0, input2 = 0;
	int Black_rank = 0,Black_num = 0,White_rank = 0,White_num = 0;
	int flag=0, tie_num =0, tmp =0,sum =0;
	while(1)
	{
	for(int i=0;i<5;i++)
	{
		if(scanf(" %c%c",&input,&input2) != 2)
			return 0;
		if(input >= '0' && input <= '9')
			BlackNumber[i] = input - '0';
		else
		{
			if(input == 'T')
				BlackNumber[i] = 10;
			else if(input == 'J')
				BlackNumber[i] = 11;
			else if(input == 'Q')
				BlackNumber[i] = 12;
			else if(input == 'K')
				BlackNumber[i] = 13;
			else if(input == 'A')
				BlackNumber[i] = 14;
		}
		BlackPattern[i] = input2;
	}
	
	for(int i=0;i<5;i++)
	{
		if(scanf(" %c%c",&input,&input2) != 2)
			return 0;
		if(input >= '0' && input <= '9')
			WhiteNumber[i] = input - '0';
		else
		{
			if(input == 'T')
				WhiteNumber[i] = 10;
			else if(input == 'J')
				WhiteNumber[i] = 11;
			else if(input == 'Q')
				WhiteNumber[i] = 12;
			else if(input == 'K')
				WhiteNumber[i] = 13;
			else if(input == 'A')
				WhiteNumber[i] = 14;
		}
		WhitePattern[i] = input2;
	}
	bsort(BlackNumber,BlackPattern);
	bsort(WhiteNumber,WhitePattern);
	
	get_rank(BlackNumber,BlackPattern,&Black_rank,&Black_num);
	get_rank(WhiteNumber,WhitePattern,&White_rank,&White_num);
		
	if(White_rank>Black_rank)
		printf("White wins.\n");
	else if(Black_rank>White_rank)
		printf("Black wins.\n");
	else if(Black_num>White_num)
		printf("Black wins.\n");
	else if(White_num>Black_num)
		printf("White wins.\n");
	else
		printf("Tie.\n");
		
	}
}
