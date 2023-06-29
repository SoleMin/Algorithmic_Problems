# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
testcase = int(input())

def find_word(grid, word):
	direction = [(1,0), (-1,0),(0,1), (0, -1), (1,1), (-1,-1), (1,-1), (-1,1)]
	
	lenCol = len(grid[0])
	for line in range(len(grid)):
		for letter in range(lenCol):
			if grid[line][letter] != word[0]:
				continue
			
			for dir_ in direction:
				for lenWord in range(len(word)):
					dirX = line + dir_[1] * lenWord
					dirY = letter + dir_[0] * lenWord
					
					if dirY < 0 or dirY>=lenCol or dirX < 0 or dirX>=len(grid):
						break
					if grid[dirX][dirY] != word[lenWord]:
						break
				else:
					print(line + 1, letter + 1)
					return

while testcase > 0:
	try:
		new_line = input()
		if new_line =='':
			pass
		
		col, row = map(int, input().split(' '))
		grid = [input().lower() for _ in range(col)]
		num_word = int(input())
		words = [input().lower() for _ in range(num_word)]
		
		for word in words:
			find_word(grid, word)
		
		print()
		testcase -= 1
	except EOFError:
		break
		
		
		
		