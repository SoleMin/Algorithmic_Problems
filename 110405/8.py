case = int(input())


for i in range(case):
	space = input()
	job = int(input())
	t = {}
	for j in range(job):
		a,b = map(int,input().split())
		t[j+1] = b/a
	t = sorted(t.items(),key= lambda x: x[1], reverse = True)
	for j in t:
		print(j[0], end=' ')
	
	print('\n')
	