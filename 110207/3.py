casenum=int(input())
CN=0
start=input()
while CN<casenum:

	CN+=1
	snapshotlist=[]
	while True:
		try:
			Inputlist=input()
			if Inputlist=='':
				break
			else:
				teamnum, questionnum, time, output=map(str,Inputlist.split())
				snapshotlist.append([int(teamnum),int(questionnum),int(time),output])
		except EOFError:
			break
			
	#teamscorelist=[맞춘갯수,시간벌점,teamnum] sortreverse, sort, sort
	teamdict={}
	correctdict={}
	snapshotlist.reverse()
	for i in snapshotlist:
		if i[0] not in teamdict:
			teamdict[i[0]]=[0,0,i[0]]
			correctdict[i[0]]=[]
		
		if i[3]== 'C':
			teamdict[i[0]][0]+=1
			teamdict[i[0]][1]+=i[2]
			correctdict[i[0]].append(i[1])
		elif i[3]=='I':
			if i[1] in correctdict[i[0]]:
				teamdict[i[0]][1]+=20
				
			
	
	
	
	
	
	teamscorelist=[]
	for i in teamdict:
		a,b,c=map(int,teamdict[i]) #맟춘갯수. 시간벌점 teamnum
		teamscorelist.append((c,a,b))
	
	teamscorelist.sort(key=lambda x:x[0])
	teamscorelist.sort(key=lambda x:x[2])
	teamscorelist.sort(key=lambda x:-x[1])
	
	for j in teamscorelist:
		print(*j)
	
	print()
		
		
