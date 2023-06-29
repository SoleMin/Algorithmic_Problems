#include <bits/stdc++.h>

using namespace std;
void constructlp(vector <int> &lp, string pat)
{
    int j = 0;
    for (int i = 1; i < pat.size(); i++) {
        while (j > 0 &&  pat[j] != pat[i]) {
            j = lp[j-1];
	}
	if (pat[j] == pat[i]) {
            j++;
        }
	lp[i] = j;
    }
}

void kmpSearch(vector<int> &occ, string pat, string word, vector<int> & lp)
{
    unsigned i = 0, j = 0;
    // cout << "\n Size "<< word.size() << "\t" << pat.size() << "\n";
    while(i < word.size()) {
        if (word[i] == pat[j]) { // increment if the pattern matches
	    // cout << word[i] <<" " << pat[j] <<"\n";
            i++;
            j++;
        }
        if (j == pat.size()) { // if we reached end of pattern we have completed.
            // cout << "Found at position " <<i - pat.size() <<"\n";
            occ.push_back(i-pat.size()+1);
            j = lp[j-1];
        }
        else if (i < word.size() && pat[j] != word[i]) {
            if (j != 0) 
                j  = lp [j - 1];
            else 
                i = i + 1;
        }
    }

}

int main(int argc, char * argv[])
{
    string pattern, word;
    vector<int> occ;
    //cout <<"Enter the search and pattern \n";
    getline(cin, word);
    getline(cin, pattern);
    // cout << word  <<"\n"<< pattern; 
    vector<int> lp(pattern.size());
    constructlp(lp, pattern);
    // for (auto i : lp) {
    //    cout << i << '\t';
    //}
    //cout << "\n";
    kmpSearch(occ, pattern, word, lp); 
    cout << occ.size() << endl;
    for (int i = 0; i < occ.size(); i++) 
        cout << occ[i] << " ";
    cout << endl;
    return 0;
}