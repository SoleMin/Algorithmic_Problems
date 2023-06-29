#include <iostream>
#include <map>
using namespace std;

int main() {
  string s1, s2;
  while (cin >> s1 >> s2) {
    map<char, pair<int, int>> m;
    
    for (auto &item : s1) {
      if (m.find(item) != m.end()) {
        m[item].first++;
      }
      else {
        m.insert({item, make_pair(1, 0)});
      }
    }
      
    
    for (auto &item : s2) {
      if (m.find(item) != m.end()) {
        if (m[item].first > m[item].second)
          m[item].second++;
      }
    }

    for (auto iter = m.begin(); iter != m.end(); iter++) {
      for (int i = 0; i < iter->second.second; i++)
        cout << iter->first;
    }
    cout << "\n";
  }
}