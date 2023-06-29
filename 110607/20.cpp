# include <iostream>
# include <vector>

using namespace std;



int main() {
	
	while(true){
		int n;
		vector<int> fn;
		
		cin >> n;
		if(n == 0){
			break;
		}
		
		/*
			f(n)의 size가 n이 되는순간 답 도출 가능
			n을 1씩 증가 => f(n)을 참조 => f(n)만큼 n을 벡터에 추가 => 벡터 사이즈가 입력값에 도달하면 출력
			근데 1하고 2는 자연스럽게 처리가 안되네
			초기값 1, 2, 2는 넣고 시작해야하나?
		*/
		fn.push_back(1);
		fn.push_back(2);
		fn.push_back(2);
		
		int k = 3;
		while(fn.size() != n){
			for(int i = 0; i < fn[k-1]; i++){
				fn.push_back(k);
				if(fn.size() == n){
					break;
				}
			}
			k++;
		}
		
		cout << fn[n - 1] << endl;
		
		
	}
	
	return 0;
}