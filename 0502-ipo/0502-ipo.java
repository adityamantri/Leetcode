class Solution {
    class Project{
        int capital;
        int profit;
        public Project(int cap, int pro){
            this.capital = cap;
            this.profit = pro;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Project[] projects = new Project[n];
        for(int i = 0; i < n; i++){
            projects[i] = new Project(capital[i], profits[i]);
        }
        Arrays.sort(projects, (a, b) -> Integer.compare(a.capital, b.capital));
        PriorityQueue<Integer> maxCapital = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;
        while(k-- > 0){
            while(i < n && projects[i].capital <= w){
                maxCapital.offer(projects[i].profit);
                i++;
            }
            if(maxCapital.isEmpty()){
                return w;
            }
            w += maxCapital.poll();
        }
        return w;
    }
}