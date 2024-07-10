class Solution {
    public int minOperations(String[] logs) {
        int levels = 0;
        for(String log : logs){
            if(log.equals("../")){
                levels = Math.max(0, levels-1);
            }else if(log.equals("./")){
                continue;
            }else{
                levels++;
            }
        }
        return levels;
    }
}