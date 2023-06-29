# include <iostream>
# include <string>
# include <vector>
# include <algorithm>
# define MIN(x,y) ((x) > (y) ? (y) : (x))

using namespace std;

int main() {
	int test_case;
	string dump;
	cin >> test_case;
	getline(cin, dump);
	cin.ignore();
	
	while(test_case-- > 0){
		int n;
		int answer = 0;
		int input;
		vector<int> time;
		
		cin >> n;
		for(int i = 0; i < n; i++){
			cin >> input;
			time.push_back(input);	
		}
		
		sort(time.begin(), time.end());
		
		if(n == 1){
			answer = time[0];
		}
		else if(n == 2){
			answer = time[1];
		}
		else if(n == 3){
			answer = time[0] + time[1] + time[2];
		}
		else if(n >= 4){
			int person;
			for(person = n; person > 3; person -= 2){
				int first_case = time[0] + 2*time[1] + time[person-1];
				int second_case = 2*time[0] + time[person - 2] + time[person - 1];
				answer += MIN(first_case, second_case);
			}
			if(person == 3){
				answer += time[0] + time[1] + time[2];
			}
			else if (person == 2){
				answer += time[1];
			}
			else if (person == 1){
				answer += time[0];
			}
		}
		cout << answer << endl << endl;
		
		
	}
	
	return 0;
}