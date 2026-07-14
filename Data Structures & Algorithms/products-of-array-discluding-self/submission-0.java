class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[nums.length - 1] = 1;

        for(int i=nums.length-1; i>0; i--){
            result[i-1] = nums[i] * result[i];
        }

        int current = 1;
        for(int i=0; i<nums.length; i++){
            result[i] = current * result[i];
            current *= nums[i];
        }
        return result;
    }
}  
