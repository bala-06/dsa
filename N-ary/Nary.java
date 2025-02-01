import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class Nary {
    private static class TreeNode {
        int val;
        ArrayList<TreeNode> children;

        TreeNode(int data) {
            this.val = data;
            this.children = new ArrayList<>();
        }
    }

    TreeNode root;

    Nary() {
        this.root = null;
    }

    TreeNode constructTree() {
        root = new TreeNode(1);
        this.root.children.add(new TreeNode(2));
        this.root.children.get(0).children.add(new TreeNode(3));
        this.root.children.get(0).children.add(new TreeNode(4));
        this.root.children.get(0).children.add(new TreeNode(6));

        this.root.children.add(new TreeNode(5));
        this.root.children.get(1).children.add(new TreeNode(7));


        this.root.children.add(new TreeNode(8));
        this.root.children.get(2).children.add(new TreeNode(9));
        this.root.children.get(2).children.add(new TreeNode(11));
        return root;

    }

    void preorder(TreeNode root) {
        System.out.print(root.val + " ");
        for (int i = 0; i < root.children.size(); i++) {
            preorder(root.children.get(i));

        }
    }

    void postorder(TreeNode root) {
        for (int i = 0; i < root.children.size(); i++) {
            postorder(root.children.get(i));
        }
        System.out.print(root.val + " ");
    }

    void inorder(TreeNode root) {
        int i = 0;
        for (; i < root.children.size()-1; i++) {
            inorder(root.children.get(i));
        }
        System.out.print(root.val + " ");
        if (root.children.size()>0)
        inorder(root.children.get(i));

    }

    void leveorder(TreeNode root)
    {
        Queue<TreeNode> qu=new LinkedList<>();
        qu.add(root);
        while(!qu.isEmpty())
        {
            int size=qu.size();
            for(int i=0;i<size;i++) {
                TreeNode temp = qu.poll();
                System.out.print(temp.val+" ");
                for(TreeNode eachNode: temp.children)
                {
                    qu.add(eachNode);
                }

            }
            System.out.println();
        }
    }
    void zizzag(TreeNode root)
    {
        Queue<TreeNode> qu=new LinkedList<>();
        qu.add(root);
        int flag=0;
        while(!qu.isEmpty())
        {
            int size=qu.size();

            for(int i=0;i<size;i++) {
                TreeNode temp = qu.poll();
                System.out.print(temp.val+" ");
                if (flag==0) {
                    flag=1;
                    for (TreeNode eachNode : temp.children) {
                        qu.add(eachNode);
                    }
                }
                else {
                    flag=1;
                    Stack<TreeNode> st=new Stack();
                    for (TreeNode eachNode : temp.children) {
                        st.push(eachNode);
                    }
                    while(!st.isEmpty()){
                        qu.add(st.pop());
                    }

                }

            }
            System.out.println();
        }
    }


}

class Main{
    public static void main(String[] args)
    {
        Nary tree=new Nary();
        tree.constructTree();
        tree.preorder(tree.root);
        System.out.println(" ");
        tree.postorder(tree.root);
        System.out.println();
        tree.inorder(tree.root);
        System.out.println();
        tree.leveorder(tree.root);
        System.out.println();
        tree.zizzag(tree.root);

    }
}