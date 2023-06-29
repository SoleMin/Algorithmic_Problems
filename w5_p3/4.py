# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
def KMP_table(pattern):
	lp = len(pattern)
	tb = [0 for i in range(lp)]
	
	pidx = 0
	for idx in range(1, lp):
		while pidx > 0 and pattern[idx] != pattern[pidx]:
			pidx = tb[pidx-1]
			
		if pattern[idx] == pattern[pidx]:
			pidx += 1
			tb[idx] = pidx
			
	return tb

def KMP(word, pattern):
	table = KMP_table(pattern)
	
	results = []
	pidx = 0
	
	for idx in range(len(word)):
		while pidx > 0 and word[idx] != pattern[pidx]:
			pidx = table[pidx-1]
			
		if word[idx] == pattern[pidx]:
			if pidx == len(pattern)-1:
				results.append(idx-len(pattern)+2)
				pidx = table[pidx]
			else:
				pidx += 1
				
	return results

word=input()
pattern=input()

res=KMP(word, pattern)
print(len(res))
print(*res, sep=' ')