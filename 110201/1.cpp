#include<iostream>
#include<cstring>
#include<string>
#include<stdio.h>

using namespace std;

int main()
{
	int inputn;
	string input;
	int intrace[5000];
	int prev;
	
	while(cin >> inputn)
	{
		for(int i = 1; i<=inputn; i++)
			intrace[i] = 0;
		
		int flag = 1;
		cin >> prev;
		for(int i = 1; i < inputn; i++)
		{
			int cur;
			cin >> cur;
			
			int tmp = abs(cur - prev);
			if(tmp <= 0 || tmp >= inputn || intrace[tmp])
			{
				flag = 0;
				break;
			}
			intrace[tmp] = 1;
			prev = cur;
		}

	cin.ignore(30,'\n');
	string ret = (flag ? "Jolly" : "Not jolly");
	cout << ret << endl;
}
}
