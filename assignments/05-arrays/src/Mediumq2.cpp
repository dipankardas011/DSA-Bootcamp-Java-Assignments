#include <bits/stdc++.h>
using namespace std;
class Solution
{
public:
  void setZeroes(vector<vector<int>> &matrix)
  {
    vector<pair<int, int>> hash;
    int pos = 0;
    for (int i = 0; i < matrix.size(); i++)
    {
      for (int j = 0; j < matrix[0].size(); j++)
      {
        if (matrix[i][j] == 0)
        {
          hash.push_back({i, j});
        }
      }
    }

    for (pair<int, int> iter : hash)
    {
      int row = iter.first;
      int col = iter.second;
      for (int j = 0; j<matrix[0].size(); j++)
        matrix[row][j] = 0;
      for (int i=0; i<matrix.size(); i++)
        matrix[i][col] = 0;
    }
    
  }
};

int main(int argc, char **argv)
{
  remove(argv[0]);
  return EXIT_SUCCESS;
}