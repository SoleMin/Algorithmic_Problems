#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int s[8][2] = {{1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}};

int search(string find, int x, int y, vector<string> &board) {
  for (int i = 0; i < 8; i++) {
    int dx = 0, dy = 0;
    for (int j = 0; j < find.length(); j++) {
      // cout << j << ": " << find[j] << " " << board[x + dx][y + dy] << " ";
      if (find[j] != board[x + dx][y + dy])
        break;
      if (j == find.length() - 1) {
        return 1;
      }
      dx += s[i][0];
      dy += s[i][1];
      if ((dx + x) < 0 || (dy + y) < 0 || (dx + x) >= board.size() || (dy + y) >= board[0].length())
        break;
    }
  }
  return 0;
}

int main() {
  int count = 0;
  cin >> count;

  for (int i = 0; i < count; i++) {
    vector<string> v;
    int x, y;
    cin >> x >> y;

    for (int j = 0; j < x; j++) {
      string tmp;
      cin >> tmp;
      transform(tmp.begin(), tmp.end(), tmp.begin(), ::tolower);
      v.push_back(tmp);
    }

    int findCount = 0;
    cin >> findCount;

    for (int j = 0; j < findCount; j++) {
      string tmp;
      cin >> tmp;
      transform(tmp.begin(), tmp.end(), tmp.begin(), ::tolower);
      
      bool isPrint = false;
      for (int dx = 0; dx < x; dx++) {
        for (int dy = 0; dy < y; dy++) {
          if (search(tmp, dx, dy, v)) {
            cout << dx + 1 << " " << dy + 1 << "\n";
            isPrint = true;
            break;
          }
        }
        if (isPrint)
          break;
      }
      if (!isPrint) {
        cout << x << " " << y << "\n";
      }
    }
    cout << "\n";
  }
}