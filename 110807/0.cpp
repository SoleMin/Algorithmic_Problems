#include <bits/stdc++.h>
#define MAXDEPTH 16
using namespace std;

class solution{
	int fragmove[11][11]={{0, 1, 1, 0, 1, 2, 3, 2, 3, 3, 3}, {1, 2, 2, 0, 0, 1, 2, 3, 4, 4, 4},
						{0, 2, 3, 1, 1, 0, 1, 4, 5, 3, 5}, {1, 1, 2, 2, 2, 0, 0, 3, 4, 2, 4},
						{0, 0, 1, 2, 3, 1, 1, 2, 3, 1, 3}, {1, 0, 0, 1, 2, 2, 2, 1, 2, 2, 2},
						{0, 1, 1, 2, 3, 3, 3, 0, 1, 2, 3}, {1, 2, 2, 3, 4, 4, 4, 0, 0, 1, 2},
						{0, 2, 3, 4, 5, 3, 5, 1, 1, 0, 1}, {1, 1, 2, 3, 4, 2, 4, 2, 2, 0, 0},
						{0, 0, 1, 2, 3, 1, 3, 2, 3, 1, 1}}; //조각의 최소움직임 
	int final[24] = { 0, 3, 4, 3, 0, 5, 6, 5, 0, 1, 2, 1, 0, 7, 8, 7, 0, 9, 10, 9, 0, 1, 2, 1 };
	int state[24], point[2]={0,12}, count[2]={0};
	int stack[MAXDEPTH], result[MAXDEPTH], rn, solveable;
	int n;
	public:
		int left(int base, int offset){ //왼쪽 해쉬의 위치를 반환해줌 
			if(base<12){ 
				base+=offset;
				if(base>=12) base-=12;
			}
			else{ 
				base+=offset;
				if(base>=24) base-=12;
			}
			return base;
		}
		int right(int base, int offset){ //오른쪽 해쉬의 위치를 반환해줌 
			if(base<12){ 
				base-=offset;
				if(base<0) base+=12;
			}
			else{ 
				base-=offset;
				if(base<12) base+=12;
			}
			return base;
		}
		
		void back(int a){
			int same=1;
			if(a == rn) return;
			for(int i=0;i<12 && same;i++){ //상태검사. 
				if(state[left(point[0],i)] != final[i]) same=0;
				if(state[left(point[1],i)] != final[i+12]) same=0;
			}
			
			if(same){ //일치하면 
				for(int i=0;i<a;i++) result[i]=stack[i];
				rn=a; solveable=1; 
				return;
			}
			 
			int minmove=0, tmp1, tmp2;
			for(int i=0;i<21;i++){
				tmp1=state[left(point[i/12], i%12)]; //현재 조각의 위치를 하나씩 갖고온다. 
				if(minmove < fragmove[i/2][tmp1]) minmove=fragmove[i/2][tmp1]; //최소한 움직여야 하는 수. 
			}
			
			if(a==MAXDEPTH || a+minmove>MAXDEPTH || a+minmove>=rn) return; //a는 깊이, rn은 깊이의 단계 
			
			for(int i=1;i<=4;i++){
				if(a>=rn-1) break;
				stack[a]=i;	//stack[a]에 회전한 정보를 기록. 
				switch(i){
					//point를 옮기도록 한다. 왼쪽은 point[0]이, 오른쪽은 point[1]이 담당.
					//count를 기록한다. 왼쪽회전은 count[0]이, 오른쪽은 count[1]이 담당. 
					case 1: //왼쪽바퀴 정방향  (right)
						//정방향=감소, 역방향=증가 
						if(count[0]>0 || count[0]==-5) break; //반대방향으로 돌린적 있으면 제자리로 오지 말것. 
						point[0] = right(point[0], 2); //point[0]을 시계방향으로 한번 돌림. 
						for (int i=1;i<=3;i++) state[right(point[1],i)]=state[right(point[0],i)]; //오른쪽도 가운데는 공유함. 
						tmp1=count[0]; tmp2=count[1];
						count[0]--; //시계방향 갔음 
						count[1]=0; //오른쪽 해쉬. 
						back(a+1); //깊이증가 
						//여기로 왔다는건 실패했다는 것. 
						count[0]=tmp1; count[1] = tmp2; //이전 값으로 돌아옴 
						point[0]=left(point[0], 2); //돌렸던 시계방향도 다시 돌아옴 
						for (int i=1;i<=3;i++) state[right(point[1], i)]=state[right(point[0], i)]; //오른쪽도 마찬가지. 
						break;
					case 2: //그럼 2는 오른쪽바퀴 정방향(left) 
						//오른쪽은 반대방향으로 돌아감. 
						//정방향=감소, 역방향=증가 
						if(count[1]<0 || count[1]==5) break; //오른쪽해쉬는 역방향으로 돈다. 
						point[1] = left(point[1], 2); //point[1]을 
						for (int i=1;i<=3;i++) state[right(point[0], i)]=state[right(point[1], i)];
						tmp1=count[0]; tmp2=count[1];
						count[0]=0;
						count[1]++; //
						back(a+1);
						count[0]=tmp1; count[1]=tmp2;
						point[1]=right(point[1], 2); //되돌림 
						for (int i=1;i<=3;i++) state[right(point[0], i)]=state[right(point[1], i)];
						break;
					case 3: //왼쪽 역방향(left)
						if(count[0]<0 || count[0]==5) break; //반대방향으로 돌린적 있으면 제자리로 오지 말것. 
						point[0] = left(point[0], 2); //point[0]을 시계방향으로 한번 돌림. 
						for (int i=1;i<=3;i++) state[right(point[1],i)]=state[right(point[0],i)]; //오른쪽도 가운데는 공유함. 
						tmp1=count[0]; tmp2=count[1];
						count[0]++; //왼쪽으로 돌아가니까 값이 증가할것이다. 
						count[1]=0; //오른쪽 해쉬. 
						back(a+1); //깊이증가 
						//여기로 왔다는건 실패했다는 것. 
						count[0]=tmp1; count[1]=tmp2; //이전 값으로 돌아옴 
						point[0]=right(point[0], 2); //돌렸던 시계방향도 다시 돌아옴 
						for (int i=1;i<=3;i++) state[right(point[1], i)]=state[right(point[0], i)]; //오른쪽도 마찬가지. 
						break;
					case 4: //오른쪽 역방향(right)
						if(count[1]>0 || count[1]==-5) break; //오른쪽해쉬는 역방향으로 돈다. 
						point[1] = right(point[1], 2); //point[1]을 
						for (int i=1;i<=3;i++) state[right(point[0], i)]=state[right(point[1], i)];
						tmp1=count[0]; tmp2=count[1];
						count[0]=0;
						count[1]--;
						back(a+1);
						count[0]=tmp1; count[1]=tmp2;
						point[1]=left(point[1], 2); //되돌림 
						for (int i=1;i<=3;i++) state[right(point[0], i)]=state[right(point[1], i)];
						break;
				}
			}
		}
		
		void input(){
			scanf("%d",&n);
			while(n--){
				for(int i=0;i<24;i++) scanf("%d",&state[i]); //조각의 상태를 받는다. 
				rn=MAXDEPTH+1;
				solveable=0;
				back(0);
				
				if(solveable){
					if(rn == 0) printf("PUZZLE ALREADY SOLVED\n");
					else{
						for(int i=0;i<rn;i++) printf("%d",result[i]);
						printf("\n");
					}
				}
				else printf("NO SOLUTION WAS FOUND IN %d STEPS\n",MAXDEPTH);
			}
		}
};

int main(){
	solution sol;
	sol.input();
}