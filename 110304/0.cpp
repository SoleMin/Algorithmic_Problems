#include <iostream>
#include <cstdio>
#include <cstring>
#include <string>
#include <vector>
using namespace std;
/*
	알파벳을 다른 글자로 치환.
	이때 같은 글자로 바뀌면 안됨.
	암호화 규칙은 the quick brown fox jumps over the lazy dog 라는 문장을 암호화 한 것을 기준.
	(3 5 5 3 4 4 3 4 3) 
*/
string base="the quick brown fox jumps over the lazy dog";
int pos[9]={3,5,5,3,5,4,3,4,3};
class solution{
	private:
		char alphabet[26];
	  vector<string> crypt;
		string word;
		int cnt, baseline;
	public:
		bool isbase(string w){
			int wlen=w.length();
			int widx=0, pidx=0;
			if(wlen != 43) return 0; //글자수 입구컷
			else if(w[0]!=w[31] || w[1]!=w[32] || w[2]!=w[33]) return 0; //the the 겹치잖아.
			
			for(int i=0;i<43;i++){ //위치검사
				if(w[i] == ' '){
					if(widx == pos[pidx]){
						widx=0; ++pidx; continue;}
					else return 0;
				}
				++widx;
			}
			return 1;
		}
	
		void kicker(){
			cnt=0; baseline=-1;
			for(int i=0;i<26;i++) alphabet[i]=0;
			
			while(!cin.eof()){
				getline(cin,word);
				if(word=="") break;
				crypt.push_back(word); ++cnt;
				if(isbase(word) && baseline<0) baseline=interpret(cnt-1);
			}
			if(baseline==-1){printf("No solution.\n"); return;}
			//이제 해석만 해주면 됨..
			int len=crypt.size();
			for(int i=0;i<len;i++){
				for(auto it: crypt[i]){
					if(it == ' '){printf(" "); continue;}
					printf("%c",alphabet[it-97]);
				}
				printf("\n");
			}
			crypt.clear();
		}
		/*
			A: the quick brown fox jumps over the lazy dog
			B: xmn ceuob lrtzv ita hegfd tsmr xnm ypwq ktj
			al[x]=t; al[m]=h; 처럼 하면 겹치는지 아닌지 확인할 수가 있음.
		*/
		int interpret(int baseline){
			string str=crypt[baseline];
			int current, len=str.length();
			char pre;
			
			for(int i=0;i<len;i++){
				if(str[i]==' ') continue;
				current=str[i]-97;
				pre=alphabet[current]; //al[a]=t면 t를 넣어둔거고
				alphabet[current]=base[i]; //al[a]=h면 h가 들어가니까
				if(pre!=0 && pre!=alphabet[current]){ //다르면 겹친거니까 비워.
					for(int j=0;j<26;j++) alphabet[j]=0;
					return -1;
				}
			}
			return baseline;
		}
};
int main() {
	int n; string a;
	
	scanf("%d",&n); getchar();
	solution solv[n];
	getline(cin,a);
	for(int i=0;i<n;i++){
		solv[i].kicker();
		printf("\n");
	}
}