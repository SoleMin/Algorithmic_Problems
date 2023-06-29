#include <iostream>
#define MAXN 32

using namespace std;

int n, identifier, possible;
char automata[8], precell[MAXN], cell[MAXN + 1];
string s;

void back(int a) {
	if (a == n - 1) {
		if (automata[precell[a - 1] * 4 + precell[a] * 2 + precell[0]] == cell[a] && automata[precell[a] * 4 + precell[0] * 2 + precell[1]] == cell[0])
			possible = 1;
		return;
	}
	
	for (int i = precell[a - 1] * 4 + precell[a] * 2; i <= precell[a - 1] * 4 + precell[a] * 2 + 1; i++) {
		if (automata[i] == cell[a]) {
			precell[a + 1] = i % 2;
			back(a + 1);
			if (possible)
				break;
		}
	}
}

int main() {
	while (cin >> identifier >> n >> s) {
		for (int i = 0; i < n; i++)
			cell[i] = s[i] - '0';
		for (int i = 0; i < 8; i++) {
			automata[i] = identifier % 2;
			identifier /= 2;
		}
		possible = 0;
		for (int i = 0; i < 8; i++) {
			if (automata[i] == cell[1]) {
				precell[0] = (i / 4) % 2;
				precell[1] = (i / 2) % 2;
				precell[2] = i % 2;
				back(2);
				if (possible)
					break;
			}
		}
		cout << (possible ? "REACHABLE\n" : "GARDEN OF EDEN\n");
	}
	return 0;
}