#include <iostream>
#include <string>
#include <vector>
using namespace std;

int main()
{
  string trash;
  int count = 0;
  cin >> count;
  cin.ignore();
  getline(cin, trash);

  for (int start = 0; start < count; start++)
  {
    vector<char> crypt;
    string cryptKey = "the quick brown fox jumps over the lazy dog";

    // Get Line and input vector
    string tmp;
    vector<string> cryptVector;
    while (getline(cin, tmp))
    {
      if (tmp == "")
        break;
      cryptVector.push_back(tmp);
    }

    // Find "the quick brown fox jumps over the lazy dog"
    bool findCrypt = false;
    for (const auto &item : cryptVector)
    {
      crypt.clear();
      crypt.resize(26);

      if (item.length() != cryptKey.length())
        continue;

      int index = 0;
      for (const auto &ch : item)
      {
        if (ch != ' ')
          crypt[ch - 'a'] = cryptKey[index];
        index++;
      }

      string validTableChecking = "";
      for (const auto &ch : item)
      {
        if (ch == ' ')
          validTableChecking += " ";
        else
          validTableChecking += crypt[ch - 'a'];
      }
      if (cryptKey == validTableChecking)
      {
        findCrypt = true;
        break;
      }
    }

    if (findCrypt)
    {
      for (const auto &item : cryptVector)
      {
        for (const auto &ch : item)
        {
          if (ch == ' ')
            cout << " ";
          else
            cout << crypt[ch - 'a'];
        }
        cout << "\n";
      }
    }
    else
    {
      cout << "No solution.\n";
    }
    cout << "\n";
  }
}