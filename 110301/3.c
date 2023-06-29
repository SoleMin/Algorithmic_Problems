#include <stdio.h>
int main() {
	char buffer[500];
	int i;
	char temp;
	while(fgets(buffer,sizeof(buffer),stdin)!=NULL){
		i = 0;
		while(buffer[i]!=NULL){
			temp = buffer[i];
			switch(temp){
				case ' ' : buffer[i] = ' '; break;
				case '1' : buffer[i] = '`'; break;
				case '2' : buffer[i] = '1'; break;
				case '3' : buffer[i] = '2'; break;
				case '4' : buffer[i] = '3'; break;
				case '5' : buffer[i] = '4'; break;
				case '6' : buffer[i] = '5'; break;
				case '7' : buffer[i] = '6'; break;
				case '8' : buffer[i] = '7'; break;
				case '9' : buffer[i] = '8'; break;
				case '0' : buffer[i] = '9'; break;
				case '-' : buffer[i] = '0'; break;
				case '=' : buffer[i] = '-'; break;
				case 'W' : buffer[i] = 'Q'; break;
				case 'E' : buffer[i] = 'W'; break;
				case 'R' : buffer[i] = 'E'; break;
				case 'T' : buffer[i] = 'R'; break;
				case 'Y' : buffer[i] = 'T'; break;
				case 'U' : buffer[i] = 'Y'; break;
				case 'I' : buffer[i] = 'U'; break;
				case 'O' : buffer[i] = 'I'; break;
				case 'P' : buffer[i] = 'O'; break;
				case '[' : buffer[i] = 'P'; break;
				case ']' : buffer[i] = '['; break;
				case '\\' : buffer[i] = ']'; break;
				case 'S' : buffer[i] = 'A'; break;
				case 'D' : buffer[i] = 'S'; break;
				case 'F' : buffer[i] = 'D'; break;
				case 'G' : buffer[i] = 'F'; break;
				case 'H' : buffer[i] = 'G'; break;
				case 'J' : buffer[i] = 'H'; break;
				case 'K' : buffer[i] = 'J'; break;
				case 'L' : buffer[i] = 'K'; break;
				case ';' : buffer[i] = 'L'; break;
				case '\'' : buffer[i] = ';'; break;
				case 'X' : buffer[i] = 'Z'; break;
				case 'C' : buffer[i] = 'X'; break;
				case 'V' : buffer[i] = 'C'; break;
				case 'B' : buffer[i] = 'V'; break;
				case 'N' : buffer[i] = 'B'; break;
				case 'M' : buffer[i] = 'N'; break;
				case ',' : buffer[i] = 'M'; break;
				case '.' : buffer[i] = ','; break;
				case '/' : buffer[i] = '.'; break;
			}
			i++;
		}
		for(int j = 0; j < i; j++){
			printf("%c", buffer[j]);
		}
	}
	return 0;
}
