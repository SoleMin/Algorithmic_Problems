#include <bits/stdc++.h>
#define MAXMOVE 50 
using namespace std;

class solution{
	int n, num;
	int puzzle[4][4];
	char direction[4]={'U','R','D','L'}; //상하좌우.
	int move[4][2]={{-1,0}, {0,1}, {1,0}, {0,-1}}; //URDL
	int mlen, result[MAXMOVE];
	int h, solved;
	int MAXDEPTH;
	
	public:
		void back(int a, int x, int y){
			int nx, ny;
			
			h=cost(); //계속 h(n)을 계산 
			if(h==0){ //애초에 정렬된 경우만. 즉 빈칸이 옮겨지면서 결국 여기 들어와야함. 
				solved=1; return;
			}
			if(a+h > MAXDEPTH) return; //f(n)=g(n)+h(n)
			
			for(int i=0;i<4;i++){
				if(mlen>0 && (result[mlen-1]+2)%4 == i) continue; //UD, LR
				nx=x+move[i][0]; //i방향으로 이동해본다. 
				ny=y+move[i][1];
				if(nx<0 || nx>3 || ny<0 || ny>3) continue; //빈칸이 이상한데로 못가게.
				
				swap(puzzle[x][y],puzzle[nx][ny]); //반면 갈수 있으면 일단 간다. 이때 밀면서 바꿔치는 개념. 
				result[mlen++]=i; //따라서 거기로 갔다고 생각하고 옮겨본다. 
				
				back(a+1, nx, ny); //깊이를 1증가시키고 nx,ny가 빈칸지점이라 가정하고 다시 이동해본다. 
				if(solved) return;
				mlen--; //solved가 아니면 다시 뒤로 간다.
				swap(puzzle[nx][ny],puzzle[x][y]); //아까 했던 작업을 반복한다. 
			}
		}
		
		void solvable(){
			int invc=0;
			int x,y,l;
			for(int i=0;i<4;i++){
				for(int j=0;j<4;j++){
					if(puzzle[i][j] == 0){ //빈칸 
						invc+=i; x=i, y=j; //빈칸의 정보 저장 
					}
					for(int k=i;k<4;k++){ //전도수 확인 
						if(k==i) l=j+1;
						else l=0;
						for(;l<4;l++)
							if(puzzle[k][l]!=0 && puzzle[i][j] > puzzle[k][l]) ++invc;
							
					}
				}				
			}
			if(invc%2 == 0) return;
			for(MAXDEPTH=cost(); !solved && MAXDEPTH<=MAXMOVE; MAXDEPTH+=2) back(0,x,y);
		}
		
		int cost(){
			int distr=0, distc=0;
			for(int i=0;i<4;i++) //원래위치 
				for(int j=0;j<4;j++)
					if(puzzle[i][j]!=0){
						distr+=abs(i-((puzzle[i][j]-1)/4)); //원래행-현재행
						distc+=abs(j-((puzzle[i][j]-1)%4)); //원래열-현재열
					}
			return distr+distc; //h(n)
		}
		
		void input(){
			scanf("%d",&n);
			while(n--){
				solved=mlen=0;
				for(int i=0;i<4;i++) for(int j=0;j<4;j++) scanf("%d",&puzzle[i][j]);
				solvable();

				if(solved==0) printf("This puzzle is not solvable.");
				else
					for(int i=0;i<mlen;i++) printf("%c",direction[result[i]]);
				printf("\n");
			}
		}
};
int main() {
	solution sol;
	sol.input();
}