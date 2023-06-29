#include <stdio.h>
#include <iostream>
#include <string.h>
#include <algorithm>

using namespace std;

#define MAX 1000

char word_1[MAX], word_2[MAX];
int i, j, k;

int main() {
	while(1){
		char same[MAX]={};
		cin.getline(word_1, MAX);
		int length_1=strlen(word_1);
		if(word_1[0]=='\0') break;
		for(i=0; i<length_1; i++){
			if(word_1[i]<'a'||word_1[i]>'z') return 0;
		}
		cin.getline(word_2, MAX);
		int length_2=strlen(word_2);
		if(word_2[0]=='\0') break;
		for(i=0; i<length_2; i++){
			if(word_2[i]<'a'||word_2[i]>'z') return 0;
		}
		sort(word_1, word_1+length_1);
		sort(word_2, word_2+length_2);
		
		k=0;
		for(i=0; i<length_1; i++){
			for(j=0; j<length_2; j++){
				if(word_1[i]==word_2[j]){
					same[k]=word_1[i];
					word_2[j]=' ';
					k++;
					break;
				}
			}
		}
		printf("%s\n", same);
	}
}