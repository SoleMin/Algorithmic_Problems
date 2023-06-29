#include <iostream>
#include <cstdio>
#include <string>
#include <cstring>
#include <sstream>
#include <vector>
#include <map>
#include <stack>
#include <algorithm>
#define MAXN 101
#define INF 999
using namespace std;
//A-E가 A-C-F-E or A-C-D-E 니까
//해당 노드로 이동을 하고나서, 그 노드가 사이클을 돌면 그 노드가 카메라.
//즉 해당노드가 사이클을 소유한다면 무조건 거치는놈이란거지. 
class solution{
	int n, r, cam, number;
	string city1, city2;
	vector<vector<int>> matrix;
	vector<bool> visited; 
	vector<string> cities;
	public:
		void DFS(int start){
			visited[start]=1;
			//printf("[%d] 방문\n",start);
			for(int j=0;j<n;j++)
				if(matrix[start][j]!=INF && !visited[j])  
					DFS(j);
		}
		
		void input(){
			number=1;
			while(1){
				getline(cin,city1); //버퍼 징그럽게 쌓여서 그냥 문자열로
				istringstream ss(city1);
				ss>>n;
				if(n == 0) return;
				matrix.resize(n,vector<int>(n,INF));
				visited.resize(n,0);
				map<string,int> citynum;
				map<int,string> cityname;
				
				for(int i=0;i<n;i++){
					getline(cin, city1);
					citynum.insert(make_pair(city1,i));
					cityname.insert(make_pair(i,city1));
				}
				
				scanf("%d ",&r);
				string a;
				for(int i=0;i<r;i++){
					getline(cin,a);
					stringstream ss(a);
					ss>>city1>>city2;
					matrix[citynum[city1]][citynum[city2]]=matrix[citynum[city2]][citynum[city1]]=1;
					//printf("matrx[%d][%d] - [%d][%d] 연결\n",citynum[city1],citynum[city2], citynum[city2], citynum[city1]);
				}
				
				vector<int> tmp;
				int cnt, len;
				for(int i=0;i<n;i++){
					cnt=0;
					for(int j=0;j<n;j++)
						if(matrix[i][j]!=INF){
							tmp.push_back(j);
							matrix[i][j]=matrix[j][i]=INF; //i를 하나씩 제거해봄.
						}
					//printf("[%d]를 제거하고 %d방문\n\n",i,i+1);
					if(i==n-1) DFS(i-1);
					else DFS(i+1);

					for(int j=0;j<n;j++)
						if(visited[j] == 0 && j!=i) ++cnt; //방문한게 없으면 0임.
					//printf("cnt: %d\n",cnt);
					if(cnt>0) //애초에 방문한게 없어야 가능한 이야기임. 즉 2개생겼단거겠지 
						cities.push_back(cityname[i]);
					
					for(int j=0;j<n;j++) visited[j]=0;
					len=tmp.size();
					for(int j=0;j<len;j++) matrix[i][tmp[j]]=matrix[tmp[j]][i]=1; //복구 

					tmp.clear();
				}
				
				len=cities.size();
				printf("City map #%d: %d camera(s) found\n",number++,len);
				
				sort(cities.begin(), cities.end());
				for(int i=0;i<len;i++) cout<<cities[i]<<endl;
				printf("\n");
				
				citynum.clear(); cityname.clear(); matrix.clear(); visited.clear(); cities.clear();
				
			}
		}
};
int main(){
	solution sol;
	sol.input();
}