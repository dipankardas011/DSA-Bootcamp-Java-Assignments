#include <bits/stdc++.h>
using namespace std;

/**
 * @see https://leetcode.com/problems/minimum-number-of-operations-to-make-string-sorted/discuss/1163622/C%2B%2B-Previous-permutation-with-repetition-268ms
 */
class Q5 {
    static const int N = 1'000'000'007;
public:
    long long f(long long i, unordered_map<long long, long long>&m)
    {
        if (m.find(i) != m.end())
            return m[i];

        if (i <= 1) {
            m[i] = 1;
            return 1;
        }
        m[i] = i * f(i - 1, m) % N;
        return m[i];
    }

    long long modPower(long long a, long long p) {
        long long res = 1;
        while (p) {
            if (p&1)
                res = res * a % N;
            a = a * a % N;

            p = p >> 1;
        }
        return res;
    }

    int makeStringSorted(string s) {
        int res = 0;
        int n = s.size();
        unordered_map<long long, long long> m;
        vector<long long> cnt(26, 0);

        for (int i = n - 1; i >= 0; --i){
            int idx = s[i] - 'a';
            ++cnt[idx];
            long long n_smallerLetters = accumulate(cnt.begin(), cnt.begin() + idx, 0);
            long long n_permutation = f(n - i - 1, m);
            long long cur = n_smallerLetters * n_permutation % N;
            
            for (int j = 0; j < 26; ++j) {
                if (cnt[j] <= 1)
                    continue;
                int factorial = f(cnt[j], m);
                // Fermat little theorem
                // i.e. cur /= f(cnt[j], m) (mod N)
                cur *= modPower(factorial, N - 2) % N;
                cur %= N;
            }
            res += cur;
            res %= N;
        }
        return res;
    }
};

int main(int argc, char const *argv[])
{
    Q5 obj;
    std::cout << obj.makeStringSorted("cba") << std::endl;
    remove(argv[0]);
    return 0;
}
