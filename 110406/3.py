from collections import defaultdict
testcase=int(input())
test=0
start=input()
while test<testcase:
	test+=1
	timelist=list(map(int,input().split()))
	roadlist=[]
	try:
		while True:
			carname,mdhm,enter,pos=map(str,input().split())
			M,d,h,m=map(int,mdhm.split(':'))
			imformationlist=[carname,(M,d,h,m),enter,int(pos)]
			roadlist.append(imformationlist)
			# print(roadlist)
	except:
		print('',end='')
	roadlist=sorted(roadlist,key=lambda item:item[0])
	# print(roadlist)
	roadlist=sorted(roadlist,key=lambda item:item[1])
	enterlist={}
	outputdict=defaultdict(int)
	monthdict=defaultdict(list)
	for road in roadlist:
		# print(road)
		if road[0] not in enterlist:
			if road[2]=='enter':#name time enter km
				enterlist[road[0]]=(road[1],road[3])		
		else:
			if road[2]=='enter':
				enterlist[road[0]]=(road[1],road[3])
			else:
				time,km=enterlist[road[0]]
				M,d,h,m=time
				if M==road[1][0]:
					if M not in monthdict[road[0]]:
						monthdict[road[0]].append(M)
					money=timelist[h]
					distance=abs(km-road[3])
					output=money*(distance) #cent임)
					output=round(output/100,2)
					outputdict[road[0]]+=(output+1)
					del enterlist[road[0]]
				else:
					del enterlist[road[0]]
	Outlist=list(outputdict.keys())
	Outlist.sort()
	for i in Outlist:
		print(f'{i} ${outputdict[i]+2*len(monthdict[i]):.2f}')
	print()