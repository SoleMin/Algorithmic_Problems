#include <iostream>
#include <queue>

using namespace std;

typedef struct {
	long long n;
	int f_n;
} element;

int self_rejection(long long key) {
	if (key == 1)
		return 1;
	if (key == 2 || key == 3)
		return 2;
	
	queue<element> q;
	long long n = 4;
	int f_n = 3;
	element last = {1, 1};
	element e = {1, 1};
	q.push(e);
	e.n = 2;
	e.f_n = 2;
	q.push(e);
	while (key > n) {
		e.n = n;
		e.f_n = f_n;
		q.push(e);
		while (q.front().n < f_n) {
			last = q.front();
			q.pop();
		}
		if (q.front().n == f_n)
			last = q.front();
		n = n + last.f_n;
		f_n = f_n + 1;
	}
	
	if (key == n)
		return f_n;
	else
		return f_n - 1;
}

int main(void) {
	while (true) {
		long long johnson;
		cin >> johnson;
		if (johnson == 0)
			break;
		cout << self_rejection(johnson) << endl;
	}
}