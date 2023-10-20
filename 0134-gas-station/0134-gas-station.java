class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        for(int i = 0; i < gas.length; i++){
            gas[i] = gas[i]-cost[i];
            total += gas[i];
        }
        if(total < 0) return -1;
        int currSum = 0, start = 0;
        for(int i = 0; i < gas.length; i++){
            currSum += gas[i];
            if(currSum < 0){
                start = i+1;
                currSum = 0;
            }
        }
        return start;
    }
}