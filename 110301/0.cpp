#include <iostream>
#include <string>
using namespace std;
int main() {
	char msg;
	while((msg = getchar()) != EOF) {
		switch(msg) {
			case ' ':
				cout << ' ';
				break;
			case '\n':
				cout << '\n';
				break;
			case '1':
				cout << '`';
				break;
			case '2':
				cout << '1';
				break;
			case '3':
				cout << '2';
				break;
			case '4':
				cout << '3';
				break;
			case '5':
				cout << '4';
				break;
			case '6':
				cout << '5';
				break;
			case '7':
				cout << '6';
				break;
			case '8':
				cout << '7';
				break;
			case '9':
				cout << '8';
				break;
			case '0':
				cout << '9';
				break;
			case '-':
				cout << '0';
				break;
			case '=':
				cout << '-';
				break;
			case 'W':
				cout << 'Q';
				break;
			case 'E':
				cout << 'W';
				break;
			case 'R':
				cout << 'E';
				break;
			case 'T':
				cout << 'R';
				break;
			case 'Y':
				cout << 'T';
				break;
			case 'U':
				cout << 'Y';
				break;
			case 'I':
				cout << 'U';
				break;
			case 'O':
				cout << 'I';
				break;
			case 'P':
				cout << 'O';
				break;
			case '[':
				cout << 'P';
				break;
			case ']':
				cout << '[';
				break;
			case '\\':
				cout << ']';
				break;
			case 'S':
				cout << 'A';
				break;
			case 'D':
				cout << 'S';
				break;
			case 'F':
				cout << 'D';
				break;
			case 'G':
				cout << 'F';
				break;
			case 'H':
				cout << 'G';
				break;
			case 'J':
				cout << 'H';
				break;
			case 'K':
				cout << 'J';
				break;
			case 'L':
				cout << 'K';
				break;
			case ';':
				cout << 'L';
				break;
			case '\'':
				cout << ';';
				break;
			case 'X':
				cout << 'Z';
				break;
			case 'C':
				cout << 'X';
				break;
			case 'V':
				cout << 'C';
				break;
			case 'B':
				cout << 'v';
				break;
			case 'N':
				cout << 'B';
				break;
			case 'M':
				cout << 'N';
				break;
			case ',':
				cout << 'M';
				break;
			case '.':
				cout << ',';
				break;
			case '/':
				cout << '.';
				break;				
		}
	}
	
	return 0;
}