# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
from collections import deque

alp = 'abcdefghijklmnopqrstuvwxyz'

def read():
	d = set()
	word = input()
	while word!='':
		d.add(word)
		word=input()
		
	return d

def readword():
	case=[]
	while True:
		try:
			case_in=tuple(input().split())
			case.append(case_in)
			
		except EOFError: break
	return case

def word_check(w,dic):
	words=[]
	
	for pos in range(len(w)):
		for c in alp:
			word = w[:pos]+c+w[(pos+1):]
			if word in dic and word!=w:
				words.append(word)
				
	return words

def bfs(start, end, dic):
	if start==end:
		return [start,end]
	
	add_end=end not in dic
	if add_end:
		dic.add(end)
		
	parent={}
	q=deque([start])
	
	while q:
		word=q.popleft()
		if word==end:
			break
			
		for w in word_check(word,dic):
			if w not in parent.keys():
				parent[w]=word
				q.append(w)
				
	if add_end:
		dic.remove(end)
		
	if word != end:
		return []
	
	path=[word]
	while parent[word]!=start:
		path.append(parent[word])
		word=parent[word]
	path.append(start)
	
	return list(reversed(path))

dic=read()
words=list(reversed(readword()))

while words:
	start, end=words.pop()
	
	ans=bfs(start, end, dic)
	if not ans:
		print('No solution.')
		
	else:
		[print(w) for w in ans]
		
	if words:
		print()