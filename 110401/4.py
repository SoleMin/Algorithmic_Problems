testcase = int(input())
data = []
while True:
	try:
		line = input().split()
		data.append(list(map(int, line)))
	except EOFError:
		break
		
def findDistance(line):
	NOH = line.pop(0)
	if NOH == 2:
		return print(line[1] - line[0])
	else:
		middle = line[int(len(line) / 2)]
	
	lst = []
	for idx, value in enumerate(line):
		if idx == line.index(middle) and value == middle:
			continue
		else:
			lst.append(abs(middle - value))
	print(sum(lst))
	
for line in data:
	findDistance(line)