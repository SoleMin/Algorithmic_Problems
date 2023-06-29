#include <iostream>
using namespace std;
int main() {
	int n, input, diff;
	while (cin >> n) {
		int *arr = new int[n];
		int *diffArr = new int[n];
		
		for (int i = 0; i < n; i++) 
			diffArr[i] = 0;
		
		for (int i = 0; i < n; i++) {
			cin >> input;
			arr[i] = input;
		}
		
		for (int i = 0; i < n - 1; i++) {
			diff = arr[i] > arr[i + 1] ? arr[i] - arr[i + 1] : arr[i + 1] - arr[i];
			if (diff < n)
				diffArr[diff]++;
		}
		
		for (int i = 1; i < n; i++)
			if (diffArr[i] != 1)
				diffArr[0]++;
		
		if(diffArr[0] == 0)
			cout << "Jolly" << endl;
		else
			cout << "Not jolly" << endl;
		
		delete[] arr;
		delete[] diffArr;
	}
	
	
	return 0;
}