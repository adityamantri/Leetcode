class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = Arrays.stream(arr1).max().getAsInt();
        int[] count = new int[max+1];
        for(int ele : arr1){
            count[ele]++;
        }
        List<Integer> result = new ArrayList<>();
        for(int val : arr2){
            while(count[val] > 0){
                result.add(val);
                count[val]--;
            }
        }

        for(int val = 0; val <= max; val++){
            while(count[val] > 0){
                result.add(val);
                count[val]--;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}