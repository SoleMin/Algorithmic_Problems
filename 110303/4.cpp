#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
#define LINE_MAX 1001
using namespace std;

void find_common(vector<string>& input){
	vector<char> v;

	for(int i = 0; i < input[0].size(); i++){
		if(input[1].find(input[0][i]) < LINE_MAX){
			v.push_back(input[0][i]);
			input[1][input[1].find(input[0][i])] = 0;
		}	
	}
	sort(v.begin(), v.end());
	
	for(int j = 0; j < v.size(); j++)
	cout << v[j];
	
	cout << endl;
}

int main() {
	bool odd = true;
	string line;
	vector<string> input(2);
	
	while(getline(cin,line)){
		
		if(odd) input[0] = line;
		else{
			input[1] = line;
			find_common(input);
		}
		
		odd = odd ? false : true;
	}

	return 0;
}