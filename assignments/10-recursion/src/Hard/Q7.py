def maxNiceDivisors(self, x):
  if x == 1:
    return 1
  if x == 2:
    return 2
  
  a, b = x//3, x%3
  mod = 10**9 + 7
  if b == 0:
    return pow(3, a, mod)
  if b == 1:
    return pow(3, a-1, mod)*4%mod
  if b == 2:
    return pow(3, a, mod)*2%mod