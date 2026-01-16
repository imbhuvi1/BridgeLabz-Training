class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        int leftSum = 0;
        int rightSum;
        for(int i : nums){
            totalSum += i;
        }
        int count = 0;
        for(int i = 0; i < n - 1; i++){
            leftSum += nums[i];
            rightSum = totalSum - leftSum;
            if((leftSum - rightSum) % 2 == 0){
                count++;
            }
        }
        return count;
    }
}