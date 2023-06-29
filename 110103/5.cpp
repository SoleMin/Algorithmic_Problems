#include <iostream>
#include <cmath>
using namespace std;

int n;
double cost[1001];

int main() {
	cout << fixed;
	cout.precision(2);
	while(true) {
		cin >> n;
		if(!n) break;
		
		double sum = 0;
		for(int i = 0; i < n; i++) {
			cin >> cost[i];
			sum += cost[i];
		}
		double avg = sum / n;
		
		//avg = round((avg - 0.005) * 100) / 100;
		//avg = avg - 0.009;
		//avg = floor(avg * 100) / 100;
		//cout << avg << endl;
		
		//avg = floor(avg * 100) / 100;
		//cout << avg << endl;
		/*
		double ret = 0;
		for(int i = 0; i < n; i++) {
			if(cost[i] < avg) {
				//ret += (avg - cost[i]);
				ret += round((avg - cost[i]) * 100) / 100;
			}
		}*/
		
		double ret = 0;
		for(int i = 0; i < n; i++) {
			if(cost[i] > avg) {
				ret += floor((cost[i] - avg) * 100) / 100;
			}
		}
		cout << '$' << ret << endl;
	}
	
	
	return 0;
}