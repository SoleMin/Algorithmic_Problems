#include <iostream>
#include <string>
using namespace std;
int main() {
	while(1)
	{
		if(cin.eof() == true)
		{
			break;
		}
		char input[1000];
		char input1[1000];
		char output[1000] ={0};
		cin.getline(input,1000);
		cin.getline(input1,1000);
		int v=0;
		for(int y=0;y<1000;y++)
		{
			if(input[y] == '\0')
			{
				break;
			}
			for(int x=0;x<1000;x++)
			{
				if(input1[x] =='\0')
				{
					break;
				}
				if(input[y] == input1[x])
				{
					output[v] =input[y];
					input1[x] = '0';
					v++;
					break;
				}
			}
		}
		int cnt=0;
		for(int x=0;x<1000;x++)
		{
			if(output[x] =='\0')
			{
				cnt=x;
				break;
			}
		}
		char temp;
		for(int y=0;y<cnt-1;y++)
		{
			for(int x=y+1;x<cnt;x++)
			{
				if(output[y] >= output[x])
				{
					temp = output[y];
					output[y] = output[x];
					output[x] = temp;
				}
			}
		}
		for(int x=0;x<cnt;x++)
		{
			cout <<output[x];
		}
		cout << endl;
	}
	return 0;
}