package important;

import java.util.HashMap;

class Node {
    int val, key;
    Node next, pre;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Node(%s:%s) ", key, val));
        return sb.toString();
    }
}

class DoubleList {
    private Node head, tail; //添加头尾虚节点
    private int size; //链表元素个数

    public DoubleList() {
        //初始化双向链表数据
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    // 在链表头部添加节点 x
    public void addFirst(Node x) {
        x.next = head.next;
        x.pre = head;
        head.next.pre = x; //因为是向头部添加 所以不能用tail来操作
        head.next = x;
        size++;
    }

    // 删除链表中的 x 节点（x 一定存在）
    public void remove(Node x) {
        x.pre.next = x.next;
        x.next.pre = x.pre;
        size--;
    }

    // 删除链表中最后一个节点，并返回该节点
    public Node removeLast() {
        if (tail.pre == head) return null;
        Node last = tail.pre;
        remove(last);
        return last;
    }

    // 返回链表长度
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = head;
        sb.append("头<-");
        while (cur.next != tail) {
            sb.append(cur.next.val + " ");
            cur = cur.next;
        }
        sb.append("<-尾");
        return sb.toString();
    }

}

class LRUCache {
    private int cap; //容量
    //key --> Node(key,val)
    private HashMap<Integer, Node> map;
    private DoubleList cache;

    //初始化LRUCache数据
    public LRUCache(int capacity) {
        map = new HashMap<>();
        cache = new DoubleList();
        this.cap = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        int val = map.get(key).val; //map 拿到的是Node
        //利用put方法把当前的node提前
        put(key, val);
        return val;
    }

    //核心思路:必须同时维护双向链表和map
    public void put(int key, int val) {
        //先把节点做出来
        Node node = new Node(key, val);
        if (map.containsKey(key)) {
            //删除旧节点
            cache.remove(map.get(key)); //这里因为size-1了,所以即便是下面只有if 也不会满足cap == cache.size()
        } else if (cap == cache.size()) { //这里最好是else if 可以少做一次判断,且易于理解
            //删除链表中的最后一个数据,注意 同时也要把map中对应的key删除
            Node last = cache.removeLast();
            map.remove(last.key);
        }
        //不管key存不存在, 缓存是否已满 最终都是要在头部添加新节点的
        cache.addFirst(node);
        map.put(key, node);
    }

    //打印结果不准确?  要打印链表 即cache
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
//        for (Map.Entry entry : map.entrySet()) {
//            sb.append(String.format("map->%s:%s ", entry.getKey(), entry.getValue()));
//        }
        sb.append(cache.toString());
        return sb.toString();
    }

}

public class LRU {
    public static void main(String[] args) {
        LRUCache lru = new LRUCache(4);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);
        lru.put(4, 4);

        //节点提前
        System.out.println(lru.toString());
        lru.put(2, 2);

        //在满cache情况下添加新节点
        System.out.println(lru.toString());
        lru.put(5, 5);

        System.out.println(lru.toString());


    }
}

