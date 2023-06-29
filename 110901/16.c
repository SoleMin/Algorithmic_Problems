#include<stdio.h>

int table[210][210],color[210],queue[210];
int main()
{
	int i,j,n,l,res,x,y,col,q,top;
	while(1)
	{
		scanf("%d",&n);
		if(n==0)
			break;
		for(i=0;i<n;i++)
		{
			table[i][0]=0;
			color[i]=0;
		}
		scanf("%d",&l);
		for(i=0;i<l;i++)
		{
			scanf("%d %d",&x,&y);
			table[x][0]++;
			table[x][table[x][0]]=y;
			table[y][0]++;
			table[y][table[y][0]]=x;
		}
		queue[0]=x;
		color[x]=1;
		q=0;
		top=1;
		res=1;
		while(q!=top)
		{
			x=queue[q];
			q++;
			if(color[x]==1)
				col=2;
			else
				col=1;
			j=table[x][0];
			for(i=1;i<=j;i++)
			{
				y=table[x][i];
				if(color[y]==0)
				{
					color[y]=col;
					queue[top]=y;
					top++;
				}
				else if(color[y]!=col)
				{
					res=0;
					break;
				}
			}
			if(res==0)
				break;
		}
		if(res)
			printf("BICOLORABLE.\n");
		else
			printf("NOT BICOLORABLE.\n");
	}
	return 0;
}