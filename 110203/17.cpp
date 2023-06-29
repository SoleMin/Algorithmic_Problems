#include <iostream>
#include <set>
using namespace std;
int main() {
	
	int t, n, p, elem;
	int cnt[101];
	set<int> set;
	
	cin >> t;
	while(t != 0) {
		set.clear();
			
		cin >> n >> p;
			
		for(int i = 0; i < p; i++) {
			cin >> cnt[i];
		}
		
		for(int i = 0; i < p; i++) {
			for(int j = 1; j <= n; j++) {
				elem = cnt[i] * j;
				
				if(elem <= n) {
					if(elem % 7 != 0 && elem % 7 != 6) {
						set.insert(elem);
					}
				} else
						break;
				
			}
		}
		
		cout << set.size() << endl;
		
		t -= 1;
		
	}
	
	return 0;
}