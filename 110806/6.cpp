#include <iostream>

using namespace std;

int id, n ,p;
char cell[32], automata[8], precell[32];

void back(int a) {
	if(a == n-1) {
		if(automata[precell[a-1]*4 + precell[a]*2 + precell[0]] == cell[a] && automata[precell[a]*4 + precell[0]*2 + precell[1]] == cell[0])
			p = 1;
		return;
	}
	
	for(int i = precell[a-1]*4 + precell[a]*2; i <= precell[a-1]*4 + precell[a]*2 + 1; i++) {
		if(automata[i] == cell[a]) {
			precell[a+1] = i%2;
			back(a+1);
			if(p)
				break;
		}
	}
}

int main() {
	while(cin >> id >> n >> cell){
		for(int i=0; i<n; i++)
			cell[i] -= '0';
		for(int i=0; i<8; i++){
			automata[i] = id%2;
			id /= 2;
		}
		
		p = 0;
		for(int i=0; i<8; i++) {
			if(automata[i] == cell[1]) {
				precell[0] = (i/4)%2;
				precell[1] = (i/2)%2;
				precell[2] = i%2;
				back(2);
				if(p)
					break;
			}
		}
		
		if(p){
			cout << "REACHABLE" << endl;
		}
		else{
			cout << "GARDEN OF EDEN" << endl;
		}
	}

	return 0;
}
