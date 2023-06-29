#include <iostream>
#include<vector>
using namespace std;

int y, x;

int cury[9] = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
int curx[9] = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

int search(int my, int mx, vector<vector <char>> &board, vector<vector<int>> &ret)
{
	if(my < 0 || my >= y || mx < 0 || mx >= x)
		return 0;
	
	if(board[my][mx] == '*')
	{
		ret[my][mx] = -1;
		for(int i = 0; i < 9; i++)
		{
			if(my+cury[i] < 0 || my+cury[i] >=y || mx + curx[i] < 0 || mx + curx[i] >= x)
				continue;
			
			if(board[my + cury[i]][mx + curx[i]] != '*')
			{
				ret[my+cury[i]][mx + curx[i]] += 1; 
	 	  }
		}
		 return search(my + 1, mx, board, ret);
	}
							 
	else
	{
		if(board[my][mx] != '*')
			return search(my +1, mx, board, ret);
  }
}
int main() 
{
	int tmp = 1;
	do{
		cin >> y >>x;
		vector<vector<char>> board(y, vector<char>(x,0));
		vector<vector<int>> ret(y, vector<int>(x,0));
		if(y==0 && x==0)
			return 0;
		
		for(int i = 0; i < y; i++)
			for(int j=0; j<x; j++)
				cin >> board[i][j];
	
		//cout << endl;
		
		for(int i = 0; i<x; i++)
		{
			search(0, i, board, ret);
		}
		
		cout << "Field #" << tmp <<":" <<endl;
		
		for(int i = 0; i<y; i++)
		{
			for(int j =0; j<x; j++)
			{
				if(ret[i][j] == -1)
					cout << '*';
				else
					cout << ret[i][j];
			}
			cout << endl;
		}
		
		cout << endl;
		tmp++;
	}while(y != 0 && x != 0);
	
	return 0;
}