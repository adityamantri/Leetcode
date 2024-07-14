class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> st = new Stack<>();
        Map<String, Integer> map = new HashMap<>();
        int idx = 0, n = formula.length();
        while(idx < n){
            char c = formula.charAt(idx);
            // move idx one point ahead
            idx++;
            
            if(c == '('){
                // store current map to stack and start new map for bracket
                st.push(map);
                map = new HashMap<>();
            }else if(c == ')'){
                // calculate the num after bracket
                int val = 0;
                while(idx < n && Character.isDigit(formula.charAt(idx))){
                    val = val*10 + formula.charAt(idx) - '0';
                    idx++;
                }
                if(val == 0) val = 1;
                // take current map and merge it with last map
                if(!st.isEmpty()){
                    Map<String, Integer> temp = map;
                    map = st.pop();
                    for(String key : temp.keySet()){
                        map.put(key, map.getOrDefault(key, 0) + temp.get(key) * val);
                    }
                }
            }else{
                int start = idx - 1;
                while(idx < n && Character.isLowerCase(formula.charAt(idx))){
                    idx++;
                }
                String s = formula.substring(start, idx);
                int val = 0;
                while(idx < n && Character.isDigit(formula.charAt(idx))){
                    val = val * 10 + formula.charAt(idx) - '0';
                    idx++;
                }
                if(val == 0) val = 1;
                map.put(s, map.getOrDefault(s, 0) + val);
            }
        }
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for(String key : list){
            sb.append(key);
            if(map.get(key) > 1)
                sb.append(map.get(key));
        }
        return sb.toString();
    }
}