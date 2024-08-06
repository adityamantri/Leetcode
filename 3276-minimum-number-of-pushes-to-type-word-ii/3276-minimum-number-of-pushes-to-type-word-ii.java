class Solution {
    public int minimumPushes(String word) {
        int[] arr = new int[26];
        for(char c : word.toCharArray()){
            arr[c - 'a']++;
        }
        // arr = Arrays.stream(arr)
        //     .boxed()
        //     .sorted(Collections.reverseOrder())
        //     .mapToInt(Integer::intValue)
        //     .toArray();
        Arrays.sort(arr);
        int res = 0;
        for(int j = 0; j < 26; j++){
            if(arr[25-j] > 0){
                res += (j/8 + 1) * arr[25-j];
            }else{
                break;
            }
        }
        return res;
    }
}