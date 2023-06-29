#include <cstdio>
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <sstream>
#define INF 999
using namespace std;

class solution{
	vector<vector<int>> dist;
	vector<int> firepos; 
	string space;
	int t,fire,road;
	int start,end,weight;
	int maxdist;
	public:
		void floyd(){
			for(int k=1;k<=road;k++)
				for(int i=1;i<=road;i++)
					for(int j=1;j<=road;j++)
							dist[i][j]=min(dist[i][j],dist[i][k] + dist[k][j]);
		}
		
		void input(){
			scanf("%d",&t);
			while(t--){
				//scanf("%d %d",&fire,&road);
				cin>>fire>>road;
				dist.resize(road+1,vector<int>(road+1,INF));
				for(int i=0;i<=road;i++) dist[i][i]=0; //초기화까지. 
				
				firepos.resize(fire,0);
				for(int i=0;i<fire;i++) cin>>firepos[i]; //scanf("%d ",&firepos[i]);

				getline(cin,space);
				while(getline(cin,space) && !space.empty()){
					istringstream ss(space);
					ss>>start>>end>>weight;
					dist[start][end]=dist[end][start]=weight; //간선연결 
				}
				floyd(); //각 노드에 대한 최단거리 구함. 

				vector<int> shortway(road+1,INF);
				maxdist=0;
				for(int i=1;i<=road;i++){
					for(int j=0;j<fire;j++) //소방서가 가지는 최단거리를 구한다. 
						shortway[i]=min(dist[firepos[j]][i],shortway[i]); //어떤 소방서에서 i까지가 제일 짧은가. 
					maxdist=max(maxdist, shortway[i]); //그중에서도 제일 긴 값을 저장해둔다. 
				}
				
				int tmp, tmpdist=0, maxi=1;
				for(int i=1;i<=road;i++){
					tmpdist=0;
					for(int j=1;j<=road;j++){
						//이번엔 각 노드시점에서 비교해보면.. (소방서들이 가졌던 최단거리와)
						tmp=min(shortway[j], dist[i][j]);
						tmpdist=max(tmpdist, tmp); //위에서와 같은작업이 될테니까.
					}
					if(maxdist > tmpdist){ //이때 제일 짧았던 값이 있으면 거기에 설치하는게 맞음.
						maxdist=tmpdist; //갱신
						maxi=i;
					}
				}
				printf("%d\n\n",maxi);
				dist.clear(); firepos.clear(); shortway.clear();
			}
		}
};
int main(){
	solution sol;
	sol.input();
}