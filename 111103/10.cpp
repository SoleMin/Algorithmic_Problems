# include <iostream>
# include <vector>
# include <algorithm>

# define MAX_SIZE (1000)
# define MAX(x, y) ((x) > (y) ? (x) : (y))
# define MIN(x, y) ((x) < (y) ? (x) : (y))

using namespace std;

static int dp[MAX_SIZE];
static int max_sequence = 0;
vector<int> result;
static int final_answer[MAX_SIZE];
static int first_flag = 1;


struct Elephant {
    int iq;
    int weight;
    int num;
};

vector<Elephant> v;

bool compare(Elephant e1, Elephant e2) {
    if (e1.weight == e2.weight) {
			if (e1.iq == e2.iq){
				return false;	
			}
        return e1.iq < e2.iq;
    }
    return e1.weight < e2.weight;
}

void swap_answer() {
    for (int i = 0; i < max_sequence; i++) {
        final_answer[i] = result[i];
    }
}

void init() {
    for (int i = 0; i < MAX_SIZE; i++) {
        dp[i] = -1;
    }
}

void print_vector() {
    for (int i = 0; i < v.size(); i++) {
        cout << "num : " << v[i].num << " || iq : " << v[i].iq << " || wieght : " << v[i].weight << endl;
    }
}

void print_dp(int n) {
    for (int i = 0; i < n; i++) {
        cout << "dp[" << i << "] : " << dp[i] << endl;
    }

}

void print_path(int index, int parent) {
    //cout << v[index].num << endl;
    if (result.size() == max_sequence - 1) {
        result.push_back(v[index].num);
    }

    /*cout << "Check => ";
    for (int i = 0; i < result.size(); i++) {
        cout << result[i] << " ";
    }
    cout << endl;*/
    
    if (result.size() == max_sequence) {
        if (first_flag) {
            //cout << "Check => ";
            for (int i = 0; i < max_sequence; i++) {
                //cout << result[i] << " ";
                final_answer[i] = result[i];
            }
            first_flag = 0;
            //cout << endl;
        }
        
        for (int i = 0; i < max_sequence; i++) {
            if (final_answer[i] > result[i]) {
                swap_answer();
            }
        }    
        
        result.pop_back();
        return;
    }
    
    for (int i = index + 1; i < v.size(); i++) {
        if (dp[i] == parent) {
            if (v[i].weight >= v[index].weight && v[i].iq <= v[index].iq) {
                result.push_back(v[index].num);
                print_path(i, parent - 1);
                result.pop_back();
            }            
        }
    }
}

int solve(int index) {
    int val = dp[index];
    if (val != -1) {
        return val;
    }

    val = 1;
    dp[index] = 1;
    for (int i = index + 1; i < v.size(); i++) {
        if (v[i].weight > v[index].weight && v[i].iq < v[index].iq) {
            val = MAX(val, solve(i) + 1);
            dp[index] = val;
        }
    }

    return dp[index];
}

int main() {

    init();

    int weight;
    int iq;
    int num = 0;
    
    while (cin >> weight) {
        cin >> iq;
        num++;
        v.push_back({ iq, weight, num });
    }

    sort(v.begin(), v.end(), compare);
    for (int i = 0; i < v.size(); i++) {
        max_sequence = MAX(max_sequence, solve(i));
    }

    
    //print_dp(v.size());
    //cout << "P1" << endl;
    for (int i = 0; i < v.size(); i++) {
        if (dp[i] == max_sequence) {
            print_path(i, max_sequence - 1);
            
        }
    }
    cout << max_sequence << endl;
    for (int i = 0; i < max_sequence; i++) {
        cout << final_answer[i] << endl;
    }
    cout << endl;

    return 0;
}
