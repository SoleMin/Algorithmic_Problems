#include <iostream>
using namespace std;

bool visited[3001];
int arr[3001];
int n;

int main() {
	
	while(true) {
		cin >> n;
		if(cin.eof()) break;
		for(int i = 0; i < n; i++) 
			cin >> arr[i];
		for(int i = 0; i < n; i++)
			visited[i] = false;
		
		bool isJolly = true;
		for(int i = 1; i < n; i++) {
			int cur = abs(arr[i] - arr[i - 1]);
			if(visited[cur] || cur >= n || cur == 0) {
				isJolly = false;
				break;
			}
			visited[cur] = true;
		}
		if(isJolly)
			cout << "Jolly\n";
		else
			cout << "Not jolly\n";
	}
	
	return 0;
}