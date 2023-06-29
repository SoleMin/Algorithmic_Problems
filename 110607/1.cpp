#include <iostream>
#include <cstdio>
#include <string>
#include <vector>
#include <sstream>
using namespace std;
/*

	1, (2,2), (3,3), (4,4,4), (5,5,5), (6,6,6)?
	f(6)=4
	f(7)=4
	f(8)=4
	f(f(6,7,8)) = f(4) = 3
	f(n+f(n))+1
	f(4+3)=f(7)+1=5
	6,7,8...차이
	f(n-f(n))=f(6-3)=f(3)+1=3...
	f(n+f(n) - n-f(n))=f(7 - 3)= f(4)+1=4


	f(f(12))=f(6)=4 f(6+4)+1=6
	f(n+f(n))+1=6

	f(n+f(n)=12+f(6)=12+4=16    n-f(n)=12-4=8)=f(8)+2=6.
	f(n+f(n-1))=f(6+f(5))=f(6+3)=f(9)=5
	f(n-f(n-1))=f(6-f(5))=f(6-3)=f(3)=2

	f(f(f(n)))=f(f(f(6)))=f(f(4))=f(3)=2
	f(n-f(n))=f(6-f(6))=f(6-4)=f(2)
	f(n-f(f(n)))=f(6-f(4))=f(6-3)=f(3)=2
	f(n-f(f(n-1)))=f(6-f(f(5)))=f(6-f(3))=f(6-2)=f(4)=3

	f(12-f(f(11)))=f(12-f(5))=f(12-3)=f(9)=5+1=6
	f(2-f(f(1)))=f(2-f(1))=f(2-1)=1+1=2
	f(3-f(f(2)))=f(3-f(2))=f(3-2)=f(1)+1=2

	f(n-f(f(n-1)))+1?


	2147483647
	2000000000
*/
 //1~12 (6,6,6,6) 12 13 14 15
/*
	n=f(n-1)+f(n-2) 인데?
	n+1=f(n)+f(n-1)이네?
	근데 값을 2000000000번 연산해야함. 따라서 의미없다.
	뭔가 여기서 단서를 얻을 수 없을까?
	이전 결과의 덧셈...
	10=f(9)+f(8)=5+4=9 (x)
	
	3=f(2)+f(1)
	f(3)=2
	
	1+2=3
	
	4=f(3)+f(2)=2+2
	f(4)=3
	
	1+2+2=5
	
	5=f(4)+f(3)=3+2
	f(5)=3

	6=f(5)+f(4)=3+3
	f(6)=4
	
	f(1+2+2)=f(5)=3
	1+2+2가 3까지인데
    그럼 f(6)은..
	f(1+2+2+1)..
	
	f(1+2+2+3)=f(8)=4
	이게 4까진데

*/
int result[800000]={0,1,3}; //result[i]까지 i더하는 식?
class solution{
	int before, n;

	public:
		void solv(int n){
			//vector<int> sds={0,1,2,2,3,3,4,4,4,5,5,5,6};
			//for(int i=13;i<=n;i++) sds.push_back(sds[i-sds[sds[i-1]]]+1); //dp는 옳은 방법이 아님.
			//int sds[1000000]={0,1,2,2,3,3,4,4,4,5,5,5,6};
			//1+2=3 f(3)=2 (i=2),
			//f(4)=3
			//1+2+2=5 f(5)=3 (i=3)
			int idx, sum;//f(1+2+2+3)=f(8)=4 이게 4까진데
			int num=2, pidx;
			sum=1; //누적
			
			if(n==1){ printf("1\n"); return; }
			//즉 result[i]는 한계점, i는 값
			//1000000000=430000쯤이니까 최댓값은..
			for(int i=2;i<=2000000000;i++){
				//f(idx)=i; 로 커트라인
				//처음 idx=3 즉 2를 더한다.
				//다음 idx=5 즉 3을 더한다. (4~5)
				//다음 idx=8 즉 4를 더한다. (6~8)
				
				int idx=result[i]-result[i-1]; //2~3
				
				while(idx>0){
					sum+=i; //f(sum)을 넣으려했더니, sum자체가 원하는 값보다 큰 경우
					if(sum>=n){ printf("%d\n",num); return; }
					//printf("result[%d] = %d\n",num,sum);
					result[num++]=sum; //아마 result[3]=2 result[4]=3 순서.. 즉 result[num]=1000000000 같은게 있을듯

					--idx;
				}
				
				/*for(int j=0;j<idx;j++){
					sum+=i;
					if(sum>=n){ printf("%d\n",i); return;}
				}*/
			}

   			
		}

		void input(){
			before=13;
			while(1){
				scanf(" %d",&n);
				if(n == 0) break;
				solv(n);
				//printf("%d\n",sds[n]);
			}
		}
};
int main() {
	solution a;
	a.input();
}