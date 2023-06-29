result = [2,5,13]

def gustabo(n):
	if n > len(result):
		for i in range(len(result), n):
			result.append(2 * result[i - 1] + result[i - 2] + result[i - 3])
	return result[n-1]

numbers = []
while True:
	try:
		line = int(input())
		numbers.append(line)
	except EOFError:
		break
		
for item in numbers:
	print(gustabo(item))