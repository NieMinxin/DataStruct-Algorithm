package solution.ch01;

import Algorithm.TreeNode;

import java.util.*;

public  class Demo01 {
    public static void main(String[] args) {

        float f = 1.5f;//float  如果不写 f 会当成double
        System.out.println("请输入一个年份：");
        Scanner scanner  = new Scanner(System.in);
        int in;
        in = scanner.nextInt();
        if(in % 400==0 || (in % 4==0 && in %100!=0)){
            System.out.println("是闰年");
        }else {
            System.out.println("不是");
        }
    }

    public void fun() {
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();
        if(root!=null){
            deque.offer(root);
        }
        while (!deque.isEmpty()){
            List<Integer> list = new ArrayList<>();
            for (int i = deque.size(); i >0; i--) {
                TreeNode node = deque.removeFirst();
                if(node.left!=null){deque.addLast(node.left);}
                if(node.right!=null){deque.addLast(node.right);}
                list.add(node.val);
            }
            lists.add(list);
            if(deque.isEmpty())  break;//如果为空，提前退出
            list  = new ArrayList<>();
            //从右向左打印
            for (int i = deque.size(); i >0 ; i--) {
                TreeNode node = deque.removeLast();
                list.add(node.val);
                if(node.right!=null){deque.addFirst(node.right);}
                if(node.left!=null){deque.addFirst(node.left);}
            }

            lists.add(list);
        }
        return lists;
    }


    public TreeNode mirrorTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }


    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        return p.val==q.val && (check(p.left,q.right)&& check(p.right,q.left));
    }


    public int maxProfit(int prices[]) {
        int maxProfit = 0,minPrice = Integer.MAX_VALUE;
        for (int i = 0; i <prices.length; i++) {
            if(prices[i]<minPrice){
                minPrice = prices[i];
            }
            if(prices[i]-minPrice > maxProfit){
                maxProfit = Math.max(prices[i]-minPrice,maxProfit);
            }
        }
        return maxProfit;
    }






}
