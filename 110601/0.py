dp = [0] * 1000000
while True:
	a, b = map(int, input().split())
	if a == 0 and b == 0:
		break
	i = 1
	idx = 0
	while True:
		if i == 1:
			dp[i] = 1
		elif i == 2:
			dp[i] = 2
		else:
			dp[i] = dp[i-1] + dp[i-2]
		if dp[i] >= b:
				break
		if dp[i] <= a:
			idx = i
		i += 1
	
	if a == b:
		if a in dp:
			print(1)
		else:
			print(0)
	elif dp[idx] == a  and dp[i] == b:
			print(i - idx + 1)
	elif dp[idx] == a:
		print(i - idx)
	elif dp[i] == b:
		print(i - idx)
	else:
		print(i - idx - 1)
			