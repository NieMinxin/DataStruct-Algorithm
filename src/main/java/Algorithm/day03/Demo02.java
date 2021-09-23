package Algorithm.day03;



import Algorithm.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Demo02 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root!=null){
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            List list = new ArrayList();
            for (int i = queue.size(); i >0 ; i--) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null){queue.offer(node.left);}
                if(node.right!=null){queue.offer(node.right);}
            }
            lists.add(list);
        }
        return lists;
    }

}
