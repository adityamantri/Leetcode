/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    
    private int binarySearch(int start, int end){
        if(start == end){
            return start;
        }
        int mid = (end - start)/2 + start;
        if(isBadVersion(mid)){
            return binarySearch(start, mid);
        }else{
            return binarySearch(mid+1, end);
        }
    }
    
    public int firstBadVersion(int n) {
        return binarySearch(0, n);
    }
}