#include <bits/stdc++.h>
using std::cin;
using std::endl;
using std::cout;


vector<int> frequencySort(vector<int> &A)
{
    int count[201]={0};
//    -100 <= nums[i] <= 100
    for (int a: A)
    count[a+100]++;

    sort(begin(A), end(A), [&](int a, int b)->bool {
         return count[a+100] == count[b+100] ? a > b : count[a+100] < count[b+100];
    });

    return A;
}

int main(int argc, char** argv) {
    
    remove(argv[0]);
    return EXIT_SUCCESS;
}
