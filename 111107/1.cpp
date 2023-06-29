#include <iostream>
#include <algorithm>
#include <string.h>
#include <stdlib.h>
#define N 2000
#define M 6000
using namespace std;

long long  dp[M], w[M], cost[M];

void read_input(int n){
 for (int i = n; i >= 1; i--){
           cin >> w[i];
	}
}

void calc_cost(int n){
   for (int i = 2; i <= n; i++){
        cost[i] = (w[i]-w[i-1])*(w[i]-w[i-1]);
	}
}

void clear_dp_array(){
   memset (dp, 0, sizeof(dp));
}

void dynamic_program(int n, int m){
    for (int j = n; j >= m; j--){
         dp[j] = dp[j-2]+cost[j];
	 }
    for (int j = m+1; j <= n; j++){
         if (dp[j-1] < dp[j]){
             dp[j] = dp[j-1];
			}
	}
}

int main()
{
    int test_case, n, k;
    cin >> test_case;
    while (test_case--)
    {
        cin >> k >> n;
        k += 8;

		  read_input(n);
		  calc_cost(n);
		  clear_dp_array();

        for (int i = 1; i <= k; i++)
        {
            int m = 3*i;
				dynamic_program(n,m);
        }
        cout << dp[n] << endl;
    }
    return 0;
}