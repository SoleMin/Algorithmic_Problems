#include <iostream>
#include <vector>
#include <algorithm>
#define MAXN 1000
using namespace std;

int main() {
	int n, testcase;

	vector<int> ti(MAXN);
	vector<int> si(MAXN);
	vector<int> result(MAXN);
	
	cin >> testcase;
	
	for(int i = 0; i < testcase; i++){

		cin >> n;
		
		for(int j = 0; j < n; j++){
			cin >> ti[j] >> si[j];
			result[j] = j;
		}

		for(int x = 1; x < n; x++){
			for(int y = 0; y < n - x; y++){
				if(ti[result[y]]*si[result[y+1]] > ti[result[y+1]]*si[result[y]])
					swap(result[y], result[y+1]);
			}
		}
		

		for(int z = 0; z < n; z++)
			cout << result[z] + 1 << " ";
		cout << endl;
		cout << endl;

	}

	return 0;
	
}