#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

struct Task {
	int name;
	int T;
	double p;
};

bool compare(Task t1, Task t2) {
	if (t1.p == t2.p) {
		if (t1.T == t2.T)
			return t1.name < t2.name;
		else
			return t1.T < t2.T;
	}
	else
			return t1.p > t2.p;
}

int main() {
	int tc;
	cin >> tc;
	while (tc-- != 0) {
		int n;
		cin >> n;
		vector<Task> order;
		for (int i = 1; i <= n; i++) {
			int T, S;
			cin >> T >> S;
			Task temp = { i, T, (double) S / T };
			order.push_back(temp);
		}
		
		sort(order.begin(), order.end(), compare);
		
		for (int i = 0; i < n; i++)
			cout << order[i].name << ' ';
		
		cout << "\n\n";
	}
	return 0;
}