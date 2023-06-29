#include <iostream>

using namespace std;

int main() {
	
	long long original_value1, original_value2;
	long long left, right;
	
	while(cin >> original_value1 >> original_value2){
	
	left = original_value1;
	right = original_value2;
	
	if(original_value1 > original_value2){
		left = original_value2;
		right = original_value1;
	}	
	
	long long max_length = 0;
	
	for (long long i = left; i <= right; i++){
		//cout << "i => " << i << endl;
		long long j = i;
		
		long long length = 1;
	
		while(j != 1){
			if (j & 1) {
				j = j * 3 + 1;
				length++;
			}
			while (!(j & 1)) {
				j >>= 1;
				length++;
			}
		}
		if (length > max_length){
			max_length = length;
		}
	}
	
	cout << original_value1 << " " << original_value2 << " " << max_length << endl;
	
	}
	return 0;
}