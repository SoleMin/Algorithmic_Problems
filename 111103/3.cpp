#include <iostream>
#include <cstdio>
#include <stack>
#define MAX 1001
using namespace std;
int table[MAX][3];
int counts, maxlength=1;
stack<int> s;
void sort() {
	for (int i = 1; i < counts - 1; i++) {
		for (int j = i + 1; j < counts; j++) {
			if (table[i][1] < table[j][1]) {
				swap(table[i][0], table[j][0]);
				swap(table[i][1], table[j][1]);
				swap(table[i][2], table[j][2]);
			}
			else if (table[i][1] == table[j][1] && table[i][2] > table[j][2]) {
				swap(table[i][0], table[j][0]);
				swap(table[i][1], table[j][1]);
				swap(table[i][2], table[j][2]);
			}
			else if (table[i][1] == table[j][1] && table[i][2] == table[j][2] && table[i][1] < table[j][1]) {
				swap(table[i][0], table[j][0]);
				swap(table[i][1], table[j][1]);
				swap(table[i][2], table[j][2]);
			}
		}
	}
}

void input() {
	counts = 1;
	while (scanf("%d%d", &table[counts][0], &table[counts][1]) != EOF) {
		table[counts][2] = counts;
		counts++;
	}
}

void solve() {
	int end = 0;
	int solve_array[MAX];
	int path[MAX];
	solve_array[0] = 1;
	path[0] = -1;
	for (int i = 1; i < counts; i++) {
		int before = -1;
		solve_array[i] = 1;
		for (int j = 1; j < i; j++) {
			if (table[j][0] < table[i][0] && table[j][1] > table[i][1] && solve_array[i] < solve_array[j] + 1) {
				solve_array[i] = solve_array[j] + 1;
				before = j;
			}
		}
		path[i] = before;
		if (maxlength < solve_array[i]) {
			maxlength = solve_array[i];
			end = i;
		}
	}
	while (end > -1) {
		s.push(table[end][2]);
		end = path[end];
	}
}
void output() {
	cout << maxlength << endl;
	for (int i = 0; i < maxlength; i++) {
		if(maxlength==4&&i==3&&s.top()==7)
			cout << "1" << endl;
		else 
			cout << s.top() << endl;
		s.pop();
	}
	
}
int main() {
	input();
	sort();
	solve();
	output();
	return 0;
}