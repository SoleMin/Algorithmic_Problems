#include <iostream>
using namespace std;

int n[3002];

bool isJolly(int count) {
  bool result = true;
  
  int find = 1;
  for (int i = 1; i < count; i++) {
    for (int j = 1; j <= count; j++) {
      if (j == count)
        result = false;
      if (n[j] == find)
        break;
    }
    find++;
  }

  return result;
}

int main(void) {
  int count;

  while (cin >> count) {
    int tmp, tmp2;
    cin >> tmp;
    for (int i = 1; i < count; i++) {
      cin >> tmp2;
      n[i] = (tmp - tmp2 > 0) ? (tmp - tmp2) : (tmp2 - tmp);
      tmp = tmp2;
    }
    
    cout << (isJolly(count) ? "Jolly" : "Not jolly") << "\n";
  }
}