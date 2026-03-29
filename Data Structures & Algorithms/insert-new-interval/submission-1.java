public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //we have to insert that new interval in original interval

        int n = intervals.length;
        List<int[]> sortInterval = new ArrayList<>();
        List<int[]> mergeInterval = new ArrayList<>();

        int i = 0;
        boolean insert = false ;

        while(i<n){

            int start = intervals[i][0];

            if(insert == false && start >= newInterval[0]){
                sortInterval.add(newInterval);
                insert = true;   
            }
            sortInterval.add(intervals[i]);
           
            i++;
        }

        if (!insert) {
        sortInterval.add(newInterval);
           }


        int start1 = sortInterval.get(0)[0];
        int end1 = sortInterval.get(0)[1];

        for(int j = 1 ; j < sortInterval.size(); j++){
            int start2 = sortInterval.get(j)[0];
            int end2 = sortInterval.get(j)[1];

            if(end1 >= start2){
               end1 = Math.max(end1 , end2);
            } else {
            mergeInterval.add(new int[]{start1, end1});
            start1 = start2;
            end1 = end2;
           }
        }

         // add last
         mergeInterval.add(new int[]{start1, end1});

         return mergeInterval.toArray(new int[mergeInterval.size()][]);

    }
}