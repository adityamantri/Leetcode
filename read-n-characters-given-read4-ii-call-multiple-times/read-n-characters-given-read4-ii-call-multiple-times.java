/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4); 
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    int prevIndex = 0, prevSize = 0;
    char[] buf4 = new char[4];
    public int read(char[] buf, int n) {
        int idx = 0;
        while(idx < n){
            // add the char to buf if already present in buf4
            // prevSize is chars read by read4 in last call
            if(prevIndex < prevSize){
                buf[idx++] = buf4[prevIndex++];
            }else{
                prevSize = read4(buf4);
                prevIndex = 0; // start from 0 to 3
                // return if curr chars read from read4 is 0.
                if(prevSize == 0) return idx; 
            }
        }
        return idx;
    }
}