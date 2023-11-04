class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        Arrays.sort(left);
        Arrays.sort(right);
        int farthestLeft = right.length == 0 ? 0 : n - right[0];
        int rightmost = left.length == 0 ? 0 : left[left.length-1];
        return Math.max(farthestLeft, rightmost);
    }
}