#include <iostream>
#include<string>
using namespace std;
int main() {
	string input;
	while(getline(cin, input))
	{
		int words=0, letters = 0;
		for(int i =0; i < input.size(); i++)
		{
			if((i == 0) && (input[i] != ' ' && input[i] != '\t') || (i>0 &&(input[i-1] == ' ' || input[i-1] == '\t')) && (input[i] != ' ' && input[i] != '\t'))
				words++;
			if(input[i] != ' ' && input[i] != '\t')
				letters++;
		}	
		cout << letters <<" " <<words << endl;
	}
	return 0;
}