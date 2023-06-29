#include <iostream>

using namespace std;

int n, k, solution_count;

void construct_candidates(int a[], int diag, int c[], int *ncandidates){
	bool legal_move;
	int j, square = diag;
	*ncandidates = 0;
	if(diag>n)
		square = 2*n-diag;
	for (int i=0; i<=square; i++) {
		legal_move = true;
		if(diag%2)
			j = 1;
		else
			j = 2;
		for (; j<diag && i!=0; j=j+2) {
			if(a[j] == 0)
				continue;
			if(j>=n){
				if((diag-j)/2 == a[j]-i)
					legal_move = false;
			}
			else if(diag<=n){
				if((diag-j)/2 == i-a[j])
					legal_move = false;
			}
			else{
				if(2*n-diag > j){
					if((2*n-diag-j)/2 == i-a[j])
						legal_move = false;
				}
				else{
					if((j-(2*n-diag))/2 == a[j]-i)
						legal_move = false;
				}
			}
		}
		if (legal_move == true) {
			c[*ncandidates] = i;
			*ncandidates = *ncandidates + 1;
		}
	}
}

void process_solution(int j){
	if(j == k)
		solution_count++;
}

bool is_a_solution(int diag, int j){
	return (j == k || diag == 2*n-1);
}


void backtrack(int a[], int diag, int j)
{
	int c[2*n];
	int ncandidates;
	bool check = true;
	if (is_a_solution(diag,j))
		process_solution(j);
	else {
		diag++;
		construct_candidates(a,diag,c,&ncandidates);
		for (int i=0; i<ncandidates; i++) {
			a[diag] = c[i];
			if(a[diag] != 0 && check){
				j++;
				check = false;
			}
			backtrack(a,diag,j);
		}
	}
}

void nbishops(int N){
	int a[2*N];
	solution_count = 0;
	backtrack(a,0,0);
	cout << solution_count << endl;
}

int main() {
	while(cin >> n >> k){
		if(n == 0 && k == 0)
			break;
		nbishops(n);
	}
	
	return 0;
}