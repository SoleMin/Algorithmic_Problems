#include <iostream>
using namespace std;
int main() {
	int TestCase;
	cin >> TestCase;
	for(int z=0;z<TestCase;z++)
	{
		int arr[30000];
		int kin;
		int MinDis = 999999;
		cin >> kin;
		for(int x=0;x<kin;x++)
		{
			cin >>arr[x];
		}
		for(int y=0;y<kin;y++)
		{
			int sum =0;
			for(int x=0;x<kin;x++)
			{
				if(arr[y] - arr[x] >=0)
				{
					sum = sum + arr[y] - arr[x]; 
				}
				else{
					sum= sum + arr[x] - arr[y];
				}
			}
			if(MinDis > sum)
				MinDis = sum;
		}
		cout << MinDis << endl;
	}
	
	
	return 0;
}