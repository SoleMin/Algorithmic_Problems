#include <iostream>
#include <algorithm>
#define MAXMV 50

using namespace std;

char movec[4] = {'U', 'R', 'D', 'L'};
int MAXD, mtop, solved, puzzle[4][4], movestack[MAXMV];
int mv[4][2] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

int cost(){
	int m = 0;
	
	for(int i=0; i<4; i++){
		for(int j=0; j<4; j++){
			if(puzzle[i][j] != 0){
				m += abs(i - ((puzzle[i][j] - 1)/4));
				m += abs(j - ((puzzle[i][j] - 1)%4));
			}
		}
	}
	
	return m;
}

void back(int a, int nowx, int nowy){
	int nextx, nexty, c = cost();
	
	if(c == 0){
		solved = 1;
		return;
	}
	if(a + c > MAXD)
		return;
	for(int i=0; i<4; i++){
		if(mtop > 0 && (movestack[mtop - 1] + 2)%4 == i)
			continue;
		nextx = nowx + mv[i][0];
		nexty = nowy + mv[i][1];
		if(nextx < 0 || nexty < 0 || nextx > 3 || nexty > 3)
			continue;
		swap(puzzle[nowx][nowy], puzzle[nextx][nexty]);
		movestack[mtop++] = i;
		back(a + 1, nextx, nexty);
		if (solved)
			return;
		mtop--;
		swap(puzzle[nowx][nowy], puzzle[nextx][nexty]);
	}
}

void solve(){
	int x, y, value = 0;
	
	for(int i=0; i<4; i++){
		for(int j=0; j<4; j++){
			if(puzzle[i][j] == 0){
				value += i;
				x = i;
				y = j;
			}
			for(int k=i; k<4; k++){
				int l = 0;
				if(k == i)
					l = j + 1;
				for(; l<4; l++){
					if(puzzle[k][l] != 0 && puzzle[i][j] > puzzle[k][l])
						value++;
				}
			}
		}
	}
	if(value%2 == 0)
		return;
	for(MAXD=cost(); !solved && MAXD <= MAXMV; MAXD += 2)
		back(0, x, y);
}

int main() {
	int t;
	cin >> t;
	for(; t>0; t--){
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				cin >> puzzle[i][j];
			}
		}
		mtop = 0;
		solved = 0;
		solve();
		if(solved){
			for(int i=0; i<mtop; i++)
				cout << movec[movestack[i]];
			cout << endl;
		}
		else
			cout << "This puzzle is not solvable." << endl;
	}
	
	return 0;
}