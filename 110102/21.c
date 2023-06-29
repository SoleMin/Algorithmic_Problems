/* Idea: C stores \n in buffer everytime user enters.
(r != i && c != j): if r or c is same as i or j, it returns false
*/

#include <stdio.h>
#include <stdlib.h>

int main(void) {
	int row;
	int col;
	int count = 1;
	scanf("%d %d", &row, &col);
	getchar();
	while (row != 0 && col != 0) {
		char** matrix = malloc(sizeof(char*) * row);
		for (int i = 0; i < row; i++) {
			matrix[i] = malloc(sizeof(char) * col);
			for (int j = 0; j < col; j++) {
				matrix[i][j] = getchar();
			}
			getchar();
		}
		printf("Field #%d:\n", count++);

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == '*')
					printf("*");
				else {
					int mine = 0;
					for (int r = i - 1; r <= i + 1; r++)
						for (int c = j - 1; c <= j + 1; c++)
							if ((r >= 0 && c >= 0) && !(r == i && c == j) && (r < row && c < col) && (matrix[r][c] == '*')) {
								mine++;
							}
					printf("%d", mine);
				}
			}
			printf("\n");
		}
		for (int i = 0; i < row; i++)
			free(matrix[i]);
		free(matrix);
		printf("\n");
		scanf("%d %d", &row, &col);
		getchar();
	}
	return 0;
}