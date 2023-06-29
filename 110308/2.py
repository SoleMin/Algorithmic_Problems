Inputlist=''
def longsentence(Inputlist):
	A=Inputlist.split()
	seq=0
	longsetlist=[]
	for i in A:
		if len(i)>72:
			longsetlist.append(len(i)-1)
			seq+=1
	return longsetlist

def wordslice(Inputlist):
	lslist=longsentence(Inputlist)

	k=0 #긴단어가 몇개 있는지 해주는거
	
	countword=0
	countspace=0
	
	startpoint=0 #(startpoint,endpoint) 형태로 출력하라 라고 할꺼임
	
	pointline=[] # \n를 써야하는 input의 지점을 저장할 공간
	for i in range(len(Inputlist)):
		countword+=1
		if Inputlist[i]==' ':
			countspace+=1
		
		if countword==73 and countspace==0:# 엄청긴 단어임...
			pointline.append((startpoint,startpoint+lslist[k]))
			startpoint=startpoint+lslist[k]+2 #spacebar까지 포함해주어야 하죠 다음 글도
			countword=72-lslist[k]
			k+=1
			countspace=0

		elif countword==73:
			if Inputlist[i]==' ':
				pointline.append((startpoint,i-1))
				startpoint=i+1
				countword=0
				countspace=0	
			else:
				for back in range(1,72):
					if Inputlist[i-back]==' ':
						break
				pointline.append((startpoint,i-back-1))
				startpoint=i-back+1
				countword=back
				countspace=0
	if len(Inputlist)<72:
		pointline.append((0,len(Inputlist)))
	else:
		pointline.append((startpoint,i))
	return pointline

try:
	while True:
		A=input()
		if A=='':
			point=wordslice(Inputlist)
			for i in point:
				start,end=i
				print(Inputlist[start:end+1])
			print()
			Inputlist=''
		else:
			Inputlist=Inputlist+A+' '
			
except:
	point=wordslice(Inputlist)
	for i in point:
		start,end=i
		print(Inputlist[start:end+1])

