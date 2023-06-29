dp = [0] * 9999999
while True:
	num = int(input())
	if num == 0:
		break
	i = 1
	n = 0
	while True:
		if i == 1:
			dp[1] = 1
		else:
			dp[i] = n + 1
			for j in range(pre, i):
				dp[j] = n
		if num <= i:
			break
		n += 1
		pre = i
		i = dp[n] + i
	
	if num == i:
		print(n + 1)
	else:
		print(n)