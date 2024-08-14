class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int arraySize = nums.length;
        int low = 0, high = nums[arraySize - 1];
        while(low < high){
            int mid = low + (high - low) / 2;
            int count = countPairs(nums, mid, k);
            if(count < k){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }

    public int countPairs(int[] nums, int maxDist, int k){
        int count = 0;
        int size = nums.length;
        int left = 0;
        for(int right = 0; right < size; right++){
            while(nums[right] - nums[left] > maxDist){
                left++;
            }
            count += right - left;
            if(count >= k){
                break;
            }
        }
        return count;
    }
}