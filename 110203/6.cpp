
#include <iostream>
using namespace std;

int main(void) {
  int count = 0;
  cin >> count;

  for (int i = 0; i < count; i++) {
    int days[3651] = {0, };
    int company[101] = {0, };
    int day = 0, n = 0;
    cin >> day;
    cin >> n;
    for (int j = 0; j < n; j++) {
      cin >> company[j];
    }

    for (int j = 0; j < n; j++) {
      for (int k = company[j] - 1; k < day; k=k+company[j]) {
        days[k]++;
      }
    }
    
    int result = 0;

    for (int i = 0; i < day; i++)
      if (days[i] > 0 && (i % 7 != 5 && i % 7 != 6))
        result++;

    cout << result << "\n";
  }

  return 0;
}
