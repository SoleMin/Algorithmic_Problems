# include <iostream>
# include <string>
# include <vector>
# include <sstream>
# include <map>
# define INT_MAX (2147483647)
# define MIN(a, b) (((a) < (b)) ? (a) : (b))

using namespace std;

int main(void) {
	int scenario = 0;
	int case_num = 0;
	string input;
	
	cin >> scenario;
	
	while (case_num++ < scenario) {
		/*맵 초기화*/
		map<string, int> m;
		m.insert({"Erdos, P.", 0});
		/*맵 초기화*/
		int p = 0, n = 0;
		cin >> p >> n;
		cin.ignore();
		
		for (int i = 0; i < p; i++) {
			string token;
			stringstream sstream;
			vector<string> tokens;
			vector<string> writers;
			
			/*논문 입력 처리*/
			getline(cin, input);
			sstream.str(input);
			while (getline(sstream, token, ',')) {
				tokens.push_back(token);
			}
			
			string last_token = tokens[tokens.size() - 1];
			tokens.pop_back();
			tokens.push_back(last_token.substr(0, last_token.find(":")));
			for (int i = 0; i < (signed)tokens.size() - 1; i += 2) {
				if (i != 0) {
					string temp = tokens[i].substr(1, tokens[i].size()) + "," + tokens[i + 1];
					writers.push_back(temp);
				}
				else {
					writers.push_back(tokens[i] + "," + tokens[i + 1]);
				}
			}
			/*논문 입력 처리*/
			
			/*저자중 최소 에르되시 수 구하기*/
			int lower_erdos_number = INT_MAX - 1;
			for (int i = 0; i < (signed)writers.size(); i++) {
				if (m.find(writers[i]) != m.end()) {
					lower_erdos_number = MIN(lower_erdos_number, m.find(writers[i])->second);
				}
			}
			/*저자중 최소 에르되시 수 구하기*/
			
			/*각 저자의 에르되시 수 갱신*/
			for (int i = 0; i < (signed)writers.size(); i++) {
				if (m.find(writers[i]) != m.end()) {
					if (m.find(writers[i])->second > lower_erdos_number + 1) {
						m.erase(writers[i]);
						m.insert({ writers[i], lower_erdos_number + 1});
					}
				}
				else {
					m.insert({ writers[i], lower_erdos_number + 1});
				}
			}
			/*각 저자의 에르되시 수 갱신*/
		}	// EOF (P)
		
		/*출력*/
		cout << "Scenario " << case_num << endl;
		for (int i = 0; i < n; i++) {
			string writer;
			getline(cin, writer);
			
			if (m.find(writer) != m.end()) {
				if (m.find(writer)->second == INT_MAX) {
					cout << writer << " infinity" << endl;
				}
				else {
					cout << writer << " " << m.find(writer)->second << endl;
				}
			}
			else {
				cout << "miss" << endl;
			}
		}
		/*출력*/
	}	// EOW (Case Num)
	
	return 0;
}







