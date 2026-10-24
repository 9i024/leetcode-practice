class LRUCache {
    private HashMap<Integer, ListNode> map;
    private int capacity;
    private ListNode head;
    private ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode(0, 0);
        tail = new ListNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        else{
            ListNode temp = map.get(key);
            removeNode(temp);
            addToEnd(temp);
            return temp.val;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            removeNode(map.get(key));
        }
        else if(map.size() == capacity){
            map.remove(head.next.key);
            removeNode(head.next);
        }
        
        ListNode temp = new ListNode(key, value);
        addToEnd(temp);
        map.put(key, temp);
    }

    private void removeNode(ListNode node) {
        ListNode tempNext = node.next;
        ListNode tempPrev = node.prev;

        tempPrev.next = tempNext;
        tempNext.prev = tempPrev;
    }

    private void addToEnd(ListNode node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }
}

class ListNode {
    public int key;
    public int val;
    public ListNode next;
    public ListNode prev;

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}