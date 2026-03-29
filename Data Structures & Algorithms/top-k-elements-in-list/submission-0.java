class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: count frequency
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        // Step 2: create buckets
        List<Integer>[] bucket = new List[nums.length + 1];

        for(int key : map.keySet()){
            int freq = map.get(key);

            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(key);
        }

        // Step 3: collect top k
        int[] res = new int[k];
        int idx = 0;

        for(int i = bucket.length - 1; i >= 0 && idx < k; i--){

            if(bucket[i] != null){

                for(int num : bucket[i]){
                    res[idx++] = num;

                    if(idx == k) break;
                }

            }
        }

        return res;
    }
}