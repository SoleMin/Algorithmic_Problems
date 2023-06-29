#include <iostream>
#include <vector>
#include <map>
#include <set>
#include <string>

using namespace std;

vector<string> parsing(const string &Text)
{
	vector<string> tmp;
	int start = 0;
	int end = Text.find(".,", 0);
	while( end != string::npos)
	{
		tmp.push_back(Text.substr(start, end + 1 - start));
		start = end + 3;
		end = Text.find(".,", start);
	}
	tmp.push_back(Text.substr(start));
	return tmp;
}

int main(int argc, char * argv[]) 
{
	int Testcase;
	cin >> Testcase;
	for(int i =0; i< Testcase; i++)
	{
		int p;
		int n;
		cin >> p; 
		cin >> n;
		cin.ignore();
		string Text;
		vector<string> psText;
		map<string, int> sortMap;
		map<string, set<string>> treeMap;
		
		for(int i = 0; i <p; i++)
		{
			getline(cin, Text);
			psText = parsing(Text.substr(0, Text.find_first_of(":")));
			
			for(int i =0; i < psText.size(); i++)
				for(int j =0; j < psText.size(); j++)
					if(i != j)
						treeMap[psText[i]].insert(psText[j]);
		}
		
		set<string> exist;
		set<string> newExist;
		exist.insert("Erdos, P.");
		sortMap["Erdos, P."] = 0;
		int ErdosNum = 1;
		while(1)
		{
			for(auto Person = exist.begin(); Person != exist.end(); Person++)
			{
				if(treeMap.find(*Person) != treeMap.end())
				{
					set<string> &cur = treeMap.at(*Person);
					for(auto next = cur.begin(); next != cur.end(); next++)
					{
						if(sortMap.find(*next) == sortMap.end())
						{
							sortMap[*next] = ErdosNum;
							newExist.insert(*next);
						}
					}
				}
			}
			if(newExist.empty())
				break;
			ErdosNum++;
			exist = newExist;
			newExist.clear();
		}
		
		cout << "Scenario " << i + 1 << endl;
		string Professor;
		for(int j =0; j<n; j++)
		{
			getline(cin, Professor);
			cout << Professor <<' ';
			auto i = sortMap.find(Professor);
			if(i != sortMap.end())
				cout << i -> second << endl;
			else
				cout << "infinity" << endl;
		}
	}
	return 0;
}