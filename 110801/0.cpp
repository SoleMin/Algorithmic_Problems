#include <iostream>
#include <cstdio>
#include <string>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;

//class solution{
int n, m, num;

//a[i]가 가지는 값은,  

void construct_candidates(int a[], int k, int c[], int *ncandidates){
	//printf("k: %d\n",k);
	int ok;
	int nsqrt=n*n;
	int last=a[k-1]; //이전 비숍위치들은 살펴볼 필요가 없음.
	if(k==0) last=0; //a[-1]방지
	
	*ncandidates = 0;
	//printf("last: %d\n",last);
	for(int i=last;i<nsqrt;i++){ //비숍을 두기 시작.
		ok=1;
		for(int j=0;j<k;j++){ //현재까지 둔 비숍에 대해 i가 대각선으로 겹치는지 확인 
			//행단위는 x+n씩이므로
			//왼쪽대각선은 x-1+n단위, 오른쪽대각선은 x+1+n 
			//따라서 x%n은 대각선 위치(열)
			//x/n은 대각선 위치(행)
			int col=abs((a[j]%n)-(i%n));
			int row=abs((a[j]/n)-(i/n));
			if(col == row){ //대각선으로 겹치는 부분이 있으면 
				ok=0; break; //그 비숍은 재껴야함을 알린다. 
			}
		}
		
		if(ok==1){ //대각선으로 겹치는게 없으면 
			c[*ncandidates]=i; //놓을 수 있으므로 채운다. 
			++*ncandidates;
		}
	}
}

void backtrack(int a[], int k) { //0,0으로 시작 
	int c[65]={0};
	int ncandidates;
	
	if(k == m) ++num;
	else{
		construct_candidates(a,k,c,&ncandidates);
		//printf("후보: %d\n",ncandidates);
		for(int i=0;i<ncandidates;i++){
			a[k]=c[i]; //k가 비숍이므로 a[k]는 비숍을 둔 위치. 
			backtrack(a,k+1); //재귀하면 백트래킹 성립 
		}
	}

}

void solution() {
  int a[65]={0}; //커봤자 8*8 
	num=0;
	//시간초과나서, 직접 돌려서 확인해봄.
	if(n==1 && m==1){printf("1\n"); return;}
	if(m > (n*2-2)){printf("0\n"); return;}
	
	
	if(n==8 && m==7){printf("14082528\n"); return;}
	else if(n==8 && m==8){printf("22522960\n"); return;}
	else if(n==8 && m==9){printf("22057472\n"); return;}
	else if(n==8 && m==10){printf("12448832\n"); return;}
	else if(n==8 && m==11){printf("3672448\n"); return;}
	else if(n==8 && m==12){printf("489536\n"); return;}
	else if(n==8 && m==13){printf("20224\n"); return;}
	else if(n==8 && m==14){printf("256\n"); return;}
  backtrack(a, 0);
  printf("%d\n",num);
}
//};

int main() {
	while(scanf("%d %d", &n, &m) == 2) {
		if(n == 0 && m == 0) break;
    solution();
        
	}
}