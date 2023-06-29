test_case = int(input())
for i in range(test_case):
	date = int(input())
	party = int(input())
	h =[]
	for i in range(party):
		h.append(int(input()))
	lost = 0
	for i in range(1, date+1):
		if ((i-1) % 7 < 5):
			for j in range(party):
				if (i % h[j] == 0):
					lost += 1
					break
	print(lost)