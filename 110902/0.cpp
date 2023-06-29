#include <cstdio>
#include <string>
#include <cstring>
#include <vector>
#include <queue>
#include <cmath>
#include <iostream>
#define INF 999;
using namespace std;

class solution{
	int cases, n, S[4], T[4], F;
	int s,t,f, ten[4]={1,10,100,1000};
	string space;
	int visited[10000]={0};
	int cnt[10000]={0};
	public:
		int Lspin(int start, int digit, int i){ //다이얼 좌회전 
			i+=1;
			if(i>9) start-=9*ten[3-digit]; //9->0
			else start+=ten[3-digit];
			return start;
		}
		int Rspin(int start, int digit, int i){ //다이얼 우회전 
			i-=1;
			if(i<0) start+=9*ten[3-digit];//0->9
			else start-=ten[3-digit];
			return start;
		}
		
		void BFS(int start){
			queue<int> que;
			int s1,s2;
			que.push(start);
			visited[start]=1;
			
			while(!que.empty()){
				start=que.front(); que.pop();
				if(start == t) break;
				
				for(int i=0;i<4;i++){ //다이얼 회전 
					s1=Lspin(start,i,start/ten[3-i]%10); //왼쪽으로 다이얼회전 
					if(!visited[s1]) { //방문한거 아니면 결과 저장 
						que.push(s1);
						cnt[s1]=cnt[start]+1; //갯수 확인 
						visited[s1]=1;
					}
					
					s2=Rspin(start,i,start/ten[3-i]%10); //오른쪽으로 다이얼회전 
					if(!visited[s2]){ //방문한거 아니면 결과 저장 
						que.push(s2);
						cnt[s2]=cnt[start]+1;
						visited[s2]=1;
					}
				}
			}
		}
		
		void input(){
			scanf("%d",&cases);
			while(cases--){
				getline(cin,space);
				s=t=f=0;
				for(int i=0;i<4;i++){ //초기케이스 
					scanf("%d",&S[i]);
					s+=ten[3-i]*S[i]; //정수화. 
				}
				for(int i=0;i<4;i++){ //최종케이스 
					scanf("%d",&T[i]);
					t+=ten[3-i]*T[i]; //정수화. 
				}
				//---------------------------------
				scanf("%d",&n);
				int a;
				for(int i=0;i<n;i++){
					F=0;
					for(int j=0;j<4;j++){ //금지케이스 
						scanf("%d",&a);
						F+=ten[3-j]*a; //정수화는 F[i][4]에 저장 
					}
					visited[F]=1; //방문했으므로 금지된 것과 다름없음. 
				}
				//---------------------------------
				BFS(s); //초기상태 넣어줌. 
				if(!cnt[t]) printf("-1\n");
				else printf("%d\n",cnt[t]);
				memset(visited,0,sizeof(visited));
				memset(cnt,0,sizeof(cnt));
			}
		}
};
int main(){
	solution sol;
	sol.input();
}