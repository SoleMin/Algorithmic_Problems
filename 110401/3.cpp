#include <iostream>
#include <sstream>
#include <cstdlib>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	bool check;
	int k, size, testcase, front, rear, sum, avg, count, ans;
	string line;
	vector<int> distance;
	vector<int> result;
	
	cin >> testcase;
	cin.ignore();
	
	for(int i = 0; i < testcase; i++){
		check = true;
		sum = 0;
		avg = 0;
		
		getline(cin, line);
		stringstream ss(line);
		while(ss >> k){
			if(check){
				count = k;
				check = false;
			}
			else distance.push_back(k);
		}
		ss.clear();
		
		sort(distance.begin(), distance.end());
		size = distance.size();
	
		for(int j = 0; j < size; j++)
			avg += distance[j]/size;

		if(size % 2){
			ans = distance[size / 2];
		}
		else{
			front = abs(avg - distance[size / 2 - 1]);
			rear = abs(avg - distance[size / 2]);
			ans = front < rear ? distance[size / 2 - 1] : distance[size / 2];
		}

		for(int n = 0; n < size; n++)
			sum += abs(ans - distance[n]);
		
		result.push_back(sum);

		distance.clear();
	}

	for(int x = 0; x < result.size(); x++)
		cout << result[x] << endl;
		
	return 0;
	
}