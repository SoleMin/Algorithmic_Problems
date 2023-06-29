#include <iostream>
#include <algorithm>
using namespace std;

struct elephant {
	int index, weight, iq;
	
	elephant() {
		
	}
	
	elephant(int index1, int weight1, int iq1) {
		index = index1;
		weight = weight1;
		iq = iq1;
	}
	bool operator < (elephant elephant2) {
		if (weight != elephant2.weight)
			return weight < elephant2.weight;
		return iq > elephant2.iq;
	}
};

int main() {
	int n = 0, weight, iq;
	elephant ea[1001];
	
	while (scanf("%d %d", &weight, &iq) == 2)
		ea[n] = elephant(++n, weight, iq);
	sort(ea, ea + n);
	int dp[n], next[n], answer = 0, start;
	
	for (int i = n - 1; i >= 0; i--) {
		dp[i] = 1;
		next[i] = -1;
		
		for (int j = i + 1; j < n; j++) {
			if (ea[i].weight < ea[j].weight && ea[i].iq > ea[j].iq && 1 + dp[j] > dp[i]) {
				dp[i] = 1 + dp[j];
				next[i] = j;
			}
		}
		if (dp[i] > answer) {
			answer = dp[i];
			start = i;
		}
	}
	cout << answer << endl;
	for (int i = start; i != -1; i = next[i])
		cout << ea[i].index << endl;
}