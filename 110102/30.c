#include <stdio.h>
int main() {
	char m[100][101];
	int i,j,q,w,e,r,n;
	int p=1;
	
	while(scanf("%d %d",&i,&j) == 2)
	{
		
		if(i==0 && j==0)
		{
			break;
		}
		
		printf("Field #%d:\n",p);
		p++;
		
		for(q=0; q<i; q++)
		{
			for(w=0; w<j; w++)
			{
				scanf(" %c",&m[q][w]);
			}
		}
	
		
		for(e=0; e<i; e++)
		{
			for(r=0; r<j; r++)
			{
			n=0;
			
				if(m[e][r]=='*')
				{
					printf("%c",m[e][r]);
					continue;
				}

				if(e-1>=0)
				{
					
					if(m[e-1][r]=='*')
					{
						n++;
					}
					
					if(r-1>=0)
					{
						if(m[e-1][r-1]=='*')
						{
							n++;
						}	
					}

					if(r+1<j)
					{
						if(m[e-1][r+1]=='*')
						{
							n++;
						}
					}
				}
				
				if(e+1<i)
				{
					if(m[e+1][r]=='*')
					{
						n++;
					}
					
					if(r-1>=0)
					{
						if(m[e+1][r-1]=='*')
						{
							n++;
						}
					}
					
					if(r+1<j)
					{
						if(m[e+1][r+1]=='*')
						{
							n++;
						}
					}
					
				}
				
					if(r-1>=0)
					{
						if(m[e][r-1]=='*')
						{
							n++;
						}
					}
				
					if(r+1<j)
					{
						if(m[e][r+1]=='*')
						{
							n++;
						}
					}
				
			printf("%d",n);
				//printf("%c",m[0][0]);
			}
			printf("\n");
		}
		
		
		printf("\n");
		
	}
	return 0;
}
