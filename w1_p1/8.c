#include <stdio.h>

#define BUFFSIZE 1024

int main() 
{
	char word [BUFFSIZE];
	
	while(fgets(word,BUFFSIZE,stdin)!=NULL)
	{
		int wordCount = 0;
		int charCount = 0;
		int i= 0;
		
		while(word[i] !='\n'&& strlen(word) > i)
		{
			if(word[i] != ' ' && word[i] != '\t')
				charCount++;
			
			if( (word[i] != ' ' && word[i] != '\t') && (word[i+1] ==' ' || word[i+1] =='\t' || word[i+1] =='\n' || word[i+1]==0) )
				wordCount++;
			
			i++;
		}
		printf("%d %d\n",charCount, wordCount);
	}
	return 0;
}
