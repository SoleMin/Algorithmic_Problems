#include <iostream>
#define MAXD 16

using namespace std;

int remainto[11][11] = {{0, 1, 1, 0, 1, 2, 3, 2, 3, 3, 3}, {1, 2, 2, 0, 0, 1, 2, 3, 4, 4, 4}, {0, 2, 3, 1, 1, 0, 1, 4, 5, 3, 5}, {1, 1, 2, 2, 2, 0, 0, 3, 4, 2, 4}, {0, 0, 1, 2, 3, 1, 1, 2, 3, 1, 3}, {1, 0, 0, 1, 2, 2, 2, 1, 2, 2, 2}, {0, 1, 1, 2, 3, 3, 3, 0, 1, 2, 3}, {1, 2, 2, 3, 4, 4, 4, 0, 0, 1, 2}, {0, 2, 3, 4, 5, 3, 5, 1, 1, 0, 1}, {1, 1, 2, 3, 4, 2, 4, 2, 2, 0, 0}, {0, 0, 1, 2, 3, 1, 3, 2, 3, 1, 1}};
int finalstate[24] = {0, 3, 4, 3, 0, 5, 6, 5, 0, 1, 2, 1, 0, 7, 8, 7, 0, 9, 10, 9, 0, 1, 2, 1};
int state[24], point[2], count[2], stack[MAXD], result[MAXD], rn, solve;

int left(int base, int offset){
	if(base < 12){
		base += offset;
		if(base >= 12)
			base -= 12;
	}
	else{
		base += offset;
		if(base >= 24)
			base -= 12;
	}
	
	return base;
}

int right(int base, int offset){
	if(base < 12){
		base -= offset;
		if(base < 0)
			base += 12;
	}
	else{
		base -= offset;
		if(base < 12)
			base += 12;
	}
	
	return base;
}

void back(int a){
	int temp1, temp2, same, minmv;
	if(a == rn)
		return;
	same = 1;
	for(int i=0; i<12 && same; i++){
		if(state[left(point[0], i)] != finalstate[i])
			same = 0;
	}
	for(int i=0; i<12 && same; i++){
		if(state[left(point[1], i)] != finalstate[i + 12])
			same = 0;
	}
	
	if(same){
		for(int i=0; i<a; i++){
			result[i] = stack[i];
		}
		rn = a;
		solve = 1;
		return;
	}
	minmv = 0;
	for(int i=0; i<21; i++){
		temp1 = state[left(point[i/12], i%12)];
		if(minmv < remainto[i/2][temp1])
			minmv = remainto[i/2][temp1];
	}
	if(a == MAXD || a + minmv > MAXD || a + minmv >= rn)
		return;
	for(int i=1; i<=4; i++){
		if(a >= rn - 1)
			break;
		stack[a] = i;
		switch(i){
			case 1:
				if(count[0] > 0 || count[0] == -5)
					break;
				point[0] = right(point[0], 2);
				for(int j=1; j<=3; j++)
					state[right(point[1], j)] = state[right(point[0], j)];
				temp1 = count[0];
				temp2 = count[1];
				count[0]--;
				count[1] = 0;
				
				back(a + 1);
				
				count[0] = temp1;
				count[1] = temp2;
				
				point[0] = left(point[0], 2);
				for(int j=1; j<=3; j++)
					state[right(point[1], j)] = state[right(point[0], j)];
				break;
			case 2:
				if(count[1] > 0 || count[1] == -5)
					break;
				point[1] = left(point[1], 2);
				
				for(int j=1; j<=3; j++)
					state[right(point[0], j)] = state[right(point[1], j)];
				temp1 = count[0];
				temp2 = count[1];
				count[1]--;
				count[0] = 0;
				
				back(a + 1);
				
				count[0] = temp1;
				count[1] = temp2;
				
				point[1] = right(point[1], 2);
				for(int j=1; j<=3; j++)
					state[right(point[0], j)] = state[right(point[1], j)];
				break;
			case 3:
				if(count[0] < 0 || count[0] == 5)
					break;
				point[0] = left(point[0], 2);
				for(int j=1; j<=3; j++)
					state[right(point[1], j)] = state[right(point[0], j)];
				temp1 = count[0];
				temp2 = count[1];
				count[0]++;
				count[1] = 0;
				
				back(a + 1);
				
				count[0] = temp1;
				count[1] = temp2;
				
				point[0] = right(point[0], 2);
				for(int j=1; j<=3; j++)
					state[right(point[1], j)] = state[right(point[0], j)];
				break;
			case 4:
				if(count[1] < 0 || count[1] == 5)
					break;
				point[1] = right(point[1], 2);
				for(int j=1; j<=3; j++)
					state[right(point[0], j)] = state[right(point[1], j)];
				temp1 = count[0];
				temp2 = count[1];
				count[1]++;
				count[0] = 0;
				
				back(a + 1);
				
				count[0] = temp1;
				count[1] = temp2;
				
				point[1] = left(point[1], 2);
				for(int j=1; j<=3; j++)
					state[right(point[0], j)] = state[right(point[1], j)];
				break;
		}
	}
}

int main() {
	int t;
	cin >> t;
	for(; t>0; t--){
		for(int i=0; i<24; i++){
			cin >> state[i];
		}
		count[0] = count[1] = 0;
		point[0] = 0;
		point[1] = 12;
		rn = MAXD + 1;
		solve = 0;
		back(0);
		
		if(solve){
			if(rn == 0)
				cout << "PUZZLE ALREADY SOLVED" << endl;
			else{
				for(int j=0; j<rn; j++)
					cout << result[j];
				cout << endl;
			}
		}
		else
			cout << "NO SOLUTION WAS FOUND IN " << MAXD << " STEPS" << endl;
	}
	
	return 0;
}