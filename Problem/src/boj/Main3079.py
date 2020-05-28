import sys
import math
N, M = map(int, input().split())

# arr = [int(i) for i in sys.stdin.read().splitlines()][:N]
x = [0] * N
for i in range(N):
    x[i] = int(sys.stdin.readline())
    # x.append(int(sys.stdin.readline()))
# x = [int(y) for y in sys.stdin.read().splitlines()][:N]
# x.sort()
l = min(x)*M//N
r = max(x) * math.ceil(M/N)
# print(r)
ans = r
print(l,r)

while l<=r:
    
    mid = int((l + int((r-l)/2)))
    cnt = 0
    print(mid)
    for i in x:
        # tmpcnt = int(mid // i)
        cnt += (mid // i)# + tmp#int(mid/i)
    if cnt >=M:
        r = mid-1
        ans = mid  
    else:
        l = mid+1
    


print(ans)