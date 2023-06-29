# include <iostream>
# include <algorithm>
# include <string>
# include <sstream>

using namespace std;

typedef struct {
	int id;
	int t;
	int s;
}Schedule;

bool compare(Schedule s1, Schedule s2){
	return s2.t * s1.s > s1.t * s2.s;
}

int main() {
	string dump;
	int test_case = 0;
	cin >> test_case;
	getline(cin, dump);
	cin.ignore();
	
	while(test_case-- > 0){
		int n, t, s;
		vector<Schedule> v;
		cin >> n;
		for(int i = 0; i < n; i++){
			cin >> t >> s;
			Schedule sc = {i+1, t, s};
			v.push_back(sc);
		}
		
		stable_sort(v.begin(), v.end(), compare);
		
		for(int i = 0; i < v.size(); i++){
			cout << v[i].id;
			if(i != v.size() - 1){
				cout << " ";
			}
		}
		cout << endl << endl;
	}
	
	
	
	return 0;
}