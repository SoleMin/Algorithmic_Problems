#include <iostream>
using namespace std;

int remainto[11][11] = { {0, 1, 1, 0, 1, 2, 3, 2, 3, 3, 3},
						 {1, 2, 2, 0, 0, 1, 2, 3, 4, 4, 4},
						 {0, 2, 3, 1, 1, 0, 1, 4, 5, 3, 5},
						 {1, 1, 2, 2, 2, 0, 0, 3, 4, 2, 4},
						 {0, 0, 1, 2, 3, 1, 1, 2, 3, 1, 3},
						 {1, 0, 0, 1, 2, 2, 2, 1, 2, 2, 2},
						 {0, 1, 1, 2, 3, 3, 3, 0, 1, 2, 3},
						 {1, 2, 2, 3, 4, 4, 4, 0, 0, 1, 2},
						 {0, 2, 3, 4, 5, 3, 5, 1, 1, 0, 1},
						 {1, 1, 2, 3, 4, 2, 4, 2, 2, 0, 0},
						 {0, 0, 1, 2, 3, 1, 3, 2, 3, 1, 1} };
int final_result [24] = {0, 3, 4, 3, 0, 5, 6, 5, 0, 1, 2, 1, 0, 7, 8, 7, 0, 9, 10, 9, 0, 1, 2, 1};
int arr[24], p[2], count[2], stack[16], result[16], rn, s_bool;

int left(int b, int off) {
	if(b < 12) {
		b += off;
		if(b >= 12) b -= 12;
	} else {
		b += off;
		if(b >= 24) b -= 12;
	}
	return b;
}

int right(int b, int off) {
	if(b < 12) {
		b -= off;
		if(b < 0) b += 12;
	} else {
		b -= off;
		if(b < 12) b += 12;
	}
	return b;
}

void back(int x) {
	int t1, t2, same, minmove;
	
	if(x == rn) return;
	
	same = 1;
	for(int i = 0; i < 12 && same; i++) {
		if(arr[left(p[0], i)] != final_result[i]) same = 0;
	}
	for(int i = 0; i < 12 && same; i++) {
		if(arr[left(p[1], i)] != final_result[i+12]) same = 0;
	}
	
	if(same) {
		for(int i = 0; i < x; i++) {
			result[i] = stack[i];
		}
		rn = x;
		s_bool = 1;
		return;
	}
	
	minmove = 0;
	for(int i = 0; i < 21; i++) {
		t1 = arr[left(p[i/12], i % 12)];
		
		if(minmove < remainto[i/2][t1])
			minmove = remainto[i/2][t1];
	}
	
	if(x == 16 || x + minmove > 16 || x + minmove >= rn) return;
	
	for(int i = 1; i <= 4; i++) {
		if(x >= rn - 1) break;
		
		stack[x] = i;
		switch(i) {
			case 1:
				if(count[0] > 0 || count[0] == -5) break;
				
				p[0] = right(p[0], 2);
				for(int j = 1; j <= 3; j++)
					arr[right(p[1], j)] = arr[right(p[0], j)];
				
				t1 = count[0];
				t2 = count[1];
				count[0]--;
				count[1] = 0;
				
				back(x+1);
				
				count[0] = t1;
				count[1] = t2;
				
				p[0] = left(p[0], 2);
				for(int j = 1; j <= 3; j++)
					arr[right(p[1], j)] = arr[right(p[0], j)];
				break;
				
			case 2:
				if(count[1] < 0 || count[1] == 5) break;
				
				p[1] = left(p[1], 2);
				for(int j = 1; j <= 3; j++)
					arr[right(p[0], j)] = arr[right(p[1], j)];
				
				t1 = count[0];
				t2 = count[1];
				count[0] = 0;
				count[1]++;
				
				back(x+1);
				
				count[0] = t1;
				count[1] = t2;
				
				p[1] = right(p[1], 2);
				for(int j = 1; j <= 3; j++)
					arr[right(p[0], j)] = arr[right(p[1], j)];
				break;
				
			case 3:
				if(count[0] < 0 || count[0] == 5) break;
				
				p[0] = left(p[0], 2);
				for(int j = 1; j <= 3; j++)
					arr[right(p[1], j)] = arr[right(p[0], j)];
				
				t1 = count[0];
				t2 = count[1];
				count[0]++;
				count[1] = 0;
				
				back(x+1);
				
				count[0] = t1;
				count[1] = t2;
				
				p[0] = right(p[0], 2);
				for(int j = 1; j <= 3; j++)
					arr[right(p[1], j)] = arr[right(p[0], j)];
				break;
				
			case 4:
				if(count[1] > 0 || count[1] == -5) break;
				
				p[1] = right(p[1], 2);
				for(int j = 1; j <= 3; j++)
					arr[right(p[0], j)] = arr[right(p[1], j)];
				
				t1 = count[0];
				t2 = count[1];
				count[0] = 0;
				count[1]--;
				
				back(x+1);
				
				count[0] = t1;
				count[1] = t2;
				
				p[1] = left(p[1], 2);
				for(int j = 1; j <= 3; j++)
					arr[right(p[0], j)] = arr[right(p[1], j)];
				break;
		}
	}
}


int main() {
	
	int i = 0;
	int num;
	cin >> num;
	
	while(i < num) {
		for(int j = 0; j < 24; j++) {
			cin >> arr[j];
		}
		
		count[0] = count[1] = 0;
		p[0] = 0;
		p[1] = 12;
		rn = 17;
		s_bool = 0;
		back(0);

		if(s_bool) {
			if (rn == 0) cout << "PUZZLE ALREADY SOLVED" << endl;
			else {
				for(int j = 0; j < rn; j++) {
					cout << result[j];
				}
				cout << endl;
			}
		} else cout << "NO SOLUTION WAS FOUND IN 16 STEPS" << endl;
		
		i++;
	}
	return 0;
}