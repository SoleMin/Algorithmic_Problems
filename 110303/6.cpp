#include <algorithm>
#include <iostream>
using namespace std;
int main() {
	int len1, len2, anslen;
	for (int k = 0; k < 4; k++) {
		anslen = 0; len1 = 0; len2 = 0;
		char word1[1000] = {0,};
		char word2[1000] = {0,};
		char ans[1000] = {0,};
		cin >> word1;
		cin >> word2;
		
		for (int i = 0; i < 1000; i++)
			if (word1[i] == 0) {
				len1 = i;
				break;
			}
		for (int i = 0; i < 1000; i++)
			if (word2[i] == 0){
				len2 = i;
				break;
		}
		for (int i = 0; i < len1; i++)
			for (int j = 0; j < len2; j++)
				if (word1[i] == word2[j]) {
					ans[anslen] = word1[i];
					anslen++;
					word1[i] = '1';
					word2[j] = '2';
				}
		sort(ans, ans + anslen);
		
		cout << ans << endl;
	}
	
	return 0;
}