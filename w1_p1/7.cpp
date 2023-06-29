#include <iostream>
#include <string>
using namespace std;
int main() 
{
	string line;
	
	while(getline(cin,line)){
		int words = 0, letters = 0;
		for(int x=0; x<line.length(); x++)
		{
			if((x==0 && (line[x] != ' ' && line[x] != '\t')) || (x > 0 && (line[x-1] == ' ' || line[x-1] == '\t')&& (line[x] != ' ' && line[x] !='\t')))
			{
				words++;
			}
			if(line[x] != ' ' && line[x] != '\t') 
			{
				letters ++;
			}
		}
		cout << letters << " " << words << endl;
	}
	return 0;
}