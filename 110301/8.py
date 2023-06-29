# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
def trans(ch):
	dic={'=':'-', '-':'0','0':'9', '9':'8', '8':'7', '7':'6', '6':'5', '5':'4', '4':'3', '3':'2', '2':'1',
			'\\':']', ']':'[', '[':'P', 'P':'O', 'O':'I', 'I':'U', 'U':'Y', 'Y':'T', 'T':'R', 'R':'E', 'E':'W', 'W':'Q',
			"'":';', ';':'L', 'L':'K', 'K':'J', 'J':'H', 'H':'G', 'G':'F', 'F':'D', 'D':'S', 'S':'A',
			'/':'.', '.':',', ',':'M', 'M':'N', 'N':'B', 'B':'V', 'V':'C', 'C':'X', 'X':'Z'}
	
	return dic[ch]
		
while(True):
	try:
		stc=input()

		ch=[]
		ans=[]
		for i in stc:
			ch.append(i)

		for c in ch:
			if c==' ':
				ans.append(c)
				continue
			else:
				ans.append(trans(c))

		op=''		
		for sp in ans:
			op+=sp
		print(op)
		
	except EOFError: break