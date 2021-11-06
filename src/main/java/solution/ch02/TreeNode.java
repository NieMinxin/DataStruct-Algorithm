package solution.ch02;

import java.util.*;

public class TreeNode {
    TreeNode root;
    private String data;
    TreeNode left;
    TreeNode right;
    public TreeNode(String data){
        this.data = data;
    }

    public TreeNode(){}


    public  void Tree(String nodes[]){
        Deque<TreeNode> queue = new LinkedList<>();
        int i=1;
        if(!nodes[0].equals("None")){
            TreeNode node = new TreeNode(nodes[0]);
            root = node;
            queue.offer(node);
        }
        while (!queue.isEmpty() &&i<nodes.length){
            TreeNode cur = queue.poll();
            if(!nodes[i].equals("None")){
                TreeNode node = new TreeNode(nodes[i]);
                cur.left = node;
                queue.offer(node);
            }else {
                cur.left = null;
            }
            ++i;
            if(i>=nodes.length){
                break;
            }

            if(!nodes[i].equals("None")){
                TreeNode node = new TreeNode(nodes[i]);
                cur.right = node;
                queue.offer(node);
            }else {
                cur.right = null;
            }
            ++i;
            if(i>=nodes.length){
                break;
            }
        }
    }


    public  TreeNode getRoot(){
        return root;
    }

    public void sOutLevel(TreeNode root){
        Deque<TreeNode> queue = new LinkedList<>();
        int level=0;
        if(root==null){
            System.out.println(0);
        }
        queue.offer(root);
        while (!queue.isEmpty()){

            for (int i = queue.size(); i>0; i--) {
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);

                }
            }
            level++;
        }
        System.out.println(level);
    }


    public  void minDepth(TreeNode root){
        Deque<TreeNode> queue = new LinkedList<>();
        int level=0;
        if(root==null){
            System.out.println(0);
        }
        queue.offer(root);
        level++;
        while (!queue.isEmpty()){

            for (int i = queue.size(); i>0; i--) {
                TreeNode node = queue.poll();
                if(node.right==null && node.left==null){
                    System.out.println(level);
                    return;
                }
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            level++;
        }
        System.out.println(level);
    }

    public void inOrderWithStack(TreeNode node){
        Deque<TreeNode> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        if(node==null){
            return;
        }
        while (node!=null || !stack.isEmpty()){
            while (node!=null){
                stack.push(node);

                node = node.left;
            }
            node = stack.pop();
            sb.append(node.data);
            sb.append(" ");
            node = node.right;
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nodes[]  = scanner.nextLine().split(" ");
        TreeNode tree = new TreeNode();
        tree.Tree(nodes);
        tree.inOrderWithStack(tree.getRoot());
    }

}
