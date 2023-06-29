#include <iostream>
# include <string>

using namespace std;

int main() {
	
	string input;

	while(getline(cin, input)){
		int character_counter = 0;
		int word_counter = 0;
		int flag = 0;	// 0 == false | 1 == true
		
		for(int index = 0; index < input.length(); index++){
			if((input[index] >= 'a' && input[index] <= 'z') || (input[index] >= 'A' && input[index] <= 'Z') || (input[index] >= '0' && input[index] <= '9')){
				character_counter++;
				flag = 1;
			}
			else{
				if(flag == 1){
					word_counter++;
					flag = 0;
				}
			}
		}
		
		if(flag == 1){
			word_counter++;
		}
		cout << character_counter << " " << word_counter << endl;
	}
	
	return 0;
}