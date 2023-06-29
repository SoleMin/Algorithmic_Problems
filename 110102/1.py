field_num = 1
while True:
	M, N = map(int, input().split())
	
	
	if M == 0 and N == 0:
		break
	board = []
	for i in range(M):
		board.append(list(input()))
		
	for x in range(M):
		for y in range(N):
			if board[x][y] == '*':
				continue
			count = 0
			for a in range(x - 1, x + 2):
				for b in range(y - 1, y + 2):
					if a < 0 or b < 0 or a >= M or  b >= N:
						continue
					if board[a][b] == '*':
						count += 1
			board[x][y] = count
	print(f'Field #{field_num}:')
	for row in board:
		print(*row, sep="")
	field_num += 1
	print()