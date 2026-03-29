class Solution {
    public int[][] merge(int[][] intervals) {

        // Edge case
        if (intervals.length == 0) return new int[0][0];

        // Step 1: Sort intervals based on start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int n = intervals.length;
        int start1 = intervals[0][0];
        int end1 = intervals[0][1];
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 1; i<n ; i++){
           int  start2 = intervals[i][0];
           int  end2 = intervals[i][1];
            //Check if interval are overlapping 
            if(end1 >= start2){
                start1 = start1;
                end1 = Math.max(end1 , end2);
                continue;
            }
            res.add(Arrays.asList(start1, end1));
            start1 = start2;
            end1 = end2;
        }

        res.add(Arrays.asList(start1, end1));

        int[][] result = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            result[i][0] = res.get(i).get(0);
            result[i][1] = res.get(i).get(1);
        }

        return result;

    }
}
