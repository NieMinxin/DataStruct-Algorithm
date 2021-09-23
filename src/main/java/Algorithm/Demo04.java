package Algorithm;

import java.util.Stack;

public class Demo04 {

    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head!=null){
            stack.push(head);
            head = head.next;
        }
        int size = stack.size();
        int [] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = stack.pop().val;
        }
        return array;
    }


    //反转链表
    public ListNode reverseList(ListNode head) {
        ListNode cur = head,pre =null;
        while(cur!=null){
            ListNode node = cur.next;//定义一个指针指向cur的下一个节点
            cur.next = pre;
            pre= cur;
            cur= node;
        }
        return pre;
    }

    //复杂链表的复制















}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
