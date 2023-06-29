try :
	arr = [2,5,13]
	for i in range(3,1000):
		arr.append(2*arr[i-1] + arr[i-2] + arr[i-3])
	while True:
			num = int(input())
			print(arr[num-1])
except:
	pass