public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
       
       if (intervals.length == 0) return 0;

        // Step 1: Sort by end time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);


        int n = intervals.length;
        int end1 = intervals[0][1];
        int count = 0;

        for(int i = 1; i < n; i++){
            int start2 = intervals[i][0];
            int end2 = intervals[i][1];

            if(end1 > start2){
                count++;
                
            }else{
            
            end1 = end2;
            }
            
        }


        return count;


    }
}