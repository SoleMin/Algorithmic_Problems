while True:
	try:
		n = int(input())
		dp = [0] * 1000
		i=0
		while True:
			if i == 1:
				dp[i] = 2
			elif i == 2:
				dp[i] = 5
			elif i == 3:
				dp[i] = 13
			else:
				dp[i] = 2 * dp[i-1] + dp[i-2] + dp[i-3]
			if i == n:
				break
			i += 1
		print(dp[i])
	except EOFError:
		break
	