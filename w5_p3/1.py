#  -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
def KMP(pat, txt):
	lenPattern = len(pat)
	lenTxt = len(txt)
	
	next = computeNext(pat)
	
	i = 0
	j = 0
	
	pos = []
	while i < lenTxt:
		if pat[j] == txt[i]:
			i+=1
			j+=1
		elif pat[j] != txt[i]:
			if j != 0:
				j = next[j-1]
			else:
				i+=1
				
		if j == lenPattern:
			pos.append(i-j+1)
			j = next[j-1]
	print(len(pos))
	for i in pos:
		print(i, end=" ")
	
def computeNext(pat):
	leng = 0
	next = [0 for i in range(len(pat))]
	
	i = 1
	while i < len(pat):
		if pat[i] == pat[leng]:
			leng +=1
			next[i] = leng
			i +=1
		else:
			if leng != 0:
				leng = next[leng - 1]
			else:
				next[i] = 0
				i+=1
	return next

txt = input()
pattern = input()
KMP(pattern, txt)
	
	