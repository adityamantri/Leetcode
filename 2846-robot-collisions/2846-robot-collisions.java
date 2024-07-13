class Solution {
    class Robot{
        int position, health, idx;
        char dir;
        public Robot(int pos, int h, char dir, int i){
            this.position = pos;
            this.health = h;
            this.dir = dir;
            this.idx = i;
        }
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Robot[] arr = new Robot[n];
        List<Integer> res = new ArrayList<>();
        Stack<Robot> st = new Stack<>();

        for(int i = 0; i < n; i++){
            arr[i] = new Robot(positions[i], healths[i], directions.charAt(i), i);
        }

        Arrays.sort(arr, (a, b) -> a.position - b.position);
        for(Robot r : arr){
            if(r.dir == 'R' || st.isEmpty() || st.peek().dir == 'L'){
                st.push(r);
                continue;
            }
            if(r.dir == 'L'){
                boolean add = true;
                while(!st.isEmpty() && st.peek().dir == 'R' && add){
                    int lastHealth = st.peek().health;
                    if(r.health > lastHealth){
                        st.pop();
                        r.health--;
                    }else if(r.health == lastHealth){
                        st.pop();
                        add = false;
                    }else{
                        add = false;
                        st.peek().health--;
                    }
                }
                if(add){
                    st.push(r);
                }
            }
        }

        List<Robot> temp = new ArrayList<>(st);
        temp.sort(Comparator.comparingInt(a -> a.idx));
        for(Robot r : temp){
            res.add(r.health);
        }
        return res;
    }
}