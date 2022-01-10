class Q7:
    def orderlyQueue(self, s: str, k: int) -> str:
        if k == 1:
            return min(s[i:]+s[:i] for i in range(len(s)))

        else:
            return ''.join(sorted(s))

print(Q7().orderlyQueue("cba", 1))