package solution.ch01;

import Algorithm.ListNode;

public class Demo03 {

    public int fib(int n) {
        if(n==0) return 0;
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
               dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public ListNode deleteNode(ListNode head, int val) {
        if(head==null) return null;
        if(head.val==val){
            return head.next;
        }
        ListNode pre = head,cur = head.next;
        while (cur!=null && cur.val!=val){
            pre = cur;
            cur = cur.next;
        }

        if(cur!=null){
            pre.next = cur.next;
        }
        return head;
    }


    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head,latter = head;

        if(k<=0){
            return null;
        }else {
            if(head==null){
                return null;
            }else {
                for (int i = 0; i < 2; i++) {
                    latter = latter.next;
                }

                while (latter!=null){
                    former = former.next;
                    latter = latter.next;
                }
            }
        }
        return former;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //合并两个有序链表，采用双指针 和一个哑节点
        ListNode dum  = new ListNode(0),cur = dum;
        while (l1!=null && l2!=null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1!=null ? l1 : l2;
        return dum.next;
    }

}
