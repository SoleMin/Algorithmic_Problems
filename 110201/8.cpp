#include <iostream>
using namespace std;


int main() {
	while(1)
	{
		int arr[3000] = {0}, arr1[2999] = {0};
		int a;
		int flag =1, test =0;
		cin >> a;
		if(cin.eof() == true)
		{
			break;
		}
		if(a ==1)
		{
			cin >> arr[0];
		}
		
		else if( a == 2)
		{
			for(int x=0;x<a;x++)
			{
				cin >> arr[x];
			}
			arr1[0]= arr[1]-arr[0];
			if( arr[1]-arr[0] <0)
			{
				arr1[0] = arr[0] - arr[1];
			}
			if( arr1[0] != 1)
			{
				flag =0;
			}
		}
		
		else if(a > 2)
		{
			for(int x=1;x<=a;x++)
			{
				cin >> arr[x];
			}
		
			for( int x=0;x<a-1;x++)
			{
				arr1[x] = arr[x+2]-arr[x+1];
				if(arr[x+2]-arr[x+1] <0)
				{
					arr1[x] = arr[x+1]-arr[x+2];
				}
			}
			for(int y=0;y<=a-2;y++)
			{
				test = arr1[y];
				for(int x=y+1;x<=a-1;x++)
				{
					if(test == arr1[x])
					{
						flag =0;
					}
					if(arr1[x] >= a)
					{
						flag =0;
					}	
				}
				if(flag==0)
				{
					break;
				}
			}					
		}
	
		if(flag ==1)
		{
			cout << "Jolly"<<endl;
		}
		else if(flag ==0){
			cout << "Not jolly"<<endl;
		}
	}
	
	
	return 0;
}