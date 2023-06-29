# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
data = []
while True:
	try:
		arr = list(map(int, input().split()))
	except EOFError:
		break
	data.append(arr)

for i in data:
	now = i
	first = now.pop(0)
	isJolly = True
	present = [0 for i in range(first)]
	
	for idx, value in enumerate(now):
		length = len(now)
		if idx < length-1:
			nowValue = now[idx]
			nextValue = now[idx+1]
			
			diff = abs(nowValue - nextValue)
			if diff <=0 or diff >=first or present[diff] >= 1:
					isJolly = False
					break
			elif len(now) == 1 or len(present) == 1:
				print("Jolly")
			else:
				present[diff] += 1
	print("Jolly" if isJolly else "Not jolly")