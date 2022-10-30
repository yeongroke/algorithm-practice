import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
* LeetCode - easy
* 145. Binary Tree Postorder Traversal
* */
public class D20221029_1 {

    static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
        TreeNode() {

        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // solution method
    static List<Integer> solution(TreeNode root) {
        List<Integer> answer = new ArrayList<>();

        if(root == null)
            return answer;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.empty()) {
            TreeNode subRoot = stack.pop();
            answer.add(0,subRoot.val);
            if(subRoot.left != null)
                stack.push(subRoot.left);
            if(subRoot.right != null)
                stack.push(subRoot.right);
        }

        return answer;
    }

    static TreeNode treeNode = new TreeNode(1);

    // coding test run
    public static void main(String[] args) {
        System.out.println(solution(treeNode));
    }
}
