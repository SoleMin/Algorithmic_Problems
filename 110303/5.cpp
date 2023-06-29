#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

int main()
{
	string str1;
	string str2;
	string answer[1000];
	int line = 0;

	while (getline(cin, str1) && getline(cin, str2))
	{
		sort(str1.begin(), str1.end());
		sort(str2.begin(), str2.end());

		for (int i = 0; i < str1.length() ; i++)
		{
			for (int j = 0; j < str2.length(); j++)
			{
				if (str1[i] == str2[j])
				{
					answer[line].push_back(str1[i]);
					str2[j] = '*';
					break;
				}
			}
		}
		line++;
	}
	
	for (int i = 0; i < line; i++)
	{
		cout << answer[i] << endl;
	}


}