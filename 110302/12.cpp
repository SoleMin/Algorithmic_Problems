#include<iostream>
#include<string>

using namespace std;

int main()
{
	int test_case;
	
	cin>> test_case;
	
	for(int i=0;i<test_case;i++)
	{
		int m, n;
		string grid[50];
		int position_m, position_n;
		
		cin>>m>>n;
		
		for(int j=0;j<m;j++)
		{
			cin>>grid[j];
		}
		for(int j=0;j<m;j++)
		{
			for(int k=0;k<n;k++)
			{
				if(grid[j][k]>=65 && grid[j][k]<=90)
					grid[j][k]+=32;
			}
		}
		
		int k_num;
		string letter[20];
		bool check=false;
		int len_letter[20];
		
		cin>>k_num;
		
		for(int j=0;j<k_num;j++)
		{
			cin>>letter[j];
		}
		for(int j=0;j<k_num;j++)
		
		for(int j=0;j<k_num;j++)
		{
			for(int k=0;k<letter[j].length();k++)
			{
				if(letter[j][k]>=65 && letter[j][k]<=90)
					letter[j][k]+=32;
			}
		}
		
		for(int j=0;j<k_num;j++)
		{
			position_m=0;
			position_n=0;
			check=false;
			
			for(int k=0;k<m;k++)
			{
				for(int g=0;g<n;g++)
				{
					string check_letter[8]={""};
					if(grid[k][g]==letter[j][0])
					{
						for(int num=0;num<letter[j].length();num++)
						{
							if(k-num>=0 && g-num>=0)
								if(grid[k-num][g-num]==letter[j][num])
									check_letter[0]+=letter[j][num];
							if(k-num>=0)
								if(grid[k-num][g]==letter[j][num])
									check_letter[1]+=letter[j][num];
							if(k-num>=0 && g+num<n)
								if(grid[k-num][g+num]==letter[j][num])
									check_letter[2]+=letter[j][num];
							if(g-num>=0)
								if(grid[k][g-num]==letter[j][num])
									check_letter[3]+=letter[j][num];
							if(g+num<=n)
								if(grid[k][g+num]==letter[j][num])
									check_letter[4]+=letter[j][num];
							if(k+num<=m && g-num>=0)
								if(grid[k+num][g-num]==letter[j][num])
									check_letter[5]+=letter[j][num];
							if(k+num>=0)
								if(grid[k+num][g]==letter[j][num])
									check_letter[6]+=letter[j][num];
							if(k+num<=m && g+num<=n)
								if(grid[k+num][g+num]==letter[j][num])
									check_letter[7]+=letter[j][num];
						}
						if(check_letter[0]==letter[j] || check_letter[1]==letter[j] || check_letter[2]==letter[j] || check_letter[3]==letter[j] || check_letter[4]==letter[j] || check_letter[5]==letter[j] || check_letter[6]==letter[j] || check_letter[7]==letter[j])
						{
							position_m=k+1;
							position_n=g+1;
							check=true;
						}
							
					}
					if(check==true)
						g=n;
				}
				if(check==true)
					k=m;
			}
			if(check==true)
				cout<<position_m<<" "<<position_n<<endl;
			else
				cout<<"wrong"<<endl;
		}
		cout<<endl;
	}
	return 0;
}