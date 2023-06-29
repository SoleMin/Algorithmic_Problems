#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

#define N (32 + 1)

char* upper(char* str) {
	for (char* p = str; *p; p++) {
		if (*p == '\n')
			continue;
		*p = toupper(*p);
	}
	return str;
}

bool rtg(int row, int col, int r, int c, int count, int len) {
	return r < row && r >= 0 && c < col && c >= 0 && count < len;
}

bool n_1(char* str, char** matrix, int row, int col, int r, int c) {
	int count = 0;
	bool result = false;
	while (rtg(row, col, r, c, count, strlen(str))) {
		result = true;
		if (str[count] == '\n')
			return true;
		if (str[count] != matrix[r][c])
			return false;
		count++;
		c++;
	}
	if (strlen(str) - 1 == count)
		return result;
	return false;
}

bool n_2(char* str, char** matrix, int row, int col, int r, int c) {
	int count = 0;
	bool result = false;
	while (rtg(row, col, r, c, count, strlen(str))) {
		result = true;
		if (str[count] == '\n')
			return true;
		if (str[count] != matrix[r][c])
			return false;
		count++;
		r++;
		c++;
	}
	if (strlen(str) - 1 == count)
		return result;
	return false;
}

bool n_3(char* str, char** matrix, int row, int col, int r, int c) {
	int count = 0;
	bool result = false;
	while (rtg(row, col, r, c, count, strlen(str))) {
		result = true;
		if (str[count] == '\n')
			return true;
		if (str[count] != matrix[r][c])
			return false;
		count++;
		r++;
	}
	if (strlen(str) - 1 == count)
		return result;
	return false;
}

bool n_4(char* str, char** matrix, int row, int col, int r, int c) {
	int count = 0;
	bool result = false;
	while (rtg(row, col, r, c, count, strlen(str))) {
		result = true;
		if (str[count] == '\n')
			return true;
		if (str[count] != matrix[r][c])
			return false;
		count++;
		r++;
		c--;
	}
	if (strlen(str) - 1 == count)
		return result;
	return false;
}

bool n_5(char* str, char** matrix, int row, int col, int r, int c) {
	int count = 0;
	bool result = false;
	while (rtg(row, col, r, c, count, strlen(str))) {
		result = true;
		if (str[count] == '\n')
			return true;
		if (str[count] != matrix[r][c])
			return false;
		count++;
		c--;
	}
	if (strlen(str) == count)
		return result;
	return false;
}

bool n_6(char* str, char** matrix, int row, int col, int r, int c) {
	int count = 0;
	bool result = false;
	while (rtg(row, col, r, c, count, strlen(str))) {
		result = true;
		if (str[count] == '\n')
			return true;
		if (str[count] != matrix[r][c])
			return false;
		count++;
		r--;
		c--;
	}
	if (strlen(str) - 1 == count)
		return result;
	return false;
}

bool n_7(char* str, char** matrix, int row, int col, int r, int c) {
	int count = 0;
	bool result = false;
	while (rtg(row, col, r, c, count, strlen(str))) {
		result = true;
		if (str[count] == '\n')
			return true;
		if (str[count] != matrix[r][c])
			return false;
		count++;
		r--;
	}
	if (strlen(str) -1 == count)
		return result;
	return false;
}

bool n_8(char* str, char** matrix, int row, int col, int r, int c) {
	int count = 0;
	bool result = false;
	while (rtg(row, col, r, c, count, strlen(str))) {
		result = true;
		if (str[count] == '\n')
			return true;
		if (str[count] != matrix[r][c])
			return false;
		count++;
		r--;
		c++;
	}
	if (strlen(str) - 1 == count)
		return result;
	return false;
}

int main(void) {
	int test_case;
	scanf("%d", &test_case);
	getchar();
	getchar();
	while (test_case--) {
		int row;
		int col;
		scanf("%d %d", &row, &col);
		getchar();
		char** matrix = malloc(sizeof(char*) * row);
		for (int i = 0; i < row; i++)
			matrix[i] = malloc(sizeof(char) * col);
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				char temp;
				scanf("%c", &temp);
				matrix[i][j] = toupper(temp);
			}
			getchar();
		}
		int num;
		scanf("%d", &num);
		getchar();
		char** names = malloc(sizeof(char*) * num);
		for (int i = 0; i < num; i++)
			names[i] = malloc(sizeof(char) * N);
		for (int i = 0; i < num; i++) {
			fgets(names[i], N, stdin);
			char* str = upper(names[i]);
			int r, c;
	
			for (r = 0; r < row; r++)
				for (c = 0; c < col; c++)
					if (n_1(str, matrix, row, col, r, c) || n_2(str, matrix, row, col, r, c) || n_3(str, matrix, row, col, r, c) || n_4(str, matrix, row, col, r, c) || n_5(str, matrix, row, col, r, c) || n_6(str, matrix, row, col, r, c) || n_7(str, matrix, row, col, r, c) || n_8(str, matrix, row, col, r, c))
						goto eol;
			eol: printf("%d %d\n", r + 1, c + 1);
		}
		printf("\n");
		for (int i = 0; i < num; i++)
			free(names[i]);
		free(names);
		for (int i = 0; i < row; i++)
			free(matrix[i]);
		free(matrix);
	}
	return 0;
}