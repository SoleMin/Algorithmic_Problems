#include <stdio.h>
#include <string.h>
#define SIZE 51
#define WORD 21

void main() {
	int i, j, k, x, y, nword;
	int n;
	char word[SIZE];
	char cmp_word[8][SIZE];
	char buff[SIZE][SIZE];
	int rows, cols;
	scanf("%d", &n);
	while (n > 0) {
		printf("\n");
		scanf("%d %d", &rows, &cols);
		for (i = 0; i < rows; i++)
			scanf("%s", buff[i]);

		for (i = 0; i < rows; i++)
			for (j = 0; j < cols; j++)
				buff[i][j] = tolower(buff[i][j]);

		scanf("%d", &nword);
		for (i = 0; i < nword; i++) {
			scanf("%s", &word);
			for (j = 0; j < strlen(word); j++)
				word[j] = tolower(word[j]);
			int len = strlen(word);
			int rx, ry;
			int out = 1;
			for (j = 0; j < 8; j++)
				for (k = 0; k < SIZE; k++)
					cmp_word[j][k] = 0;
			for (j = 0; j < rows; j++) {
				for (k = 0; k < cols; k++) {
					if (word[0] == buff[j][k]) {
						for (x = 0; x < len && (k + x) < cols; x++)
							cmp_word[0][x] = buff[j][k + x];
						for (x = 0; x < len && (k - x) >= 0; x++)
							cmp_word[1][x] = buff[j][k - x];
						for (x = 0; x < len && (j + x) < rows; x++)
							cmp_word[2][x] = buff[j + x][k];
						for (x = 0; x < len && (j - x) >= 0; x++)
							cmp_word[3][x] = buff[j - x][k];
						for (x = 0; x < len && (k + x) < cols && (j + x) < rows; x++)
							cmp_word[4][x] = buff[j + x][k + x];
						for (x = 0; x < len && (k - x) >= 0 && (j - x) >= 0; x++)
							cmp_word[5][x] = buff[j - x][k - x];
						for (x = 0; x < len && (k + x) < cols && (j - x) >= 0; x++)
							cmp_word[6][x] = buff[j - x][k + x];
						for (x = 0; x < len && (k - x) >= 0 && (j + x) < rows; x++)
							cmp_word[7][x] = buff[j + x][k - x];

						for (x = 0; x < 8; x++) {
							if (strlen(cmp_word[x]) == len) {
								if (strncmp(cmp_word[x], word, len) == 0) {
									printf("%d %d\n", j + 1, k + 1);
									out = 0;
									break;
								}
							}
						}
					}
					if(out == 0)
						break;
				}
					if(out == 0)
							break;
			}
		}
		n--;
	}
}