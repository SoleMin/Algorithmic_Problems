#include<iostream>
#include<cmath>

using namespace std;

int main()
{
	int testcase;
	
	cin>>testcase;
	
	for(int i=0;i<testcase;i++)
	{
		int num,check[100]={0},a;
		double dot[100][2], minval[100], result=0;
		
		cin>>num;
		for(int i=0;i<num;i++)
		{
			cin>>dot[i][0]>>dot[i][1];
		}
		
		check[0]=1;
		for(int j=1;j<num;j++)
		{
			minval[j]=sqrt(pow(dot[0][0]-dot[j][0], 2)+pow(dot[0][1]-dot[j][1], 2));
		}
		for(int j=0;j<num-1;j++)
		{
			//프림 알고리즘
			
			a=-1;
			for(int k=0;k<num;k++)
			{
				if(check[k]==1)
					continue;
				if(a==-1 || minval[k]<minval[a])
					a=k;
			}
			check[a]=1;
			result+=minval[a];
			
			for(int k=0;k<num;k++)
			{
				if(check[k]==1)
					continue;
				if(minval[k]>sqrt(pow(dot[a][0]-dot[k][0], 2)+pow(dot[a][1]-dot[k][1], 2)))
					minval[k]=sqrt(pow(dot[a][0]-dot[k][0], 2)+pow(dot[a][1]-dot[k][1], 2));
			}
		}
		
		if(i>0)
			cout<<endl;
		cout<<fixed;
		cout.precision(2);
		cout<<result<<endl;
	}
	
	return 0;
}