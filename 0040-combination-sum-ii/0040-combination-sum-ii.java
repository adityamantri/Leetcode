class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, res, new ArrayList<Integer>(), 0);
        return res;
    }

    private void backtrack(int[] arr, int target, List<List<Integer>> res, List<Integer> temp, int idx){
        if(target < 0) return;
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = idx; i < arr.length; i++){
            if(i > idx && arr[i] == arr[i - 1]) continue;
            temp.add(arr[i]);
            backtrack(arr, target-arr[i], res, temp, i+1);
            temp.remove(temp.size()-1);
        }
    }
}