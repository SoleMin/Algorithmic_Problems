#include <iostream>
#include <vector>

using namespace std;

void test(int days, vector<int>& hartals){
	int i, j, h_size, n, res = 0;
	
	vector<char> closed(days);
	
	h_size = hartals.size();
	for(i = 0; i < h_size; i++){
		n = hartals[i];
		for(j = n - 1; j < days; j += n) closed[j] = 1;
	}
	
	for(i = 0; i < days; i++)
		if(((i % 7) < 5) && closed[i] == 1) res++;
	
	cout << res << endl;
}

int main() {
	int i, j, cases, days, party;
	
	cin >> cases;
	vector<int> hartals;
	
	for(i = 0; i < cases; i++){
		cin >> days >> party;
		hartals.resize(party);
		
		for(j = 0; j < party; j++)
			cin >> hartals[j];

		test(days, hartals);
	}
	return 0;
}