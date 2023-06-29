#include <stdio.h>
int main() {
	long x=0,y=0,n=0,max=0,tmp=0;
	long i=0,j=0, tmpx,tmpy;

	while(scanf("%ld %ld",&x,&y) == 2)
	{
		tmpx = x;
		tmpy = y;
		if(x>y)
		{
			tmp = x;
			x = y;
			y = tmp;
		}
		for(i=x;i<=y;i++)
		{
			j=i;
			n=1;
			while(j!=1){
				if(j&1)
				{
					j=j*3+1;
					n++;
				}
				while (!(j&1))
				{
					j>>=1;
					n++;
				}
			}
			if(n>max)
				max=n;
		}
		printf("%ld %ld %ld\n", tmpx, tmpy, max);
		x=0,y=0,n=0,max=0;
	}
}

