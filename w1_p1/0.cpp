#include <cstdio>
#include <cctype>
#include <cstring>

int main() {
	char str[1024];
	int chk=1, word=0, len=0; //chk는 공백표시
	
	while(fgets(str,1024,stdin) != NULL){
		int i=0;
		chk=1; word=len=0;
		
		while(str[i] != '\n' && (i < strlen(str))){
			if(!isspace(str[i])){ //문자면 글자세고
				++len;
				if(chk){ chk=0; ++word; } //전에 공백이었으면 단어다.
			}
			else chk=1; //공백이면 공백임을 체크만.
			++i;
		}
		printf("%d %d\n", len, word); //이전 줄 정보출력
	}
}