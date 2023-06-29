import sys
while(1):
	numbers = sys.stdin.readline().rstrip()
	if (len(numbers) == 0):
		break
	numbers = list(map(int, numbers.split()))
	
	n = numbers[0]
	numbers = numbers[1:]
	check = [0] * n 
	flag = True
	check[0] = 1
	
	for i in range(n - 1):
		if (abs(numbers[i] - numbers[i+1] ) > n -1 or check[abs(numbers[i] - numbers[i+1])] == 1):
			flag = False
			break
		check[abs(numbers[i] - numbers[i+1])] = 1
	
	
	if (flag):
		print("Jolly")
	else:
		print("Not jolly")