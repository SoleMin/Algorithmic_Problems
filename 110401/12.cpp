#include <iostream>
#include <algorithm>
using namespace std;

int arr[30001];
int r;

int main() {
	int t;
	cin >> t;
	while(t--) {
		cin  >> r;
		for(int i = 0; i < r; i++) {
			cin >> arr[i];
		}
		sort(arr, arr + r);
		int mid1 = r / 2, mid2 = r / 2 + 1;
		
		int dist1 = 0, dist2 = 0;
		for(int i = 0; i < r; i++) {
			if(arr[i] != arr[mid1]) 
				dist1 += abs(arr[i] - arr[mid1]);
			// if(arr[i] != arr[mid2]) 
			// 	dist2 += abs(arr[i]- arr[mid2]);
		}
		// if(dist1 < dist2)
		// 	cout << dist1 << '\n';
		// else
		// 	cout << dist2 << '\n';
		cout << dist1 << '\n';
	}
	
	return 0;
}