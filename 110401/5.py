a = 0
test_case = int(input())
house = []
while a < test_case:
	distance = []
	test = list(map(int, input().split()))
	for i in range(1, test[0]+1):
		d = test[test[0]-i+1] - test[i]
		if d < 0:
			continue
		else:
			distance.append(d)
	print(sum(distance))
	a += 1