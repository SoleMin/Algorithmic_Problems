#include <iostream>
using namespace std;
int main() {
	long n, m, n1, m1, temp;
	long i, k, maxCycleLength, cycleLength;
	while(scanf("%ld %ld",&n, &m) == 2){
		n1 = n;
		m1 = m;
		if(n1 > m1) {
			temp = n1;
			n1 = m1;
			m1 = temp;
		}
		maxCycleLength = 0;
		for(int i=n1; i<=m1; i++){
			k = i;
			cycleLength = 1;
			while(k!=1) {
				if(k%2==0){
					k = k >> 1;
					cycleLength++;
				}
				else {
					k = k * 3 + 1;
					cycleLength++;
				}
				if(cycleLength > maxCycleLength)
					maxCycleLength = cycleLength;
			}
		}
		
		cout << n << " " << m << " " << maxCycleLength << endl;
	}
	
	return 0;
}