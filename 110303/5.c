#include <stdio.h>
void main() {
	char line1[1000];
	char line2[1000];
	int c1[26] = { 0 };
	int c2[26] = { 0 };
	int i, j;

	while (gets(line1)) {
		gets(line2);
		for (i = 0; i < 26; i++)
			c1[i] = c2[i] = 0;
		for (i = 0; i < strlen(line1); i++)
			c1[line1[i] - 'a']++;
		for (i = 0; i < strlen(line2); i++) {
			c2[line2[i] - 'a']++;
		}
		for (i = 0; i < 26; i++) {
			int min = (c1[i] > c2[i]) ? (c2[i]) : (c1[i]);
			for (j = 0; j < min; j++)
				printf("%c",((char)i + 'a'));
		}
		printf("\n");
	}

}