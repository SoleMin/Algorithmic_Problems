import sys
from collections import defaultdict
T=sys.stdin.readline().rstrip()
P=sys.stdin.readline().rstrip()

	#i는 들어가는 리스트 장소 i+1은 글자수 0 1 2 읽히지만 0 1만 할꺼니까 i가 들어가면됨
def checkmax(P):
	plist=defaultdict(int)
	count=0      #칸 이동 수 
	start=0
	end=1
	find=False# 비교대상이 되는위치 + 글자수가 되겠습니다
	while end<len(P):
		if P[start]==P[end]:
			count+=1
			plist[end]=count
			start+=1
			find=True
		else:
			if find:
				count=0
				start=0
				find=False
		end+=1
	return plist
plist=checkmax(P)
plist[0]=0
Max=max(list(plist.values()))
j=0
countlist=[]
for i in range(len(T)):
	
	if j>0 and T[i]!=P[j]:
		j=plist[j-1]
	if T[i]==P[j]:
		if j==len(P)-1:
			countlist.append(i-len(P)+2)
			j=plist[j] # 내부에 겹칠 수도 있으니까 일루 이동함
		else:
			j+=1
	# print(i)
# print('답은 ',end='')
print(len(countlist))
print(*countlist)

