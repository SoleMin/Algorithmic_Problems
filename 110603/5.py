sum_num=list()
sum_num.append(int(2))
sum_num.append(int(5))
sum_num.append(int(13))

for i in range(3,500):
	sum_num.append(sum_num[i-1]+sum_num[i-1]+sum_num[i-2]+sum_num[i-3])

while(1):
	try:
		n=input()
		n=int(n)
		print(sum_num[n-1])
	except:
		break