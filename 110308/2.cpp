#include <iostream>
#include <string>
#include <vector>
#define MAX 72
#define LIMIT 100
using namespace std;

int main() {
	int ksize, size, isize, k = 0; 
	int front = 0; 
	string line;
	string space = " ";

	vector<string> input;
	vector<string> output(LIMIT);

	while(getline(cin, line))
		input.push_back(line);
	
	size = input.size();
	for(int i = 0; i < size; i++){
		isize = input[i].size(); 
		if(isize == 0){
			k++;
			output[k++] = "";
			continue;
		}


		for(int j = 0; j < isize; j++){
			if(j == isize - 1){
				if((output[k].size() + j - front) < MAX){
					if(output[k][0] == ' ' && input[i-1].size() != 0) output[k] = output[k].substr(1, output[k].size()-1) + input[i].substr(front, j-front+1) + space;
					else output[k] = output[k] + input[i].substr(front, j-front+1) + space;
				}
				else if(j - front > MAX && output[k].size() > 0)
					output[++k] = input[i].substr(front, j-front+1);
				
				else if(j - front > MAX && output[k].size() == 0)
					output[k++] = input[i].substr(front, j-front+1);
				
				else
					output[++k] =input[i].substr(front, j-front+1) + space;
			continue;
			}
			
			if(input[i][j] == ' '){
				if((output[k].size() + j - front) < (MAX + 1))
					output[k] = output[k] + input[i].substr(front, j - front);
				
				else if(j - front < (MAX + 1)){
					if(input[i][front] == ' ') output[++k] = input[i].substr(front +1 , j - front -1);
					else output[++k] = input[i].substr(front , j - front);
				}
				front = j;
			}
		}
		front = 0;
	}
	
	for(int i = 0; i < output.size(); i++){
		if(output[i][output[i].size()-1] == ' ') output[i].pop_back();
		cout << output[i] << endl;
	}

	return 0;
}