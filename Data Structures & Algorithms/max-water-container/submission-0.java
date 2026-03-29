class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;

        int left = 0;
        int right = n-1;
        int sum = 0;

        while(left < right){

            if(heights[left] <= heights[right]){
                int diff = right - left;
                 sum = Math.max(sum , diff*heights[left]);
                left++;
            }else{
                int diff = right - left;
                 sum = Math.max(sum , diff*heights[right]);
                right--;
            }
        }

        return sum;
        
    }
}
