#include <iostream>

using namespace std;

int main() {
	int t;
	cin >> t;
	for(; t>0; t--){
		int n, sum = 0;
		cin >> n;
		int p[n];
		for(int i=0; i<n; i++){
			cin >> p[i];
		}
		for(int i=0; i<n; i++){
			int temp, j = i;
			while(j>0 && p[j] < p[j-1]){
				temp = p[j];
				p[j] = p[j-1];
				p[j-1] = temp;
				j = j-1;
			}
		}
		int i = n-1;
		while(i>2){
			if(p[i-1]+p[0] > 2*p[1])
				sum += (p[i] + p[0] + p[1]*2);
			else
				sum += (p[i] + p[i-1] + p[0]*2);
			i -= 2;
		}

		if(n == 1)
			sum = p[0];
		else if(n%2)
			sum += (p[2] + p[1] + p[0]);
		else
			sum += p[1]; 
		cout << sum << endl << endl;
	}

	return 0;
}