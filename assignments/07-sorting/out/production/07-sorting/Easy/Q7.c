#include <stdio.h>
#include <limits.h>

int thirdMax(int* nums, int numsSize){
    int third = INT_MIN;
    int second = INT_MIN;
    int first = INT_MIN;
    for (int i=0; i<numsSize; i++) {
        if (nums[i] > first) {
            second = first;
            first = nums[i];
        }
        if (nums[i] < first && nums[i]>second){
            second = nums[i];
        }
    }

    int f = 0;
    for (int i =0; i<numsSize; i++) {
        if (nums[i] < first && nums[i] < second && nums[i] >= third){
            f = 1;
            third = nums[i];
        }
    }
    // printf("First: %d\t second: %d\tthird: %d\n",first, second, third);
    if (f){
        return third;
    }
    return first;

}

int main(int argc, char **argv) {
    int arr[] = {1,2,2,5,3,5};
    printf("Third Largest= %d\n",thirdMax(arr, sizeof(arr)/sizeof(int)));

    int arr1[] = {5,2,4,1,3,6,0};
    printf("Third Largest= %d\n",thirdMax(arr1, sizeof(arr1)/sizeof(int)));
    remove(argv[0]);
    return 0;
}
