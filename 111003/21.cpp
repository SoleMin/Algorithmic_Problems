#include<iostream>
#include<sstream>
#include<algorithm>

using namespace std;

int F_pos[101], Dis[501][501];

int main()
{
	int testcase;
	
	cin>>testcase;
	
	for(int i=0;i<testcase;i++)
	{
		int num_fs, num_is;
		
		cin>>num_fs>>num_is;
		
		for(int j=0;j<num_fs;++j)
			cin>>F_pos[j];
		
		for(int j=1;j<=num_is;++j)
		{
			for(int k=1;k<=num_is;++k)
			{
				Dis[j][k]=9999999;
			}
			Dis[j][j]=0;
		}
		
		string str;
		getline(cin,str);
		
		while(getline(cin,str) && !str.empty())
		{
			stringstream ss(str);
			int x,y,L;
			
			ss>>x>>y>>L;
			Dis[x][y]=L;
			Dis[y][x]=L;
		}
		
		for(int k=1;k<=num_is;++k)
		{
			for(int m=1;m<=num_is;++m)
			{
				for(int n=1;n<=num_is;++n)
				{
					if(Dis[m][k]+Dis[k][n]<Dis[m][n])
						Dis[m][n]=Dis[m][k]+Dis[k][n];
				}
			}
		}
		
		int s_l[501];
		int max_s_l=0;
		for(int j=1;j<=num_is;++j)
		{
			s_l[j]=9999999;
			for(int k=0;k<num_fs;++k)
			{
				s_l[j]=min(s_l[j], Dis[j][F_pos[k]]);
			}
			max_s_l=max(max_s_l, s_l[j]);
		}
		
		int result=1, length, min_leng;
		
		for(int j=1;j<=num_is;++j)
		{
			/*
			if(max_s_l==s_l[j])
			{
				result=j;
				break;
			}
			*/
			
			length=0;
			for(int k=1;k<=num_is;++k)
			{
				min_leng=min(s_l[k], Dis[j][k]);
				length=max(length, min_leng);
			}
			
			if(length<max_s_l)
			{
				max_s_l=length;
				result=j;
			}
			
		}
		
		cout<<result<<endl;
		cout<<endl;
	}
	
	return 0;
}