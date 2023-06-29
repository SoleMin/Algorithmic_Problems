#include<bits/stdc++.h>

using namespace std;

typedef map<int, int> node;

int getTime(const string& buf){
	int mm, dd, hh, mi;
	sscanf(buf.c_str(), "%d:%d:%d:%d", &mm, &dd, &hh, &mi);
	return dd * 24 * 60 + hh * 60 + mi;
}

map<string, node> m;
map<string, node>::iterator it;
node::iterator it2, it3;

double Operate(node& n, int EntranceCost[])
{
	int result = 0;
	for (it2 = n.begin(); it2 != n.end(); ++it2)
	{
		if (it2->second >= 0)
		{
			if (it2 == n.begin()) 
				continue;
			it3 = it2;
			--it3;
			if (it3->second < 0)
			{
				int prev = -it3->second - 1;
				int km = it2->second - prev;
				int pr = EntranceCost[(it3->first / 60) % 24];
				result += 100 + abs(km * pr);
			}
		}
	}
	return result == 0 ? 0.00 : (double)(result + 200) / 100.0;
}
int main(int argc, char * argv[])
{
	int Testcase;
	cin >> Testcase;

	//소수점 2째자리수로 고정시킨다.
	cout.precision(2);
	cout << fixed; 

	for (int i = 0; i < Testcase; i++)
	{
		int EntranceCost[24];

		for (int i = 0; i < 24; i++)
			cin >> EntranceCost[i];

		string infma;

		cin.ignore(); //
		m.clear();

		while (getline(cin, infma) && !infma.empty())
		{
			istringstream parsing(infma);
			parsing >> infma;
			//map에 들어있는 차판에 대한 키값 저장
			node &n = m[infma];
			parsing >> infma;
			
			int time = getTime(infma);

			parsing >> infma;
			int x;
			parsing >> x;
			n[time] = (infma[1] == 'n' ? -x - 1 : x);
		}
		for (it = m.begin(); it != m.end(); ++it)
		{
			double result = Operate(it -> second, EntranceCost);

			if (result == 0.00)
				continue;

			cout << it->first << " $" << Operate(it->second, EntranceCost) << endl;

		}
		if (i != Testcase -1)
			cout << '\n';
	}
}