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
            ListNode tempNext = map.get(key).next;
            ListNode tempPrev = map.get(key).prev;

            tempPrev.next = tempNext;
            tempNext.prev = tempPrev;

            ListNode temp = new ListNode(key, map.get(key).val);
            tail.prev.next = temp;
            temp.prev = tail.prev;
            temp.next = tail;
            tail.prev = temp;
            map.put(key, temp);
            return map.get(key).val;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            ListNode tempNext = map.get(key).next;
            ListNode tempPrev = map.get(key).prev;

            tempPrev.next = tempNext;
            tempNext.prev = tempPrev;
        }
        else if(map.size() == capacity){
            map.remove(head.next.key);
            head.next.next.prev = head;
            head.next = head.next.next;
        }
        
        ListNode temp = new ListNode(key, value);
        tail.prev.next = temp;
        temp.prev = tail.prev;
        temp.next = tail;
        tail.prev = temp;
        map.put(key, temp);
    }
}

class ListNode {
    public int key;
    public int val;
    public ListNode next;
    public ListNode prev;

    public ListNode() {}

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }

    public ListNode(int key, int val, ListNode next, ListNode prev) {
        this.key = key;
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}