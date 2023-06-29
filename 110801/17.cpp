# include <iostream>

# define MAX_SIZE (8)

using namespace std;

static int board[MAX_SIZE][MAX_SIZE];
static long long answer = 0;
static int n, k;

void init() {
	for (int r = 0; r < MAX_SIZE; r++) {
		for (int c = 0; c < MAX_SIZE; c++) {
			board[r][c] = 0;
		}
	}
}

void print_board() {
	cout << "=====<Cur Board>=====" << endl;
	for (int row = 0; row < n; row++) {
		for (int col = 0; col < n; col++) {
			if (board[row][col] == -1) {
				cout << "B ";
			}
			else if (board[row][col] == 0) {
				cout << "* ";
			}
			else if (board[row][col] > 0) {
				cout << board[row][col] << " ";
			}
		}
		cout << endl;
	}
	cout << endl;
}

void block(int row, int col) {
	int temp_row = row;
	int temp_col = col;
	while (temp_col < n && temp_row < n) {
		board[temp_row][temp_col]++;

		temp_row++;
		temp_col++;
	}

	temp_row = row;
	temp_col = col;
	while (temp_row >= 0 && temp_col < n) {
		board[temp_row][temp_col]++;

		temp_row--;
		temp_col++;
	}

	temp_row = row;
	temp_col = col;
	while (temp_row >= 0 && temp_col >= 0) {
		board[temp_row][temp_col]++;

		temp_row--;
		temp_col--;
	}

	temp_row = row;
	temp_col = col;
	while (temp_row < n && temp_col >= 0) {
		board[temp_row][temp_col]++;

		temp_row++;
		temp_col--;
	}
	board[row][col] = -1;
}

void restore(int row, int col) {
	int temp_row = row;
	int temp_col = col;
	while (temp_col < n && temp_row < n) {
		board[temp_row][temp_col]--;

		temp_row++;
		temp_col++;
	}

	temp_row = row;
	temp_col = col;
	while (temp_row >= 0 && temp_col < n) {
		board[temp_row][temp_col]--;

		temp_row--;
		temp_col++;
	}

	temp_row = row;
	temp_col = col;
	while (temp_row >= 0 && temp_col >= 0) {
		board[temp_row][temp_col]--;

		temp_row--;
		temp_col--;
	}

	temp_row = row;
	temp_col = col;
	while (temp_row < n && temp_col >= 0) {
		board[temp_row][temp_col]--;

		temp_row++;
		temp_col--;
	}
}

void check(int start,int count) {
	//cout << "Row[" << cur_row << "] Col[" << cur_col << "]" << " Counter[" << count << "]" << endl;
	//print_board();
	if (k == count) {
		//cout << "Row[" << cur_row << "] Col[" << cur_col << "]" << endl;
		//cout << "Check" << endl;
		answer++;
		return;
	}

	for (int val = start; val < n*n; val++) {
		int row = val / n;
		int col = val % n;

		if (board[row][col] == 0) {
			board[row][col] = -1;
			block(row, col);
			check(val + 1, count + 1);
			restore(row, col);
			board[row][col] = 0;
		}
	}
	

}



int main() {

	while (1) {
		init();
		
		cin >> n >> k;
		if (n == 0 && k == 0) {
			//cout << "End" << endl;
			break;
		}

		check(0, 0);
		cout << answer << endl;
		answer = 0;
	}

	return 0;
}