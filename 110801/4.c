#include <stdio.h>
#include <stdbool.h>

int n, k;

int pos(int diag) {
	int odd = diag % 2;
	return odd ? diag / 4 * 2 + 1 : (diag - 1) / 4 * 2 + 2;
}

void cp(void) {
	int matrix[2 * n][k + 1];
	for (int i = 0; i < 2 * n; i++)
		for (int j = 0; j < k + 1; j++)
			matrix[i][j] = 0;
	for (int i = 0; i < 2 * n; i++)
		matrix[i][0] = 1;
	matrix[1][1] = 1;
	for (int i = 2; i < 2 * n; i++)
		for (int j = 1; j < k + 1; j++)
			matrix[i][j] = matrix[i - 2][j] + matrix[i - 2][j - 1] * (pos(i) - j + 1);
	long result = 0;
	for (int i = 0; i < k + 1; i++)
		result += matrix[2 * n - 1][i] * matrix[2 * n - 2][k - i];
	printf("%ld\n", result);
}

int main(void) {
	while (true) {
		scanf("%d %d", &n, &k);
		if (!n && !k)
			break;
		cp();
	}
	
	return 0;
}