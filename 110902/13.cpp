# include <iostream>
# include <vector>
# include <queue>
# include <string>
# define MAX_SIZE (10000)

using namespace std;

static int start_code;
static int end_code;
static int is_visit[MAX_SIZE];
vector<int> hazard_code;

void init();
void print_hazard_code();
void get_input();

int bfs();
int is_hazard(int code);

int rotate1(int code);
int rotate2(int code);
int rotate3(int code);
int rotate4(int code);
int rotate5(int code);
int rotate6(int code);
int rotate7(int code);
int rotate8(int code);

int main() {
	int test_case = 0;
	cin >> test_case;

	string dump;
	getline(cin, dump);
	
	while (test_case-- > 0) {
		init();
		get_input();
		
		cout << bfs() << endl;				
	}	// EOW (Test Case)

	return 0;
}

void init() {
	start_code = 0;
	end_code = 0;	

	while (!hazard_code.empty()) {
		hazard_code.pop_back();
	}
	for (int i = 0; i < MAX_SIZE; i++) {
		is_visit[i] = 0;
	}
}
void print_hazard_code() {
	for (int i = 0; i < hazard_code.size(); i++) {
		cout << hazard_code[i] << endl;
	}
}
void get_input() {
	int temp = 0;
	int digit = 1000;

	for (int i = 0; i < 4; i++) {
		cin >> temp;
		start_code += temp * digit;
		digit /= 10;
	}

	digit = 1000;
	for (int i = 0; i < 4; i++) {
		cin >> temp;
		end_code += temp * digit;
		digit /= 10;
	}

	int n;	
	cin >> n;
	for (int i = 0; i < n; i++) {
		int cur_code = 0;
		digit = 1000;
		for (int i = 0; i < 4; i++) {
			cin >> temp;
			cur_code += temp * digit;
			digit /= 10;
		}
		hazard_code.push_back(cur_code);
	}

}

int bfs() {
	queue<pair<int, int>> q;
	int cur_code = 0;
	int next_code = 0;
	int cur_counter = 0;

	q.push({ start_code, 0 });
	is_visit[start_code] = 1;
	
	while (!q.empty()) {				
		cur_code = q.front().first;
		cur_counter = q.front().second;
		q.pop();
		if (cur_code == end_code) {			
			return cur_counter;
		}
		
		next_code = rotate1(cur_code);
		if (!is_hazard(next_code) && !is_visit[next_code]) {
			q.push({next_code, cur_counter + 1});
			is_visit[next_code] = 1;
		}

		next_code = rotate2(cur_code);
		if (!is_hazard(next_code) && !is_visit[next_code]) {
			q.push({ next_code, cur_counter + 1 });
			is_visit[next_code] = 1;
		}

		next_code = rotate3(cur_code);
		if (!is_hazard(next_code) && !is_visit[next_code]) {
			q.push({ next_code, cur_counter + 1 });
			is_visit[next_code] = 1;
		}

		next_code = rotate4(cur_code);
		if (!is_hazard(next_code) && !is_visit[next_code]) {
			q.push({ next_code, cur_counter + 1 });
			is_visit[next_code] = 1;
		}

		next_code = rotate5(cur_code);
		if (!is_hazard(next_code) && !is_visit[next_code]) {
			q.push({ next_code, cur_counter + 1 });
			is_visit[next_code] = 1;
		}

		next_code = rotate6(cur_code);
		if (!is_hazard(next_code) && !is_visit[next_code]) {
			q.push({ next_code, cur_counter + 1 });
			is_visit[next_code] = 1;
		}

		next_code = rotate7(cur_code);
		if (!is_hazard(next_code) && !is_visit[next_code]) {
			q.push({ next_code, cur_counter + 1 });
			is_visit[next_code] = 1;
		}

		next_code = rotate8(cur_code);
		if (!is_hazard(next_code) && !is_visit[next_code]) {
			q.push({ next_code, cur_counter + 1 });
			is_visit[next_code] = 1;
		}
	}

	return -1;
}
int is_hazard(int code) {
	for (int i = 0; i < hazard_code.size(); i++) {
		if (hazard_code[i] == code) {
			return 1;
		}
	}

	return 0;
}

int rotate1(int code) {
	int temp = code / 1000;	
	code %= 1000;
	temp = temp > 0 ? (temp - 1) % 10 : (temp - 1) % 10 + 10;
	code += temp * 1000;

	return code;
}
int rotate2(int code) {
	int temp = code / 1000;
	code %= 1000;
	temp = (temp + 1) % 10;
	code += temp * 1000;

	return code;
}
int rotate3(int code) {
	int temp = code % 1000 / 100;
	code -= 100 * temp;
	temp = temp > 0 ? (temp - 1) % 10 : (temp - 1) % 10 + 10;
	code += temp * 100;

	return code;
}
int rotate4(int code) {
	int temp = code % 1000 / 100;
	code -= 100 * temp;
	temp = (temp + 1) % 10;
	code += temp * 100;

	return code;
}
int rotate5(int code) {
	int temp = code % 100 / 10;
	code -= 10 * temp;
	temp = temp > 0 ? (temp - 1) % 10 : (temp - 1) % 10 + 10;
	code += temp * 10;

	return code;
}
int rotate6(int code) {
	int temp = code % 100 / 10;
	code -= 10 * temp;
	temp = (temp + 1) % 10;
	code += temp * 10;

	return code;
}
int rotate7(int code) {
	int temp = code % 10;
	code -= temp;
	temp = temp > 0 ? (temp - 1) % 10 : (temp - 1) % 10 + 10;
	code += temp;

	return code;
}
int rotate8(int code) {
	int temp = code % 10;
	code -= temp;
	temp = (temp + 1) % 10;
	code += temp;

	return code;
}