#include<iostream>
#include<string>

using namespace std;

int main()
{
	string keyboard="`1234567890-=QWERTYUIOP[]ASDFGHJKL;'ZXCVBNM,./'";
	string text;
	int text_num[100]={1};
	
	while(getline(cin, text))
	{
		for(int j=0;j<text.length();j++)
		{
			for(int k=0;k<46;k++)
			{	
				if(text[j]==keyboard[k])
					text_num[j]=k;
			}
		}
		for(int j=0;j<text.length();j++)
		{
			if(text[j]!=' ')
				text[j]=keyboard[text_num[j]-1];
		}
		for(int j=0;j<text.length();j++)
		{
			cout<<text[j];
		}
		cout<<endl;
	}
	return 0;
}