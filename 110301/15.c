#include <stdio.h>
#include <string.h>
#define BUFSIZE 1024

int main() {
	char line[BUFSIZE];
	int index;
	
	while (fgets(line, BUFSIZE, stdin) != NULL) {
		for (index = 0; index < strlen(line); index++) {
			if (line[index] == 'W') {
				line[index] = 'Q';
			}
			if (line[index] == 'E') {
				line[index] = 'W';
			}
			if (line[index] == 'R') {
				line[index] = 'E';
			}
			if (line[index] == 'T') {
				line[index] = 'R' ;
			}
			if (line[index] == 'Y') {
				line[index] = 'T' ;
			}
			if (line[index] == 'U') {
				line[index] = 'Y' ;
			}
			if (line[index] == 'I') {
				line[index] = 'U' ;
			}
			if (line[index] == 'O') {
				line[index] = 'I';
			}
			if (line[index] == 'P') {
				line[index] = 'O' ;
			}
			if (line[index] == '[') {
				line[index] = 'P' ;
			}
			if (line[index] == ']') {
				line[index] = '[' ;
			}
			if (line[index] == '\\' ) {
				line[index] = ']' ;
			}
			if (line[index] == 'S') {
				line[index] = 'A' ;
			}
			if (line[index] == 'D') {
				line[index] = 'S' ;
			}
			if (line[index] == 'F') {
				line[index] = 'D' ;
			}
			if (line[index] == 'G') {
				line[index] = 'F' ;
			}
			if (line[index] == 'H') {
				line[index] = 'G' ;
			}
			if (line[index] == 'J') {
				line[index] = 'H';
			}
			if (line[index] == 'K') {
				line[index] = 'J' ;
			}
			if (line[index] == 'L') {
				line[index] = 'K' ;
			}
			if (line[index] == ';') {
				line[index] = 'L' ;
			}
			if (line[index] == "'") {
				line[index] = ';' ;
			}
			if (line[index] == 'X') {
				line[index] = 'Z' ;
			}
			if (line[index] == 'C') {
				line[index] = 'X' ;
			}
			if (line[index] == 'V') {
				line[index] = 'C' ;
			}
			if (line[index] == 'B') {
				line[index] = 'V' ;
			}
			if (line[index] == 'N') {
				line[index] = 'B' ;
			}
			if (line[index] == 'M') {
				line[index] = 'N' ;
			}
			if (line[index] == ',') {
				line[index] = 'M' ;
			}
			if (line[index] == '.') {
				line[index] = ',' ;
			}
			if (line[index] == '/') {
				line[index] = '.' ;
			}
			if (line[index] == '1') {
				line[index] = '`' ;
			}
			if (line[index] == '2') {
				line[index] = '1' ;
			}
			if (line[index] == '3') {
				line[index] = '2' ;
			}
			if (line[index] == '4') {
				line[index] = '3' ;
			}
			if (line[index] == '5') {
				line[index] = '4' ;
			}
			if (line[index] == '6') {
				line[index] = '5' ;
			}
			if (line[index] == '7') {
				line[index] = '6' ;
			}
			if (line[index] == '8') {
				line[index] = '7' ;
			}
			if (line[index] == '9') {
				line[index] = '8' ;
			}
			if (line[index] == '0') {
				line[index] = '9' ;
			}
			if (line[index] == '-') {
				line[index] = '0' ;
			}
			if (line[index] == '=') {
				line[index] = '-' ;
			}
		}
		printf("%s", line) ;
	}
	return 0;
}
