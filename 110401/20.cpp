# include <iostream>
# include <algorithm>
# include <vector>
# include <string>
# include <sstream>
# define ABS(x) ((x) < 0 ? (-(x)) : (x))

using namespace std;

int get_distance_sum(vector<int> v) {
	int midian = v[v.size() / 2];
	int sum = 0;
	for(int i = 0; i < v.size(); i++){
		sum += ABS(midian - v[i]);
	}
	
	return sum;
}

int main() {
	int test_case = 0;
	cin >> test_case;
	cin.ignore();
	
	while(test_case-- > 0){
		int input;
		vector<int> int_arr;
			
		cin >> input;
		for(int i = 0; i < input; i++) {
			int val;
			cin >> val;
			int_arr.push_back(val);
		}
		
		sort(int_arr.begin(), int_arr.end());
		
		cout << get_distance_sum(int_arr) << endl;
	}	// EOW(Test Case)
	
	return 0;
}