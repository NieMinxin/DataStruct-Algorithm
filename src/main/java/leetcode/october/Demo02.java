package leetcode.october;

import Algorithm.ListNode;
import Algorithm.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Demo02 {

    //快慢指针解决 链表有环的问题
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null){
            return false;
        }
        ListNode slow= head;
        ListNode fast = head.next;
        while (slow!=fast){
            if(fast==null || fast.next==null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);//哑节点
        ListNode pre = preHead;
        while (l1!=null && l2!=null){
            if(l1.val<=l2.val){
                pre.next = l1;
                l1= l1.next;
            }else{
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = (l1==null) ? l2 : l1;
        return preHead.next;
    }

    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        while (cur!=null){
            if(cur.val==val){
                if(cur==head){
                    head = head.next;
                    pre.next = head;
                }else {
                    cur = cur.next;
                    pre.next = cur;
                }
            }else {
                pre = cur;
                cur= cur.next;
            }
        }
        return  head;
    }


    //反转链表
    public ListNode reverseList(ListNode head){
        if(head==null){
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            ListNode node = cur.next;
            cur.next = pre;
            pre = cur;
            cur = node;
        }
        return pre;
    }


    //删除链表中重复的元素
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode cur = head;
        while (cur.next!=null){
            if(cur.val==cur.next.val){
                cur.next = cur.next.next;
            }else {
                cur= cur.next;
            }
        }
        return head;
    }

    //归并排序 排序链表
    public ListNode sortList(ListNode head) {
       if(head==null || head.next==null){
           return head;//就一个元素
       }
       //找到分叉点 ，使用快慢指针
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        //递归
        ListNode left  = sortList(head);
        ListNode right = sortList(tmp);

        ListNode dummy = new ListNode(-1);//哑节点
        ListNode res = dummy;
        while (left!=null && right!=null){
            if(left.val < right.val){
                dummy.next=left;
                left = left.next;
            }else {
                dummy.next = right;
                right = right.next;
            }
            dummy = dummy.next;
        }
        dummy.next = left != null ? left : right;
        return res.next;
    }

    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }else {
            TreeNode left = root.left;
            TreeNode right = root.right;
            return Math.max(maxDepth(left),maxDepth(right))+1;
        }
    }

    //二叉树的堆成镜像
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }
    public boolean check(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }//递归终止条件
        if(p==null || q==null){
            return true;
        }//递归终止条件

        // 递归下探
        return p.val==q.val && check(p.left,q.right) && check(p.right,q.left);//递归下探
    }





}
