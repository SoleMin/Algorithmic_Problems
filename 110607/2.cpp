#include <iostream>
#include <cstdlib>
#include <cstring>

using namespace std;

static int ans[2][1000000];
static int idx, n, pre_idx;
//인덱스 값이 2000000000까지 가기 때문에 ans[0][f(n)]에 시작인덱스, ans[1][f(n)]에 끝 인덱스를 넣음
void solve(){
	int pre = 2;
	for(;idx<=2000000000;){
		ans[0][n] = idx;
		ans[1][n] = idx+pre-1;
		idx = idx+pre;
		n++;
		pre_idx=n;
		for(int i=1;i<=n;i++){
			if((pre_idx>=ans[0][i])&&(pre_idx<=ans[1][i])){
				pre = i;
				break;
			}
		}
	}
}

void print(int num){
	for(int i;i<=1000000;i++){
		if((num>=ans[0][i])&&(num<=ans[1][i])){
			cout << i << endl;
			return;
		}
	}
}

int main() {
	int num;
	ans[0][1] = 1;
	ans[1][1] = 1;
	ans[0][2] = 2;
	ans[1][2] = 3;
	n=3;
	idx = 4;
	pre_idx = 3;
	solve();	
	for(;(cin>>num)&&(num!=0);){		
		print(num);
	}
	
	return 0;
}