#include <stdio.h>

void main() {
	int ncase;
	scanf("%d\n", &ncase);
	char* incode = "the quick brown fox jumps over the lazy dog";
	char decode[26] = { 0, };
	char test[44];
	int record_i = 0, i, j, k;
	char buff[100][80];
	for (int x = 0; x < ncase; x++) {
		int nline = 0;
		int solution = 0;
		while (gets(buff[nline]) && *buff[nline]) {
			nline++;
		}
		for (i = 0; i < nline; i++) {
			int nspace = 0;
			for (j = 0; j < strlen(buff[i]); j++)
				if (buff[i][j] == ' ')
					nspace++;
			if (strlen(buff[i]) == strlen(incode) && nspace == 8) {
				record_i = i;
				for (j = 0; j < 26; j++) {
					for (k = 0; k < strlen(buff[i]); k++) {
						if (buff[i][k] == 'a' + j) {
							decode[j] = incode[k];
							break;
						}
					}
				}
				for (j = 0; j < strlen(buff[i]); j++) {
					if (buff[i][j] == ' ')
						test[j] = ' ';
					else
						test[j] = decode[buff[i][j] - 'a'];
				}
				if (strncmp(test, incode, strlen(incode)) == 0)
					solution = 1;
			}
			if (solution == 1)
				break;
		}
		if (solution) {
			for (i = 0; i < 26; i++) {
				for (j = 0; j < strlen(buff[record_i]); j++)
					if (buff[record_i][j] == 'a' + i) {
						decode[i] = incode[j];
						break;
					}
			}
			for (i = 0; i < nline; i++) {
				for (j = 0; j < strlen(buff[i]); j++) {
					if (buff[i][j] == ' ')
						continue;
					else
						buff[i][j] = decode[buff[i][j] - 'a'];
				}
				printf("%s\n", buff[i]);
			}
		}
		else {
			printf("No solution.\n");
		}
		printf("\n");
	}
}