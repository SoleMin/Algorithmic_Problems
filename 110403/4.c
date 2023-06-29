#include <stdio.h>
int main() {
	int n;
	int case_,i,j,cnt,tmp;
	int p_time[1000];
	int t_sum = 0;
	int p1,p2,p3,p4,case1,case2;
	scanf("%d",&case_);
	for(int c=0;c<case_;c++)
	{	
		t_sum = 0;
		scanf("%d",&n);
		for(i=0;i<n;i++)
			scanf("%d",&p_time[i]);
		for(i=0;i<n;i++)
			for(j=i+1;j<n;j++)
				if(p_time[i]>p_time[j])
				{
					tmp=p_time[i];
					p_time[i]=p_time[j];
					p_time[j]=tmp;
				}
	
		if (n==1)
			printf("%d\n",p_time[0]);
		else if (n==2)
			printf("%d\n",p_time[1]);
		else if(n==3)
			printf("%d\n",p_time[0]+p_time[1]+p_time[2]);
		else
		{
			while(n>3)
			{
				p1 = p_time[0]; p2 = p_time[1]; p3 = p_time[n-2]; p4 = p_time[n-1];
				case1 = p2*2 +p1+p4;
				case2 = p1*2 +p3+p4;
				if(case1<case2)
					t_sum+=case1;
				else
					t_sum+=case2;
				n -=2;
			}
			if(n==1)
				t_sum+=p1;
			else if(n==2)
				t_sum+=p2;
			else
				t_sum +=p1+p2+p_time[2];
			printf("%d\n",t_sum);		
		}
		printf("\n");
	}
	
	
}
