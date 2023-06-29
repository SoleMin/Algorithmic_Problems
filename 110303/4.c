#include <stdio.h>
#include <string.h>
int main() {
	int i, j;
	char str1[1002];
	char str2[1002];
	int chk[2][30];
	int cnt;
	while(fgets(str1, 1001, stdin))
	{
		str1[strlen(str1)-1]='\0';
		if(!fgets(str2, 1001, stdin))
		str2[strlen(str2)-1]='\0';
		
	
		for(i=0; i<2; i++) 
			for(j=0; j<30; j++)
				chk[i][j]=0;				//reset array
		
		for(i=0; str1[i]!='\0'; i++)
			chk[0][str1[i]-97]++;
		for(i=0; str2[i]!='\0'; i++)
			chk[1][str2[i]-97]++;
		for(i=0; i<30; i++){
			cnt = (chk[0][i] < chk[1][i]) ? chk[0][i] : chk[1][i];
			for(j=0; j<cnt; j++)
				printf("%c", i+97);
		}
		printf("\n");
	}
	return 0;
}
