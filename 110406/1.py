A = int(input())
input()
for _ in range(A):
	cost = list(map(int, input().split()))
	record = {}
	while True:
		try:
			line = input().split()
			if not line:
				break
			if line[0] in record:
				record[line[0]].append(line[1:])
			else:
				record[line[0]] = [line[1:]]
		except EOFError:
			break
	for i in sorted(record.keys()):
		if len(record[i]) == 1:
			continue
		record[i].sort(key=lambda x: int(x[0].replace(':', '')))
		pay = 200
		check = False
		for j in range(len(record[i])):
			A = record[i][j]
			if A[1] == 'enter':
				distance = int(A[2])
				check = True
				time_cost = cost[int(A[0][6:8])]
			elif A[1] == 'exit' and check:
				distance = abs(distance - int(A[2]))
				check = False
				pay += (time_cost * distance + 100)
		if pay == 200:
			continue
		print(f'{i} ${pay / 100:.2f}')
	print()
