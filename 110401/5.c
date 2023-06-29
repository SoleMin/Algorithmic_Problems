#include <stdio.h>
int main() {
	int case_;
	int arr[1000];
	int r,i,j,tmp,mid,sum,dis;
	
	
	scanf("%d",&case_);
	
	for(int c=0;c<case_;c++)
	{
		scanf("%d",&r);
		for(i=0;i<r;i++)
			scanf("%d",&arr[i]);
	
		for(i=0;i<r;i++)
			for(j=i+1;j<r;j++)
				if(arr[i]>arr[j])
				{
					tmp=arr[i];
					arr[i]=arr[j];
					arr[j]=tmp;
				}
	
		if(r%2)
			mid=((r+1)/2)-1;
		else
			mid=(r/2)-1;
		
		sum = 0;
		for(i=0;i<r;i++)
			if(i!=mid)
			{
				dis=arr[i]-arr[mid];
				if(dis<0)
					dis*=-1;
				sum+=dis;
			}
		printf("%d\n",sum);
	}
}
