INF = 99999


def find(sticks, kits):
    # 오름차순으로 입력된걸 내림차순으로 바꿔준다.
    sticks.sort(reverse=True)

    # 0으로 초기화해준다
    dif = [0 for _ in range(len(sticks))]

    # 젓가락 개수만큼 반복
    # A-B의 값이 가장 작으려면 이미 정렬된 상태로 들어온 젓가락의 길이를 이용하면 된다
    # 현재 젓가락의 옆에 있는걸 짝으로 하면 된다.
    for i in range(2, len(sticks)):
        # 2부터 한 이유 어짜피 stick[0] - stick[1] 의 차를 구한다고 해도
        # stick[0] 과 stick[1]보다 큰 젓가락이 없어서 stick[0] stick[1]은 선택할 수가 없음
        dif[i] = (sticks[i - 1] - sticks[i]) ** 2

    # 가장 작은 짝의 차
    # 가장 작은 짝의 차 + 0번을 제외한 가장 작은 짝의 차
    # 가장 작은 짝의 차 + 0번을 제외한 가장 작은 짝의 차 + 위의 것을 제외한 가장 작은 짝의 차
    # 가장 작은 짝의 차 + 0번을 제외한 가장 작은 짝의 차 + 위의 것을 제외한 가장 작은 짝의 차 + ...

    dp = [[0] * len(sticks) for _ in range(kits + 1)]
    for i in range(1, kits+1):
        dp[i][3 * i - 2] = INF
        for j in range(3 * i - 1, len(sticks)):
            if dp[i - 1][j - 2] + dif[j] > dp[i][j - 1]:
                dp[i][j] = dp[i][j - 1]
            else:
                dp[i][j] = dp[i - 1][j - 2] + dif[j]
    return dp[kits][len(sticks)-1]

# 테스트케이스 개수 입력
T = int(input())
# 테스트케이스 개수만큼 반복
for _ in range(T):
    K, N = map(int, input().split())
    chops = list(map(int, input().split()))
    # 최적의 값을 찾아낸다.
    print(find(chops, K + 8))
