#include <stdio.h>
#define abs(x) ((x)<0 ? (-(x)) : (x))

int main() {
	int n[3000],m[3000];
	int jol,p,q,w,c;
	
	while(scanf("%d",&p) == 1)
	{
		if(p==1)
		{
			printf("Jolly\n");
		}
		
		for(q=0; q<p; q++)
		{
			scanf("%d",&n[q]);
		}
		
		for(q=0; q<p-1; q++)
		{
			m[q]=abs(n[q]-n[q+1]);
		}
		
		for(q=0; q<p-1; q++)
		{
			for(w=0; w<p-q-2;w++)
			{
				if(m[w]>m[w+1])
				{
					c=m[w];
					m[w]=m[w+1];
					m[w+1]=c;
				}
				
			}
		}
		for(q=0; q<p-1;q++)
		{
			
			if(m[q]!=q+1)
			{
				printf("Not jolly\n");
				break;
			}
			
			else if(q==p-2)
			{
				printf("Jolly\n");
			}
			
		}
	}
	
	
	return 0;
}
