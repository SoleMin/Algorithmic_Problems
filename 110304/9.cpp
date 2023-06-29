# include <iostream>
# include <string>
# include <vector>
# include <map>
# define ALPHA_SIZE (26)

using namespace std;

static int keys[ALPHA_SIZE];
static string fox = "the quick brown fox jumps over the lazy dog";
map<char, char> m;

void init() {
	for (int i = 0; i < ALPHA_SIZE; i++) {
		keys[i] = 0;
	}
	m.erase(m.begin(), m.end());
}

int is_fox(string s) {
	if (s.size() == 43) {
		if (s[3] == ' ' && s[9] == ' ' && s[15] == ' ' && s[19] == ' ' && s[25] == ' ' && s[30] == ' ' && s[34] == ' ' && s[39] == ' ') {
			if (s[0] == s[31] && s[1] == s[32] && s[2] == s[33]){
				return 1;
			}
				
		}
	}
	return 0;
}

void get_key(string s) {
	for (int i = 0; i < s.length(); i++) {
		if (s[i] != ' ') {
			m.insert({s[i], fox[i]});
			//keys[s[i] - 'a'] = s[i] - fox[i];
		}
	}
}

int is_real(string s){
	string temp = "";
	for (int i = 0; i < s.length(); i++) {
		if (s[i] == ' '){
			temp += s[i];
		}
		else {
			temp += m.find(s[i])->second;
		}
	}
	
	if(temp == fox) {
		//cout << "IS REAL FOX" << endl;
		return 1;
	}
	else {
		//cout << "NOT FOX" << endl;
		return 0;
	}
}

void encording(string s) {
	for (int i = 0; i < s.length(); i++) {
		if (s[i] == ' ') {
			cout << ' ';
		}
		else {
			cout << m.find(s[i])->second;
			//cout << (char)(s[i] - keys[s[i] - 'a']);
		}
	}
	cout << '\n';
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
		int is_in = 0;
		vector<string> texts;
		
		/*입력처리*/
		while (getline(cin, input)) {
			if (input == "") {
				break;
			}
			
			is_in = 1;
			texts.push_back(input);
			
			if (is_fox(input) == 1) {
				get_key(input);
				if(is_real(input)){
					able = 1;
				}
				else {
					m.erase(m.begin(), m.end());
				}
			}
		} // EOW(Input)
		/*입력처리*/
		
		if(able == 0 && is_in == 1){
			cout << "No solution." << endl;
		}
		else if (able == 1 && is_in == 1){
			for (int i = 0; i < texts.size(); i++) {
				encording(texts[i]);
			}
		}
		
		cout << '\n';
	} // EOW(Test Case)
	
	return 0;
}