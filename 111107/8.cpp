#include <iostream>
#define MAXN 9999
int bad[MAXN], length[MAXN],  differ[MAXN],  nChopstick, nGuest;
using namespace std;

int main()
{
	int num;

	cin >> num;
	for (int i = 0; i < num; i++) {
		{
			cin  >>  nGuest >> nChopstick;
			nGuest = nGuest + 8;

			for (int i = 1; i < nChopstick; i++) {
				bad[i - 1] = 0;
			}

			for (int i = 1; i <= nChopstick; i++){
			
				cin >> length[i];
				differ[i] = length[i] - length[i - 1];
				differ[i] = differ[i] * differ[i];
			}			

			for (int i = 1; i <= nGuest; i++){
			
				int set = nChopstick - 3 * (nGuest - i);

				for (int j = set; j >= 2 * i + 1; j--)
					bad[j - 1] = bad[j - 3] + differ[j - 1];

				for (int j = 2 * i + 1; j <= set - 1; j++)
					bad[j] = min( bad[j - 1], bad[j] );

				bad[set] = bad[set - 1];
			}

			cout << bad[nChopstick] << endl;
		}
	}
}