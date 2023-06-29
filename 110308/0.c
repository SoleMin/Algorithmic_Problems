#include <stdio.h>
#include <string.h>

int main() {
	char fmt[100000];
	char fmt1[100000];
	int i, j, k;
	char line;
	int cnt = 0;
	int temp;
	int cnt1 = 0;
	int temp1;
	int blank[100];

	while (scanf("%c", &fmt[0]) == 1) {
		for (i = 1; i < 100000; i++) {
			fmt[i] = '\0';
		}
		for (i = 1; i < 100000; i++) {
			fmt1[i] = '\0';
		}
		for (i = 1; i < 100000; i++) {
			scanf("%c", &fmt[i]);
			if (fmt[i] == '\n' && fmt[i - 1] == '\n')
				break;
		}
		temp = 0;
		for (i = 0; i < 100000; i++) {
			if (fmt[i] == '\n')
				fmt[i] = ' ';
		}
		temp = 0;
		temp1 = 1;
		cnt1 = 0;
		cnt = 0;
		for (i = 0; i < 1000; i++) {
			for (j = temp; j < temp + 72; j++) {
				if (fmt[j] == ' ') {
					cnt = j;
				}
				if ((j == temp + 71 && fmt[temp + 71] == ' ')) {
					fmt[j] = '\n';
					temp = j + 1;
				}
				else if (j == temp + 71 && fmt[temp + 72] == ' ') {
					fmt[j + 1] = '\n';
					temp = j + 2;
				}
				else if (j == temp + 71 && cnt!=0) {
					fmt[cnt] = '\n';
					temp = cnt + 1;
				}
				else if(j==temp+71 && cnt==0){
					for(k=temp+71;k<temp+71+1000;k++){
						if(fmt[k] == ' '){
							fmt[k] = '\n';
							temp = k+1;
							break;
						}
							
					}
				}
			}
			cnt = 0;
		}
		for (i = 0; i < 10000; i++) {
			if (fmt[i] == '\0')
				break;
			printf("%c", fmt[i]);
		}printf("\n");
	}
}
