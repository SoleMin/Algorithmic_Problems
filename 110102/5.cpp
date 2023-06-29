#include<iostream>

using namespace std;

int main()
{
	int game_num = 1;
	
	while(1)
	{
		int n,m;
		
		cin>>n>>m;
		if(n==0 && m==0)
			break;
		else if(n<0 || m<0)
			continue;
		
		char mine[100][100] ={0};
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				cin>>mine[i][j];
			}
		}
		
		int hint[100][100]={0};
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				int count=0;
				if(mine[i][j]!='*')
				{
					if(i==0 && j==0)
					{
						if(mine[i][j+1]=='*')
							count++;
						if(mine[i+1][j]=='*')
							count++;
						if(mine[i+1][j+1]=='*')
							count++;
					}
					else if(i!=0 && i!=n && j==0)
					{
						if(mine[i-1][j]=='*')
							count++;
						if(mine[i-1][j+1]=='*')
							count++;
						if(mine[i][j+1]=='*')
							count++;
						if(mine[i+1][j]=='*')
							count++;
						if(mine[i+1][j+1]=='*')
							count++;
					}
					else if(i==n && j==0)
					{
						if(mine[i-1][j]=='*')
							count++;
						if(mine[i-1][j+1]=='*')
							count++;
						if(mine[i][j+1]=='*')
							count++;				
					}
					else if(i==0 && j!=0 && j!=m)
					{
						if(mine[i][j-1]=='*')
							count++;
						if(mine[i][j+1]=='*')
							count++;
						if(mine[i+1][j-1]=='*')
							count++;
						if(mine[i+1][j]=='*')
							count++;
						if(mine[i+1][j+1]=='*')
							count++;
					}
					else if(i==n && j!=0 && j!=m)
					{
						if(mine[i-1][j-1]=='*')
							count++;
						if(mine[i-1][j]=='*')
							count++;
						if(mine[i-1][j+1]=='*')
							count++;
						if(mine[i][j-1]=='*')
							count++;
						if(mine[i][j+1]=='*')
							count++;
					}
					else if(i==0 && j==m)
					{
						if(mine[i][j-1]=='*')
							count++;
						if(mine[i+1][j-1]=='*')
							count++;
						if(mine[i+1][j]=='*')
							count++;
					}
					else if(i!=0 && i!=n && j==m)
					{
						if(mine[i-1][j-1]=='*')
							count++;
						if(mine[i-1][j]=='*')
							count++;
						if(mine[i][j-1]=='*')
							count++;
						if(mine[i+1][j-1]=='*')
							count++;
						if(mine[i+1][j]=='*')
							count++;
					}
					else if(i==n && j==m)
					{
						if(mine[i-1][j-1]=='*')
							count++;
						if(mine[i-1][j]=='*')
							count++;
						if(mine[i][j-1]=='*')
							count++;
					}
					else
					{
						if(mine[i-1][j-1]=='*')
							count++;
						if(mine[i-1][j]=='*')
							count++;
						if(mine[i-1][j+1]=='*')
							count++;
						if(mine[i][j-1]=='*')
							count++;
						if(mine[i][j+1]=='*')
							count++;
						if(mine[i+1][j-1]=='*')
							count++;
						if(mine[i+1][j]=='*')
							count++;
						if(mine[i+1][j+1]=='*')
							count++;
					}
					hint[i][j]=count;
				}
			}
		}
		cout<<"Field #"<<game_num<<":"<<endl;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(mine[i][j]=='*')
					cout<<mine[i][j];
				else
					cout<<hint[i][j];
			}
			cout<<endl;
		}
		cout<<endl;
		game_num++;
	}
	return 0;
}