#include <iostream>
using namespace std;
int main() {
	int TestCase;
	cin >> TestCase;
	for (int z=0;z<TestCase;z++)
	{
		int temp;
		int arr[1000][4]= {0};
		int Task;
		cin >> Task;
		for(int y=0;y<Task;y++)
		{
			for(int x=0;x<2;x++)
			{
				cin >> arr[y][x];
			}
		}
		for(int y=0;y<Task;y++)
		{
			arr[y][2] = y+1;
		}
		int Value1 =0;
		int Value2 =0;
		for(int z=0;z<Task;z++)
		{
			for(int y=0;y<Task-1;y++)
			{
				Value1 = arr[y][0] * arr[y+1][1];
				Value2 = arr[y+1][0] * arr[y][1];
				if(Value1 > Value2)
				{
					for(int x=0;x<3;x++)
					{
						temp = arr[y][x];
						arr[y][x] = arr[y+1][x];
						arr[y+1][x] = temp;
					}
				}
			
			}
		}
		for(int y=0;y<Task;y++)
		{
			cout << arr[y][2] << " ";
		}
		cout << endl;
		cout << endl;
	}
	return 0;
}