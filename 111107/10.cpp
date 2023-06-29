#include <iostream>
using namespace std;

int clen[5000];
int pre_bad [5001];
int now_bad [5001];

int main() {
	
	int t;
	cin >> t;
	
	for(int i = 0; i < t; i++) {
		int guest, chopstick;
		cin >> guest >> chopstick;
		
		for(int j = 0; j < chopstick; j++) {
			cin >> clen[j];
		}
		
		guest += 8;
		for(int j = 0; j <= chopstick; j++) pre_bad[j] = 0;
		
		for(int j = 0; j < guest; j++) {
			int max_cand = chopstick - 3 * (guest - 1 - j) - 1;
			now_bad[0] = -1;
			now_bad[1] = -1;
			for(int k = 2; k <= max_cand; k++) {
				if(pre_bad[k-2] > -1) {
					int bad, diff;
					diff = clen[k-1] - clen[k-2];
					bad = pre_bad[k-2] + diff * diff;
					if(now_bad[k-1] > bad || now_bad[k-1] == -1) now_bad[k] = bad;
					else now_bad[k] = now_bad[k-1];
				}
				else {
					now_bad[k] = -1;
				}
			}
			
			now_bad[max_cand + 1] = now_bad[max_cand];
			for(int k = 0; k <= max_cand + 1; k++) {
				pre_bad[k] = now_bad[k];
			}
		}
		cout << pre_bad[chopstick - 1] << endl;
	}

	return 0;
}