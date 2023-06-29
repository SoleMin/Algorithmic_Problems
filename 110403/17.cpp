#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int time_taken(vector<int> numbers);

int main() {
	string input;

	vector<int> numbers;
	
	int num_cases, num_people;
	
	cin >> num_cases;
	getline(cin, input);
	getline(cin, input);
	// cin >> num_people;
  // getline(cin, input);

	for(int i = 0; i< num_cases; i++){	
		cin >> num_people;
		getline(cin, input);
		while(getline(cin, input)){				
			if(input.length() == 0)
				break;			
			numbers.push_back(stoi(input));						
		}
		
		sort(numbers.begin(), numbers.end());
		
		cout << time_taken(numbers) << endl << endl;
		
		numbers.clear();
	}
			
	return 0;
}

int time_taken(vector<int> numbers) {
	int num_people = numbers.size();
	
	if (num_people == 1){
		return numbers[0];
	} else if (num_people == 2){
		return numbers[1];
	} else if (num_people == 3){
		return numbers[0] + numbers[1] + numbers[2];
	} else {
		
		int largest = numbers[num_people - 1];
		int second_largest = numbers[num_people - 2];
		
		vector<int> numbers_copy = numbers;		
		
		numbers_copy.pop_back();
		numbers_copy.pop_back();
		
		numbers.pop_back();
		
		// cout << "numbers_copy: " <<  numbers_copy.size() << ", numbers: " <<  numbers.size() << endl;
		
		return min(time_taken(numbers_copy) + largest + numbers[0] + numbers[1] * 2, time_taken(numbers) + largest + numbers[0]);
	}
}
