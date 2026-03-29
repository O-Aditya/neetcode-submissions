class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxsum = nums[0];
        int res = nums[0];

        for(int i = 1 ; i < n ; i++){
            int currsum = maxsum + nums[i];

            if(currsum < nums[i]){
                currsum = nums[i];
            }
            maxsum = currsum;
            res = Math.max(res , maxsum);
        }

        return res;
        
    }
}
