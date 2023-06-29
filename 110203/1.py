T = int(input())

for _ in range(T):
	N = int(input())
	P = int(input())
	h = []
	for __ in range(P):
		h.append(int(input()))
	s = set()
	for i in h:
		j = 1
		while i * j <= N:
			if (i * j) % 7 != 0 and (i * j) % 7 != 6:
				s.add(i * j)
			j += 1
	print(len(s))