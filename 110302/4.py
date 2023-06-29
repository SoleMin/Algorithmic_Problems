import sys;
T = int(sys.stdin.readline())
sys.stdin.readline()
idx = 0

def check(x, y, board, word):
	flag = False
	
	for i in range(len(word)):
		dx = x + i
		if (dx < 0 or dx >= n):
			break
		if(board[dx][y] != word[i]):
			break
		if(i == len(word) - 1):
			flag = True
	
	for i in range(len(word)):
		dx = x - i
		if(dx < 0 or dx >= n):
			break
		if(board[dx][y] != word[i]):
			break
		if ( i == len(word) - 1):
			flag = True
	
	for i in range(len(word)):		
		dy = y + i
		if (dy < 0 or dy >= m):
			break
		if (board[x][dy] != word[i]):
			break
		if (i == len(word) - 1):
			flag = True
	
	for i in range(len(word)):
		dy = y - i
		
		if (dy < 0 or dy >= m):
			break
		if (board[x][dy] != word[i]):
			break
		if ( i == len(word) - 1):
			flag = True
		
		
	for i in range(len(word)):
		dx = x + i
		dy = y + i
		
		if (dx < 0 or dy < 0 or dx >= n or dy >= m):
			break
		if(board[dx][dy] != word[i]):
			break
		if (i == len(word) - 1):
			flag = True
	
	for i in range(len(word)):
		dx = x + i
		dy = y - i
		
		if (dx < 0 or dy < 0 or dx >=n or dy >= m):
			break
		if (board[dx][dy] != word[i]):
			break
		if (i == len(word) - 1 ):
			flag = True
	
	
	for i in range(len(word)):
		dx = x - i
		dy = y + i
		
		if (dx < 0 or dy < 0 or  dx >= n or dy >= m):
			break
		if(board[dx][dy] != word[i]):
			break
		if (i == len(word) - 1):
			flag = True
	
	
	for i in range(len(word)):
		dx = x - i
		dy = y - i
		
		if (dx < 0 or dy < 0 or dx >= n or dy >= m):
			break
		if (board[dx][dy] != word[i]):
			break
		if (i == len(word) - 1):
			flag = True
	
	return flag


while( idx < T):
	n, m = map(int, sys.stdin.readline().split());
	board = [sys.stdin.readline().rstrip().lower() for _ in range(n)]
	k = int(sys.stdin.readline())
	wordList = []
	for i in range(k):
		wordList.append(sys.stdin.readline().rstrip().lower())
	
	ans = []
	
	for word in wordList:
		flag = False
		for i in range(len(board)):
			for j in range(len(board[i])):
				if (board[i][j] == word[0]):
					if (check(i,j,board, word)):
						if (not flag):
							ans.append(str(i+1) + " " + str(j+1))
							flag = True
			
	
	print("\n".join(ans) +"\n")
	sys.stdin.readline()
	idx += 1