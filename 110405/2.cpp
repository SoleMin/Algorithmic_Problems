#include<bits/stdc++.h>

using namespace std;


int main(int argc, char *argv[])
{
	int Testcase;
	cin >> Testcase;

	for (int i = 0; i < Testcase; i++)
	{
		int taskNum;
		cin >> taskNum;
		int ti[1000], si[1000];
		int result[1000];
		for (int i = 0; i < taskNum; i++)
			cin >> ti[i] >> si[i];
		
		for (int i = 0; i < taskNum; i++)
			result[i] = i;

		for (int i = 1; i < taskNum; i++)
		for (int j = 0; j < taskNum - i; j++)
		{
			if (ti[result[j]] * si[result[j + 1]] > ti[result[j + 1]] * si[result[j]])
				swap(result[j], result[j + 1]);
		//	else if (ti[result[j]] * si[result[j + 1]] == ti[result[j + 1]] * si[result[j]])
		//		if(result[j] > result[j + 1])
		//		swap(result[j], result[j + 1]);
		}

		if (i > 0)
			cout << '\n';

		for (int k = 0; k < taskNum; k++)
		{
			if (k == taskNum - 1)
			{
				cout << result[k] + 1;
				continue;
			}
			cout << result[k] + 1 << " ";
		}

		cout << endl;
		
	}
	return 0;
}