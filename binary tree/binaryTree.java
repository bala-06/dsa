import java.util.LinkedList;
import java.util.Queue;
class BinaryTree{
    class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;

        public TreeNode(int val) {
            this.val = val;
            this.right = null;
            this.left = null;
        }
    }
        TreeNode  root;
        BinaryTree() {
            this.root = null;
        }
    public TreeNode insertval(TreeNode root,int val)
    {
        if (root==null) return new TreeNode(val);
        if (root.val<val)
        {
            root.right= insertval(root.right,val);
            return root;
        }
        else if(root.val>val) {
            root.left= insertval(root.left, val);
            return root;
        }
        return root;
    }
        public TreeNode insert(int val)
        {

           return insertval(root,val);
        }
        public void inorderempty(){
            System.out.print("InOrder Traversal :");
            inorder(root);
        }
        public void inorder(TreeNode root)
        {
            if (root==null) return;
            inorder(root.left);
            System.out.print(root.val+ " ");
            inorder(root.right);
        }
        public void preorderempty()
        {
            System.out.print("PreOrder Traversal :");
            preorder(root);
        }
        public void preorder(TreeNode root)
        {
            if (root==null) return;
            System.out.print(root.val+ " ");
            preorder(root.left);
            preorder(root.right);
        }
        public void postorderempty()
        {
            System.out.print("PostOrder Traversal :");
            postorder(root);
        }
        void postorder(TreeNode root)
        {
            if (root==null) return;
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.val+" ");
        }
        void levelorderempty(){
            System.out.print("LevelOrder Traversal :");
            levelorder(root);
        }
        void levelorder(TreeNode root)
        {
            if (root==null )return;
            Queue<TreeNode> queue=new LinkedList<>();
            queue.add(root);
            int size;
            TreeNode temp;
            while(!queue.isEmpty())
            {
                size=queue.size();
                for (int i=0;i<size;i++)
                {
                    temp=queue.poll();
                    System.out.print(temp.val+" ");
                    if (temp.left!=null) queue.add(temp.left);
                    if (temp.right!=null)  queue.add(temp.right);
                }
            }
        }
    public int  delinorder(TreeNode root)
    {
        if (root.left==null) return root.val;
        return delinorder(root.left);
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null)
        {
            return root;
        }
        if (root.val<key)
        {
            root.right=deleteNode(root.right,key);
            return root;
        }
        else if (root.val>key){
            root.left=deleteNode(root.left,key);
            return root;
        }
        else{
            if (root.left==null )
            {
                root=root.right;
                return root;
            }
            else if (root.right==null)
            {
                root=root.left;
                return root;
            }
            else
            {
                root.val=delinorder(root.right);
                root.right=deleteNode(root.right,root.val);
                return root;
            }
             }
        }
        public void deletenodeempty(int val)
        {
            System.out.println("After deleting value "+ val);
            deleteNode(root,val);
        }
}
class Main{
    public static void main(String[] args){
        BinaryTree tree=new BinaryTree();
        tree.root=tree.insert(10);
        tree.insert(30);
        tree.insert(5);
        tree.insert(50);
        tree.insert(50);
        tree.insert(2);
        tree.insert(6);
        tree.preorderempty();
        System.out.println();
        tree.inorderempty();
        System.out.println();
        tree.postorderempty();
        System.out.println();
        tree.levelorderempty();
        System.out.println();
        tree.deletenodeempty(6);
        tree.levelorderempty();
        System.out.println();
    }
}