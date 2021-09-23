package Algorithm;

public class Demo02 {
    public TreeNode mergeTwoLists(TreeNode l1, TreeNode l2) {
        TreeNode preHead = new TreeNode(-1);
        TreeNode pre = preHead;
        while(l1!=null && l2!=null){
            if(l1.val<= l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre= pre.next;
        }
        //最后一部合并
        pre.next= (l1==null) ? l2 : l1;
        return preHead.next;
    }

    public TreeNode removeElements(TreeNode head, int val) {
        TreeNode newHead = new TreeNode(0);
        newHead.next = head;
        TreeNode cur =newHead;
        while (cur.next!=null){
            if(cur.next.val==val){
                //删除的为头节点
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return newHead.next;
    }


    public TreeNode deleteDuplicates(TreeNode head) {
        if(head==null){
            return head;
        }
        TreeNode cur = head;
        while (cur.next!=null){
            if(cur.next.val==cur.val){
                cur.next= cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }

    public int maxProfit(int prices[]) {
        int minValue = Integer.MIN_VALUE,maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i]<minValue){

            }
        }
        return 0;
    }

    public int[] exchange(int[] nums) {

        int i=0,j=nums.length-1;
        while (i<j){
            if(nums[i]%2!=0){
                i++;
            }
            if(nums[j]%2==0){
                j--;
            }
            int tmp = nums[i];
            nums[j] = tmp;
            nums[i] = nums[j];
        }
        return nums;
    }









}




