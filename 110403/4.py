testcase=int(input())
test=0
def case1(alphalist,speednum): #1이 갔다오고 갔다오고
	T=alphalist[-1]+alphalist[-2]+2*alphalist[0]
	return T
def case2(alphalist,speednum):
	T=alphalist[-1]+2*alphalist[1]+alphalist[0]
	return T

while test<testcase:
	test+=1
	start=input()
	n=int(input())
	speednum=[]
	for _ in range(n):
		speednum.append(int(input()))
	speednum.sort()
	alphalist=speednum.copy()
	betalist=[]
	time=0
	while len(betalist)!=len(speednum):
		# print(alphalist)
		# print(betalist, time)
		if len(alphalist)==3:
			for i in alphalist:
				time+=i
				betalist.append(i)
		elif len(alphalist)<=2:
				time+=alphalist[1]
				betalist.append(alphalist[0])
				betalist.append(alphalist[1])
		else:
			C1=case1(alphalist,speednum)
			C2=case2(alphalist,speednum)
			# print(C1,C2)
			if C1>C2:
				time+=alphalist[-1]+2*alphalist[1]+alphalist[0]
				betalist.append(alphalist.pop())
				betalist.append(alphalist.pop())
			else:
				time+=alphalist[-1]+alphalist[0]
				betalist.append(alphalist.pop())
	print(time)
	print()
					
	#순서가 잘못된거네 일단 2를 갔다놓고 판단하는거야 cost값이 어떤지 만약에 C1이 비싸면 C2를 이용하면 되는거지 