testcase = int(input())

while testcase > 0:
	try:
		new_line = input()
		if new_line == '':
			pass
		n = int(input())
		p = [list(map(int, input().split())) for _ in range(n)]
		
		dictWithList = dict(enumerate(p, start=1))
		sortedByRate = dict(sorted(dictWithList.items(), key=lambda item: item[1][0] / item[1][1]))
		
		keys = list(sortedByRate.keys())
		for i in keys:
			print(i, end=" ")
		if testcase > 0:
			testcase -=1
			print()
			print()
	except EOFError:
		break