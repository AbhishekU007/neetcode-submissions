class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()){
            int frequency = entry.getValue();
            if(bucket[frequency] == null){
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(entry.getKey());
        }

        int[] result = new int[k];
        int index = 0;

        for(int i = nums.length; i >= 1; i--){
            if(bucket[i] != null){
                for(int num:bucket[i]){
                    result[index++] = num;

                    if(index == k) return result;
                }
            }
        }
        return result;
    }
}
