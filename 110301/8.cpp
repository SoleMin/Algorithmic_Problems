#include <iostream>
#include <string>
using namespace std;
int main() {
	char arr[50] = {"`1234567890-=QWERTYUIOP[]\ASDFGHJKL;'ZXCVBNM,./"};
	while(1)
	{
		char input[50];
		if(cin.eof()==true)
		{
			break;
		}
		cin.getline(input,50);
		for(int x=0;x<50;x++)
		{
			if(input[x] == '\0')
			{
				break;
			}
			if(input[x] != 'Q' && input[x] != 'A' && input[x] != 'Z' && input[x] != '`' && input[x] != ' ')
			{
				for(int y=0;y<50;y++)
				{
					
					if(input[x] == arr[y])
					{
						cout << arr[y-1];
					}
				}
			}
			else{
				cout << input[x];
			}
		}
		cout << endl;
	}
	
	
	
	return 0;
}