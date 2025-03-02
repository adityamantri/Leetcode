class LRUCache {
    class Node {
        int key;
        int val;
        Node next;
        Node prev;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    
    Map<Integer, Node> map;
    int cap;
    Node head;
    Node tail;
    
    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        tail.prev = head;
        head.next = tail;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node n = map.get(key);
        remove(n);
        add(n);
        return n.val;
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key)){
            remove(map.get(key));
        }else if(map.size() == cap){
            Node del = tail.prev;
            remove(del);
            map.remove(del.key);
        }
        Node n = new Node(key, value);
        map.put(key, n);
        add(n);
    }
    
    public void add(Node n){
        n.next = head.next;
        head.next = n;
        n.next.prev = n;
        n.prev = head;
    }
    
    public void remove(Node n){
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */