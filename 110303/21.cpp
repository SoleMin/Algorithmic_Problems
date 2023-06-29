# include <iostream>
# include <string>
# define ALPHA_SIZE (26)
# define MIN(x, y) (((x) < (y)) ? (x) : (y))

static int first[ALPHA_SIZE];
static int second[ALPHA_SIZE];

using namespace std;

void reset() {
	for (int i = 0; i < ALPHA_SIZE; i++){
		first[i] = 0;
		second[i] = 0;
	}
}

int main(void) {
	
	string first_input;
	string second_input;
	
	while ( getline(cin, first_input) ) {
		if (first_input == "") {
			break;
		}
		getline(cin, second_input);
		
		reset();
		
		for (int i = 0; i < first_input.size(); i++) {
			first[first_input[i] - 'a']++;
		}
		for (int i = 0 ; i < second_input.size(); i++) {
			second[second_input[i] - 'a']++;
		}
		
		for (int i = 0; i < ALPHA_SIZE; i++) {
			int print_counter = MIN(first[i], second[i]);
			for (int print = 0; print < print_counter; print++) {
				cout << (char)(i + 'a');
			}
		}
		cout << '\n';
		
	}
	
	
	return 0;
}