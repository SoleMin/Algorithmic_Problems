#include <cstdio>
#include <iostream>
#include <vector>
#include <map>
#include <algorithm>
#include <string>
#include <sstream>
#define INF 999
using namespace std;
//입력은 몸무게 IQ*100
//몸무게는 증가하게끔, IQ는 감소하게끔 만드는 순서를 찾아라.
//이때 순서값이 최대한 긴 순서로 출력해라.
class info{ public: int idx, w, s; };

bool cmp(info& a, info& b){
	if(a.w == b.w) return a.s < b.s;
	else return a.w < b.w;
} 
class solution{
	int max, cnt, len, callby;
	vector<info> elephant;
	vector<vector<int>> connect;
	vector<int> visited;
	vector<vector<int>> sequence;
	vector<vector<int>> ans;
	public:
		void maxinDFS(int start, int cnt){
			visited[start]=1;
			if(max < cnt) max=cnt;
			for(int i=0;i<len;i++)
				if(!visited[i] && connect[start][i]!=INF){
					maxinDFS(i, cnt+1);
					visited[i]=0;
				}
		}
		
		void DFS(int start, int cnt){
			visited[start]=1;
			//printf("%d에 접근(cnt=%d)\n",start,cnt);
			if(max == cnt){
				vector<int> tmp(max);
				for(int i=0;i<max;i++)
					tmp[i]=elephant[sequence[callby][i]].idx+1;
				ans.push_back(tmp);
			}
			for(int i=0;i<len;i++){
				if(!visited[i] && connect[start][i]!=INF){
					//printf("inside: %d\n",i);
					//i에 방문하므로 기록해야함. 근데 왜 기록이 안되지? 
					sequence[callby][cnt]=i;
					DFS(i, cnt+1); //i노드로 이동하기 
					visited[i]=0;
				}
			}
		}
		
		void input(){
			info inf;
			string inst;
			len=0;
			while(!cin.eof()){
				getline(cin,inst);
				if(inst == "") break;
				istringstream ss(inst);
				ss>>inf.w>>inf.s;
				inf.idx=len++;
				elephant.push_back(inf);
			}
			sort(elephant.begin(),elephant.end(),cmp); //몸무게순 정렬
			
			/*for(int i=0;i<len;i++)
				printf("[%d] %d %d\n",elephant[i].idx+1, elephant[i].w,elephant[i].s);*/
			
			connect.resize(len,vector<int>(len,INF)); visited.resize(len,0);
			for(int i=0;i<len-1;i++){
				connect[i][i]=1;
				for(int j=i+1;j<len;j++)
					if(elephant[i].s > elephant[j].s && elephant[i].w != elephant[j].w) connect[i][j]=1;
			}
					
			/*for(int i=0;i<len;i++){
				for(int j=0;j<len;j++)
					printf("%5d",connect[i][j]);
				printf("\n");
			}*/
			//-----------------------------------------------
			max=1;
			for(int i=0;i<len;i++){
				maxinDFS(i, 1);
				visited.assign(len,0);
			} //최댓값 추출
			//printf("max: %d\n",max);
			//-----------------------------------------------
			sequence.resize(len,vector<int>(max,0)); 
			//printf("max: %d\n",max);
			for(int i=0;i<len;i++){
				//printf("start=%d\n",i);
				//for(int j=0;j<len;j++) printf("%d ",connect[i][j]); printf("\n");
				callby=i; sequence[i][0]=i;
				DFS(i, 1);
				visited.assign(len,0);
			}
			//-----------------------------------------------
			sort(ans.begin(),ans.end());
			int a=ans.size();
			/*for(int i=0;i<a;i++){
				int b=ans[i].size();
				for(int j=0;j<b;j++)
					printf("%d ",ans[i][j]);
				printf("\n");
			}*/
			printf("%d\n",max);
			for(int j=0;j<max;j++)
				printf("%d\n",ans[0][j]);
			
		}
			
};

int main() {
	solution a;
	a.input();
}