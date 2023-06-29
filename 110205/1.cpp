#include <cstdio>
#include <cstring>
#include <cstdlib>
#include <iostream>
#define SWAP(a,b,tmp) ((tmp)=(a), (a)=(b), (b)=(tmp))
using namespace std;
/*
	문제가 설명을 너무너무너무 못하는데, 쉽게 말해서
	n개의 케이스가 주어지는데, 각 케이스는 1~52까지의 숫자가 섞여있을 것이다.
	이는 바꿔치기를 썼기 때문이다. 즉 각 케이스는 몇 번째 것과 바꿔치기했는지 보여주는 것이다.
	그리고 이중에서 어떤 바꿔치기 스타일을 사용할건지 선택한다.
	그다음 해당 스타일의 바꿔치기를 순서대로 실행하면 된다. 그러니까 결과가 계속 갱신되겠지.
	그러고나서 그 덱을 출력하면 된다.
	
	이때 1~52까지의 값은 숫자는 2~10,J,Q,K,A 순, 알파벳은 Clubs, Diamonds, Hearts, Spades 순으로 해서 번호가 매치된다.
	알파벳 우선순위가 더 크므로. 알파벳 하나당 2~10,J,Q,K,A 순으로 총 4짝이 있다고 생각하자. 13*4가 되겠지.
*/
class Decks{
	private:
		int cased[53]; //케이스용 덱
		int saved[53];
	public:
		void setting(){
			for(int i=1;i<=52;i++){
				scanf("%d",&cased[i]);
				saved[i]=cased[i];
			}
		}
	
		void shuffle(int result[]){
			
			for(int i=1;i<=52;i++){
				saved[i]=result[i];
			}
			for(int i=1;i<=52;i++) result[i]=saved[cased[i]];
		}
	
};
int main(){
	int t, n, tmp;
	int result[53]={0};
	char k[101];
	Decks deck[101];
	
	scanf("%d",&t);
	while(fgets(k,101,stdin) != NULL)
			if(k[0] == '\n') break;
	
	while(t>0){
		for(int i=1;i<=52;i++) result[i]=i;
		scanf("%d",&n);
		for(int i=0;i<n;i++) deck[i].setting();
		while(getchar()!='\n');
		while(!cin.eof()){
			cin.getline(k,101);
			if(k[0] == '\0') break;
			tmp=atoi(k);
			deck[tmp-1].shuffle(result); //입력 계속받으면서 셔플.
		}
		
		//13으로 나눴을 때, 0이면 C, 1이면 D, 2면 H, 3이면 S.
		//숫자값 자체는 11, 12, 13, 14, 15
		for(int i=1;i<=52;i++){
			switch((result[i]-1)%13){
				case 9: printf("Jack "); break;
				case 10: printf("Queen "); break;
				case 11: printf("King "); break;
				case 12: printf("Ace "); break;
				default: printf("%d ",((result[i]-1)%13+2)); break;
			}
			
			printf("of ");
			
			switch((result[i]-1)/13){
				case 0: printf("Clubs\n"); break;
				case 1: printf("Diamonds\n"); break;
				case 2: printf("Hearts\n"); break;
				case 3: printf("Spades\n"); break;
			}
		}
		if(t-1 != 0) printf("\n");
		--t;
	} //while end
}