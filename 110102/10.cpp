# include <iostream>
# include <string>
# define MAX_SIZE (100)

using namespace std;

static char field[MAX_SIZE][MAX_SIZE];

void check_mine(int n, int m, int row, int col){
	int pos_x[8] = {-1, 0, 1, -1, 1, -1 ,0, 1};
	int pos_y[8] = {-1, -1, -1, 0, 0, 1, 1, 1};
	int mine_counter = 0;
	
	for(int i = 0 ; i < 8; i++){	// repeat for direction
		int next_row = row + pos_y[i];
		int next_col = col + pos_x[i];
		if(next_row >= 0 && next_col >= 0 && next_row < n && next_col < m){ // check index is valid
			if(field[next_row][next_col] == '*'){
				mine_counter++;
			}
		}
	}
	
	field[row][col] = mine_counter + '0';
	
	return;
}

void fullfill_field(int n, int m){
	
	for(int row = 0; row < n; row++){
		for(int col = 0; col < m; col++){
			if(field[row][col] == '.'){
				check_mine(n, m, row, col);
			}
		}
	}
}

void print_field(int n, int m, int test_case){
	cout << "Field #" << test_case << ":" << '\n';
	for(int row = 0; row < n; row++){
		for(int col = 0; col < m; col++){
			cout << field[row][col];
		}
		cout << '\n';
	}
	cout << '\n';
}

int main() {
	
	int n = -1;
	int m = -1;
	int test_case = 0;
	
	while( true ){
		test_case++;
		
		string line;
		cin >> n >> m;
		if(n == 0 && m == 0){
			break;
		}
		
		/***** 입력처리 *****/
		for (int row = 0; row < n; row++){
			cin >> line;
			for (int col = 0; col < m; col++){
				if(line[col] == '*'){
					field[row][col] = '*';	// -1 means mine, else 0
				}
				else{
					field[row][col] = '.';
				}
			}
		}
		/***** 입력처리 *****/
		
		/***** Fullfill Field *****/
		fullfill_field(n, m);
		/***** Fullfill Field *****/
		
		print_field(n, m, test_case);
	}
	
	return 0;
}