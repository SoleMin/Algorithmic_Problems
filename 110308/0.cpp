#include <iostream>
#include <cstdio>
#include <cstring>
#include <string>
#include <map>
#include <vector>
using namespace std;
/*
	최대한 72자를 기준으로 하며,
	따라서 넘으면 줄을 바꿔야한다.

	이때 단어인 경우 줄을 바꿀 수 있다.

	개행같은 경우는 스페이스바로 바뀌는걸 원칙으로 한다.
	다만 단순히 빈줄인 경우(구분용 개행), 그리고 개행할시 바로 개행이 있는 개행은 무시한다.
	
    일단 문자열을 받는다. 이때 받다가 입력이 \n이고, 바로 뒤에 \n이 없으면 \n=' ' 로 치환한다.
    그리고 문자열을 받다가 72자에 도달했는데 아직도 단어작성중이다? 그럼 그 단어는 아래로 내린다.
*/
vector<string> fmt(1);
int chk=0;
class paragraph{
	string word;
	string line;
	string tmp;
	int ch, len, tlen;
	int i, idx;
	public:
		//word받고, 한 줄 길이 체크해서 len+word길이>72 이면  일단 [0]+=한줄\n 하고
		//[0]+=word를 하는 식으로 하면?
		/*void b4space(){ //이전공백
			for(int i=len-1;i>=0;i--){
				if()
			}
		}*/
		void input_line(){
			line=tmp=""; idx=0;
			while(!cin.eof()){
				if(tmp.length()>72){ //앞이 너무 길어서 밑에를 처리못할 경우.
					len=line.length();
					if(line[len-1] == ' ') line.pop_back();
					fmt[idx]+=(line+'\n');
					line=tmp="";
					continue;
				}
				getline(cin,word);
				line+=word;
			
				len=line.length(); //line은 최대한 72글자씩 유지하도록 만들고싶다.
				//cout<<"line:"<<line<<endl;
				
				if(word==""){
					if(line[len-1] == ' ') line.pop_back();
					fmt[idx++]+=(line+'\n'); line=""; fmt.push_back(""); continue;} //빈줄이므로 새 문단이라 판단.
				//새 줄이면 이전줄 끝에 있는 공백이나 현재줄 맨앞의 공백은 모두 지우도록 한다.

				if(len>72){ //line이 72자를 넘었어?
					for(i=len-1;i>=0;i--){ //72자를 넘게만든 주범인 단어를 찾는다.
						if(line[i] == ' '){ //(len-1)~(i+1)까지가 단어의 길이겠지.
							if(i <= 72){ //line이... 72자 안으로 들어온다. 아니라면 분명 엄청나게 긴 글일텐데.
								tmp=line.substr(i+1,len); //일단 그거 다 뺀다.
								tlen=tmp.length(); //길이 측정해둠.
								for(int j=i;j<len;j++) line.pop_back(); //지워. (현재줄 스페이스바까지 사라진다.)
								break;
							}
						}
					}
					//여기까지 오면 tmp에는 다음 행에 넣어야할 값이 담겨있고, line은 공백없이 텅텅 비어있음.
					//다만 예외라면, 단어가 72자를 혼자 뚫어버린 경우겠지.
					//중간에 72자를 뚫어버리는 경우는 어차피 현line이 이미 72자를 뚫었으므로 걔만 출력하고 말듯?
					if(i<0){ //72자 자체가 단어였거나, i가 72보다 크면 이런 꼴임.
						fmt[idx]+=(line+'\n'); //혼자 72자를 뚫어버린 경우는 그냥 바로. 넣고 건너뛴다.
						line="";
					}
					else{ //그냥 아닌 경우는
						fmt[idx]+=(line+'\n'); //line이 72자에 가까울 것이다.
						line="";
						line+=tmp;
						if(i>72){fmt[idx]+=(tmp+'\n'); tmp="";}
						else line+=' '; //line에 tmp를 넣고 시작하면 되겠지.
					}
				}
				else{
					if(len == 72){
						fmt[idx]+=(line+'\n'); //딱 72자면 그냥 넣는다.
						line="";
						//cout<<"fmt:"<<idx<<fmt[idx]<<endl;
					}
					else line+=' '; //72자 이내면, 아직 더 입력받을 수 있으니까 일단 계속 받기로 한다.
				}
			}
			fmt[idx]+=line;
		}
};
int main() {
	int len;
	paragraph word;
	word.input_line();
	for(auto it: fmt) cout<<it<<endl;
	
}