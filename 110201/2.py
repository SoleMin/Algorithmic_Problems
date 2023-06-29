while True:
	try:
		nums = list(map(int, input().split()))
		checks = [False] * nums[0]

		for i in range(1, len(nums)-1):
			idx = abs(nums[i+1] - nums[i])
			if idx >= len(checks):
				break
			checks[idx]=True
		if False in checks[1:]:
			print("Not jolly")
		else:
			print("Jolly")
	except:
			break