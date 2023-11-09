class Solution {
    public String reverseVowels(String s) {
        int left = 0, right = s.length()-1;
        Set<Character> set = new HashSet(Arrays.asList('a','e','i','o','u','A','E','I','O', 'U'));
        char[] arr = s.toCharArray();
        while(left < right){
            if(!set.contains(arr[left])) left++;
            else if(!set.contains(arr[right])) right--;
            else {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return new String(arr);
    }
}