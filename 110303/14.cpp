#include<iostream>
#include<string>
#include<algorithm>

using namespace std;

int main()
{
	string text[20];
	string part_text[20];
	char part_text_Char[20][50];
	int i=0;

	while(getline(cin, text[i]))
	{
		i++;
	}
	
	for(int j=0;j<i;j+=2)
	{
		for(int k=0;k<text[j].length();k++)
		{
			for(int h=0;h<text[j+1].length();h++)
			{
				if(text[j][k]==text[j+1][h])
				{
					part_text[j]+=text[j][k];
					text[j+1][h]=NULL;
					h=text[j+1].length();
				}
			}
		}
	}
	for(int j=0;j<i;j+=2)
	{
		for(int k=0;k<part_text[j].length();k++)
		{
			part_text_Char[j][k]=part_text[j].at(k);
		}
	}
	
	for(int j=0;j<i;j+=2)
	{
		std::sort(part_text_Char[j], part_text_Char[j]+part_text[j].length());
	}
	
	for(int j=0;j<i;j+=2)
	{
		for(int k=0;k<part_text[j].length();k++)
		{
			cout<<part_text_Char[j][k];
		}
		cout<<endl;
	}
	
	return 0;
}