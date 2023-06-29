num = 0
while True:
	num += 1
	mine_row, mine_col = map(int, input().split())
	matrix = []
	for i in range(mine_row):
		matrix.append(list(input()))
	if (mine_row == 0) and (mine_col == 0):
		break
	print(f"Field #{num}:")
	
	for i in range(mine_row):
		for j in range(mine_col):
			mine_info = 0
			if matrix[i][j]==".":
				for y in range(i-1, i+2):
					for x in range(j-1, j+2):
						if not (y < 0 or x < 0 or y >= mine_row or x >= mine_col):
							if matrix[y][x] == "*":
								mine_info += 1
				matrix[i][j] = mine_info
				print(matrix[i][j], end="")
			else:
				print(matrix[i][j], end="")
		print()
	print()