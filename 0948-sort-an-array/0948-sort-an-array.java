class Solution {
    public int[] sortArray(int[] nums) {
        if(nums == null || nums.length == 0) return nums;
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }

    public void mergeSort(int[] nums, int l, int r){
        if(l >= r) return;
        int mid = l + (r - l)/2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid+1, r);
        merge(nums, l, r);
    }

    public void merge(int nums[], int l, int r){
        int mid = l + (r - l)/2;
        int[] temp = new int[r-l+1];
        int i = l, j = mid + 1, k = 0;
        while(i <= mid || j <= r){
            if(i > mid || j <= r && nums[i] > nums[j]){
                temp[k++] = nums[j++];
            }else{
                temp[k++] = nums[i++];
            }
        }
        System.arraycopy(temp, 0, nums, l, r - l + 1);
    }

    public void selectionSort(int[] nums){
        for(int i = 0; i < nums.length; i++){
            int minIdx = i;
            for(int j = i+1; j < nums.length; j++){
                if(nums[j] < nums[minIdx]) minIdx = j;
            }
            if(minIdx != i) swap(nums, minIdx, i);
        }
    }

    public void insertionSort(int[] nums){
        for(int i = 1; i < nums.length; i++){
            for(int j = i; j >= 1; j--){
                if(nums[j] >= nums[j-1]){
                    break;
                }
                swap(nums, j, j-1);
            }
        }
    }

    public void swap(int[] nums, int i, int j){
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}