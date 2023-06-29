#include <iostream>
#include <algorithm>
using namespace std;

#define MAX_N 1000
int n, arr[MAX_N];

int solve(int n){
	int index = n;
	int min, sec_min, max, sec_max;
	int result, solution1, solution2;
	
	min = arr[0];
	sec_min = arr[1];
	max = arr[index];
	sec_max = arr[index - 1];
	
	solution1 = (2*min + sec_max + max);
	solution2 = (min + 2*sec_min + max);
	
	result = solution1 < solution2 ? solution1 : solution2;
	
	if(index == 2){
		return min + sec_min + max;
	}
	else if(index == 1){
		return sec_min;
	}
	
	return result + solve(index-2);
}

int main() {
	int tc;
	cin >> tc;
	while(tc--){
		cin >> n;
		for(int i=0; i<n; i++){
			cin >> arr[i];
		}
		sort(arr, arr+n);
		cout << solve(n-1) << "\n\n";
	}
	return 0;
}