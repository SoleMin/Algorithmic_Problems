#include <stdio.h>

int main(void)
{
	char line[1024];
	
	while(fgets(line,1024,stdin)!=NULL) //입력
	{
		int words=0 , letters=0 , i=0;
		while(line[i]!='\n' && strlen(line)>i) //개행문자가 아니고 길이가 확인위치보다 클경우
		{
			if((i==0 && (line[i]!=' ' && line[i]!='\t')) || (i>0 && (line[i-1]==' ' || line[i-1]=='\t')
																											&& (line[i]!=' ' && line[i]!='\t')))
				words++; //1번째자리가 공백이아니거나 . 2번째 자리부터 그전자리가 공백, 탭 이고 현재자리가 공백이나 탭이아닐경우
			if(line[i]!=' ' && line[i]!='\t') //공백이아닌 다른 문자가 존재시 문자수 +1
				letters++;
			i++; //위치 +1변화
		}
		printf("%d %d\n", letters, words);
	}
	return 0;
}