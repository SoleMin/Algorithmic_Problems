#include <iostream>

using namespace std;

int main() {
	int t;
	cin >> t;
	for(; t>0; t--){
		int n;
		cin >> n;
		int T[n], S[n], result[n];
		for(int i=0; i<n; i++){
			cin >> T[i] >> S[i];
		}
		double input[n];
		for(int i=0; i<n; i++){
			input[i] = (double)T[i]/(double)S[i];
			result[i] = i+1;
		}
		for(int i=1; i<n; i++){
			int j=i;
			while(input[j] < input[j-1]){
				swap(input[j], input[j-1]);
				swap(result[j], result[j-1]);
				j--;
			}
		}
		for(int i=0; i<n-1; i++)
			cout << result[i] << " ";
		cout<< result[n-1] << endl << endl;
	}

	return 0;
}