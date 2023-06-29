while True:
	try:
		a = list(input())
		b = list(input())
		ch = []
		for c in a:
			if c in b:
				b.pop(b.index(c))
				ch.append(c)
		ch.sort()
		for c in ch:
			print(c, end="")
		print()
	except EOFError:
		break