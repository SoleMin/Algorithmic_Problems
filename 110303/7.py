# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
while(True):
	try:
		a=list(input())
		b=list(input())
		
		ans_ch=[]
		ans=''
		for ch in a:
			for i in range(len(b)):
				if ch==b[i]:
					b.remove(ch)
					ans_ch.append(ch)
					break
		
		ans_ch.sort()
		for c in ans_ch:
			ans+=c
		print(ans)
	except EOFError: break