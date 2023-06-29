# include <iostream>
# include <string>
# include <vector>
# define MAX_SIZE (50)
# define DIRECTION (8)

using namespace std;

static vector<string> field;

void init() {
	for (int i = 0; i < MAX_SIZE; i++) {
		while (field.size()) {
			field.pop_back();
		}
	}
}

void field_to_lower() {
	for (int r = 0; r < field.size(); r++) {
		for (int c = 0; c < field[r].size(); c++) {
			if (field[r][c] >= 'A' && field[r][c] <= 'Z') {
				field[r][c] += 'a' - 'A';
			}
		}
	}
}

void string_to_lower(string& s) {
	for (int i = 0; i < s.size(); i++) {
		if (s[i] >= 'A' && s[i] <= 'Z') {
			s[i] += 'a' - 'A';
		}
	}
}

int is_waldorf(string s, int pos_y, int pos_x, int m, int n) {
	int x[DIRECTION] = {-1, 0, 1, -1, 1, -1, 0, 1};
	int y[DIRECTION] = {-1, -1, -1, 0, 0, 1, 1, 1};
	int able = 0;
	
	for (int i = 0; i < DIRECTION; i++) {
		int cur_row = pos_y;
		int cur_col = pos_x;
		
		for (int j = 0; j < s.size(); j++) {
			if (cur_row >= 0 && cur_row < m && cur_col >= 0 && cur_col < n) {
				if (s[j] != field[cur_row][cur_col]) {
					break;
				}
				if (j == s.size() - 1) {
					able = 1;
				}
				
				cur_row += y[i];
				cur_col += x[i];
			}
		}
		
		if (able) {
			return 1;
		}
	}
	
	return 0;
}

int main(void) {
	
	int test_case = 0;
	string input;
	cin >> test_case;
	getline(cin, input);
	cin.ignore();
	
	while (test_case-- > 0) {
		init();
		int able = 0;
		
		while (getline(cin, input)) {
			if (input == "") {
				break;
			}
			
			int parsing_point = input.find(' ');
			int m = stoi(input.substr(0, parsing_point));
			int n = stoi(input.substr(parsing_point, input.size()));
			
			for (int i = 0; i < m; i++) {
				getline(cin, input);
				field.push_back(input);
			}
			
			field_to_lower();
			
			int k = 0;
			cin >> k;
			cin.ignore();
			
			for (int i = 0; i < k; i++) {
				getline(cin, input);
				string_to_lower(input);
				int flag = 0;
				
				for (int r = 0; r < field.size(); r++) {
					for (int c = 0; c < field[r].size(); c++) {
						if (is_waldorf(input, r, c, m, n)) {
							cout << r + 1 << " " << c + 1 << endl;
							flag = 1;
							break;
						}
					}
					if (flag) {
						break;
					}
				}	// EOF(RC)
			}	// EOF(K)
		}	// EOW(Input)
		cout << '\n';
	}	// EOW(Test Case)
	
	return 0;
}