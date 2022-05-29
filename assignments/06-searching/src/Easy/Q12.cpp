#include <iostream>
#include <vector>
#include <algorithm>

class Solution {
public:
    vector<int> fairCandySwap(vector<int>& alice, vector<int>& bob) {
     int n=alice.size();
        int m=bob.size();
        int sa=0,sb=0;
        for(auto it:alice) sa+=it;
        vector<int>output;
        for(auto it:bob)
        {
            sb+=it;
        }
        sort(bob.begin(),bob.end());
        int x,y;
        y=(sb-sa)/2 ;
        for(auto it:alice){
            if(binary_search(bob.begin(),bob.end(),it+y)==true){
                output.push_back(it);
                 output.push_back(y+it);
                return output;
            }
        }
        return output;
    }
};

int main() {
    Solution obj;
    obj.fairCandySwap(....);
}