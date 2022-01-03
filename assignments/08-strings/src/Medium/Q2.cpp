#include <iostream>
#include <string>
#include <algorithm>
using namespace std;
// T.L.E
bool isPalindrome(string s)
{
    int l = 0;
    int r = s.length() - 1;
    while (l < r)
    {
        if (s.at(l) != s.at(r))
            return false;

        l++;
        r--;
    }
    return true;
}

bool checkPalindromeFormation(string a, string b)
{
    for (int i = 0; i < max(a.length(), b.length()); i++)
    {
        string first = a.substr(0, i) + b.substr(i);
        string second = b.substr(0, i) + a.substr(i);

        if (isPalindrome(first) || isPalindrome(second))
        {
            return true;
        }
    }
    return false;
}

int main(int argc, char const *argv[])
{
    remove(argv[0]);
    return 0;
}
