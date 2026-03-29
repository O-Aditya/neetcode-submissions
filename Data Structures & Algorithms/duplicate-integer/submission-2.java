class Solution {
    public boolean hasDuplicate(int[] nums) {
        int n = nums.length;
        int i = 0;
        Arrays.sort(nums);
        for(int j = 1; j<n ; j++){
            if(nums[i] != nums[j]){
                i++;
            }
            else{
                return true;
            }
        }
        return false;
    }
}