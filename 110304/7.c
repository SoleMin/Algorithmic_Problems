#include <stdio.h>
#include <string.h>
#define MAX_BUF 80
#define MAX_INPUT 100


char origin[] = "the quick brown fox jumps over the lazy dog"; // 기준 암호.

int search_origin(char data[], char origin_p[], int decode[], int yes);
void make_pattern(char data[], char pattern[]);
//void set_charr(char arr[]);
//void set_inarr(int arr[]);
void print(char data[MAX_INPUT][MAX_BUF], int decode[], int n, int yes);

int main() {
	char line[MAX_BUF] = {};
	char input_data[MAX_INPUT][MAX_BUF] = {};
	char origin_p[MAX_BUF] = {};
	int decode[26];    // a(0)~z(26)에 암호화된 배열 
	int current;
	int cas;
	int yes = 0;
	scanf("%d", &cas);
	fgets(line, MAX_BUF, stdin); // 줄넘기기
	fgets(line, MAX_BUF, stdin); // 줄넘기기
	make_pattern(origin, origin_p);
	
	while(cas--) {
		current = 0;
		
		while(fgets(line, MAX_BUF, stdin) != NULL) {
			if(line[0] == '\n')
				break;
			strcpy(input_data[current], line);
			yes = search_origin(input_data[current], origin_p, decode, yes);
			current++;
			//set_charr(line);
		}
		//printf("%d", current);
		print(input_data, decode, current, yes);
		
	}
	
	
	return 0;
}

int search_origin(char data[], char origin_p[], int decode[], int yes) {
	char data_p[MAX_BUF];
	char* token1;
	int i = 0;
	int num;
	
	make_pattern(data, data_p);
	if(strncmp(data_p, origin_p, 80) == 0) {
		yes = 1;
		while(data[i] != NULL) {
			if(data[i] == ' ') {
				i++;
				continue;
			}
			num = (int)origin[i] - (int)'a';
			//printf("%c", origin[i]);\
			
			decode[num] = data[i];
			
			i++;
		}
	}
	return yes;
}

void make_pattern(char data[], char pattern[]) {
	int i;
	
	for(i = 0; i < 80; i++) {
		if(data[i] >= 'a' && data[i] <= 'z') {
			pattern[i] = '1';
		} else if(data[i] == ' ') {
			pattern[i] = '0';
		} 
		//printf("%d ", pattern[i]);
	}
	//printf("\n");
}

void print(char data[MAX_INPUT][MAX_BUF], int decode[], int n, int yes) {
	int i, j, k;
	char ch;
	
	if(yes == 0) {
		printf("No solution.\n\n");
		return;
	}
	for(i = 0; i < 25; i++) {
		for(j = i + 1; j < 26; j++) {
			if(decode[i] == decode[j]) {
				printf("No solution.\n\n");
				return;
			}
		}
	}
	
	for(i = 0; i < n; i++) {
		j = 0;
		while(data[i][j] != NULL) {
			for(k = 0; k < 26; k++) {
				ch = decode[k];
				if(data[i][j] == ch){
					printf("%c", k + 'a');
					break;
				}
			}
			if(data[i][j] != ch) {
				printf("%c", data[i][j]);
			}
			j++;
		}
	}
	printf("\n");
}






/*
void set_charr(char arr[]) {
	int i;
	for(i = 0; i < MAX_BUF; i++)
		arr[i] = NULL;
}

void set_inarr(int arr[]) {
	int i;
	for(i = 0; i < MAX_BUF; i++)
		arr[i] = NULL;
}
*/