#include <iostream>
#include <cmath>
#define MAX 64
using namespace std;

int n, m, num;

void construct_candidates(int a[], int k, int c[], int* ncandidates) {
	bool legal_move;
	int times = k;
	
	*ncandidates = 0;

	if (k > n)
		times = 2 * n - k;

	for (int i = 0; i <= times; i++) {
		legal_move = true;
		
		for (int j = 1; j < k; j++) {
			int x = (abs(j - k) / 2);
			int y = 2 * n - k - j;

			if (i != 0) {
				

				if ((k % 2 == j % 2) && (a[j] != 0)) {
					if (k > n && j > n) {
						if (x + i == a[j])
							legal_move = false;
					}
					else if (k > n && j <= n) {
						if (y < 0) {
							if (i + (abs(y) / 2) == a[j])
								legal_move = false;

						}
						else if (i == (abs(y) / 2) + a[j])
							legal_move = false;
					}
					else if (k <= n && j <= n) {
						if (x + a[j] == i)
							legal_move = false;
					}
				}
			}

		}

		if (legal_move == true) {
			c[*ncandidates] = i;
			*ncandidates = *ncandidates + 1;
		}
	}
}
int is_a_solution(int count) {
	if (count == m) {
		num++;
		return 0;
	}
	return 1;
}
void backtrack(int a[], int k, int count) {
	int c[MAX];
	int ncandidates;
	bool legal_move;
	if (is_a_solution(count)) {
		k++;
		construct_candidates(a, k, c, &ncandidates);
		legal_move = true;
		for (int i = 0; i < ncandidates; i++) {
			a[k] = c[i];

			if (c[i] != 0) {
				if (legal_move == true) {
					count++;
					legal_move = false;
				}
			}

			if (count + 2 * n - 1 - k >= m)
				backtrack(a, k, count);
		}
	}

}
void mqueens() {
	int a[MAX];
	backtrack(a, 0, 0);
	cout << num << endl;
}
int main() {
	while (cin >> n >> m) {
		num = 0;
		if (n == 0 && m == 0)
			break;
		mqueens();
	}
	return 0;
}