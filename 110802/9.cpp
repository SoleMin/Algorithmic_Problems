#include <iostream>
#include <climits>
#include <string>
#include <algorithm>
 
using namespace std;
 
const int y_move[4] = {0, 0, +1, -1};
const int x_move[4] = {+1, -1, 0, 0};
const int direction[4] = {'R', 'L', 'D', 'U'};
const int MAX_N = 50;
string path;
int P[15][15], e_y, e_x;
 
int limits()
{
    int limit = 0;
    for (int y = 0; y < 4; y++)
    {
        for (int x = 0; x < 4; x++)
        {
            if (P[y][x] == 0)
                continue;
            int goal_y = (P[y][x] - 1) / 4;
            int goal_x = (P[y][x] - 1) % 4;
            limit += abs(goal_y - y) + abs(goal_x - x); 
        }
    }
    return limit;
}
 
bool dfs(int curr, int prev, int bound)
{
    int limit = limits();
    if (limit == 0)
        return true;
    if (curr + limit > bound)
        return false;
 
    for (int i = 0; i < 4; i++)
    {
        if (i == (prev ^ 1))  
            continue;
 
        int ny = e_y + y_move[i];
        int nx = e_x + x_move[i];
        if (ny < 0 || ny >= 4)
            continue;
        if (nx < 0 || nx >= 4)
            continue;
 
        path.push_back(direction[i]);
        swap(P[ny][nx], P[e_y][e_x]);
        swap(ny, e_y);
        swap(nx, e_x);
        if (dfs(curr + 1, i, bound))
            return true;
        swap(ny, e_y);
        swap(nx, e_x);
        swap(P[ny][nx], P[e_y][e_x]);
        path.pop_back();
    }
 
    return false;
}
 
bool check()
{
    for (int limit = limits(); limit <= MAX_N; ++limit)
    {
        if (dfs(0, -1, limit))
            return true;
    }
    return false;
}
 
bool solvable()
{
    int n = 0;
    bool occur[16] = {false};
    for (int y = 0; y < 4; y++)
    {
        for (int x = 0; x < 4; x++)
        {
            if (P[y][x] == 0)
            {
                e_y = y;
                e_x = x;
            }
            else
            {
                n += count(occur + 1, occur + P[y][x], false);
                occur[P[y][x]] = true;
            }
        }
    }
    return ((n + (e_y + 1)) & 1) == 0;
}
 
int main()
{
    int n;
    scanf("%d", &n);
    while (n--)
    {
        for (int y = 0; y < 4; y++)
        {
            for (int x = 0; x < 4; x++)
            {
                scanf("%d", &P[y][x]);
            }
        }
        path.clear();
        if (!solvable() || !check())
        {
            puts("This puzzle is not solvable.");
        }
        else
        {
            printf("%s\n", path.c_str());
        }
    }
    return 0;
}