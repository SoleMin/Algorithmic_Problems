#include <iostream>
#include <string>

using namespace std;

int main(void) 
{
	
	int num1 = 0;
	int num2 = 0;
	int k = 0;
	int r;
	bool result;
	
	while (cin >> r)
	{
		result = true;
		
		bool * list = new bool[3005];
		
		for (int i = 0; i < r; i++)
		{
			list[i] = false;
		}
		cin >> num1;
		
		for (int i = 1; i < r; i++)
		{
			cin >> num2;
			
			if (num1 < num2)
			{
				k = num2 - num1;
			}
			else
			{
				k = num1 - num2;
			}
			if (r > k)
				list [k] = true;
			
			num1 = num2;
		}
		for (int i = 1; i< r && result; i++)
		{
			if (!list[i])
			{
				result = false;
			}
		}
			if (result)
			
				cout << "Jolly" << endl;
			
			else
				
				cout << "Not jolly" << endl;
			
			delete[]list;
		
	}
		return 0;
	
}