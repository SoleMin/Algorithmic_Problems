#include <iostream>

using namespace std;

int main()
{
	int T;
	
	cin>>T;
	
	for(int i=0;i<T;i++)
	{
		int N, P, h[100], count=0;
		
		cin>>N>>P;
		
		for(int i=0;i<P;i++)
		{
			cin>>h[i];
		}
		for(int i=1;i<=N;i++)
		{
			if(i%7!=6 && i%7!=0)
			{
				for(int j=0;j<P;j++)
				{
					if(i%h[j]==0)
					{
						count++;
						break;
					}
				}
			}
		}
		cout<<count<<endl;
	}
	
	return 0;
}