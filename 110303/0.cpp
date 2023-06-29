#include <iostream>
#include <cstdio>
#include <cstring>
#include <string>
#include <vector>
/*
	1케이스=2줄 (구분없음)
	각자 가능한 아나그램 중 제일 긴 문장 출력.
	len<=1000
	only 소문자
	문장이 여러개면 알파벳순..
	말이 문장이지 그냥 알파벳순으로 출력하란 소리아니야?
	1. 공통된 알파벳을 찾는다.
	2. 배열같은데에 순차적으로 저장해둔다. (a~z까지 카운팅해도 될듯)
	3. 다시 처음부터 돌면서 같은애들만 쪼르륵 출력한다. (들어있는 갯수만큼.)
*/
using namespace std;
int main() {
	int same_alph[26];
	int word2_alph[26];
	int ch, idx, max;
	string word1, word2;
	int len1, len2;
	
	while(!cin.eof()){
		word1=word2="";
		idx=max=0;
		for(int i=0;i<26;i++)
			same_alph[i]=word2_alph[i]=0;
		
		getline(cin,word1); len1=word1.length();
		//if(word1=="") break;
		vector<int> visited(len1);
		
		while((ch=getchar())!='\n' && ch!=EOF){
			word2+=ch; ++word2_alph[ch-97];
			for(int i=0;i<len1;i++){
				if(word1[i] == ch && !visited[i]){
					++visited[i];
					++same_alph[ch-97];
				}
			}
		}
		for(int i=0;i<26;i++){
			while(same_alph[i]>0 && word2_alph[i]>0){
				printf("%c",i+97);
				--same_alph[i]; --word2_alph[i];
			}
		}
		printf("\n");
	}
}