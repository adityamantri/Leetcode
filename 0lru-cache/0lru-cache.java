class LRUCache {
    class Node{
        int key, value;
        Node prev, next;
        public Node(){}
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    Map<Integer, Node> map;
    Node head, tail;
    int cap;
    public LRUCache(int capacity) {
        cap = capacity;
        head = new Node();
        tail = new Node();
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node n = map.get(key);
        if(n == null)
            return -1;
        delete(n);
        add(n);
        return n.value;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            delete(map.get(key));
            map.remove(key);
        }
        if(map.size() == cap){
            map.remove(tail.prev.key);
            delete(tail.prev);
        }
        Node n = new Node(key, value);
        map.put(key, n);
        add(n);
    }
    
    public void add(Node n){
        // map.put(n.key, n);
        Node next = head.next;
        head.next = n;
        next.prev = n;
        n.next = next;
        n.prev = head;
    }
    
    public void delete(Node n){
        // map.remove(n.value);
        Node next = n.next;
        Node prev = n.prev;
        next.prev = prev;
        prev.next = next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */