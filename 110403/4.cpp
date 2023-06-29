#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	bool check;
	int testcase, time, lsize, rsize, n, case1, case2;
	vector<int> left;
	vector<int> result;
	
	cin >> testcase;
	
	for(int i = 0; i < testcase; i++){
		check = false;
		time = 0;
		
		cin >> n;
		left.resize(n);
		
		for(int j = 0; j < n; j ++) cin >> left[j];
		
		sort(left.begin(),left.end());

		while(!check){
			if(left.size() <= 2){
				time += left.back();
				check = true;
			}
			else if(left.size() == 3){
				for(int x = 0; x < 3; x++){
					time += left[x];
					check = true;
				}		
			}
			else{
				lsize = left.size();
				case1 = 2 * left[0] + left[lsize-1] + left[lsize-2];
				case2 = left[0] + 2 * left[1] + left[lsize-1];

				if(case1 < case2)  time += case1;
				else time += case2;
				
				left.pop_back();
				left.pop_back();
			}
		}
		
		result.push_back(time);
		left.clear();
	}

	for(int x = 0; x < result.size(); x++){
		cout << result[x] << endl;
		cout << endl;
	}
		
		
	return 0;
	
}