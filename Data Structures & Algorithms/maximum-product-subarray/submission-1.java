class Solution {
    public int maxProduct(int[] nums) {

        int n = nums.length;
        int prevmax = nums[0];
        int prevmin = nums[0];
        int res = nums[0];

        for(int i = 1; i < n ; i++){

            int newmax = Math.max(nums[i] , Math.max(nums[i]*prevmax , nums[i]*prevmin));
            int newmin = Math.min(nums[i] , Math.min(nums[i]*prevmax , nums[i]*prevmin));

            prevmax = newmax;
            prevmin = newmin;

            res = Math.max(res , prevmax);
    
        }

        return res;

    }
}
