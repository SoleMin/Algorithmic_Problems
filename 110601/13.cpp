# include <iostream>
# include <string>
# include <algorithm>
# include <vector>
# define MAX(x, y) ((x) > (y) ? (x) : (y))

using namespace std;

string add(string s1, string s2) {
	if(s1.length() < s2.length()){
		string temp;
		temp = s1;
		s1 = s2;
		s2 = temp;
	}
	// int padding = MAX(s1.length() - s2.length(), s2.length() - s1.length());
	int padding = s1.length() - s2.length();
	
	for(int i = 0; i < padding; i++){
		s2 = "0" + s2;
	}
	
	vector<int> sum_arr;
	for(int i = 0; i < s1.length(); i++){
		sum_arr.push_back((s1[i] - '0') + (s2[i] - '0'));
	}
	
	reverse(sum_arr.begin(), sum_arr.end());
	
	for(int i = 0; i < sum_arr.size(); i++){
		if(sum_arr[i] < 10){
			continue;
		}
		
		if(i < sum_arr.size() - 1){
			sum_arr[i + 1] += sum_arr[i]/10;
		}
		else{
			sum_arr.push_back(sum_arr[i]/10);
		}
		
		sum_arr[i] %= 10;
	}
	
	reverse(sum_arr.begin(), sum_arr.end());
	
	string sum;
	int i = 0;
	while(sum_arr[i] == 0){
		i++;
	}
	
	if(i >= sum_arr.size()){
		sum.push_back('0');
	}
	
	while(i < sum_arr.size()){
		sum.push_back((char)(sum_arr[i] + '0'));
		i++;
	}
	
	return sum;
}

int main() {
	
	
	while(true){
		vector<string> fibo;
		int counter = 0;
		string input1, input2;
		cin >> input1 >> input2;
		if(input1 == "0" && input2 == "0"){
			break;
		}
		
		fibo.push_back("0");
		fibo.push_back("1");
		fibo.push_back("2");
		
		if((fibo[1] >= input1 && fibo[1].length() == input1.length()) ){
			if((fibo[1] <= input2 && fibo[1].length() == input2.length()) || fibo[1].length() < input2.length()){
				//cout << "In1" << endl;
				counter++;
			}
		}
		
		if((fibo[2] >= input1 && fibo[2].length() == input1.length())){
			if((fibo[2] <= input2 && fibo[2].length() == input2.length()) || fibo[2].length() < input2.length()){
				counter++;
				//cout << "In2" << endl;
			}
			
		}
		
		int i = 3;
		while(true){
			fibo.push_back(add(fibo[i-1], fibo[i-2]));
			//cout << "fibo[" << i << "] => " << fibo[i] << endl;
			//cout << input1 << " || " << input2 << endl;
			
				
				if(fibo[i].length() > input1.length() || (fibo[i].length() == input1.length() && fibo[i] >= input1)){
					if(fibo[i].length() < input2.length() || (fibo[i].length() == input2.length() && fibo[i] <= input2)){
						counter++;
						//cout << "▲count" << endl;
					}
				}

				if((fibo[i] >= input2 && fibo[i].length() == input2.length()) || fibo[i].length() > input2.length()){
					//cout << fibo[i] << " || Out!" <<endl;
					break;
				}
			
			
			i++;
		}
	
		cout << counter << endl;
	}
	
	return 0;
}