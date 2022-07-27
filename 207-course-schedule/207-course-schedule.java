class Solution {
    
    private static int count;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        count = 0;
        int indegrees[] = new int[numCourses];
        List<List<Integer>>adjacencyList = new ArrayList();
        Deque<Integer> queue = new ArrayDeque();
        for(int i = 0; i < numCourses; i++)
            adjacencyList.add(new ArrayList<>());
        // create adjacency list
        for(int[] prereq : prerequisites){
            adjacencyList.get(prereq[1]).add(prereq[0]);
            indegrees[prereq[0]]++;
        }
        
        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0)
                queue.offerLast(i);
        }
        
        while(!queue.isEmpty()){
            int node = queue.pollFirst();
            
            count++;
            for(int neighbour : adjacencyList.get(node)){
                indegrees[neighbour]--;
                if(indegrees[neighbour] == 0){
                    queue.offerLast(neighbour);
                }
            }
        }
        return count == numCourses;
    }
    
    
    
    
}