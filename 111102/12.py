testcase = int(input())

for _ in range(testcase):
    s1 = input()
    s2 = input()

    dp = [[0 for i in range(len(s2)+1)] for _ in range(len(s1)+1)]

    for i in range(len(s1)+1):
        dp[i][0] = 1

    for i in range(1, len(s1)+1):
        for j in range(1, len(s2) + 1):
            # 두 문자열이 같으면 dp에 저장된 값 중 왼쪽 상단의 값과 바로 위의 값을 더해서 저장한다.
            if s1[i-1] == s2[j-1]:
              ''''코드 작성'''
              dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
            # 두 문자열이 같지않으면 바로 위의 값을 저장해준다
            else:
              ''''코드 작성'''
              dp[i][j] = dp[i-1][j]

    print(dp[len(s1)][len(s2)])
