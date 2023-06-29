#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

int solution_count;
bool finished = false;
bool cc[16] = {0, };

// 조합 ㅌㅍㄹ
template<typename Container_, typename value_type = typename Container_::value_type>
	std::vector<std::vector<value_type> > Combination(Container_ container, int r) {
	int n = container.size();
	if (n < r) return {};
	if (r < 0) return {};
 
	std::vector<std::vector<value_type> >totVec;
	std::vector<value_type> tempVec(r);
 
	std::vector<bool> v(n);
	std::fill(v.end() - r, v.end(), true);
	int idx;
	do {
			idx = 0;
			for (int i = 0; i < n; ++i) {
				if (v[i]) {
					tempVec[idx++] = *(container.begin() + i);
				}
			}
			totVec.push_back(tempVec);
	} while (std::next_permutation(v.begin(), v.end()));
 
	return totVec;
}

//백트래킹 코드
void construct_candidates(int a[], int k, int n, int *line, int c[], int *ncandidates){
	int i, j, tmp;
	bool legal_move;
	*ncandidates = 0;
	tmp = *line-n;
	for(i=1+abs(tmp);i<=(2*n-1)-abs(tmp);i+=2){
		legal_move = true;
		for(j=1+abs(n-i);(j<*line)&&(j<=(2*n));j+=2){
			if(i == a[j]){
				legal_move = false;
			}
		}
		if(legal_move == true){
			c[*ncandidates] = i;
			*ncandidates = *ncandidates + 1;
		}
	}
}
void process_solution(int a[], int k){
	solution_count++;
}
bool is_a_solution(int a[], int k, int n){
	return (k==n);
}
void backtrack(int a[], int k, int n, int l, int line, vector<int> intVec){
	int c[2*n];
	int ncandidate;
	if(is_a_solution(a, k, l)){
		process_solution(a, k);
	}
	else{
		line=intVec[k];
		k=k+1;
		construct_candidates(a, k, n, &line, c, &ncandidate);
		for(int i=0;i<ncandidate;i++){
			a[line] = c[i];
			backtrack(a, k, n, l, line, intVec);
			if(finished) return;
		}
	}
}
void nbishops(int n, int l){
	int a[20] = {99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99};
	vector<int> intVec;
	
	for(int i=1;i<=(2*n-1);i++){
		intVec.push_back(i);
	}
	solution_count = 0;

	for(auto& vec : Combination(intVec, l)) {
		for(int i = 0;i<(2*n-1);i++)
		a[i] = 99;
		backtrack(a, 0, n, l, 0, vec);
	}
	
	cout << solution_count << endl;
}

// 8부터 시간초과 걸려서;; 수식으로 했습니다.
int not_backtracking_sorry(int n, int l, vector<int> vec){
	int a[16];
	vector<int> tmp;
	int ans = 1;
	int holcount = 0, jjakcount = 0;
	int line;
	for(int i=1, j = -(n-1); i<(2*n);i++, j++)
		a[i] = n - abs(j);
	for(int i=0;i<l;i++){
		tmp.push_back(a[vec[i]]);
	}
	sort(tmp.begin(), tmp.end());
	for(int i=0;i<l;i++){
		line = tmp[i];
		if((line%2) != 0){
			if(line-holcount > 0){
				ans *= (line-holcount);
				holcount++;
			}
			else
				return 0;
		}
		else{
			if(line-jjakcount > 0){
				ans *= (line-jjakcount);
				jjakcount++;
			}
			else
				return 0;
		}
	}
	return ans;
}

void nbishops2(int n, int l){
	vector<int> intVec;
	int ans;
	for(int i=1;i<=(2*n-1);i++){
		intVec.push_back(i);
	}
	ans = 0;
	for(auto& vec : Combination(intVec, l)) {
		ans += not_backtracking_sorry(n, l, vec);
	}
	
	cout << ans << endl;
}


int main() {
	int x, y;
	
	for(;(cin>>x>>y)&&(x!=0 || y!=0);){
		if(x!=8)
			nbishops(x, y);
		else{
			nbishops2(x, y);
		}	
	}
	
	return 0;
}