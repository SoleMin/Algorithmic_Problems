#include <cstdio>
//N일 동안 파업하는 주기가 입력되고, 금,토는 취급하지 않는다.
int main() {
	int t, n, p, h[100];
	int result=0;
	//일1 월2 화3 수4 목5 금6 토7
	//h번째 일에 일을 안함.
	//n%7은 해당 요일.
	scanf("%d",&t);
	while(t>0){
		scanf("%d",&n); //며칠동안?
		scanf("%d",&p); //몇개의 정당이?
		for(int i=0;i<p;i++) scanf("%d",&h[i]); //파업지수를 받는다.
		
		//아무리 생각해도 금토를 구분할 수학적 규칙은 전혀없는데??
		for(int i=1;i<=n;i++){ //1일부터 n일까지.
			if(i%7 == 6 || i%7 == 0) continue; //금토%7=금토니까.
			
			//굳이 배수로 안해줘도 될듯. 멈춰라.
			for(int j=0;j<p;j++) if(i%h[j] == 0){ ++result; break; }
		}
		printf("%d\n",result);
		result=0; --t;
	}
}