T = int(input())
input()
for _ in range(T):
	dic = {}
	while True:
		try:
			line = input().split()
			if len(line) == 0:
				break
			if line[1] in dic.get(line[0], [[], 0, {}])[0]:
				continue
			time = dic.get(line[0], [[], 0, {}])[1]
			nums = dic.get(line[0], [[], 0, {}])[0]
			incor_nums = dic.get(line[0], [[], 0, {}])[2]
			if line[3] == 'C':
				if line[1] in incor_nums.keys():
					time += incor_nums[line[1]]
				time += int(line[2])
				nums.append(line[1])
			elif line[3] == 'I':
				incor_nums[line[1]] = incor_nums.get(line[1], 0) + 20
			dic[line[0]] = [nums, time, incor_nums]
		except EOFError:
			break
	dic = sorted(dic.items(), key=lambda x: [-len(x[1][0]), x[1][1], x[0]])
	for d in dic:
		print(f'{d[0]} {len(d[1][0])} {d[1][1]}')
	print()
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	