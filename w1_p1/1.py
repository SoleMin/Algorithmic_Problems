
while True:
	try:
		st = input().split()
		num = 0
		for s in st:
			num += len(s)
		print(num, len(st))
	except EOFError:
		break
	
