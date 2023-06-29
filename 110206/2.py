import sys
T = int(input())
erdos = 'Erdos, P.'
for cnt in range(T):
	dic ={}
	P, N = map(int, input().split())
	
	for __ in range(P):
		names = []
		line = input()
		line = line[:line.find(':')].split(',') # 저자 이름 배열 생성
		for i in range(0, len(line), 2):
			names.append((line[i] + ',' + line[i + 1]).strip()) # 저자이름 전처리
			if erdos in names: # 에르되시가 있을 시 저자 에르되시 수 1로 변경
				for name in names:
					if name == erdos:
						continue
					dic[name] = 1
			else: # 에르되시가 없는 경우
				m = sys.maxsize
				for name in names:
					if m > dic.get(name, sys.maxsize):
							m = dic.get(name)
				for name in names:
					if dic.get(name, sys.maxsize) == m:
						continue
					dic[name] = m + 1
	
	names = []
	for __ in range(N):
		names.append(input())
	print(f'Scenario {cnt + 1}')
	for name in names:
		print(f'{name} {dic.get(name, "infinity")}')