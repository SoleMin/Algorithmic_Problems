#include <iostream>
#include <cstdio>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;
/*
	1 2 5 10
	(1,2) 보냄(2) + 왕복(1) = 3
	(5,10) 보냄(10) + 왕복(2) = 12 (2가 도착지에 있기 때문에.)
	(1,2) 보냄(2) = 2
	따라서 3+12+2=17.

	출발지의 가장 작은 사람을 보내면 되고, 도착지의 가장 작은 사람을 보내는 식으로.
    이때 2명씩 짝을 지어야하니까, (최소1, 최소2) -> 최소1 -> (최대1, 최대2) -> 최소2 -> (최소1,최소2) -> ... 반복?
    
    홀수개면?
    1 2 5 10 13
	(1,2) 보냄(2) + 왕복(1) = 3
	(10,13) 보냄(13) + 왕복(2) = 15
	(1,2) 보냄(2) + 왕복(1) = 3
	(1,5) 보냄(5) = 5
	따라서 3+15+3+5=26
*/

//printf("%d,%d보내고 왕복%d\n",min1,min2,min1);
//printf("%d,%d보내고 왕복%d\n",pep[len-2],pep[len-1],min2);
class solution{
	int min1, min2, max, test1, test2, time;
	int len,n;
	string Case;
	
	public:
		int calcul(vector<int> pep){
			test1=test2=0;
			if(len%2 == 0){
				while(len>2){
					test1+=(min2+min1); //(최소1, 최소2) -> 최소1 ->
					test1+=(pep[len-1]+min2); //(최대1, 최대2) -> 최소2 ->

					test2+=(pep[len-1]+min1); //min1, min2중 값이 중복되는게 있을 경우 이쪽이 더 효율적임.
					test2+=(pep[len-2]+min1);
					
					if(test1 < test2) time+=test1;
					else time+=test2;
					test1=test2=0;
					len=len-2;
				}
				//여기서 len=2 즉 편도만 하면 됨.
				time+=min2;
			}
			else{
				while(len>3){
					test1+=(min2+min1); //(최소1, 최소2) -> 최소1 ->
					test1+=(pep[len-1]+min2); //(최대1, 최대2) -> 최소2 ->

					test2+=(pep[len-1]+min1);
					test2+=(pep[len-2]+min1);

					if(test1 < test2) time+=test1;
					else time+=test2;
					test1=test2=0;
					len=len-2;
				}
				//여기서 len=3 즉...
				time+=(min2+min1);
				time+=(pep[2]);
			}
			return time;
		}
		
		void solv(){
			getline(cin,Case);
			time=0;
			scanf(" %d",&n); vector<int> pep(n,0);
			for(int i=0;i<n;i++) scanf("%d",&pep[i]);
			stable_sort(pep.begin(), pep.end());

			min1=pep[0]; min2=pep[1];
			len=pep.size();
			//값이 중복되는 경우엔 효율이 떨어짐...
			if(len==3) time+=(min2+min1+pep[2]);
			else if(len==2) time+=min2;
			else if(len==1) time+=min1;
			else time=calcul(pep);

			printf("%d\n",time); printf("\n");
			pep.clear();
		}
};

int main(){
	int t;
	solution a;
	
	scanf("%d",&t);
	while(t--){
		a.solv();
	}
}