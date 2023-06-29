#include<iostream>
#include<cstring>
using namespace std;

int main(int argc, char * argv[])
{
	int Testcase;
	int check[3651];
	cin >> Testcase;
	
	for(int i = 0; i < Testcase; i++)
	{
		int maxDay;
		int partySize;
		int ret = 0;
		cin >> maxDay;
		cin >> partySize;
		memset(check, -1, sizeof(check));
		
		for(int i =0; i< partySize; i++)
		{
			int party;
			cin >> party;
			
			for(int i = 1; party * i <= maxDay; i++)
				check[party * i] = 1;	
		 }
		
		int a = 0;
		while((7 + 7 * a) <= maxDay)
		{
			//check[6 +7 * a] = -1;
			check[7 + 7 *a] = -1;
			a++;
		}
		int b =0;
		while((6 + 6 * b) <=maxDay)
		{
			check[6 + 7 * b] = -1;
			b++;
		}
		
	for(int i = 0; i<= maxDay; i++)
		if(check[i] == 1)
			ret++;
		
		cout << ret << endl;
	}
	return 0;
}