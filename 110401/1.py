T = int(input())

for _ in range(T):
	rs = list(map(int, input().split()))
	s = rs[1:]
	if len(s) == 1:
		print(0)
	else:
		s.sort()
		mid = (len(s) - 1) // 2
		sum1 = 0
		sum2 = 0
		for i in range(len(s)):
			sum1 += abs(s[i] - s[mid])
		for i in range(len(s)):
			sum2 += abs(s[i]-s[mid+1])
		if sum1 > sum2:
			print(sum2)
		else:
			print(sum1)
			