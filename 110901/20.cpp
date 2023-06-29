#include <stdio.h>
#include <algorithm>
static int n, adjm[200][200];
static int color[200];
static int colorable;

void dfs(int, int);

 int main(void) {
    while (1) {
        int e;
        scanf("%d", &n);
        if (!n) {
            return 0;
        }
        for (size_t i = 0; i < n; i++)
        {
            for (size_t j = 0; j < n; j++)
            {
                adjm[i][j] = 0;
            }
            
        }
        
        scanf("%d", &e);
        for (size_t i = 0; i < e; i++)
        {
            int a, b;
            scanf("%d %d", &a, &b);
            adjm[a][b] = 1;
            adjm[b][a] = 1;

        }
        for (size_t i = 0; i < n; i++)
        {
            color[i] = 0;
        } 
        colorable = 1;
        dfs(0, 1);
        if (colorable)
        {
            printf("BICOLORABLE.\n");
        }
        else
        {
            printf("NOT BICOLORABLE.\n");
        }
        
        
    }
    
    
 }
 
 void dfs(int node, int c) {
    color[node] = c;
    for (size_t i = 0; i < n && colorable; i++)
    {
        if (!adjm[node][i]) {
            continue;
        }
        if (!color[i]) {
            dfs(i, c % 2 + 1);
        } else {
            if (color[i] == c) {
                colorable = 0;
                return;
            }
        }
    }
    
 }

 