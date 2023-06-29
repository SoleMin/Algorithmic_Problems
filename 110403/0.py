x = int(input())

for _ in range(x):
	n = input()
	n = int(input())
	
	a = []
	for _ in range(n):
		a.append(int(input()))
	
	res = 0
	
	while True:
		a.sort()
		if len(a) == 3:
			res += sum(a)
			break
		elif len(a) == 2:
			res += max(a)
			break
		else:
			pass

		if a[0] + a[-2] >= 2 * a[1]:
			res += a[0] + (a[1] * 2) + a[-1]
			a = a[:-2]
		else:
			res += a[0] * 2 + a[-1] + a[-2]
			a = a[:-2]

	print(res)
	print()
	
#1 2 2 2 2 2 2







