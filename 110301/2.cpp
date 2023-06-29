#include <iostream>
#include <string>
using namespace std;

int main(void) {
  ios_base::sync_with_stdio(false);
  cin.tie(0); cout.tie(0);

  char keyboard[48] = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";
  
  string input = "";
  while (getline(cin, input)) {
    for (auto &item : input) {
      for (int i = 0; i < 48; i++) {
        if (item == keyboard[i])
          item = keyboard[i-1];
        else if (item == ' ')
          break;
      }
    }
    cout << input << "\n";
    input = "";
  }

  return 0;
}

