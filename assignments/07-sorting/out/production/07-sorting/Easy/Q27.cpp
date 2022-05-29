#include <iostream>
#include <vector>
using std::cin;
using std::cout;
using std::endl;

vector<int> findDisappearedNumbers(vector<int> &nums) {
    // if the index +1 != nums[index] then add
    int index = 0;
    while (index < nums.size()) {
        int correct = nums[index] - 1;

        if (nums[index] != nums[correct]) {
            // if the duplicated is not there then swap
            std::swap(nums[index], nums[correct]);
        } else {
            index++;
        }
    }

    vector<int> ans;
    for (int i = 0; i < nums.size(); i++) {
        if (i + 1 != nums[i])
            ans.push_back(i + 1);
    }
    return ans;
}

int main(int argc, char **argv)
{

    remove(argv[0]);
    return EXIT_SUCCESS;
}