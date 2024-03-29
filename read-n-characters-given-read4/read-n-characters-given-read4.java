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
    public int read(char[] buf, int n) {
        int copiedChar = 0, readChars = 4;
        char[] buf4 = new char[4];
        while(copiedChar < n && readChars == 4){
            readChars = read4(buf4);

            for(int i = 0; i < readChars; i++){
                if(copiedChar == n)
                    return copiedChar;
                buf[copiedChar++] = buf4[i];
            }
        }
        return copiedChar;
    }
}