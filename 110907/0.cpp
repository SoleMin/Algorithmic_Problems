#include <bits/stdc++.h>
#define MAXN 100
#define MAXE 1000
#define MAXNAME 32
#define MAXQUESIZE 10000
using namespace std;

class solution{
	string city[MAXN];
	string name1, name2;
	int edges[MAXE][4], check[MAXN][2];
	int que[MAXQUESIZE];
	int t1, t2;
	int n, e, ne, front, rear, reachable, start, finish;
	public:
		
		void BFS(){
			int t, now[3]; //현재도시 / 필요혈액량 / 도착시간 
			front=rear=reachable=0;
			for(int i=0;i<n;i++) check[i][0]=10000; //check에 now와 관련된 정보가 들어가야함. 
			
			que[rear++]=start; //도시를 일단 담음 
			check[start][0]=check[start][1]=0; //[0]은 혈액량, [1]은 도착시간으로. 
			while(front<rear){
				now[0]=que[front++]; //현재 front도시로 이동했음. 
				now[1]=check[now[0]][0]; //현재도시에서의 혈액량이 됨.(처음엔 필요x) 
				now[2]=check[now[0]][1]; //현재도시에서의 도착가능한 최단시간 
				if(now[0] == finish){ //만약 도시가 도착한 곳이면. 
					reachable=1; continue; //도달했으므로 표시함. 
				}
				
				for(int i=0;i<ne;i++){ //ne에 대한 BFS 제대로 시작
					if(edges[i][0] != now[0]) continue; //현재도시인 곳만 보면 됨. 
					//도착시간이 노선 출발시간전이면 기본적으로 탈 수 있다. 
					//또한 도착지일 때 혈액량이 현재 혈액량보다 많아도 탈 수 있고, 
					//아니면 같은 경우, 도착했을 때 해당 노선의 도착시간보다 이후면 아직 안지났으니 타도됨. 
					if(now[2] <= edges[i][2] && (check[edges[i][1]][0] > now[1] ||
					 (check[edges[i][1]][0] == now[1] && check[edges[i][1]][1] > edges[i][2] + edges[i][3]))){
							que[rear++]=edges[i][1]; //원하는대로 도착할 수 있으므로 이동 
							check[edges[i][1]][0]=now[1]; //혈액량도 갱신하고 
							check[edges[i][1]][1]=edges[i][2]+edges[i][3]; //시간도 갱신하면 됨. 
					}
					//하루 후면 일단 무조건 혈액을 한번 먹어야함. now[1]+1
					//그리고 이후 하루가 지나고 도착했을 때 혈액량이 더 많다면 충분히 탈 수 있을것이고. 
					//마찬가지로 같은 경우면 노선 도착시간 똑같이 비교해주면 될듯 
					else if(now[1]+1 < check[edges[i][1]][0] || 
					(now[1]+1 == check[edges[i][1]][0]) && (check[edges[i][1]][1] > edges[i][2]+edges[i][3])){
						que[rear++]=edges[i][1];
						check[edges[i][1]][0]=now[1]+1; //갱신하는데 하루지났으니 +1만 해주면 됨. 똑같음
						check[edges[i][1]][1]=edges[i][2]+edges[i][3];
					}
				}
			}
		} 
		int getcity(string name){ //도시의 고유번호 반환 
			for(int i=0;i<n;i++)
				if(name == city[i]) return i;
			city[n]=name;
			return n++;
		}
		void input(int i){
			n=ne=0;
			scanf("%d",&e);
			for(int i=0;i<e;i++){
				cin>>name1>>name2>>t1>>t2;
				t1%=24; 
				
				if((t1>=6 && t1<18) || (t1<6 && t2>6-t1) || (t1>=18 && t2>30-t1)) continue; //죽는 시간대 
				
				edges[ne][0]=getcity(name1); //출발지 
				edges[ne][1]=getcity(name2); //도착지 
				edges[ne][2]=(t1+12)%24; //출발시간 
				edges[ne][3]=t2; //소요시간 
				ne++; //edge++
			}
			cin>>name1>>name2; //최종 출발지, 도착지 
			start=getcity(name1);
			finish=getcity(name2);
			
			BFS();
			printf("Test Case %d.\n", i);
			if (reachable) printf("Vladimir needs %d litre(s) of blood.\n", check[finish][0]);
			else printf("There is no route Vladimir can take.\n");
		}
};
int main(){
	solution sol;
	int t;
	scanf("%d",&t);
	for(int i=1;i<=t;i++){
		sol.input(i);
	}
}