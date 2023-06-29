
#include <iostream>
#include <vector>
#define MAX 100000
using namespace std;

int main() {
	int n;

	vector<int> arr(MAX);
	arr[1] = 1;
	while(1){
		cin >> n;
		if(n == 0) break;
		for(int i = 2; i < MAX+1; i++){
			arr[i] = 1 + arr[i-arr[arr[i-1]]];
		}
		cout << arr[n] << endl;
	}
	return 0; 
}


