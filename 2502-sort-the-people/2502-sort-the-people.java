class Solution {
    class People{
        String name;
        int height;
        public People(String n, int h){
            this.name = n;
            this.height = h;
        }
    }

    public String[] sortPeople(String[] names, int[] heights) {
        // Map<String, Integer> map = new HashMap<>();
        People[] p = new People[names.length];
        for(int i = 0; i < heights.length; i++){
            p[i] = new People(names[i], heights[i]);
        }
        Arrays.sort(p, (a, b) -> b.height - a.height);
        
        for(int i = 0; i < heights.length; i++){
            names[i] = p[i].name;
        }
        return names;
    }
}