#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
// do it using cycle sort
  int firstMissingPositive(vector<int> nums)
  {
    sort(nums.begin(), nums.end());
    int minT = 1;
    for (int i : nums)
    {
      if (i <= 0)
        continue;
      if (std::binary_search(nums.begin(), nums.end(), minT))
        minT++;
      else
        break;
    }
    return minT;
  }
};

int main(int argc, char const *argv[])
{
  vector<vector<int>> questions = {
    {1,2,0},
    {3,4,-1,1},
    {7,8,9,11,12}
  };
  vector<int> answer = {3, 2, 1};
  Solution testCases = Solution();
  for (int i = 0; i<questions.size(); i++) {
    if(answer[i] == testCases.firstMissingPositive(questions[i])) {
      cout<<"✅ passed\n";
    } else {
      cout<<"❌ failed\n";
      break;
    }
  }
  remove(argv[0]);
  return 0;
}
