#include <cstdio>
#include <iostream>
#include <cstring>
#include <string>
#include <vector>
#include <map>
#include <queue>
#include <sstream>
using namespace std;
/*
    가장 짧은 순서를 찾으라고 했기 때문에,
    최단경로를 묻는 것같다.
	그러면 DFS나 BFS를 쓰는게 맞는건가?
	DFS면 끝까지 들어갔다 나오다가 오른쪽꺼 만나면 바로 종료.
	BFS면 찾다가 오른쪽꺼 만나면 바로 종료.

    길이가 꼭 일치해야 하니까
    map<len, vector<string>> 으로 해보면
    같은 길이인 단어가 쫙 쌓일텐데...
    찾는 글자에 해당하는 길이로 들어가서,
    찾는글자와 더블릿인 단어를 찾아서, matrix에 넣고(넣는 방법 미구상)
	matrix에서 BFS를 하면서 최단경로를 찾는다.

	핵심은 matrix에 뭘 어떤 식으로 넣겠느냐는건데.
	각 행을 단어라고 하면, 첫 단어는 0번에 넣고,
    더블릿 단어들을 넣는다. 이때 넣으면서 만약 내가 찾는 최종단어면 얘 값은 따로 추출해둔다.
    아니다... 이거 string으로 matrix 짜는게 낫다.
*/

map<string, vector<string>> matrix;

class solution{
	map<int, vector<string>> candi; //n글자 더블릿 후보들
	string find1, find2;
	string word;
	int len, len1, len2;
	vector<string> answer;
	bool chk;

	public:
		void doublets(string w1, string w2, int len){ //w1의 더블릿이 w2인가?
			int cnt=0;
			for(int i=0;i<len;i++){
				if(w1[i] != w2[i]) ++cnt;
				if(cnt>1) return; //더블릿이 아니면 필요없음.
			}
			//printf("w1은 "); cout<<w1<<endl;
			//printf("w2는 "); cout<<w2<<endl;
			matrix[w1].push_back(w2);
			matrix[w2].push_back(w1); //w1에서 w2를, w2에서 w1을 찾을 수 있다는 뜻.
		}

		void setmatrix(int len){
			int size=candi[len].size(); //candi[len]이 가진 문자열들의  개수
			//printf("size: %d\n",size);
			for(int i=0;i<size;i++){
				for(int j=i+1;j<size;j++)
					doublets(candi[len][i],candi[len][j], len1); //길이len에 관한 더블릿 매트릭스 구축
			}
		}

		/*
            어떻게 BFS를 할 것인가?
            언제 최단거리인가?
			BFS로 한번씩 접근하겠지.
			깊이를 계속 체크하도록 하고. depth=0;

			find2를 만나면 사실 그게 최단거리가 아닐까.
			depth는 의미가 없네.
			즉 matrix[start][i]를 돌다가 find2를 만나면,
            지금까지 갔던 길이 곧 최단거리잖아?
            그걸 어떻게 기록해두지? 그게 문제네.
		*/
		void BFS(string find1, string find2, int len){ //find1 -> find2
			queue<string> que;
			map<string, string> visited;
			int depth=0;
			string start;

			que.push(find1); //find1의 더블릿부터 시작.
			while(!que.empty()){
				start=que.front(); que.pop();	//matrix를 map형태로 짜놔서.. [start][0]~[start][end] 처럼 접근하겠지.
				//cout<<"start: "<<start<<endl;
				int size=matrix[start].size(); //start키가 가진 원소의 개수.

				for(int i=0;i<size;i++){ //map이 헛쓰인 부분이 없을걸? 그래서 방문만 시켜준다.
					//문제는 최단경로를 방문하는 방법인데, 부모노드의 번호로 탐색한다고 함. depth가 아니네
					//근데 우리 번호로 구분을 안했는데?
					if(!visited.count(matrix[start][i])){ //방문한적 없는 곳이면
						if(matrix[start][i] == find1) continue;
						que.push(matrix[start][i]); //방문대기 시키고.
						visited[matrix[start][i]]=start; //방문. 분명히 나는 부모를 기억하고 있다.

						if(matrix[start][i] == find2){ //근데 원하는게 거기 있으면
							answer.push_back(matrix[start][i]); //find2 저장하고.
							string tmp=visited[matrix[start][i]]; //부모노드 지정해서
							while(1){ //find2~find1까지 반복
								if(tmp == find1){
									answer.push_back(find1);
									return;
								}
								answer.push_back(tmp); //부모노드부터 등록되는 거임.
								tmp=visited[tmp]; //부모노드 방문
							}
						}
					}
				}
				//--------------------------------------------------------------------------------
			}
			printf("No solution.\n\n");
			chk=1; return;
		}
		void input_words(){
			chk=0;
			while(!cin.eof()){ //사전입력
				getline(cin,word);
				if(word == "") break;
				len=word.length();
				candi[len].push_back(word); //len자릿수 애들 다 모은다.
			}
			int a=1; //setmatrix를 한번밖에 할 필요가 없어서.
			while(!cin.eof()){
				//scanf("%s %s",find1,find2);
				getline(cin,word);
				if(word=="") break;

				stringstream input(word);
				input>>find1>>find2;

				len1=find1.length(), len2=find2.length();
				if(len1 != len2) printf("No solution.\n\n"); //길이가 다르면 더블릿이 아니다.
				else{
					if(a==1){setmatrix(len1); ++a; } //len들에 대해 matrix를 구축.
				//matrix를 세웠으니, 방문해야겠지? BFS로 최단경로 검색.
					BFS(find1, find2, len);

					if(!chk){
						int alen=answer.size();
						for(int i=alen-1;i>=0;i--) cout<<answer[i]<<endl;
						printf("\n");
					}
				}
				answer.clear();
				chk=0;
			}
			candi.clear();
		}

};

int main(){
	solution solv;
	solv.input_words();
}