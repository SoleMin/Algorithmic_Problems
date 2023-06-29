#include <iostream>
using namespace std;

int main() {
	int T,N, P;
	cin >> T;
	for(int i=0;i<T;i++)
	{
		int arr[100][3651] = {0};
		int cnt =0;
		cin >> N>>P;
		for(int y=0;y<P;y++)
		{
			cin >> arr[y][0];
		}
		for(int y=0;y<P;y++)
		{
			for(int x=1;x<=N;x++)
			{
				if(x % arr[y][0] ==0)
				{
					arr[y][x] +=1;
					if(x % 7 ==0 || x%7 ==6)
					{
						arr[y][x] -=1;
					}
				}
			}
		}
		for(int x=1;x<=N;x++)
		{
			for(int y=0;y<P;y++)
			{
				if( arr[y][x] ==1)
				{
					cnt++;
					break;
				}
			}
			
		}
		cout << cnt<<endl;
	}
	
	
	
	return 0;
}