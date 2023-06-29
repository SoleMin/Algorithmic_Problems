#include <iostream>
#include <cstdio>
#include <string>
#include <vector>
#include <cmath>
using namespace std;

class solution{
	int t,n;
	string space;
	vector<vector<double>> point; //point가 정점이 되고,
	vector<bool> visited;
	vector<int> callby; //부른애 
	vector<double> dist; //거리 
	double x,y, result=0;
	
	public:
		double distance(vector<double> a, vector<double> b){ //distance가 가중치가 되고. 
			return sqrt(pow(a[0] - b[0],2)+pow(a[1] - b[1],2));
		}
		void prim(int start){
			double min;
			int move;
			visited[start]=1; dist[start]=0;
			
			for(int i=1;i<n;i++)
				dist[i]=distance(point[0], point[i]); //0노드부터 이동한다. 
			
			
			for(int i=0;i<n-1;i++){
				min=9999;
				for(int j=1;j<n;j++){
					if(min > dist[j] && !visited[j]){ //이때 최솟값을 찾는데 거리가 짧은애가 있으면 
						min=dist[j]; //최단거리로 가져온다 
						move=j;
					}
				}
				result+=min; //이동했으면 이동했을 때 가중치 넣으면 되고. 
				visited[move]=1; //거기로 이동함. 
				
				for(int j=1;j<n;j++){
					double weight=distance(point[move],point[j]); //가중치 구해놓고 
					if(dist[j] > weight && !visited[j]){ 
						dist[j]=weight;
					}
				}
				
			}
		}
		void input(){
			scanf("%d",&t);
			getline(cin, space);
			while(t--){
				scanf("%d ",&n);
				point.resize(n,vector<double>(2,0)); 
				dist.resize(n,0); visited.resize(n,0);
				for(int i=0;i<n;i++) scanf("%lf %lf",&point[i][0],&point[i][1]);
				result=0;
				prim(0);
				printf("\n");
				printf("%.2lf\n",result);
				dist.clear(); visited.clear(); point.clear();
			}
		}
};
int main(){
	solution sol;
	sol.input();
}