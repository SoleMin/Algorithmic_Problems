x = int(input())

for _ in range(x):
	n = input()
	n = int(input())
	
	a = []
	for _ in range(n):
		a.append(list(map(int, input().split()))) #걸리는 날수 : t, 하루당 벌금 : s
	
	b = a.copy()
	res = []
	#print('a : ',a)
	while True:
		if b == []:
			break
	
		for i in range(len(b)):
			h = 0
			for j in range(len(b)):
				if i == j:
					continue
				
				#print(' x : ',a[i][0] * a[j][1])
				#print(' y : ',a[i][1] * a[j][0])
				
				if b[i][0] * b[j][1] > b[i][1] * b[j][0]:
					h = 1
					break
			
			if h == 1:
				#print(' i : j : ',i,' ',j)
				continue
			else:
				#print('i, j : ',i,', ',j)
				#print('a[i] : ',a[i])
				res.append(b[i])
				b.remove(b[i])
				break
	
	num = []
	for i in res:
		for j in range(n):
			if j+1 in num:
				continue
				
			if i == a[j]:
				num.append(j+1)
				break
				
	print(*num)
	print()
	
'''
3 1    2 5
4 1000 2 5

1 1 2
 1

=> 2 1 3 4

1 2 3 4 5 6 7 8 9 10 11 12
1 3 3 3 2 2 5 5 5 5  5 
'''


