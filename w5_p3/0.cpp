#include <iostream>
#include <cstdio>
#include <cstring>
#include <string>
#include <sstream>
#include <vector>
using namespace std;
/*
	T에서 P가 몇번 나오는지 출력하고,
	P가 나타난 첫 위치를 출력해라.
	1. KMP vs Boyer moore
	2. T, P의 최대길이는 100만.
	3. 최악의 경우 효율이 안좋으므로 KMP로.
*/
class solution{
	string txt, p; int tlen, plen;
	
	int times; vector<int> pos;
	int idx;
	public:
	
	//table 채운 방식과 똑같은 원리로 진행하면 된다.
	void KMP(vector<int> table){
		int idx=0; times=0; //이번엔 txt와 p의 비교.
		for(int i=0;i<tlen;i++){
			while(txt[i] != p[idx]){ //i에 따라 idx도 상승시킬거니까.
				if(idx==0) break;
				idx=table[idx-1]; 
			}
			
			if(txt[i] == p[idx]){ //둘의 끝이 같으면,
				if(idx == plen-1){ //근데 아예 단어 자체가 일치하면
					pos.push_back(i-plen+1); ++times; //해당 위치를 저장, 횟수도 저장.
					//idx=0; //idx를 다시 초기화.
					idx=table[idx];
				}
				else ++idx; //틀린거 나올때까지 넘김.
			}
		}
	}

	void input(){
		getline(cin,txt); tlen=txt.length();
		getline(cin,p); plen=p.length();
		
		vector<int> table(plen,0); //접두사=접미사 인 위치를 기록
		/*
			일치하는 부분의 맨 마지막이 max라고 했을떄,
			p[max]부터 거꾸로 가면서 세워지는 접미사가,
			p[0=k]부터 올라오면서 세워지는 접두사와 어디까지 일치하는지 알면 거기까지만 점프할 수 있다.

			여기서 기준을 max를 내릴것이냐, k를 올릴것이냐로 달라질 것 같음.
			그런데 우리는 max-1의 결과를 알고있는 식으로 진행하므로 굳이 max를 움직일 필요가 없다.
			그럼 max는 접미사의 끝이므로 k도 똑같이 계속 올려서 접두사의 끝을 가리켰으면 좋겠다.
			따라서 max와 k 둘의 값이 다르면, k를 뒤로 뺀다.
			그래서 max != k일때까지 k-1을 해준다.
			그런데 어차피 table[k-1]까지는 몇 글자까지가 똑같은지 알기떄문에... k=table[k-1]? 처럼 해보고
			
		*/
		int k=0; //올라올 놈
		int result;
		for(int max=1;max<plen;max++){ //max는 내려올놈.
			//if(p.substr(0,max) == p.substr(plen-max,max)) table[plen-max]=max;
			//substr는 O(n) 이라고 함.
			
			while(p[max] != p[k]){ //다르면 같은 지점까지
				if(k==0) break; //k-1 런타임 에러
				k=table[k-1]; //k를 뒤로, 공통된 한계점까지 뺀다는 개념.
				//result=table[k-1];
			}
			
			if(p[max] == p[k]){ //둘이 글자가 같으면 == 접미사와 접두사의 끝이 같음.
				table[max]=k+1; //실제로 k+1만큼의 길이를 가지겠지. max는 계속 상승
				++k; //k값도 같이 올림.
			}
		}
		
		KMP(table);
		
		printf("%d\n",times);
		for(auto it: pos) printf("%d ",it+1); //출력은 인덱스+1
	}
};
int main() {
	solution solv;
	solv.input();
}