while True:
	try:
		n = int(input())
		dp = [0] * (n+1)
		i = 1
		while True:
			if i == 1:
				dp[i] = 1
			elif i == 2:
				dp[i] = 3
			elif i == 3:
				dp[i] = 5
			elif i == 4:
				dp[i] = 9
			elif i == 5:
				dp[i] = 13
			elif i == 6:
				dp[i] = 17
			else:
				import sys
				
				m = sys.maxsize
				for j in range(1, i):
					temp = 2 * dp[j] + (2 ** (i - j) - 1)
					if m > temp:
						m = temp
				dp[i] = m
			if i == n:
				break
			i += 1
		print(dp[n])
	except EOFError:
		break