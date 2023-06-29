#include <stdio.h>

int sticklen[5000];
int prebad[5001];
int nowbad[5001];
void main()
{
	int t;
	scanf("%d", &t);
	
	for(int i = 0; i < t; i++)
	{
		int guest, stick;
		scanf("%d %d", &guest, &stick);
		for(int j = 0; j < stick; j++)
		{
			scanf("%d",&sticklen[j]);
		}
		guest += 8;
		
		for(int j = 0; j <= stick; j++)
			prebad[j] = 0;
		for(int j = 0; j <guest; j++)
		{
			int max_candidate = stick -3*(guest -1-j)-1;
			nowbad[0] = -1;
			nowbad[1] = -1;
			for(int k = 2; k <=max_candidate; k++)
			{
				if(prebad[k-2] > -1)
				{
					int bad, diff;
					diff = sticklen[k-1] - sticklen[k-2]; // ab의 차이
					bad = prebad[k-2] + diff*diff;
					if(nowbad[k-1]>bad || nowbad[k-1]==-1)//작은수 찾기
						nowbad[k] = bad; 
					else
						nowbad[k] = nowbad[k-1];
				}
				else
					nowbad[k]= -1;
				
			}
			nowbad[max_candidate + 1] = nowbad[max_candidate];
			for(int k = 0; k <= max_candidate +1; k++)
				prebad[k] = nowbad[k];
				
				
		}
		printf("%d\n", prebad[stick-1]);
	}
}
