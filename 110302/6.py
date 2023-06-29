# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
def find(row,column,word_list,find_word):
	xx=[-1,0,1]
	yy=[-1,0,1]
	
	ans=[]
	for fw in find_word:
		temp=[]
		for i in range(row):
			for j in range(column):
				for x in xx:
					for y in yy:
						if x==0 and y==0:
							continue
						for n,ch in enumerate(fw):
							r=i+x*n
							c=j+y*n
							
							if r<0 or c<0 or r>=row or c>=column:
								break
							if ch!= word_list[r][c]:
								break
						else:
							temp.append([str(i+1),str(j+1)])
		if len(temp)>1:
			temp.sort(key=lambda x:x[0])
			ans.append(temp[0])
		else:
			ans.append(temp[0])
	return ans
					
n=int(input())

for i in range(n):
	space_line=input()
	word_list=[]
	find_word=[]
	row,column=map(int,input().split())
	
	for j in range(row):
		word_list.append(input().lower())
		
	word_num=int(input())
	
	for wn in range(word_num):
		find_word.append(input().lower())
	ans=find(row,column,word_list,find_word)
	
	for rc in ans:
		print(" ".join(rc))
	
	print()
	