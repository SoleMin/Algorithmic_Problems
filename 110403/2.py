n = int(input())

for _ in range(n):
	input()
	time = []
	T = int(input())
	for __ in range(T):
		time.append(int(input()))
	time.sort()
	total = 0
	while True:
		if len(time) == 1 or len(time) == 2:
			total += time.pop()
			break
		elif len(time) == 3:
			total += time.pop()
			total += time.pop()
			total += time.pop()
			break
		firstA = time[0]
		firstB = time[1]
		lastA = time.pop()
		lastB = time.pop()
		if lastB + firstA > 2 * firstB:
			total += (firstB + firstA + lastA + firstB)
		else:
			total += (lastA + firstA + lastB + firstA)
	print(total)
	print()
		

	