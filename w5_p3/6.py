# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
text = input()
pattern = input()

text_length = len(text)
pattern_length = len(pattern)


# 접미사, 접두사 공통부분을 찾기 위한 실패테이블을 만든다.
def makeIps(pattern,lps):
	lps = [0]*(pattern_length)
	idx = 0
	for i in range(1,len(pattern)):
		while(idx > 0 and pattern[i] != pattern[idx]):
			idx = lps[idx-1]
		if pattern[i] == pattern[idx]:
			idx +=1
			lps[i] = idx
			
	#print(lps)
	return lps

def KMP(pattern,text):
	res = []
	lps = [0]*(pattern_length)
	lps=makeIps(pattern,lps)
	i = 0
	j = 0
	
	while i < text_length:
		if pattern[j] == text[i]:
			i+=1
			j+=1
		elif pattern[j] != text[i]:
			if j != 0:
				j = lps[j-1]
			else:
				i+=1
				
		# 패턴을 찾은경우
		if j == pattern_length:
			res.append((i-j)+1)
			j = lps[j-1]
	
	print(len(res))
	
	for i in res:
		print(i,end=" ")
			
KMP(pattern,text)


