#include <iostream>
#include <algorithm>
using namespace std;

#define MAX_JOB 1000

static int result[MAX_JOB],arr[MAX_JOB], ti[MAX_JOB], si[MAX_JOB];

int main() {
	int tc,job,temp,t,s;
	
	cin >> tc;
	
	while(tc--){
		cin >> job;
		for(int i=0; i<job; i++){
			cin >> t >> s;
			ti[i] = t;
			si[i] = s;
			result[i] = i;
		}
	
		for(int i=1; i<job; i++){
			for(int j=0; j<job - 1; j++){
				if(ti[result[j]] * si[result[j+1]] > ti[result[j+1]] * si[result[j]]){
					temp = result[j];
					result[j] = result[j+1];
					result[j+1] = temp;
				}
			}
		}
		for(int j=0; j<job-1; j++)
			cout << result[j] + 1 << " ";
		cout << result[job-1] + 1 << "\n";
		cout << "\n";
	}
	
	return 0;
}