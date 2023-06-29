#include <stdio.h>
int main() {
	int case_,day,party;
	int hartal[101];
	int cnt,flag;
	
	for(int i=0;i<101;i++)
		hartal[i] = 0;
	
	scanf("%d",&case_);
	
	for(int i=0;i<case_;i++)
	{
		scanf("%d",&day);
		scanf("%d",&party);
		
		for(int j=0;j<party;j++)
			scanf("%d",&hartal[j]);
		
		cnt = 0;
		for(int k=1;k<=day;k++)
		{				
			if(k%7 != 6 && k%7 != 0)
			{
				flag =0;
				for(int x=0;x<party;x++)
				{
					if(k%hartal[x] == 0)
						flag = 1;
				}
			
				if(flag == 1)
					cnt++;
			}
		}
		printf("%d\n",cnt);	
	}	
}
