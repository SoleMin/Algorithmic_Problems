#include <iostream>
#include <string>
#include <vector>
using namespace std;
int main() {
	int p;
	string temp;
	cin >> p;
	while(p--) {
		getline(cin, temp);
		cin.ignore();
		int n;
		cin >> n;
		vector<int> t(n);
		vector<int> s(n);
		for(int i = 0; i < n; i++) cin >> t[i] >> s[i];
		
		vector<int> result(n);
		int temp;
		for(int i = 0; i < n; i++) result[i] = i;
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < n - i; j++) {
				if(t[result[j]] * s[result[j+1]] > t[result[j+1]] * s[result[j]]) {
					temp = result[j];
					result[j] = result[j+1];
					result[j+1] = temp;
				}
			}
		}
		for(int i = 0; i < n - 1; i++) cout << result[i] + 1 << ' ';
		cout << result[n - 1] + 1;
		cout << endl << endl;
	}
	return 0;
}