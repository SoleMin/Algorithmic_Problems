testcase=int(input())
test=0
while test<testcase:
	test+=1
	start=input()
	N=int(input())
	inputdict={}
	for i in range(N):
		jobnum, money=map(int,input().split())
		inputdict[i+1]=money/jobnum
	sorteddictlist=sorted(inputdict.items(),key=lambda item: item[0])
	sorteddictlist=sorted(sorteddictlist,key=lambda item: item[1],reverse=True)
	for j in sorteddictlist:
		a,b=j
		print(a,end=' ')
	print()
	print()
