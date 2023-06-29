#include <bits/stdc++.h>
#define INF 999;
using namespace std;

class solution{
	int n,l;
	int matrix[201][201], colored[201];
	int p[50];
	int a,b, chk;
	public:
		void DFS(int start, int color){
			colored[start]=color; //색을 칠한 개념이 됨.
			for(int i=0;i<n;i++){
				if(matrix[start][i]==0) continue; 
				
				if(!colored[i]){
					p[i]=start;
					if(color==1) DFS(i,2);
					else DFS(i,1);	
				}
				else if(i!=start && colored[i] == colored[start]){ //부모색과 동일하면 안됨. 
						chk=0; return;
				}
			}
		}
		void input(){
			while(1){
				scanf("%d",&n);
				if(n==0) break;
				scanf("%d",&l);
				for(int i=0;i<n;i++) for(int j=0;j<n;j++) matrix[i][j]=0; 
				for(int i=0;i<n;i++) colored[i]=0;
				
				for(int i=0;i<l;i++){
					scanf("%d %d",&a,&b);
					matrix[a][b]=matrix[b][a]=1; //conncted
				}
				chk=1;
				DFS(0,1); //1번색으로 
				if(chk) printf("BICOLORABLE.\n");
				else printf("NOT BICOLORABLE.\n");
			}
		}
};
int main(){
	solution sol;
	sol.input();
}